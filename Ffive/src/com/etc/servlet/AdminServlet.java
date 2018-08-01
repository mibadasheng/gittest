
package com.etc.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.etc.service.GoodsService;
import com.etc.vo.Goods;

public class AdminServlet extends HttpServlet {

	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "";
		Goods goods = new Goods();
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 如果不是返回页面提示错误
			message = "表单必须包含 enctype=multipart/form-data";
			request.setAttribute("message", message);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		// 创建DiskFileItemFactory
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 创建ServletFileUpload 实例
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		//String uploadPath="C:\\Users\\37613\\Desktop\\apache-tomcat-9.0.0.M22-windows-x64\\apache-tomcat-9.0.0.M22\\wtpwebapps\\shop\\images";
		// 中文处理
		upload.setHeaderEncoding("UTF-8");
		String uploadPath = request.getServletContext().getRealPath("upload");
		// 如果目录不存在则创建
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// 解析请求的内容提取文件数据
		try {
			List<FileItem> formItems = upload.parseRequest(request);
			if (formItems != null && formItems.size() > 0) {
				// 迭代表单数据
				for (FileItem item : formItems) {
					// 处理不在表单中的字段
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String saveFileName = ""+System.currentTimeMillis();
						String type = fileName.split("\\.")[1];
						saveFileName = saveFileName+"."+type;
						String filePath = uploadPath + File.separator + saveFileName;
						File storeFile = new File(filePath);
						String displayPath = request.getContextPath()+File.separator +"upload";
						String url = displayPath +File.separator +saveFileName;
						// 在控制台输出文件的上传路径
						System.out.println(filePath);
						// 保存文件到硬盘
						try {
							item.write(storeFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//保存到DB
//						user.setPhoto(fileName);
						goods.setPhotoname(saveFileName);
						goods.setPhoto(url);
//						request.setAttribute("message", "文件上传成功!");
					} else {//取得表单的其他项目
						String fieldName = item.getFieldName();
						if("gname".equals(fieldName)) {
							goods.setGname(item.getString("utf-8"));
						}else if("typeid".equals(fieldName)) {
							goods.setTypeid(item.getString("utf-8"));
						}
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.register(goods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String displayPath = request.getContextPath()+File.separator +"upload";
		String displayFileName = goods.getPhotoname();
		String url = displayPath +File.separator +displayFileName;
		System.out.println("url:"+url);
		request.setAttribute("goodsinfo", goods);
		request.setAttribute("url", url);
		request.getRequestDispatcher("choose.jsp").forward(request, response);
	}

}


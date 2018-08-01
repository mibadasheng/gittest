
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
			// ������Ƿ���ҳ����ʾ����
			message = "��������� enctype=multipart/form-data";
			request.setAttribute("message", message);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		// ����DiskFileItemFactory
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// ����ServletFileUpload ʵ��
		ServletFileUpload upload = new ServletFileUpload(factory);
		// ��������ļ��ϴ�ֵ
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// �����������ֵ (�����ļ��ͱ�����)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		//String uploadPath="C:\\Users\\37613\\Desktop\\apache-tomcat-9.0.0.M22-windows-x64\\apache-tomcat-9.0.0.M22\\wtpwebapps\\shop\\images";
		// ���Ĵ���
		upload.setHeaderEncoding("UTF-8");
		String uploadPath = request.getServletContext().getRealPath("upload");
		// ���Ŀ¼�������򴴽�
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// ���������������ȡ�ļ�����
		try {
			List<FileItem> formItems = upload.parseRequest(request);
			if (formItems != null && formItems.size() > 0) {
				// ����������
				for (FileItem item : formItems) {
					// �����ڱ��е��ֶ�
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String saveFileName = ""+System.currentTimeMillis();
						String type = fileName.split("\\.")[1];
						saveFileName = saveFileName+"."+type;
						String filePath = uploadPath + File.separator + saveFileName;
						File storeFile = new File(filePath);
						String displayPath = request.getContextPath()+File.separator +"upload";
						String url = displayPath +File.separator +saveFileName;
						// �ڿ���̨����ļ����ϴ�·��
						System.out.println(filePath);
						// �����ļ���Ӳ��
						try {
							item.write(storeFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//���浽DB
//						user.setPhoto(fileName);
						goods.setPhotoname(saveFileName);
						goods.setPhoto(url);
//						request.setAttribute("message", "�ļ��ϴ��ɹ�!");
					} else {//ȡ�ñ���������Ŀ
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


package com.qingke.servlet;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qingke.service.SearchService;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String filePath = uploadFile(request);
				
				SearchService.cun(filePath);
				// 跳转到 message.jsp
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().println("上传成功!");
				//getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);

			
	}

	public static String uploadFile(HttpServletRequest request) {
		String filePath = "";
		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置临时存储目录
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		//负责把request变成格式比较好用的request
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 中文处理
		upload.setHeaderEncoding("UTF-8");

		// 构造临时路径来存储上传的文件
		// 这个路径相对当前应用的目录
		//String uploadPath = getServletContext().getRealPath("/") + File.separator + "upload";
		String uploadPath = "/Users/niyongfeng/qingke";
		// 如果目录不存在则创建
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// 解析请求的内容提取文件数据
			
			List<FileItem> formItems = upload.parseRequest(request);

			// 迭代表单数据
			for (FileItem item : formItems) {
				// 处理不在表单中的字段
				if (!item.isFormField()) {
					String fileName = new File(item.getName()).getName();
					filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					// 在控制台输出文件的上传路径
					System.out.println(filePath);
					// 保存文件到硬盘
					item.write(storeFile);
					request.setAttribute("message", "文件上传成功!");
				}
			}
		} catch (Exception ex) {
			request.setAttribute("message", "错误信息: " + ex.getMessage());
		}
		return filePath;
	}
}

package mall.demo.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.jasper.tagplugins.jstl.core.Out;

import mall.demo.mybatis.pojo.User;
import mall.demo.mybatis.service.UserService;
import mall.demo.util.FileUtil;
import mall.demo.util.SessionKeyEnum;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/servlet/uploadPhotoServlet")
@MultipartConfig
public class UploadPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		boolean isLogged = (new UserService()).isUserLogged(request.getSession());
		if (!isLogged) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		User user = (User)request.getSession().getAttribute(SessionKeyEnum.userObj.name());
		PrintWriter out = response.getWriter();
		
		String contentType = request.getContentType();
		if(contentType != null && contentType.contains("multipart/form-data")) {
			Part part = request.getPart("photo");//这个参数值，就是jsp里面input控件的name
			if(part == null) {
				out.println("no file as name of upload input");
			} else {
				String original = part.getSubmittedFileName();
				if(original == null || original.isEmpty()) {
					out.println("looks that there is no filename and content");
				} else {
					String tempFolder = System.getProperty("user.home");
					File folder = new File(tempFolder + File.separator + "MallDemo");
					folder.mkdirs();
					File newFile = new File(tempFolder + File.separator + "MallDemo", user.getUserId() + "_photo"
							+ FileUtil.getSuffix(original));
					InputStream is = part.getInputStream();
					FileOutputStream fos = new FileOutputStream(newFile);
//					int length = is.available();
					byte [] content = new byte[1024];
					int len = 0;
					while((len = is.read(content)) != -1) {
						fos.write(content, 0, len);
					}
//					is.read(content);
					is.close();
//					fos.write(content);
					fos.close();
					System.out.println("file upload to this folder " + newFile.getAbsolutePath());
					out.println("file upload to this folder " + newFile.getAbsolutePath());
					(new UserService()).updatePhoto(user, newFile.getAbsolutePath());
					response.sendRedirect(request.getContextPath() + "/profile.jsp");
					return;
				}
			}
		} else {
			out.println("not a file upload request");
		}
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

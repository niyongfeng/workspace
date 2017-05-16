package mall.demo.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mall.demo.mybatis.pojo.User;
import mall.demo.mybatis.service.UserService;
import mall.demo.util.SessionKeyEnum;
import mall.demo.util.StringUtil;



/**
 * Servlet implementation class RespTestBinaryServlet
 */
@WebServlet("/servlet/photoDownload")
public class PhotoDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(PhotoDownloadServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isLogged = (new UserService()).isUserLogged(request.getSession());
		if (!isLogged) {
//			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		User user = (User)request.getSession().getAttribute(SessionKeyEnum.userObj.name());
		String name = user.getPhotoPath();
		if (name == null || name.equals("")) {
			
			return;
			
		}
		
		response.setContentType(StringUtil.getContentTypeByFileSuffix(name));
//		String file = "/Users/chenxianpeng/Desktop/screenshot-record/java-learning/M3-3ServletV2/ch20-resp-body/test.jpg";
		File imgFile = new File(name);
		FileInputStream fis = new FileInputStream(imgFile);
		ServletOutputStream os = response.getOutputStream();
		byte [] content = new byte[1024];
		int num ;
		int length = 0;
		while((num = fis.read(content)) != -1) {
			os.write(content, 0, num);
			length += num;
		}
//		int length = fis.available();
//		byte [] content = new byte[length];
//		fis.read(content);
		fis.close();
//		response.getOutputStream().write(content);
		response.setContentLength(length);
		response.flushBuffer();
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

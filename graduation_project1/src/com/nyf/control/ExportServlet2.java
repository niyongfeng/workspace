package com.nyf.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nyf.dao.ApplicationFormDao;
import com.nyf.dao.UserDao;
import com.nyf.dao.VolunteerActivityDao;
import com.nyf.projo.ApplicationForm;
import com.nyf.projo.User;
import com.nyf.projo.VolunteerActivity;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class ExportServlet
 */
@WebServlet("/ExportServlet2")
public class ExportServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int volunteer_id = Integer.valueOf(request.getParameter("volunteer_id"));
		SqlSession session = MybatisSessionFactory.getSession();
		response.setCharacterEncoding("utf-8");
		System.out.println(request.getRequestURL());
		int id = Integer.valueOf(request.getParameter("id"));
		ApplicationFormDao af = session.getMapper(ApplicationFormDao.class);
		List<ApplicationForm> laf = af.selectByVolunteer_id(id);
		
		UserDao ud = session.getMapper(UserDao.class);
		List<User> lu = new ArrayList<User>();
		
		VolunteerActivityDao vad = session.getMapper(VolunteerActivityDao.class);
		String fileName = "";
		for(ApplicationForm l : laf) {
			//System.out.println(l.getStudent_id());
			//System.out.println(ud.selectByLogin_id(l.getStudent_id()));
			User u = (User)(ud.selectByLogin_id(l.getStudent_id())).get(0);
			List<VolunteerActivity> lva = vad.selectById(l.getVolunteer_id());
			//System.out.println(u);
			fileName = lva.get(0).getDescription() + ".xls";
			u.setVolunteer_id(l.getId());
			u.setDesc(lva.get(0).getDescription());
			lu.add(u);
		}
		System.out.println(lu);
		String filePath = "/Users/niyongfeng/qingke";
		//PrintWriter out = response.getWriter();
		boolean b = creatExcelFile(filePath,fileName,lu);
		System.out.println(b);
//		if(creatExcelFile(filePath,fileName,lu)) {
//			System.out.println("0000000000000");
//			//response.sendRedirect("manVolunteerActivity.jsp");
//			out.print("<script>alert('导出成功！');window.location.href='manVolunteerActivity.jsp';</script>");
//		}else {
//			out.print("<script>alert('导出失败！');window.location.href='manVolunteerActivity.jsp';</script>");
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static boolean creatExcelFile(String filePath,String fileName, List<User> list) throws IOException {
		System.out.println("==========");
		HSSFWorkbook workbook = new HSSFWorkbook();
		System.out.println(workbook);
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, fileName);
		HSSFRow row = sheet.createRow(0);
		HSSFCell label_num = row.createCell(0);
		label_num.setCellValue("序号");
		HSSFCell label_name = row.createCell(1);
		label_name.setCellValue("姓名");
		HSSFCell label_stu_num = row.createCell(2);
		label_stu_num.setCellValue("学号");
		HSSFCell label_major = row.createCell(3);
		label_major.setCellValue("专业");
		HSSFCell label_phone = row.createCell(4);
		label_phone.setCellValue("联系方式");
		
		for(int i = 1; i <= list.size(); i++) {
			User user = list.get(i-1);
			HSSFRow row1 = sheet.createRow(i);
			HSSFCell label_num1 = row1.createCell(0);
			HSSFCell label_name1 = row1.createCell(1);
			HSSFCell label_stu_num1 = row1.createCell(2);
			HSSFCell label_major1 = row1.createCell(3);
			HSSFCell label_phone1 = row1.createCell(4);
			label_num1.setCellValue(i);
			label_name1.setCellValue(user.getName());
			label_stu_num1.setCellValue(user.getStudent_number());
			label_major1.setCellValue(user.getMajor());
			label_phone1.setCellValue(user.getPhone());
		}
		File xlsFile = new File(filePath,fileName);
		FileOutputStream fos = new FileOutputStream(xlsFile);
		workbook.write(fos);
		fos.close();
		return true;
	}
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M17
 * Generated at: 2017-04-27 06:28:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pwd2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<title>Bootstrap Admin</title>\n");
      out.write("<meta content=\"IE=edge,chrome=1\" http-equiv=\"X-UA-Compatible\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<meta name=\"description\" content=\"\">\n");
      out.write("<meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"lib/bootstrap/css/bootstrap.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"lib/bootstrap/css/bootstrap-responsive.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheets/theme.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"lib/font-awesome/css/font-awesome.css\">\n");
      out.write("\n");
      out.write("<script src=\"lib/jquery-1.8.1.min.js\" type=\"text/javascript\"></script>\n");

	String user = (String) session.getAttribute("userName");
	if (user == null) {

      out.write("\n");
      out.write("<script>\n");
      out.write("\talert('尊敬的游客，由于您未登录，所以无法使用该平台，谢谢合作！');\n");
      out.write("\twindow.location.href = 'sign-in.html';\n");
      out.write("</script>\n");

	}

      out.write("\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("#line-chart {\n");
      out.write("\theight: 300px;\n");
      out.write("\twidth: 800px;\n");
      out.write("\tmargin: 0px auto;\n");
      out.write("\tmargin-top: 1em;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".brand {\n");
      out.write("\tfont-family: georgia, serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".brand .first {\n");
      out.write("\tcolor: #ccc;\n");
      out.write("\tfont-style: italic;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".brand .second {\n");
      out.write("\tcolor: #fff;\n");
      out.write("\tfont-weight: bold;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<link rel=\"shortcut icon\" href=\"../assets/ico/favicon.ico\">\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\"\n");
      out.write("\thref=\"../assets/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\"\n");
      out.write("\thref=\"../assets/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\"\n");
      out.write("\thref=\"../assets/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\"\n");
      out.write("\thref=\"../assets/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div class=\"navbar\">\n");
      out.write("\t\t<div class=\"navbar-inner\">\n");
      out.write("\t\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t\t<ul class=\"nav pull-right\">\n");
      out.write("\t\t\t\t\t<li id=\"fat-menu\" class=\"dropdown\">\n");
      out.write("\t\t\t\t\t<a href=\"#\" id=\"drop3\" role=\"button\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"icon-user\"></i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <i class=\"icon-caret-down\"></i>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t\t\t\t\t<li><a tabindex=\"-1\" href=\"sign-in.html\">注销</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a tabindex=\"-1\" href=\"pwd.jsp\">修改密码</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a tabindex=\"-1\" href=\"studentInfo.jsp\">个人中心</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t<a class=\"brand\" href=\"studentIndex.jsp\"><span class=\"first\">浙江传媒学院</span>\n");
      out.write("\t\t\t\t\t<span class=\"second\">第二课堂管理系统</span>(学生)</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"container-fluid\">\n");
      out.write("\t\t<div class=\"row-fluid\">\n");
      out.write("\t\t\t<div class=\"span3\">\n");
      out.write("\t\t\t\t<div class=\"sidebar-nav\">\n");
      out.write("\t\t\t\t\t<div class=\"nav-header\" data-toggle=\"collapse\"\n");
      out.write("\t\t\t\t\t\tdata-target=\"#dashboard-menu\">\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-dashboard\"></i>导航栏\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<ul id=\"dashboard-menu\" class=\"nav nav-list collapse in\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherIndex.jsp\">主页</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherVolunteerActivity.jsp\">志愿者活动</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherCompetition.jsp\">竞赛活动</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherChair.jsp\">讲座</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherTeacherProject.jsp\">教师项目</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherhelp.jsp\">帮助</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t<div class=\"nav-header\" data-toggle=\"collapse\"\n");
      out.write("\t\t\t\t\t\tdata-target=\"#accounts-menu\">\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-briefcase\"></i>第二课堂项目管理</span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<ul id=\"accounts-menu\" class=\"nav nav-list collapse in\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherVolunteerActivityManage.jsp\">志愿者活动管理</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherCompetitionManage.jsp\">竞赛活动发布管理</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherChairManage.jsp\">讲座发布管理</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherTeacherProjectManage.jsp\">教师项目发布管理</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"span9\">\n");
      out.write("\t\t\t\t<h3 class=\"page-title\">修改密码</h3>\n");
      out.write("\t\t\t\t<form id=\"tab2\" action=\"StudentPwd\" method=\"get\">\n");
      out.write("\t\t\t\t<div class=\"well\">\n");
      out.write("\t\t\t\t\t<label>用户名</label>\n");
      out.write("\t\t\t\t\t<input name=\"name\" type=\"text\" value = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" class=\"input-xlarge\" readonly> \n");
      out.write("\t\t\t\t\t<label>请输入新的密码</label>\n");
      out.write("\t\t\t\t\t<input name=\"firstPwd\" type=\"password\" class=\"input-xlarge\"> \n");
      out.write("\t\t\t\t\t<label>请再次输入确认</label>\n");
      out.write("\t\t\t\t\t<input name=\"secondPwd\" type=\"password\" class=\"input-xlarge\"> \n");
      out.write("\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-primary\" style=\"submit\">提交修改</button>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<script src=\"lib/bootstrap/js/bootstrap.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

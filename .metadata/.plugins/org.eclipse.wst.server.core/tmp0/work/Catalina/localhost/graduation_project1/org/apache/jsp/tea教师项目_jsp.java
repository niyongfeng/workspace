/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M17
 * Generated at: 2017-04-16 08:32:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tea教师项目_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>Bootstrap Admin</title>\r\n");
      out.write("    <meta content=\"IE=edge,chrome=1\" http-equiv=\"X-UA-Compatible\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"lib/bootstrap/css/bootstrap.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"lib/bootstrap/css/bootstrap-responsive.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheets/theme.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"lib/font-awesome/css/font-awesome.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"stylesheets/panigate.css\">\r\n");
      out.write("    <script src=\"lib/jquery-1.8.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"javascripts/teacherProject.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"javascripts/panigate.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Demo page code -->\r\n");
      out.write("\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        #line-chart {\r\n");
      out.write("            height:300px;\r\n");
      out.write("            width:800px;\r\n");
      out.write("            margin: 0px auto;\r\n");
      out.write("            margin-top: 1em;\r\n");
      out.write("        }\r\n");
      out.write("        .brand { font-family: georgia, serif; }\r\n");
      out.write("        .brand .first {\r\n");
      out.write("            color: #ccc;\r\n");
      out.write("            font-style: italic;\r\n");
      out.write("        }\r\n");
      out.write("        .brand .second {\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    <!-- Le fav and touch icons -->\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"../assets/ico/favicon.ico\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"../assets/ico/apple-touch-icon-144-precomposed.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"../assets/ico/apple-touch-icon-114-precomposed.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"../assets/ico/apple-touch-icon-72-precomposed.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" href=\"../assets/ico/apple-touch-icon-57-precomposed.png\">\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <!--[if lt IE 7 ]> <body class=\"ie ie6\"> <![endif]-->\r\n");
      out.write("  <!--[if IE 7 ]> <body class=\"ie ie7\"> <![endif]-->\r\n");
      out.write("  <!--[if IE 8 ]> <body class=\"ie ie8\"> <![endif]-->\r\n");
      out.write("  <!--[if IE 9 ]> <body class=\"ie ie9\"> <![endif]-->\r\n");
      out.write("  <!--[if (gt IE 9)|!(IE)]><!-->\r\n");
      out.write("  <body>\r\n");
      out.write("  <!--<![endif]-->\r\n");
      out.write("\r\n");
      out.write("    <div class=\"navbar\">\r\n");
      out.write("        <div class=\"navbar-inner\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <ul class=\"nav pull-right\">\r\n");
      out.write("\r\n");
      out.write("                    <li id=\"fat-menu\" class=\"dropdown\">\r\n");
      out.write("                        <a href=\"#\" id=\"drop3\" role=\"button\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                            <i class=\"icon-user\"></i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                            <i class=\"icon-caret-down\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("                            <!-- <li><a tabindex=\"-1\" href=\"#\">Settings</a></li> -->\r\n");
      out.write("                            <!-- <li class=\"divider\"></li> -->\r\n");
      out.write("                            <li><a tabindex=\"-1\" href=\"sign-in.html\">注销</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("                <a class=\"brand\" href=\"teacherIndex.jsp\"><span class=\"first\">浙江传媒学院</span> <span class=\"second\">第二课堂管理系统</span></a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row-fluid\">\r\n");
      out.write("            <div class=\"span3\">\r\n");
      out.write("                <div class=\"sidebar-nav\">\r\n");
      out.write("                  <div class=\"nav-header\" data-toggle=\"collapse\" data-target=\"#dashboard-menu\"><i class=\"icon-dashboard\"></i>导航栏</div>\r\n");
      out.write("                    <ul id=\"dashboard-menu\" class=\"nav nav-list collapse in\">\r\n");
      out.write("                      <li><a href=\"teacherIndex.jsp\">主页</a></li>\r\n");
      out.write("                      <li ><a href=\"tea志愿者活动.jsp\">志愿者活动</a></li>\r\n");
      out.write("                      <li ><a href=\"tea竞赛活动.jsp\">竞赛活动</a></li>\r\n");
      out.write("                      <li ><a href=\"tea讲座.jsp\">讲座</a></li>\r\n");
      out.write("                      <li class=\"active\"><a href=\"tea教师项目.jsp\">教师项目</a></li>\r\n");
      out.write("                      <li ><a href=\"teahelp.jsp\">帮助</a></li>\r\n");
      out.write("\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <div class=\"nav-header\" data-toggle=\"collapse\" data-target=\"#accounts-menu\"><i class=\"icon-briefcase\"></i>第二课堂项目管理</span></div>\r\n");
      out.write("                    <ul id=\"accounts-menu\" class=\"nav nav-list collapse in\">\r\n");
      out.write("                      <li ><a href=\"tea志愿者活动发布.jsp\">志愿者活动管理</a></li>\r\n");
      out.write("                      <li ><a href=\"tea竞赛活动发布.jsp\">竞赛活动发布管理</a></li>\r\n");
      out.write("                      <li ><a href=\"tea讲座发布.jsp\">讲座发布管理</a></li>\r\n");
      out.write("                      <li ><a href=\"tea教师项目发布.jsp\">教师项目发布管理</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"span9\">\r\n");
      out.write("            <script type=\"text/javascript\" src=\"lib/jqplot/jquery.jqplot.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"javascripts/graphDemo.js\"></script>\r\n");
      out.write("  <h1 class=\"page-title\">教师项目</h1>\r\n");
      out.write("  <div class=\"well\">\r\n");
      out.write("    <table class=\"table\">\r\n");
      out.write("      <thead>\r\n");
      out.write("        <tr title=\"\" id=\"teacherProjectList\">\r\n");
      out.write("          <th>#</th>\r\n");
      out.write("          <th>项目名</th>\r\n");
      out.write("          <th>指导教师</th>\r\n");
      out.write("          <th>具体内容</th>\r\n");
      out.write("          <th>人数</th>\r\n");
      out.write("          <th>发布时间</th>\r\n");
      out.write("          <!-- <th style=\"width: 26px;\"></th> -->\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("      <div id=\"Pagination\" class=\"right flickr\"></div>\r\n");
      out.write("  </div>\r\n");
      out.write("<div class=\"well search-well\">\r\n");
      out.write("              <form class=\"form-inline\" action=\"TeacherProjectSearchSerlvet\" method=\"get\">\r\n");
      out.write("                  <input name = \"search\" class=\"input-xlarge\" id=\"appendedInputButton\" type=\"text\">\r\n");
      out.write("                  <button class=\"btn\" type=\"submit\"><i class=\"icon-search\"></i>Go</button>\r\n");
      out.write("              </form>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Le javascript\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("    <script src=\"lib/bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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

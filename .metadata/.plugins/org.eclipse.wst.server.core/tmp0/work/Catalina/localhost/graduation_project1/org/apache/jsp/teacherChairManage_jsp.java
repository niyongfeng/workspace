/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M17
 * Generated at: 2017-04-27 06:28:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teacherChairManage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Bootstrap Admin</title>\r\n");
      out.write("<meta content=\"IE=edge,chrome=1\" http-equiv=\"X-UA-Compatible\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"lib/bootstrap/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"lib/bootstrap/css/bootstrap-responsive.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheets/theme.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"lib/font-awesome/css/font-awesome.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"stylesheets/panigate.css\">\r\n");
      out.write("<script src=\"lib/jquery-1.8.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"javascripts/panigate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"javascripts/teacherMyChair.js\"></script>\r\n");
      out.write("\r\n");

	String user = (String) session.getAttribute("userName");
	if (user == null) {

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\talert('尊敬的游客，由于您未登录，所以无法使用该平台，谢谢合作！');\r\n");
      out.write("\twindow.location.href = 'sign-in.html';\r\n");
      out.write("</script>\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#line-chart {\r\n");
      out.write("\theight: 300px;\r\n");
      out.write("\twidth: 800px;\r\n");
      out.write("\tmargin: 0px auto;\r\n");
      out.write("\tmargin-top: 1em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".brand {\r\n");
      out.write("\tfont-family: georgia, serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".brand .first {\r\n");
      out.write("\tcolor: #ccc;\r\n");
      out.write("\tfont-style: italic;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".brand .second {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"../assets/ico/favicon.ico\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\"\r\n");
      out.write("\thref=\"../assets/ico/apple-touch-icon-144-precomposed.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\"\r\n");
      out.write("\thref=\"../assets/ico/apple-touch-icon-114-precomposed.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\"\r\n");
      out.write("\thref=\"../assets/ico/apple-touch-icon-72-precomposed.png\">\r\n");
      out.write("<link rel=\"apple-touch-icon-precomposed\"\r\n");
      out.write("\thref=\"../assets/ico/apple-touch-icon-57-precomposed.png\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"navbar\">\r\n");
      out.write("\t\t<div class=\"navbar-inner\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav pull-right\">\r\n");
      out.write("\t\t\t\t\t<li id=\"fat-menu\" class=\"dropdown\"><a href=\"#\" id=\"drop3\"\r\n");
      out.write("\t\t\t\t\t\trole=\"button\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"icon-user\"></i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <i class=\"icon-caret-down\"></i>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a tabindex=\"-1\" href=\"sign-in.html\">注销</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a tabindex=\"-1\" href=\"pwd2.jsp\">修改密码</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<a class=\"brand\" href=\"teacherIndex.jsp\"><span class=\"first\">浙江传媒学院</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"second\">第二课堂管理系统</span>(教师)</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"row-fluid\">\r\n");
      out.write("\t\t\t<div class=\"span3\">\r\n");
      out.write("\t\t\t\t<div class=\"sidebar-nav\">\r\n");
      out.write("\t\t\t\t\t<div class=\"nav-header\" data-toggle=\"collapse\"\r\n");
      out.write("\t\t\t\t\t\tdata-target=\"#dashboard-menu\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-dashboard\"></i>导航栏\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<ul id=\"dashboard-menu\" class=\"nav nav-list collapse in\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherIndex.jsp\">主页</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherVolunteerActivity.jsp\">志愿者活动</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherCompetition.jsp\">竞赛活动</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherChair.jsp\">讲座</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherTeacherProject.jsp\">教师项目</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherhelp.jsp\">帮助</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<div class=\"nav-header\" data-toggle=\"collapse\"\r\n");
      out.write("\t\t\t\t\t\tdata-target=\"#accounts-menu\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-briefcase\"></i>第二课堂项目管理</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<ul id=\"accounts-menu\" class=\"nav nav-list collapse in\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherVolunteerActivityManage.jsp\">志愿者活动管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherCompetitionManage.jsp\">竞赛活动发布管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"teacherChairManage.jsp\">讲座发布管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t<!-- <li><a href=\"teacherChairManage2.jsp\">我发布的讲座</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"teacherTeacherProjectManage.jsp\">教师项目发布管理</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"span9\">\r\n");
      out.write("\t\t\t\t<h1 class=\"page-title\">讲座管理</h1>\r\n");
      out.write("\t\t\t\t<div class=\"btn-toolbar\">\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-group\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"well\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav nav-tabs\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"#home\" data-toggle=\"tab\">修改</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#profile\" data-toggle=\"tab\">发布</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#show\" data-toggle=\"tab\">我发布的讲座</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<div id=\"myTabContent\" class=\"tab-content\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"tab-pane active in\" id=\"home\">\r\n");
      out.write("\t\t\t\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\t\t\tselect();\r\n");
      out.write("\t\t\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t\t\t<form id=\"tab1\" action=\"teacherUpdateChair\" method=\"get\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>活动时间</label> <input name=\"activity_time\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"input-xlarge\"> <label>主讲人</label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"chair_professor\" type=\"text\" class=\"input-xlarge\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>具体内容</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea name=\"description\" rows=\"3\" class=\"input-xlarge\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>地点</label> <input name=\"address\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"input-xlarge\"> <label>状态</label> <select\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"code\" name=\"status\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2\">请选择</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"0\">失效</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"1\">有效</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select> <input name=\"id\" type=\"text\" class=\"input-xlarge\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"display: none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button class=\"btn btn-primary\" type=\"submit\">提交修改</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"tab-pane fade\" id=\"profile\">\r\n");
      out.write("\t\t\t\t\t\t\t<form id=\"tab2\" action=\"ChariManageServlet\" method=\"get\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>活动时间</label> <input name=\"activity_time\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"input-xlarge\" placeholder=\"yyyy-MM-dd HH:mm:ss\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>主讲人</label> <input name=\"chair_professor\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"input-xlarge\"> <label>具体内容</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea name=\"description\" rows=\"3\" class=\"input-xlarge\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>地点</label> <input name=\"address\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"input-xlarge\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button class=\"btn btn-primary\" type=\"submit\">发布</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"tab-pane fade\" id=\"show\">\r\n");
      out.write("\t\t\t\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\t\t\tselect();\r\n");
      out.write("\t\t\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t\t\t<h6 id=\"tatol\" style=\"display:none\">搜索结果:<a id = \"number\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${number}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a></h6>\r\n");
      out.write("\t\t\t\t\t\t\t<form id=\"tab3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"well\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr title=\"\" id=\"myChairList\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>#</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>活动时间</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>主讲人</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>具体内容</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>地点</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>发布时间</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>状态</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"display: none;\">id</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div id=\"Pagination\" class=\"right flickr\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"well search-well\">\r\n");
      out.write("\t\t\t\t\t<form class=\"form-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input name = \"info\" class=\"input-xlarge\" placeholder=\"Search Help...\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"appendedInputButton\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t<button id = \"search\" class=\"btn\" type=\"button\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"icon-search\"></i>Go\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write(" $(\"#search\").click(function(){\r\n");
      out.write("\t\t\tvar info = $(\"input[name='info']\").val();\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\t\turl : 'searchMyChair', // 提交到一般处理程序请求数据\r\n");
      out.write("\t\t\t\tdata:{info:info},\r\n");
      out.write("\t\t\t\tcache : false, // 提交两个参数：pageIndex(页面索引)，pageSize(显示条数)\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t// 移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）\r\n");
      out.write("\t\t\t\t\tconsole.log(\"开始渲染数据\");\r\n");
      out.write("\t\t\t\t\tconsole.log(\"info:\"+info);\r\n");
      out.write("\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\tvar json = eval('('+data+')');\r\n");
      out.write("\t\t\t\t\ttatol.style.display=\"\";\r\n");
      out.write("\t\t\t\t\t$(\"#number\").text(json.length);\r\n");
      out.write("\t\t\t\t\t// 将返回的数据追加到表格\r\n");
      out.write("\t\t\t\t\t$(\".table tr:gt(0)\").remove();\r\n");
      out.write("\t\t\t\t\tfor (var i = 0; i < json.length; i++) {\r\n");
      out.write("\t\t\t\t\t\tvar val = json[i];\r\n");
      out.write("\t\t\t\t\t\tvar s = \"失效\";\r\n");
      out.write("\t\t\t\t\t\tif(val.status == 1) {\r\n");
      out.write("\t\t\t\t\t\t\ts = \"有效\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tvar str = \"<tr><td>\"+ (json.length - i)\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td>\"\r\n");
      out.write("\t\t\t\t\t\t+ val.activity_time\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td>\"\r\n");
      out.write("\t\t\t\t\t\t+ val.chair_professor\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td>\"\r\n");
      out.write("\t\t\t\t\t\t+ val.description\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td>\"\r\n");
      out.write("\t\t\t\t\t\t+ val.address\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td>\"\r\n");
      out.write("\t\t\t\t\t\t+ val.release_time\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td>\"\r\n");
      out.write("\t\t\t\t\t\t+ s\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td style=\\\"display:none;\\\">\" + val.id\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td><a href=\\\"teacherChairManage.jsp?id=\"  +val.id + \"\\\"role=\\\"button\\\" data-toggle=\\\"modal\\\"><i class=\\\"icon-pencil\\\"></i></a>&nbsp;&nbsp<a href=\\\"#\\\" role=\\\"button\\\" data-toggle=\\\"modal\\\" onclick='deleteChair($(this))'><i class=\\\"icon-remove\\\"></i></a></td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t$(\"#myChairList\").after(str);\r\n");
      out.write("\t\t\t\t\t};\r\n");
      out.write("\t\t\t\t\t$(\"#Pagination\").hide();\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t});\r\n");
      out.write(" </script>\r\n");
      out.write("\t<script src=\"lib/bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("</body>\r\n");
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

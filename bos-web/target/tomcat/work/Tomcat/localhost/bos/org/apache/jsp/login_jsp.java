/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-02-13 08:19:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/jsp/taglib.jsp", Long.valueOf(1486286562588L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<title>BOS-员工登录</title>\r\n");
      out.write("\t\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/logo.ico\" rel=\"shortcut icon\" type=\"image/x-icon\" />\r\n");
      out.write("\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" />\r\n");
      out.write("\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style_grey.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/default/easyui.css\"/>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\tinput[type=text] {\r\n");
      out.write("\t\t\t\twidth: 80%;\r\n");
      out.write("\t\t\t\theight: 25px;\r\n");
      out.write("\t\t\t\tfont-size: 12pt;\r\n");
      out.write("\t\t\t\tfont-weight: bold;\r\n");
      out.write("\t\t\t\tmargin-left: 45px;\r\n");
      out.write("\t\t\t\tpadding: 3px;\r\n");
      out.write("\t\t\t\tborder-width: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tinput[type=password] {\r\n");
      out.write("\t\t\t\twidth: 80%;\r\n");
      out.write("\t\t\t\theight: 25px;\r\n");
      out.write("\t\t\t\tfont-size: 12pt;\r\n");
      out.write("\t\t\t\tfont-weight: bold;\r\n");
      out.write("\t\t\t\tmargin-left: 45px;\r\n");
      out.write("\t\t\t\tpadding: 3px;\r\n");
      out.write("\t\t\t\tborder-width: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t//$.messager.defaults.ok = '确定';\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/** 登录窗口不能被其它窗口包含 */\r\n");
      out.write("\t\t\tif (window != parent){\r\n");
      out.write("\t\t\t\tparent.location = window.location;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t/** 判断用户是否登录 */\r\n");
      out.write("\t\t\tif (\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session_user}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" != \"\"){\r\n");
      out.write("\t\t\t\twindow.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/main.jspx\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t/** 文档加载完 */\r\n");
      out.write("\t\t\t$(window).ready(function(){\r\n");
      out.write("\t\t\t\t/** 获取验证图片绑定onmouseover 与 onclick */\r\n");
      out.write("\t\t\t\t$(\"#see\").mouseover(function(){\r\n");
      out.write("\t\t\t\t\t// this: dom元素   光标变成手状\r\n");
      out.write("\t\t\t\t\t$(this).css(\"cursor\", \"pointer\");\r\n");
      out.write("\t\t\t\t}).click(function(){ // onclick\r\n");
      out.write("\t\t\t\t\t// 让src重新请求一次\r\n");
      out.write("\t\t\t\t\t$(this).attr(\"src\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/verify.jspx?random=\" + Math.random());\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t/** 为登录按钮绑定点击事件 */\r\n");
      out.write("\t\t\t\t$(\"#loginBtn\").on(\"click\", function(){\r\n");
      out.write("\t\t\t\t\t/** 表单校验 */\r\n");
      out.write("\t\t\t\t\tvar userId = $(\"#userId\");\r\n");
      out.write("\t\t\t\t\tvar password = $(\"#password\");\r\n");
      out.write("\t\t\t\t\tvar vcode = $(\"#vcode\");\r\n");
      out.write("\t\t\t\t\tvar msg = \"\";\r\n");
      out.write("\t\t\t\t\tvar obj = null;\r\n");
      out.write("\t\t\t\t\tif ($.trim(userId.val()) == \"\"){\r\n");
      out.write("\t\t\t\t\t\tmsg = \"账号不能为空！\";\r\n");
      out.write("\t\t\t\t\t\tobj = userId;\r\n");
      out.write("\t\t\t\t\t}else if (!/^\\w{5,20}$/.test($.trim(userId.val()))){\r\n");
      out.write("\t\t\t\t\t\tmsg = \"账号格式不正确！\";\r\n");
      out.write("\t\t\t\t\t\tobj = userId;\r\n");
      out.write("\t\t\t\t\t}else if ($.trim(password.val()) == \"\"){\r\n");
      out.write("\t\t\t\t\t\tmsg = \"密码不能为空！\";\r\n");
      out.write("\t\t\t\t\t\tobj = password;\r\n");
      out.write("\t\t\t\t\t}else if (!/^\\w{6,20}$/.test($.trim(password.val()))){\r\n");
      out.write("\t\t\t\t\t\tmsg = \"密码格式不正确！\";\r\n");
      out.write("\t\t\t\t\t\tobj = password;\r\n");
      out.write("\t\t\t\t\t}else if ($.trim(vcode.val()) == \"\"){\r\n");
      out.write("\t\t\t\t\t\tmsg = \"验证码不能为空！\";\r\n");
      out.write("\t\t\t\t\t\tobj = vcode;\r\n");
      out.write("\t\t\t\t\t}else if (!/^[a-zA-Z0-9]{4}$/.test($.trim(vcode.val()))){\r\n");
      out.write("\t\t\t\t\t\tmsg = \"验证码格式不正确！\";\r\n");
      out.write("\t\t\t\t\t\tobj = vcode;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif (msg != \"\"){\r\n");
      out.write("\t\t\t\t\t\tif (window.isFlag){\r\n");
      out.write("\t\t\t\t\t\t\twindow.isFlag = false;\r\n");
      out.write("\t\t\t\t\t\t\tsetTimeout(function(){\r\n");
      out.write("\t\t\t\t\t\t\t\t/** 监听消息窗口的关闭事件 */\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert(\"警告信息\", msg, \"warning\").window({\r\n");
      out.write("\t\t\t\t\t\t\t\t\tonClose : function(){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tobj.focus(); // 获取焦点\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\twindow.isFlag = true;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t}, 1);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t/** 获取表单中的请求参数 */\r\n");
      out.write("\t\t\t\t\t\tvar params = $(\"#loginform\").serialize();\r\n");
      out.write("\t\t\t\t\t\t// userId=admin&password=111111&vcode=2455&key=1\r\n");
      out.write("\t\t\t\t\t\t/** 异步请求登录 */\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login.jspx\", // 请求URL\r\n");
      out.write("\t\t\t\t\t\t\ttype : \"post\", // 请求方式post|get\r\n");
      out.write("\t\t\t\t\t\t\tdata : params, // 请求参数 key=value&key=value|{key:value,key:value}|[{key:value,key:value},{key:value,key:value}]\r\n");
      out.write("\t\t\t\t\t\t\tdataType : \"json\", // 指定服务器响应回来的数据类型\r\n");
      out.write("\t\t\t\t\t\t\tasync : true,  // true:异步请求中异步(不等待响应数据)   false:异步请求中同步(等待响应数据)\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(data){ // 请求成功\r\n");
      out.write("\t\t\t\t\t\t\t\t// data: 服务器响应回来的数据\r\n");
      out.write("\t\t\t\t\t\t\t\t// data: json {status : 0, tip : \"\"}\r\n");
      out.write("\t\t\t\t\t\t\t\t//alert(data);\r\n");
      out.write("\t\t\t\t\t\t\t\t/** 在控制台输出日志 */\r\n");
      out.write("\t\t\t\t\t\t\t\t//console.log(data);\r\n");
      out.write("\t\t\t\t\t\t\t\tif (data.status == 0){\r\n");
      out.write("\t\t\t\t\t\t\t\t\twindow.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/main.jspx\";\r\n");
      out.write("\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t/** 让验证码变一下 */\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#see\").trigger(\"click\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$.messager.alert(\"提示信息\", data.tip, \"info\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\terror : function(){ // 请求出错\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert(\"错误信息\", \"亲，网络出现了异常！\", \"error\");\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t/** 定义标记 */\r\n");
      out.write("\t\t\t\twindow.isFlag = true;\r\n");
      out.write("\t\t\t\t/** 监听回车键  onkeydown */\r\n");
      out.write("\t\t\t\t$(document).keydown(function(event){\r\n");
      out.write("\t\t\t\t\t// event：事件对象\r\n");
      out.write("\t\t\t\t\t// keyCode : 按键对应的代号 13 回车键\r\n");
      out.write("\t\t\t\t\tif(event.keyCode === 13 && window.isFlag){\r\n");
      out.write("\t\t\t\t\t\t/** 事件主动触发 */\r\n");
      out.write("\t\t\t\t\t\t$(\"#loginBtn\").trigger(\"click\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t/** 为忘记密码a标签绑定点击事件 */\r\n");
      out.write("\t\t\t\t$(\"#findPwd\").click(function(){\r\n");
      out.write("\t\t\t\t\t/** 创建div */\r\n");
      out.write("\t\t\t\t\tvar divDialog = $(\"<div style='overflow:hidden;'/>\");\r\n");
      out.write("\t\t\t\t\t/** 把div转化成dialog */\r\n");
      out.write("\t\t\t\t\tdivDialog.dialog({\r\n");
      out.write("\t\t\t\t\t\ttitle : \"找回密码\", // 标题\r\n");
      out.write("\t\t\t\t\t\twidth : 330, // 宽度\r\n");
      out.write("\t\t\t\t\t\theight : 190, // 高度\r\n");
      out.write("\t\t\t\t\t\tmodal : true // 模态窗口\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t/** 创建iframe子窗口 */\r\n");
      out.write("\t\t\t\t\t$(\"<iframe width='100%' height='100%' frameborder='0'/>\")\r\n");
      out.write("\t\t\t\t\t  .prop(\"src\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/showFindPassword.jspx\")\r\n");
      out.write("\t\t\t\t\t  .appendTo(divDialog);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("<body style=\"background-color: #E6E6FA;\">\r\n");
      out.write("\t<div style=\"width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: -280px;\">\r\n");
      out.write("\t\t<span style=\"float: right; margin-top: 35px; color: #488ED5;\">新BOS系统，致力于便捷、安全、稳定等方面的客户体验</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"main-inner\" id=\"mainCnt\"\r\n");
      out.write("\t\tstyle=\"width: 900px; height: 440px; overflow: hidden; position: absolute; left: 50%; top: 50%; margin-left: -450px; margin-top: -220px; background-image: url('images/bg_login.jpg')\">\r\n");
      out.write("\t\t<div id=\"loginBlock\" class=\"login\"\r\n");
      out.write("\t\t\tstyle=\"margin-top: 80px; height: 255px;\">\r\n");
      out.write("\t\t\t<div class=\"loginFunc\">\r\n");
      out.write("\t\t\t\t<div id=\"lbNormal\" class=\"loginFuncMobile\">员工登录</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"loginForm\">\r\n");
      out.write("\t\t\t\t<form id=\"loginform\" method=\"post\" class=\"niceform\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"idInputLine\" class=\"loginFormIpt showPlaceholder\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"margin-top: 5px;\">\r\n");
      out.write("\t\t\t\t\t\t<input id=\"userId\" type=\"text\" name=\"userId\" class=\"loginFormTdIpt\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\t\t<label for=\"idInput\" class=\"placeholder\" id=\"idPlaceholder\">账号：</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"forgetPwdLine\"></div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"pwdInputLine\" class=\"loginFormIpt showPlaceholder\">\r\n");
      out.write("\t\t\t\t\t\t<input id=\"password\" class=\"loginFormTdIpt\" type=\"password\" name=\"password\"/>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"pwdInput\" class=\"placeholder\" id=\"pwdPlaceholder\">密码：</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"loginFormIpt loginFormIptWiotTh\" style=\"margin-top:58px;\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"codeInputLine\" class=\"loginFormIpt showPlaceholder\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"margin-left:0px;margin-top:-40px;width:50px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"vcode\" class=\"loginFormTdIpt\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"vcode\" title=\"请输入验证码\" style=\"margin-left: 1px;margin-top: 1px;\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<img id=\"see\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/verify.jspx\" width=\"75\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"margin: 0px 0 0 60px;height:32px;\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<span id=\"loginBtn\" class=\"btn btn-login\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"margin-top:-36px;\">登录</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"loginFormIpt loginFormIptWiotTh\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"margin-top:8px;font-size:14px;\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" name=\"key\" value=\"1\"/>\r\n");
      out.write("\t\t\t\t\t\t<font color=\"#888\">记住用户</font>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" id=\"findPwd\" style=\"padding-left: 100px;\">忘记密码</a>\r\n");
      out.write("\t\t\t\t\t\t<font color=\"red\"></font>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: 220px;\">\r\n");
      out.write("\t\t<span style=\"color: #488ED5;\">Powered By www.itcast.cn</span><span\r\n");
      out.write("\t\t\tstyle=\"color: #488ED5;margin-left:10px;\">推荐浏览器（右键链接-目标另存为）：<a\r\n");
      out.write("\t\t\thref=\"http://download.firefox.com.cn/releases/full/23.0/zh-CN/Firefox-full-latest.exe\">Firefox</a>\r\n");
      out.write("\t\t</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/jsp/taglib.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("path");
    // /WEB-INF/jsp/taglib.jsp(5,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/taglib.jsp(5,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}

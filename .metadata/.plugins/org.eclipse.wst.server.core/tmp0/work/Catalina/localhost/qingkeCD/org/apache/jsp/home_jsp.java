/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M17
 * Generated at: 2017-05-10 12:58:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.qingke.pojo.Dictionary;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.qingke.pojo.Dictionary");
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<style type=\"text/css\">\n");
      out.write("html,body{padding:0; margin:0;}\n");
      out.write(".d2{\n");
      out.write("position:relative;\n");
      out.write("width:800px;\n");
      out.write("/*height:180px;*/\n");
      out.write("text-align:center;\n");
      out.write("line-height:40px;\n");
      out.write("margin:0 auto;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<title>轻课词典</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"d2\">\n");
      out.write("<h1>轻课词典</h1>\n");
      out.write("<hr>\n");
      out.write("<a href=\"upload.html\">上传文件</a>\n");
      out.write("<!-- <form action=\"SearchServlet\" > -->\n");
      out.write("<br/>\n");
      out.write("<input name=\"word\" type=\"text\" style=\"width:200px;height:30px;font-size:17px;\" placeholder = \"请输入单词\"></input>\n");
      out.write("\n");
      out.write("<!-- <button type=\"submit\" style=\"width:100px;height:30px;font-size:17px;\">搜索</button> -->\n");
      out.write("<div id=\"words\"></div>\n");
      out.write("<br/>\n");
      out.write("\n");
      out.write("<!-- </form> -->\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\" src=\"javascripts/jquery-3.1.1.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t\tconsole.log(1);\n");
      out.write("\t\t$(\"input[name='word']\").bind(\"input propertychange\",function(){\n");
      out.write("\t\t\tvar word = $(\"input[name='word']\").val();\n");
      out.write(" \t\t\tif(word.length == 0){\n");
      out.write(" \t\t\treturn false;\n");
      out.write(" \t\t};\n");
      out.write("\t\t/* function fiter(){  //监控为onchange时 用这种方法\n");
      out.write(" \t\t\tvar word = $(\"input[name='word']\").val();\n");
      out.write(" \t\t\tif(word.length == 0){\n");
      out.write(" \t\t\treturn false;\n");
      out.write(" \t\t}; \n");
      out.write(" \t\t//一种\n");
      out.write(" \t\t/* $.get(\"search?word=\"+word,function(data){\n");
      out.write(" \t\t\tvar array = eval(\"(\"+data+\")\");\n");
      out.write(" \t\t\tif(array.length == 0) {\n");
      out.write(" \t\t\t\t$(\"#words\").append(\"<p>no dic</p>\");\n");
      out.write(" \t\t\t}\n");
      out.write(" \t\t\t$(\"#words\").empty();\n");
      out.write(" \t\t\tfor(var i = 0;i < array.length;i++){\n");
      out.write(" \t\t\t\tconsole.log(array[i]);\n");
      out.write(" \t\t\t\t$(\"#words\").append(\"<p>\"+array[i].word+\":\"+array[i].description+\"</p>\");\n");
      out.write(" \t\t\t}\n");
      out.write(" \t\t}); */\n");
      out.write(" \t\t//第二种\n");
      out.write(" \t\t/*  $.get(\"search?word=\"+word,function(data){\n");
      out.write(" \t\t\tif(data.length == 0) {\n");
      out.write(" \t\t\t\t$(\"#words\").append(\"<p>no dic</p>\");\n");
      out.write(" \t\t\t}\n");
      out.write(" \t\t\t<!--清空标签内的内容-->\n");
      out.write(" \t\t\t$(\"#words\").empty();\n");
      out.write(" \t\t\t<!--遍历数组并把每一个元素添加到words标签内-->\n");
      out.write(" \t\t\tfor(var i = 0;i < data.length;i++){\n");
      out.write(" \t\t\t\tconsole.log(data[i]);\n");
      out.write(" \t\t\t\t$(\"#words\").append(\"<p>\"+data[i].word+\":\"+data[i].description+\"</p>\");\n");
      out.write(" \t\t\t}\n");
      out.write(" \t\t},'json');  */\n");
      out.write(" \t\t $.ajax({ \n");
      out.write(" \t\t\turl:\"SearchServlet\",\n");
      out.write(" \t\t\ttype:\"GET\",\n");
      out.write(" \t\t\tdata:{word:word},\n");
      out.write(" \t\t\tdataType:\"json\",\n");
      out.write(" \t\t\tasync:false,\n");
      out.write(" \t\t\tsuccess: function(data){\n");
      out.write(" \t\t\t\tif(data.length == 0) {\n");
      out.write(" \t\t\t\t\t$(\"#words\").append(\"<p>no dic</p>\");\n");
      out.write(" \t \t\t\t}\n");
      out.write(" \t \t\t\t<!--清空标签内的内容-->\n");
      out.write(" \t \t\t\t$(\"#words\").empty();\n");
      out.write(" \t \t\t\t<!--遍历数组并把每一个元素添加到words标签内-->\n");
      out.write(" \t \t\t\tfor(var i = 0;i < data.length;i++){\n");
      out.write(" \t \t\t\t\tconsole.log(data[i]);\n");
      out.write(" \t \t\t\t\t$(\"#words\").append(\"<p>\"+data[i].word+\":\"+data[i].description+\"</p>\");\n");
      out.write(" \t \t\t\t}\n");
      out.write(" \t\t\t}\n");
      out.write(" \t\t}); \n");
      out.write(" \t});\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
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

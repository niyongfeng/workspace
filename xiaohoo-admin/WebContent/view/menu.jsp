<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String v = request.getParameter("v");
    if (v==null) {v="";}
%>
<ul class="sidebar-menu">
    <li class="header">导航</li>
    <!-- Optionally, you can add icons to the links -->

    <li class="treeview">
        <a href="#">
            <i class="fa fa-user-secret"></i>
            <span>管理员管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>

        <ul  <% if(v.equals("admin_menu")) {%> class="treeview-menu menu-open" style="display: block;" <%}else{ %> class="treeview-menu" <%} %> >
            <li id="admin_menu" <% if(v.equals("admin_menu")) {%> class="active" <%} %> ><a href="/xiaohoo-admin/view/admin/adminList.jsp?v=admin_menu"><i class="fa fa-circle-o"></i> 账户管理</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> 日志管理</a></li>
        </ul>
    </li>

    <li class="treeview">
        <a href="#">
            <i class="fa fa-user"></i>
            <span>用户管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul  <% if(v.equals("user_menu")) {%> class="treeview-menu menu-open" style="display: block;" <%}else{ %> class="treeview-menu" <%} %> >
            <li id="user_menu" <% if(v.equals("user_menu")) {%> class="active" <%} %> ><a href="/xiaohoo-admin/view/user/userList.jsp?v=user_menu"><i class="fa fa-circle-o"></i> 用户</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> 短信验证码</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> 权限管理</a></li>
        </ul>
    </li>

</ul>

<script type="text/javascript">


</script>

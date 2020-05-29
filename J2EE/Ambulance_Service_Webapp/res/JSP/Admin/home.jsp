<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="com.dev.util.Utility"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Admin Home</title>

<link href="<%=request.getContextPath()%>/res/CSS/centerd_menu_tab.css" rel="stylesheet" type="text/css"/>

<%-- Nav Menu (Starts) --%>
<link href="<%=request.getContextPath()%>/res/CSS/message.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="<%=request.getContextPath()%>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/JS/script.js"></script>

<script>
    history.forward();
</script>

</head>

<body onload="startTimer()">
<img src="<%=request.getContextPath()%>/res/Images/title.png" width="1024" height="80"  alt=""/>


<div id="centeredmenu" style="margin-top: 1px;">
    <ul>
	      
	      
	     <li><a href="<%=request.getContextPath()%>/HospitalCreation?action=get" target="myFrame">Hospital</a></li>
	     <li><a href="<%=request.getContextPath()%>/Ambulance?action=get" target="myFrame">Ambulance</a></li>
	     <li><a href="<%=request.getContextPath()%>/index.jsp?no=2">Sign Out</a></li>
    </ul>
    
</div>



<div class="Content" style="position: absolute;">
<iframe src="<%=request.getContextPath()%>/res/JSP/Admin/default.jsp" name="myFrame" height="590" width="918"></iframe>
</div>

<%
	int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{
%>
			<div class="info" id="message" style="position:absolute;top:600px;left:50px">
				<p>Welcome! <%=AdminDAO.getAdminName((String)session.getAttribute("username"))%></p>
			</div>
		<%}
%>

</body>
</html>

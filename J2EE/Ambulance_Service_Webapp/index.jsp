<%@page import="com.dev.util.Utility"%>
<html>
<head>
<title>Index Page</title>

<link href="<%=request.getContextPath()%>/res/CSS/style1.css" rel="stylesheet" type="text/css">

<script>
    history.forward();
</script>


</head>

<body onload="startTimer();changeHashOnLoad();">
<center>
  <img src="<%=request.getContextPath()%>/res/Images/title.png" width="1024" height="80"  alt=""/> 

</center>

<%-- Admin Login (Starts) --%>
	<div class="container" style="position:absolute;top:150px;left:30px;">
			 <!-- Codrops top bar -->
           
                           <div id="boxForm">
                           <h2 id="title">Admin Login Page</h2>
                            <form  action="<%=request.getContextPath()%>/AdminLogin" method="post" autocomplete="on"> 
                                <input class='text' type='username' name='username' placeholder='username' required>
    							<br>
   								<input class='text' id='pwd'  type='password' name='password' placeholder='Password' required>
    							<br>
    							<input id='rememberMe' name='rememberMe' type='checkbox'> <label>Remember me</label>
    							<br>
    							<input class='button' type='submit' value='Login'>
                                
                            </form>
                            <script src="js/index.js"></script>
                        </div>

                        
                    </div>
                

<%-- Developer Signature(Ends) --%>

<%
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>Invalid Username / Password ...!!</p>
			</div>
<%
		}
		if(no==2)
		{
%>
			<div class="success" id="message" style="position:absolute;top:600px;left:50px">
				<p>You Have Logged Out Successfully.....</p>
			</div>
<%
		}
		if(no==3)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>password resetted Successfully</p>
			</div>
<%
		}
		if(no==4)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>Sorry,User Already Exists!!!!!</p>
			</div>
<%
		}
		if(no==5)
		{
%>
			<div class="success" id="message" style="position:absolute;top:600px;left:50px">
				<p>Registration Done Successfully.....</p>
			</div>
<%
		}
		if(no==6)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>Opps,Invalid User!!!!!</p>
			</div>
<%
		}
		if(no==7)
		{
%>
			<div class="success" id="message" style="position:absolute;top:600px;left:50px">
				<p>Your Password Mailed To Your Mail.</p>
			</div>
<%
		}
		if(no==8)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>Opps,Mailing Process Failed,Check Internet!!!!!</p>
			</div>
<%
		}
%>



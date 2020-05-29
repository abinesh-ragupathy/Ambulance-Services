<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Update Police Station</title>
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<%-- Easy UI Validation (Starts) --%>	
<link href="<%=request.getContextPath() %>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>
<%-- Easy UI Validation (Ends) --%>	

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>

</head>

<%!

	String code=null;
	String police_station_name="",Address1="",Address2="",Area="",City="",state="",pin="",land_line="",cell_no1="",cell_no2="",remarks="",latitude="",logitude="";
%>
<% int csno=0; %>
 <%
 int i=1;
 ResultSet rs=AdminDAO.getcheckAmbulanceno();

%>
<%
	// rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	if(rs != null)
	{
		if(rs.next())
		{
			 csno = i;
			code = rs.getString(1);
			police_station_name = rs.getString(2);
			Address1 = rs.getString(3);
			Address2 = rs.getString(4);
			Area = rs.getString(5);
			City=rs.getString(6);
			state=rs.getString(7);
			pin=rs.getString(8);
			land_line=rs.getString(9);
			cell_no1=rs.getString(10);
			/* cell_no2=rs.getString(11); */
			remarks=rs.getString(11);
			latitude=rs.getString(12);
			logitude=rs.getString(13);
	   		
		}
	}
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:15;left:190px;">
	<form name="frm" action="<%=request.getContextPath()%>/Ambulance">
			
	<h1>Update Police station Details</h1>
	<table style="width: 500px;text-align: center;">
		
		<tr align="center">
	        <td>
	        		police_station_name<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="police_station_name"  value="<%=police_station_name%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		<tr align="center">
	        <td>
	        		Address1<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="Address1"  value="<%=Address1%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		<tr align="center">
	        <td>
	        		Address2<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="Address2"  value="<%=Address2%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		<tr align="center">
	        <td>
	        		Area<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="Area"  value="<%=Area%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		<tr align="center">
	        <td>
	        		City<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="City"  value="<%=City%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		<tr align="center">
	        <td>
	        		State<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="state"  value="<%=state%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		<tr align="center">
	        <td>
	        		Pin<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="pin"  value="<%=pin%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		<tr align="center">
	        <td>
	        		Land Line<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="land_line"  value="<%=land_line%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		<tr align="center">
	        <td>
	        		Cell no1<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="cell_no1"  value="<%=cell_no1%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		<%-- <tr align="center">
	        <td>
	        		Cell no2<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="cell_no2"  value="<%=cell_no2%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr> --%>
		<tr align="center">
	        <td>
	        		Remark<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="remarks"  value="<%=remarks%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
			
		<tr align="center">
	        <td>
	        		Latitude<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
			        <%--
			        		pattern="^-?([0-8]?[0-9]|90)\.[0-9]{1,6}"
			        		It valids lat -90.XXXXXX to 90.XXXXXX
			        		Example : -85.123456
			         --%>
					<input type="text" name="latitude" value="<%=latitude%>" class="easyui-validatebox" required="required" pattern="^-?([0-8]?[0-9]|90)\.[0-9]{1,6}"  title="Please,Enter The Valid Latitude(x-axis)."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		<tr align="center">
	        <td>
	        		Longitude<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
			        <%--
			        		pattern="-?((1?[0-7]?|[0-9]?)[0-9]|180)\.[0-9]{1,6}"
			        		It valids  lng -180.XXXXXX to 180.XXXXXX
			        		Example : -100.123456
			         --%>
					<input type="text" name="logitude" value="<%=logitude%>" class="easyui-validatebox" pattern="-?((1?[0-7]?|[0-9]?)[0-9]|180)\.[0-9]{1,6}" required="required"   title="Please,Enter The Valid Longitude(y-axis)."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		
		
		
		<tr align="center">
				<td colspan="3" align="center">
						<input type="submit" name="action" value="Delete Police" style="left: 201px;"/>
	
					    <input type="hidden" name="delete" value="YES" />
					    <%-- <input type="hidden" name="code" value="<%=code%>"></input> --%>
				</td>
		</tr>
	</table>
	   
	</form><!-- form -->
	<div class="button">
		
	</div><!-- button -->
</section><!-- content -->

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<div class="info" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Ambulance Details Added Successfully......</p>
		</div>			
<%
	}
	
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opps,Something Went Wrong Try Again Latter!!!!!</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Sorry,This Land Mark Already Exists!!!!!</p>
		</div>			
<%
	}
%>

</body>
</html>
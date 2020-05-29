<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Add Hospital Details</title>
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<%-- Easy UI Validation (Starts) --%>	
<link href="<%=request.getContextPath() %>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<link href="<%=request.getContextPath() %>/res/CSS/popup.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/map.js"></script>

<%-- Easy UI Validation (Ends) --%>	

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>

<!-- <script
src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
</script> -->
<script
src="http://maps.googleapis.com/maps/api/js?key=AIzaSyC-GYbPUsFoQTLdY-mChcWqYLfRZflchSE&sensor=false">
</script>

<style type="text/css">
	
#file
{
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	-ms-border-radius: 3px;
	-o-border-radius: 3px;
	border-radius: 3px;
	-webkit-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-moz-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-ms-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-o-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-ms-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	
	border: 1px solid #c8c8c8;
	color: #777;
	font: 13px Helvetica, Arial, sans-serif;
	margin: 0 0 10px;
	padding: 5px 1px 5px 1px;
	width: 100px;
	
}

</style>
<% int csno=0; %>
<%int H_code=0; %>
<% String Hospital_name="",Address1="",Address2="",Area="",city="",state="",pin="",land_line="",cell_no1="",remarks="",latitude="",logitude=""; %>
 <%
String check=request.getParameter("num");
 
 System.out.println("check"+check);
 ResultSet rs=AdminDAO.getHospital1(check);

%>

<%



	if(rs!=null)
		while(rs.next())
		{
		
			H_code=rs.getInt(1);
			Hospital_name=  rs.getString(2);
			Address1=rs.getString(3);
			Address2=rs.getString(4);
			Area=rs.getString(5);
			city=rs.getString(6);
			state=	rs.getString(7);
			pin=rs.getString(8);
			land_line=rs.getString(9);
			cell_no1=rs.getString(10);
			remarks=	rs.getString(11);
			latitude=rs.getString(12);
			logitude=rs.getString(13);
			
	    }   
	%>
		

</head>


<body onload="startTimer()">
<section id="content" style="position: absolute;top:15;left:190px;">

	
	<form name="frm" action="<%=request.getContextPath()%>/HospitalCreation">
			
	<h1>Edit Hospital </h1>
	 	
	
	<table style="width: 500px;text-align: center;">
         <input type="hidden" name="chk" value="<%= H_code%>" class="easyui-validatebox" />
		<tr align="center">
	        <td>
	        		Hospital Name:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="Hospital_name" value="<%= Hospital_name%>" class="easyui-validatebox" />
			</td>
			
			
			<td width="15px"></td>
		</tr>
		<tr align="center">
	        <td>
	        		Address1:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="Address1"   value="<%=Address1%>" class="easyui-validatebox" />
			</td>
			
			
			<td width="15px"></td>
		</tr>
		<tr align="center">
	        <td>
	        		Address2:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="Address2"  value="<%=Address2%>"  class="easyui-validatebox"  />
			</td>
			
			
			<td width="15px"></td>
		</tr>
		<tr align="center">
	        <td>
	        		Area:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="Area"  value="<%=Area%>"   class="easyui-validatebox"   />
			</td>
			
			<td width="15px"></td>
		</tr>
		<tr align="center">
	        <td>
	        		City:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="city"   value="<%=city%>"  class="easyui-validatebox"   />
			</td>
			
			<td width="15px"></td>
		</tr>
		<tr align="center">
	        <td>
	        		State:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="state"  value="<%=state%>"   class="easyui-validatebox"   />
			</td>
			
			<td width="15px"></td>
		</tr>
		<tr align="center">
	        <td>
	        		Pin Code:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="pin"  value="<%=pin%>"  class="easyui-validatebox"  />
			</td>
			
			<td width="15px"></td>
		</tr>
		<tr align="center">
	        <td>
	        		Land Line:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="land_line"   value="<%=land_line%>"  class="easyui-validatebox"   />
			</td>
			
			<td width="15px"></td>
		</tr>
		<tr align="center">
	        <td>
	        		Cell NO1:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="cell_no1"  value="<%=cell_no1%>"  class="easyui-validatebox"   />
					
			</td>
			
			<td width="15px"></td>
		</tr>
		<!-- <tr align="center">
	        <td>
	        		Cell NO2:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="cell_no2"  class="easyui-validatebox"   />
					
			</td>
			
			<td width="15px"></td>
		</tr> -->
		<tr align="center">
	        <td>
	        		Remark:<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="remarks"  value="<%=remarks%>"  class="easyui-validatebox"   />
			</td>
			
			<td width="15px"></td>
		</tr>
		
		
		<tr align="center">
		
	        <td>
	        		Latitude<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
			       
					<input type="text" id="x" name="latitude"  value="<%=latitude%>"   class="easyui-validatebox"  />
			</td>
			
			
			<td width="15px" style="position: relative;top: 25px;left: -20px">
				<input type="image"  src="<%=request.getContextPath()%>/res/Images/google_maps.png" onclick="return getMap();"></input>
			</td>
		<tr>	
		
		<tr align="center">
	        <td>
	        		Longitude<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
			       
					<input 
					type="text" id="y" name="logitude" value="<%=logitude %>" class="easyui-validatebox" />
			</td>
			
			
			<td width="15px">
			</td>
		</tr>
		
		
		
		<tr align="center">
				<td colspan="3" align="center">
						<input  type="submit" name="action" value="Edit" style="left:190px;width: 150px;"/>
						
				</td>
		</tr>
<%-- 		 <%
		}
%>  --%>
	</table>
	
	<%-- Getting Google Map Popup(Starts) --%>  
	<div id="light" class="white_content" > 
		<a href = "javascript:void(0)" onclick = "closelightbox()" style="float:right"><img src="<%=request.getContextPath()%>/res/Images/close.gif" alt="" /></a>
		
		
		<div  id="googleMap" style="width:710px;height:510px;"></div>
		
    </div>
    <div id="fade" class="black_overlay"></div>
	 
	<%-- Getting Google Map Popup(Ends) --%>  
	</form><!-- form -->
	<div class="button">
		
	</div><!-- button -->
</section><!-- content -->

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<div class="info" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Hospital Details Added Successfully......</p>
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
			<p>Sorry,This Hospital Already Exists!!!!!</p>
		</div>			
<%
	}
%>

</body>
</html>
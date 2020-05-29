package com.dev.admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.AdminDAO;
import com.dev.util.Utility;

public class HospitalCreation extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean result = false,flag=false;
		String Hospital_name="",Address1="",Address2="",Area="",city="",state="",pin="",land_line="",cell_no1="",remarks="",latitude="",logitude="";
		HttpSession session = request.getSession();
		try{
           String submit=request.getParameter("action");
           System.out.println("submit value is >>>>>>>>>>>"+submit);
		   rs=AdminDAO.getHospital();
		   if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/hospital_list.jsp");
				rd.forward(request, response);
			}
		   if(submit.equals("Add Hospital"))
		   {
			   String add=request.getParameter("add");
			   System.out.println(">>>>>addd>>>>>>"+add);
			if(Utility.parse1(request.getParameter("add")).equals("YES"))
			{
			Hospital_name=request.getParameter("Hospital_name");
			Address1=request.getParameter("Address1");
			Address2=request.getParameter("Address2");
			Area=request.getParameter("Area");
			city=request.getParameter("city");
			state=request.getParameter("state");
			pin=request.getParameter("pin");
			land_line=request.getParameter("land_line");
			cell_no1=request.getParameter("cell_no1");
			/*cell_no2=request.getParameter("cell_no2");*/
			remarks=request.getParameter("remarks");
			latitude=request.getParameter("latitude");
			logitude=request.getParameter("logitude");
			
			flag=AdminDAO.checkhospital(Hospital_name);
			if(!flag)
			{
				flag = AdminDAO.addhospital(Hospital_name, Address1, Address2, Area, city, state, pin, land_line, cell_no1, remarks, latitude, logitude);
				if(flag)
				{
					rs=AdminDAO.getHospital();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/hospital_list.jsp?no=1");
					rd.forward(request, response);
				}
				else
				{
						rd=request.getRequestDispatcher("/res/JSP/Admin/add_landmark.jsp?no=2");
						rd.forward(request, response);
				}
			}
			else
			    {
				        rd=request.getRequestDispatcher("/res/JSP/Admin/add_landmark.jsp?no=3");
				        rd.forward(request, response);
			    }
		    }
		    else
			{
				rd=request.getRequestDispatcher("/res/JSP/Admin/add_landmark.jsp");
				rd.forward(request, response);
			}	
		  }
		   
		   
		
		   
		   
		   //edit
		   if(submit.equals("Edit Hospital"))
		   {
			   String edit=request.getParameter("edit");
			   System.out.println("edit>>>>>>>>>"+edit);
			   String []chk11  =request.getParameterValues("chk");
			   System.out.println("chk[]>>>>>>>>>>>"+chk11[0]);
			   
			   rd=request.getRequestDispatcher("/res/JSP/Admin/edit_landmark.jsp?num="+chk11[0]);
				rd.forward(request, response); 
		   }
		   
		   
		   
		   
		   
   
			if(submit.equals("Edit"))
			{
				
				System.out.println("its came edit condition");
			
			String s[]=new String [14];
			
			s[0] =request.getParameter("Hospital_name");
			System.out.println("hospitalname>>>>>>>>>>>>"+s[0]);
			s[1]=request.getParameter("Address1");
			s[2]=request.getParameter("Address2");
			s[3]=request.getParameter("Area");
			s[4]=request.getParameter("city");
			s[5] =request.getParameter("state");
			s[6]=request.getParameter("pin");
			s[7]=request.getParameter("land_line");
			s[8]=request.getParameter("cell_no1");
			
			s[9]=request.getParameter("remarks");
			s[10]=request.getParameter("latitude");
			s[11]=request.getParameter("logitude");
			
			s[12]=request.getParameter("chk");
			
	
			
				flag = AdminDAO.edithospital(s[0] , s[1] , s[2] , s[3] , s[4] , s[5] , s[6] , s[7] , s[8] ,  s[9] , s[10] , s[11],s[12]);
				if(flag)
				{
					rs=AdminDAO.getHospital();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/hospital_list.jsp?no=5");
					rd.forward(request, response);
				}
				else
				{
						rd=request.getRequestDispatcher("/res/JSP/Admin/edit_landmark.jsp?no=2");
						rd.forward(request, response);
				}
			
		    }
		
		
		   
		   if(submit.equals("Delete Hospital"))
		   {
			   String delete=request.getParameter("delete");
			   System.out.println("delete>>>>>>>>>"+delete);
			   String []chk=request.getParameterValues("chk");
			   System.out.println("chk[]>>>>>>>>>>>"+chk[0]);
			
				flag = AdminDAO.deletehospital(chk[0]);
				if(flag)
				{
					rs=AdminDAO.getHospital();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/hospital_list.jsp?no=1");
					rd.forward(request, response);
				}
				else
				{
						rd=request.getRequestDispatcher("/res/JSP/Admin/delete_landmark.jsp?no=2");
						rd.forward(request, response);
			
				}
		   
		   }
		} 
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin hospital Creation Servlet : ");
			e.printStackTrace();
			
		}
	}
}

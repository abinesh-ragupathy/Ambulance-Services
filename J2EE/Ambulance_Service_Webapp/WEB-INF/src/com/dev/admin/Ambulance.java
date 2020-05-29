package com.dev.admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.AdminDAO;
import com.dev.util.Utility;
public class Ambulance extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{  
		String []chk11 = null;
		PrintWriter out=response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean result = false,flag=false;
		String ambulance_loc_name="",Address1="",Address2="",Area="",City="",state="",pin="",land_line="",cell_no1="",cell_no2="",remarks="",latitude="",logitude="";
		HttpSession session = request.getSession();
		try{
           String submit=request.getParameter("action");
       	   System.out.println("police station submit>>>>>>>>>>>"+submit);
		   rs=AdminDAO.getAmbulance();
		   if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/ambulance_list.jsp");
				rd.forward(request, response);
			}
		   if(submit.equals("Add Ambulance"))
		   {
			if(Utility.parse1(request.getParameter("add")).equals("YES"))
			{
			ambulance_loc_name=request.getParameter("ambulance_loc_name");
			System.out.println("police station>>>>>>>>>>>"+ambulance_loc_name);
			Address1=request.getParameter("Address1");
			Address2=request.getParameter("Address2");
			Area=request.getParameter("Area");
			City=request.getParameter("City");
			state=request.getParameter("state");
			pin=request.getParameter("pin");
			land_line=request.getParameter("land_line");
			cell_no1=request.getParameter("cell_no1");
		/*	cell_no2=request.getParameter("cell_no2");*/
			remarks=request.getParameter("remarks");
			latitude=request.getParameter("latitude");
			logitude=request.getParameter("logitude");
			
			flag=AdminDAO.checkAmbulance(ambulance_loc_name);
			if(!flag)
			{
				flag = AdminDAO.addAmbulance(ambulance_loc_name, Address1, Address2, Area, City, state, pin, land_line, cell_no1,  remarks, latitude, logitude);
				if(flag)
				{
					rs=AdminDAO.getAmbulance();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/ambulance_list.jsp?no=1");
					rd.forward(request, response);
				}
				else
				{
						rd=request.getRequestDispatcher("/res/JSP/Admin/add_ambulance.jsp?no=2");
						rd.forward(request, response);
				}
			}
			else
			    {
				        rd=request.getRequestDispatcher("/res/JSP/Admin/add_ambulance.jsp?no=3");
				        rd.forward(request, response);
			    }
		    }
		    else
			{
				rd=request.getRequestDispatcher("/res/JSP/Admin/add_ambulance.jsp");
				rd.forward(request, response);
			}	
		  }
		   if(submit.equals("Edit Ambulance"))
		   {
			 
   	         chk11=request.getParameterValues("chk");
			   System.out.println("the police id+++++ "+chk11[0]);
			   
			  rs=AdminDAO.UdatAmbulance(chk11[0]);
			  request.setAttribute("rs", rs);
			  rd=request.getRequestDispatcher("/res/JSP/Admin/edit_ambulance.jsp");
		        rd.forward(request, response);
		   }
		  if(submit.equals("edit"))
		  {
				String chk=request.getParameter("chk");
				ambulance_loc_name=request.getParameter("ambulance_loc_name");
				Address1=request.getParameter("Address1");
				Address2=request.getParameter("Address2");
				Area=request.getParameter("Area");
				City=request.getParameter("City");
				state=request.getParameter("state");
				pin=request.getParameter("pin");
				land_line=request.getParameter("land_line");
				cell_no1=request.getParameter("cell_no1");
				remarks=request.getParameter("remarks");
				latitude=request.getParameter("latitude");
				logitude=request.getParameter("logitude");
				ArrayList<String> list = new ArrayList<String>();
				list.add(ambulance_loc_name);
				list.add(Address1);
				list.add(Address2);
				list.add(Area);
				list.add(City);
				list.add(state);
				list.add(pin);
				list.add(land_line);
				list.add(cell_no1);
			
				list.add(remarks);
				list.add(latitude);
				list.add(logitude);
				list.add(chk);
				flag = AdminDAO.updateAmbulance(list);
				System.out.println("%%%%%%%%%%%%%%");
				if(flag)
				{
					System.out.println("^^^^^^^^^^^^^^^^^^^^");
					rs=AdminDAO.getAmbulance();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/ambulance_list.jsp?no=5");
					rd.forward(request,response);
				}
				else
				{
					
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/edit_ambulance.jsp?no=2");
					rd.forward(request,response);
				} 
		  }
		  
		   
		   if(submit.equals("Delete Ambulance"))
		   {
			   String delete=request.getParameter("delete");
			   System.out.println("delete>>>>>>>>>"+delete);
			   String []chk=request.getParameterValues("chk");
			   System.out.println("chk[]>>>>>>>>>>>"+chk[0]);
			
			
				flag = AdminDAO.deleteAmbulance(chk[0]);
				if(flag)
				{
					rs=AdminDAO.getAmbulance();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/ambulance_list.jsp?no=3");
					rd.forward(request, response);
				}
				else
				{
					
					rd=request.getRequestDispatcher("/res/JSP/Admin/ambulance_list.jsp?no=6");
					rd.forward(request, response);
				}
			
		  
		    
		  }
		} 
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin Police Creation Servlet : ");
			e.printStackTrace();
			
		}
	}
}

		 
		  
		 
		
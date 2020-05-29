
package com.dev.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.AdminDAO;


@SuppressWarnings("serial")
public class ChangePassword extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		boolean flag = false;
		RequestDispatcher rd=null;
		String username= "";
		try
		{
			
			username=request.getParameter("username");
			String npass=request.getParameter("npass");
			String cpass=request.getParameter("cpass");
			if(!npass.equals(cpass))
			{
				rd=request.getRequestDispatcher("/res/JSP/Admin/change_password.jsp?no=2");
				rd.forward(request,response);
			}
			else
			{
				
				flag = AdminDAO.changePassword(username,npass);
				if(flag)
				{
					rd=request.getRequestDispatcher("/res/JSP/Admin/change_password.jsp?no=1");
					rd.forward(request,response);
				}
				else
				{
					rd=request.getRequestDispatcher("/res/JSP/Admin/change_password.jsp?no=3");
					rd.forward(request,response);
				}
				
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception In Admin==>ChangePassword Servlet : ");
			e.printStackTrace();
			out.println("Opps,Exception In Admin==>ChangePassword Servlet : "+e);
		}
	}
}

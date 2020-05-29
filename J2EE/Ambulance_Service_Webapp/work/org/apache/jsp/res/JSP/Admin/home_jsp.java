package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dev.dao.AdminDAO;
import com.dev.util.Utility;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\r\n");
      out.write("<title>Admin Home</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/centerd_menu_tab.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/res/JS/jquery-1.8.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/res/JS/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    history.forward();\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath());
      out.write("/res/Images/title.png\" width=\"1024\" height=\"80\"  alt=\"\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"centeredmenu\" style=\"margin-top: 1px;\">\r\n");
      out.write("    <ul>\r\n");
      out.write("\t      \r\n");
      out.write("\t      \r\n");
      out.write("\t     <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/HospitalCreation?action=get\" target=\"myFrame\">Hospital</a></li>\r\n");
      out.write("\t     <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Ambulance?action=get\" target=\"myFrame\">Ambulance</a></li>\r\n");
      out.write("\t     <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp?no=2\">Sign Out</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"Content\" style=\"position: absolute;\">\r\n");
      out.write("<iframe src=\"");
      out.print(request.getContextPath());
      out.write("/res/JSP/Admin/default.jsp\" name=\"myFrame\" height=\"590\" width=\"918\"></iframe>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

	int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"info\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\r\n");
      out.write("\t\t\t\t<p>Welcome! ");
      out.print(AdminDAO.getAdminName((String)session.getAttribute("username")));
      out.write("</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dev.util.Utility;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Index Page</title>\n");
      out.write("\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/style1.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    history.forward();\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body onload=\"startTimer();changeHashOnLoad();\">\n");
      out.write("<center>\n");
      out.write("  <img src=\"");
      out.print(request.getContextPath());
      out.write("/res/Images/title.png\" width=\"1024\" height=\"80\"  alt=\"\"/> \n");
      out.write("\n");
      out.write("</center>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<div class=\"container\" style=\"position:absolute;top:150px;left:30px;\">\n");
      out.write("\t\t\t <!-- Codrops top bar -->\n");
      out.write("           \n");
      out.write("                           <div id=\"boxForm\">\n");
      out.write("                           <h2 id=\"title\">Admin Login Page</h2>\n");
      out.write("                            <form  action=\"");
      out.print(request.getContextPath());
      out.write("/AdminLogin\" method=\"post\" autocomplete=\"on\"> \n");
      out.write("                                <input class='text' type='username' name='username' placeholder='username' required>\n");
      out.write("    \t\t\t\t\t\t\t<br>\n");
      out.write("   \t\t\t\t\t\t\t\t<input class='text' id='pwd'  type='password' name='password' placeholder='Password' required>\n");
      out.write("    \t\t\t\t\t\t\t<br>\n");
      out.write("    \t\t\t\t\t\t\t<input id='rememberMe' name='rememberMe' type='checkbox'> <label>Remember me</label>\n");
      out.write("    \t\t\t\t\t\t\t<br>\n");
      out.write("    \t\t\t\t\t\t\t<input class='button' type='submit' value='Login'>\n");
      out.write("                                \n");
      out.write("                            </form>\n");
      out.write("                            <script src=\"js/index.js\"></script>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                \n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Invalid Username / Password ...!!</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==2)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>You Have Logged Out Successfully.....</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==3)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>password resetted Successfully</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==4)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Sorry,User Already Exists!!!!!</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==5)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Registration Done Successfully.....</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==6)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Opps,Invalid User!!!!!</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==7)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Your Password Mailed To Your Mail.</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==8)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Opps,Mailing Process Failed,Check Internet!!!!!</p>\n");
      out.write("\t\t\t</div>\n");

		}

      out.write('\n');
      out.write('\n');
      out.write('\n');
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.52
 * Generated at: 2014-05-10 19:23:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.couponAdmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import il.ac.hit.samples.*;
import java.util.*;

public final class updateCoupon_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=windows-1255");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("     \r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("       <head>   \r\n");
      out.write("           \t");

  		if(session.getAttribute("username") == null)
  		{
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/CouponServlet/admin");	
			dispatcher.forward(request, response);
  		}

  		
      out.write("\r\n");
      out.write("              <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("              <title>Update Coupon - Couponic Admin</title>\r\n");
      out.write("\t\t\t  \r\n");
      out.write("              <!-- Bootstrap core CSS -->\r\n");
      out.write("              <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("              <!--custom CSS-->\r\n");
      out.write("              <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/css/sb-admin.css\" rel=\"stylesheet\">\r\n");
      out.write("              <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("              <!-- Page Specific CSS -->\r\n");
      out.write("              <link rel=\"stylesheet\" href=\"http://cdn.oesmith.co.uk/morris-0.4.3.min.css\">\r\n");
      out.write("          </head>\r\n");
      out.write("\r\n");
      out.write("          <body>\r\n");
      out.write("\r\n");
      out.write("          <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("              <!-- Sidebar -->\r\n");
      out.write("              <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("                  <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("                  <div class=\"navbar-header\">\r\n");
      out.write("                      <a class=\"navbar-brand\" href=\"index.html\">Admin-Couponic</a>\r\n");
      out.write("                  </div>\r\n");
      out.write(" <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("        <div class=\"collapse navbar-collapse navbar-ex1-collapse\">\r\n");
      out.write("          <ul class=\"nav navbar-nav side-nav\">\r\n");
      out.write("            <li class=\"active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/couponAdmin.jsp\"><i class=\"fa fa-dashboard\"></i>Dashboard</a></li>           \r\n");
      out.write("           <li class=\"dropdown\">\r\n");
      out.write("              <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/couponManagement.jsp\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-book fa-fw\"></i> Coupon Management <b class=\"caret\"></b></a>\r\n");
      out.write("              <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CouponServlet/addCouponInit\"><i class=\"fa fa-plus\"></i> Add Coupon</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/deleteCoupon.jsp\"><i class=\"fa fa-trash-o\"></i> Delete Coupon</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CouponServlet/updateCouponInit\"><i class=\"fa fa-pencil\"></i> Update Coupon</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("\t\t\t <li class=\"dropdown\">\r\n");
      out.write("              <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/businessManagement.jsp\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-th\"></i> Business Management <b class=\"caret\"></b></a>\r\n");
      out.write("              <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/addBusiness.jsp\"><i class=\"fa fa-plus\"></i> Add Business</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/deleteBusiness.jsp\"><i class=\"fa fa-trash-o\"></i> Delete Business</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/updateBusiness.jsp\"><i class=\"fa fa-pencil \"></i> Update Business</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("\t\t\t <li class=\"dropdown\">\r\n");
      out.write("              <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/categoryManagement.jsp\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-caret-square-o-down\"></i> Categories Management <b class=\"caret\"></b></a>\r\n");
      out.write("              <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/addCategory.jsp\"><i class=\"fa fa-plus\"></i> Add Category</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/deleteCategory.jsp\"><i class=\"fa fa-trash-o\"></i> Delete Category</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/updateCategory.jsp\"><i class=\"fa fa-pencil \"></i> Update Category</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("\r\n");
      out.write("    <ul class=\"nav navbar-nav navbar-right navbar-user\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <li class=\"dropdown user-dropdown\">\r\n");
      out.write("              <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-user\"></i>admin<b class=\"caret\"></b></a>\r\n");
      out.write("              <ul class=\"dropdown-menu\">            \r\n");
      out.write("                <li class=\"divider\"></li>\r\n");
      out.write("                 <form role=\"form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CouponServlet/logout\" method=\"POST\" >\r\n");
      out.write("                   <input type=\"hidden\" name=\"logout\" value=\"logout\" > \r\n");
      out.write("                <li><i class=\"fa fa-power-off\"></i> <button type=\"submit\"  class=\"btn btn-default\" >Logout</button></li>\r\n");
      out.write("                </form>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div><!-- /.navbar-collapse -->\r\n");
      out.write("      </nav>\r\n");
      out.write("\r\n");
      out.write("      <div id=\"page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-12\">\r\n");
      out.write("            <h1>Update Coupon<small></small></h1>\r\n");
      out.write("            <ol class=\"breadcrumb\">\r\n");
      out.write("              <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/couponAdmin.jsp\"><i class=\"icon-dashboard\"></i> Dashboard</a></li>\r\n");
      out.write("              <li class=\"active\"><i class=\"icon-file-alt\"></i>Update the coupon By id </li>\r\n");
      out.write("            </ol>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div><!-- /.row -->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-6\">\r\n");
      out.write("            <form role=\"form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CouponServlet/adminController\" name=\"updateCouponForm\"  method=\"POST\" onsubmit=\"return checkForm();\" >\r\n");
      out.write("\t  \t\t  <input type=\"hidden\" name=\"controller\" class=\"form-control\" value=\"updateCoupon\" >\r\n");
      out.write("              <div class=\"form-group\">\r\n");
      out.write("                <label>Coupon id</label>\r\n");
      out.write("                <input type=\"text\" name=\"id\" class=\"form-control\" placeholder=\"Enter text\" >\r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("\t\t\t  <div class=\"form-group\">\r\n");
      out.write("                <label>coupon Name</label>\r\n");
      out.write("                <input type=\"text\" name=\"couponName\" class=\"form-control\" placeholder=\"Enter text\" >\r\n");
      out.write("              </div>\r\n");
      out.write("\t\t\t  <div class=\"form-group\">\r\n");
      out.write("                <label>imageURL</label>\r\n");
      out.write("                <input type=\"text\" name=\"image\" class=\"form-control\" placeholder=\"Enter text\" >\r\n");
      out.write("              </div>\r\n");
      out.write("\t\t\t  <div class=\"form-group\">\r\n");
      out.write("                <label>Price</label>\r\n");
      out.write("                <input type=\"text\" name=\"price\" class=\"form-control\" placeholder=\"Enter text\" >\r\n");
      out.write("              </div>\r\n");
      out.write("\t\t\t  \t<div class=\"form-group\">\r\n");
      out.write("                <label>Coupon Date Exipre</label>\r\n");
      out.write("\t\t\t\t<div class=\"bfh-datepicker\">\r\n");
      out.write("                <input type=\"date\" name=\"Date\" class=\"form-control\" placeholder=\"Enter text\" >\r\n");
      out.write("              </div>\r\n");
      out.write("              </div>\r\n");
      out.write("              \t <div class=\"form-group\">\r\n");
      out.write("                <label>Coupon Time Exipre</label>\r\n");
      out.write("\t\t\t\t<div class=\"bfh-datepicker\">\r\n");
      out.write("                <input type=\"time\" name=\"time\" class=\"form-control\" placeholder=\"Enter text\" >\r\n");
      out.write("              </div>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  <div class=\"form-group\">\r\n");
      out.write("                <label>Details</label>\r\n");
      out.write("                <input type=\"text\" name=\"Details\" class=\"form-control\" placeholder=\"Enter text\" >\r\n");
      out.write("              </div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("                <label>Business Select</label>\r\n");
      out.write("                <select name=\"business\" class=\"form-control\">\r\n");
      out.write("                ");
	
					ArrayList<Object> listBiz = (ArrayList<Object>)request.getAttribute("allBusiness");
					if(listBiz != null)
					{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"\" disabled selected>Select your Business</option>\r\n");
      out.write("\t\t\t\t");

					for(int i= 0;i<listBiz.size();i++)
					{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
 Business b = (Business)listBiz.get(i);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=");
      out.print(b.getBuisnessId());
      out.write('>');
      out.print(b.getName());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
} 	
	}
      out.write("\t\t\r\n");
      out.write("               </select>\r\n");
      out.write("              </div>\r\n");
      out.write("              \t<div class=\"form-group\">\r\n");
      out.write("                <label>Category Select</label>\r\n");
      out.write("               <select name=\"categories\" class=\"form-control\">\r\n");
	
@SuppressWarnings("unchecked")
ArrayList<Object> listCategories = (ArrayList<Object>)request.getAttribute("allCategories");
	if(listCategories != null)
	{
		 
      out.write("\r\n");
      out.write("\t\t\t<option value=\"\" disabled selected>Select your Category</option>\r\n");
      out.write("\t\t");

		for(int i= 0;i<listCategories.size();i++)
		  {
      out.write("\r\n");
      out.write("\t\t\t");
 Category category = (Category)listCategories.get(i);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<option value=");
      out.print( category.getCategoryId());
      out.write('>');
      out.print(category.getCategoryName());
      out.write("</option>\r\n");
      out.write("\t");
} 
		
		
	
	}
      out.write("\r\n");
      out.write("</select>\r\n");
      out.write("\t\t</div>\t  \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t");
 if(request.getAttribute("message") != null) {
			String massege = (String)request.getAttribute("message");
			
      out.write("\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t function MYALERT() { \r\n");
      out.write("\t\t\talert('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'); } MYALERT(); \r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t");
} 
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t  <button type=\"submit\" class=\"btn btn-default\">Submit Form</button>\r\n");
      out.write("              <button type=\"reset\" class=\"btn btn-default\">Reset Form</button>\r\n");
      out.write("</form>\r\n");
      out.write("      </div><!-- /#page-wrapper -->\r\n");
      out.write("    </div><!-- /#wrapper -->\r\n");
      out.write("\r\n");
      out.write("    <!-- JavaScript -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/js/jquery-1.10.2.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/js/bootstrap.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/couponAdmin/js/bootstrap-datepicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("  function checkForm()\r\n");
      out.write("  {\r\n");
      out.write("\t  var currentTime = new Date();\r\n");
      out.write("\t  var month = (currentTime.getMonth() + 1).toString();\r\n");
      out.write("\t  var day = currentTime.getDate().toString();\r\n");
      out.write("\t  var year = currentTime.getFullYear().toString();\r\n");
      out.write("\t  var today = (year+ \"-\" + (month[1] ? month:\"0\"+month[0])+ \"-\" + (day[1] ? day:\"0\"+day[0]));\r\n");
      out.write("\t  var todayDate = Date.parse(today);\r\n");
      out.write("\t\r\n");
      out.write("    var id = document.updateCouponForm.id.value;\r\n");
      out.write("\tvar price = document.updateCouponForm.price.value;\r\n");
      out.write("\tvar details = document.updateCouponForm.Details.value;\r\n");
      out.write("\tvar couponName = document.updateCouponForm.couponName.value;\r\n");
      out.write("\tvar image = document.updateCouponForm.image.value;\r\n");
      out.write("\tvar date = document.updateCouponForm.Date.value;\r\n");
      out.write("\tvar time = document.updateCouponForm.time.value;\r\n");
      out.write("\tvar choosenDate =Date.parse(date);\r\n");
      out.write("\tvar business = document.updateCouponForm.business.value;\r\n");
      out.write("\tvar categories = document.updateCouponForm.categories.value;\r\n");
      out.write("\tvar okNum = /^[0-9]+$/;\t\r\n");
      out.write("\tvar flag = true;\r\n");
      out.write("\t\r\n");
      out.write("\t\tif ((isEmpty(id)) == true ||(checkString(okNum, id)) == false)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('id: you need to insert valid integet number');\r\n");
      out.write("\t\t\t document.updateCouponForm.id.value;\r\n");
      out.write("\t\t\t flag = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ((isEmpty(couponName)) == true )\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('couponName: you need to insert valid integet number');\r\n");
      out.write("\t\t\t document.updateCouponForm.price.value;\r\n");
      out.write("\t\t\t flag = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ((isEmpty(price)) == true ||(checkString(okNum, price)) == false)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('price: you need to insert valid integet number');\r\n");
      out.write("\t\t\t document.updateCouponForm.price.value;\r\n");
      out.write("\t\t\t flag = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ((isEmpty(details)) == true )\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('details: you need to insert valid integet number');\r\n");
      out.write("\t\t document.updateCouponForm.price.value;\r\n");
      out.write("\t\t\t flag = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ((isEmpty(image)) == true || isValidURL(image) == false)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('image: you need to insert valid integet number');\r\n");
      out.write("\t\t\t document.updateCouponForm.image.value;\r\n");
      out.write("\t\t\t flag = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tif ((isEmpty(business)) == true )\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('business: you need to insert valid business name');\r\n");
      out.write("\t\t\t document.updateCouponForm.business.value;\r\n");
      out.write("\t\t\t flag = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ((isEmpty(categories)) == true )\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('category: you need to insert valid category name');\r\n");
      out.write("\t\t\t document.updateCouponForm.categories.value;\r\n");
      out.write("\t\t\t flag = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ((isEmpty(date)) == true)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('Please choose a Date');\r\n");
      out.write("\t\t\t flag = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ((isEmpty(time)) == true)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('Please choose a Time');\r\n");
      out.write("\t\t\t flag = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif (choosenDate<todayDate)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t alert('date: date small then today!!');\r\n");
      out.write("\t\t\t flag= false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(flag == true)\r\n");
      out.write("    {\r\n");
      out.write("\t\talert(\"this is your details,Click ok and wait to approval :\\n\"+\"id:\"+id+\"\\n\"+\r\n");
      out.write("\t\t\t\t\"date:\" +date+ \"\\n\"+\r\n");
      out.write("\t\t\t\t\"time:\" +time+\"\\n\"+\r\n");
      out.write("\t\t\t\t\"price:\" +price+\"\\n\"+\r\n");
      out.write("\t\t\t\t\"coupon Name:\" +couponName+\"\\n\"+\r\n");
      out.write("\t\t\t\t\"business ID:\" +business+\"\\n\"+\r\n");
      out.write("\t\t\t\t\"category:\" + categories);\r\n");
      out.write("\r\n");
      out.write("\t    return true;\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  function isEmpty(ob)\r\n");
      out.write("  {\r\n");
      out.write("  \tif(ob == null || ob == \"\")\r\n");
      out.write("  \t\t{\r\n");
      out.write("  \t\t\treturn true;\r\n");
      out.write("  \t\t}\r\n");
      out.write("  } \r\n");
      out.write("  \r\n");
      out.write("  function isValidURL(url)\r\n");
      out.write("  {\r\n");
      out.write("    var RegExp =  /(ftp|http|https):\\/\\/(\\w+:{0,1}\\w*@)?(\\S+)(:[0-9]+)?(\\/|\\/([\\w#!:.?+=&%@!\\-\\/]))?/;\r\n");
      out.write("\r\n");
      out.write("    if(RegExp.test(url)){\r\n");
      out.write("        return true;\r\n");
      out.write("    }else{\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("} \r\n");
      out.write("\r\n");
      out.write("  function checkString(checking,ob) \r\n");
      out.write("  {   \r\n");
      out.write("  \tif(ob.match(checking))  \r\n");
      out.write("  \t{  \r\n");
      out.write("  \t\treturn true;\r\n");
      out.write("  \t}  \r\n");
      out.write("  \telse  \r\n");
      out.write("  \t{  \r\n");
      out.write("  \t\treturn false;\r\n");
      out.write("  \t}  \r\n");
      out.write("  } \r\n");
      out.write(" </script>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
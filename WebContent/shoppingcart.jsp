<%@ page language="java" import="il.ac.hit.samples.couponix.controller.*,java.util.*" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page isErrorPage="false" errorPage="errorPage.jsp"%>
     <%@ page import ="il.ac.hit.samples.couponix.controller.*" %>
 <%@ page import ="il.ac.hit.samples.couponix.db.*" %>
     <%@page import ="java.lang.*" %>
     
<%-- This JSP document should present the total coupons that were added so far to the shopping cart. 
	 On the bottom of "coupon.jsp" the dynamic page generated  link "add to Favorite": 
	 Pressing on this link should take the user to this page (shopping cart).
	this page show the total coupon and if the session null this create a new shopping cart using HttpSession object.
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Favorite | Couponix</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">

  <link href="https://s3.amazonaws.com/codiqa-cdn/mobile/1.4.0/jquery.mobile-1.4.0.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/homeTheme/jquery-1.10.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/homeTheme/jquery.mobile-1.4.2.min.js"></script>
  <script src="https://s3.amazonaws.com/codiqa-cdn/codiqa.ext.js"></script>

  <!-- Theme CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/homeTheme/jqueysample.min.css" />

</head>
<body>

    <div data-theme="a" data-role="header">
        <h1>
            My Coupons
        </h1>
        <a href="" class="ui-btn ui-btn-left" data-direction="reverse" data-rel="back">
            Previous
        </a>
    </div>
    <div role="main" class="ui-content">
    <ul data-role="listview" data-inset="true" >
  <%
	boolean flag = true;
	/*list that we get from controller, list of all avillable coupon that ready to enter to the shopping cart */
	@SuppressWarnings("unchecked")
	List<Coupon> listCoupon = (List<Coupon>)request.getAttribute("listCouponForFavorite");
	Coupon coupon=(Coupon)request.getAttribute("couponForFavorite");
		
		/*check with httpSession object if the seesion null to open a new session and new shopping cart */
		if(session.getAttribute("cart")==null)
		{
			session.setAttribute("cart",new ShoppingCart());
		}
	
	ShoppingCart cart = (ShoppingCart)(session.getAttribute("cart"));
	/*checking for null coupon and show message */
	if(coupon == null)
	{
		if(cart.getSize() == 0)
		{
			%>
			<h1>There is no Coupon in your Favorites</h1>
		<%}
		else
		{
			/* print the list view of shopping cart , it will print even if the coupon exist or null */
			out.println(cart.getXMLTable());
		}
	}
	else
	{
		/* if coupon no null add the couoon to shopping cart*/
		cart.addCoupon(coupon);
		/* print the list view of shopping cart*/
		out.println(cart.getXMLTable());
	}
%>
</ul>
      <div data-role="tabbar" data-iconpos="top" data-theme="a" data-ajax="false"> 
         <ul>
            <li>
                <a href="${pageContext.request.contextPath}/home.jsp" data-transition="flip" data-theme="" data-icon="home"  data-ajax="false">
                    Home
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/shoppingcart.jsp" data-transition="slideup" data-theme="" data-icon="star">
                    My Coupons
                </a>
            </li>
            <li>
                 <a href="${pageContext.request.contextPath}/contact.jsp" data-transition="flip" data-theme="" data-icon="info">
                    Contact As
                </a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
 <%@ page import ="il.ac.hit.samples.couponix.controller.*" %>
 <%@ page import ="il.ac.hit.samples.couponix.db.*" %>
 <%@page import ="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Coupon by Categories | Couponix</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">

  <link href="https://s3.amazonaws.com/codiqa-cdn/codiqa.ext.css" rel="stylesheet">
  <link href="https://s3.amazonaws.com/codiqa-cdn/mobile/1.4.0/jquery.mobile-1.4.0.css" rel="stylesheet">

  <script src="themes/jquery-1.10.2.min.js"></script>
  <script src="https://s3.amazonaws.com/codiqa-cdn/mobile/1.4.0/jquery.mobile-1.4.0.min.js"></script>
  <script src="https://s3.amazonaws.com/codiqa-cdn/codiqa.ext.js"></script>
   <link rel="stylesheet" href="themes/jqueysample.min.css" />

</head>
<body>
<div data-role="page" data-control-title="addCoupon" id="page2">
    <div data-theme="a" data-role="header">
        <h1>
            Coupon by Category
        </h1>
        <a href="" class="ui-btn ui-btn-left" data-direction="reverse" data-rel="back" data-ajax="false">
            Previous</a>
    </div>
    <div role="main" class="ui-content">
  
<ul data-role="listview" data-inset="true" >


 <%
 @SuppressWarnings("unchecked")
 ArrayList<Coupon> listCoupon = (ArrayList<Coupon>)request.getAttribute("allCouponsByCategories");

		if (listCoupon != null && !listCoupon.isEmpty())
		{
			for(int i=0;i<listCoupon.size();i++)
			{%>
			<% Coupon coupon = (Coupon)listCoupon.get(i);%>
   	   	  <li><a href="coupon/<%=String.valueOf(coupon.getId())%>" data-transition="slidedown"><img src="<%=coupon.getimage()%>" width="200px" height="200px"/><h3><%=coupon.getCouponName()%></h3></a></li>
		  <%}
		 }
		else
		{
			%>
			<h3>There is no Coupons</h3>
		<%}
			%>	

	</ul>
</div>
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
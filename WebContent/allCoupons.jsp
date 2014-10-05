<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page isErrorPage="false" errorPage="errorPage.jsp"%>
 <%@ page import ="il.ac.hit.samples.couponix.controller.*" %>
 <%@ page import ="il.ac.hit.samples.couponix.db.*" %>
 <%@ page import ="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- this JSP page Responsible for Display all coupons --%> 
<html>

<head>
 <title>All coupons | Couponix</title>
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
<div data-role="page" data-control-title="addCoupon" id="page2">

    <div data-theme="a" data-role="header">
        <h1>
            All Coupon
        </h1>
        <a href="" class="ui-btn ui-btn-left" data-direction="reverse" data-rel="back">
            Previous</a>
    </div>
    <div role="main" class="ui-content">
  
<ul data-role="listview" data-inset="true" >
 <%
 //get list by getAttribute from servlet and Produces rows(<li>)  of all coupons
 @SuppressWarnings("unchecked")
 ArrayList<Coupon> listCoupon = (ArrayList<Coupon>)request.getAttribute("allCoupons");
		if (listCoupon != null && !listCoupon.isEmpty())
		{
			for(int i=0;i<listCoupon.size();i++)
			{%>
			<% Coupon coupon = (Coupon)listCoupon.get(i);%>
   	   	  <li><a href="coupon/<%=String.valueOf(coupon.getId())%>" data-transition="slidedown">
   	   	  <img src="<%=coupon.getimage()%>" width="200px" height="200px"/><h3><%=coupon.getCouponName()%></h3><h3>Price: <%=coupon.getPrice()%>$</h3></a></li>
	  <%
	  	}
	   }
		else
		{
			%>
			<h3>There is no Coupon</h3>
		<%}	
		
	  %>	


	
	</ul>
</div>
   <div data-role="tabbar" data-iconpos="top" data-theme="a"> 
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
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page isErrorPage="false" errorPage="errorPage.jsp"%>
 <%@ page import ="il.ac.hit.samples.couponix.controller.*" %>
 <%@ page import ="il.ac.hit.samples.couponix.db.*" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html> 
<%-- this JSP page Responsible for Display all coupons --%> 
<html> 
<head>
 <%
 // get list by getAttribute from servlet and Produces list  of all coupons
 Coupon ob = (Coupon)request.getAttribute("couponObject");
 %>
  <title>Coupons page| Couponix</title>
  <meta charset="utf-8" >
  <meta name="description" content="<%=ob.getdetail()%>"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js" type="text/javascript"></script>
  <link href="https://s3.amazonaws.com/codiqa-cdn/mobile/1.4.0/jquery.mobile-1.4.0.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/homeTheme/jquery-1.10.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/homeTheme/jquery.mobile-1.4.2.min.js"></script>
  <script src="https://s3.amazonaws.com/codiqa-cdn/codiqa.ext.js"></script>

  <!-- Theme CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/homeTheme/jqueysample.min.css" />
</head> 
<body> 
<script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=238840752972082&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
	
	<div data-role="header"> 
		<h1>Coupon page</h1>
           <a href="" class="ui-btn ui-btn-left" data-direction="reverse" data-rel="back" data-ajax="false">
            Previous</a>
	</div> 
	
	<div data-role="content">
	<div class="ui-grid-a" id="restau_infos">	
	<p><img src="<%= ob.getimage() %>" alt="picture" width="240px" height="180px"/></p>
		<div class="ui-block-a">
		<h1><%= ob.getCouponName() %></h1>
				<p><strong>Coupon Code: <%=ob.getId() %> </strong></p><br>			
				<hr/>
		<p><strong>Details:<br><%=ob.getdetail() %> </strong></p><br>			
				<hr/>
		<p><strong>Price: <%= ob.getPrice()%></strong></p>
		 <hr/>
		<p><strong>Expire Date:<br><%= ob.getLastDate()%></strong></p>
	    
		</div>		

	</div><!-- /grid-a -->
	<hr/>

	<div class="ui-grid-a" id="contact_infos">	
		<div class="ui-block-a">
		<h2> Contact us : <%=ob.getBusiness().getName() %></h2>
		<p><b>Address</b> :  <%=ob.getBusiness().getAdress() %></p>
		<p>Phone :  <%=ob.getBusiness().getPhone() %></p>		
		</div>		
		<div class="ui-block-b">
		</div>
		<img src="http://icons.iconarchive.com/icons/wwalczyszyn/android-style-honeycomb/128/Phone-icon.png" alt="coupon contact"/>
	</div><!-- /grid-a -->
	<div id="contact_buttons">	
     <a href="${pageContext.request.contextPath}/CouponsController/ShoppingCart/<%=String.valueOf(ob.getId())%>" data-role="button" data-icon="star">Add To Favorites</a>


	<div class="fb-share-button" data-href="http://couponix.jelastic.lunacloud.com/Couponix/CouponsController/coupon/<%=ob.getId() %> "data-type="button_count"></div>

	<hr/>
</div>

</div><!-- /page -->
</body>
</html>
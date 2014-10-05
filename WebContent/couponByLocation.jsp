<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
     <%@page import ="il.ac.hit.samples.couponix.controller.*" %>
 <%@page import ="java.util.*" %>
 <%@ page isErrorPage="false" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
	  <meta charset="utf-8">
  <title>Coupon by Location</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">

  <link href="https://s3.amazonaws.com/codiqa-cdn/mobile/1.4.0/jquery.mobile-1.4.0.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/homeTheme/jquery-1.10.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/homeTheme/jquery.mobile-1.4.2.min.js"></script>
  <script src="https://s3.amazonaws.com/codiqa-cdn/codiqa.ext.js"></script>

  <!-- Theme CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/homeTheme/jqueysample.min.css" />
		<script type="text/javascript">
				
		function fetch_coupons()
		{	
			//this function will be invoked when the browser completes 
			//loading this web page document
			window.navigator.geolocation.getCurrentPosition(function(ob){
				
				//finding latitude and longtitude
				var latitude = ob.coords.latitude;
				var longitude = ob.coords.longitude;

				//creating the query string
				var query = "latitude="+latitude+"&longitude="+longitude;
				//writing ajax code in order to send an HTTP request 
								
				//creating the XMLHttpRequest object
				var request = new XMLHttpRequest();

				//configuring the XMLHttpRequest object
				request.open(
						"GET",
						"CouponsController/location?"+query,
						true);

				//specifying the anonymous function we want the web browser
				//to invoke when the ajax reply arrives
				request.onreadystatechange= function()
				{
					if (request.readyState == 4 && request.status==200)
					{
						document.getElementById('coupons').innerHTML = request.responseText;
					}
				};

				//sending the HTTP request
				request.send(null);		
			}, function(ob){
				//this function will be invoked if the browser fails 
				//when trying to find the user geo location
				document.getElementById('coupons').innerHTML = ob.message;
				document.write("you have problem with you location");
			});
		}		
		</script>
	</head>

<body onLoad="fetch_coupons()">	

<div data-role="page" data-control-title="addCoupon" id="page2">
    <div data-theme="a" data-role="header">
        <h1>
            The closest Coupons
        </h1>
        <a href="" class="ui-btn ui-btn-left" data-direction="reverse" data-rel="back" data-ajax="false">
            Previous</a>
    </div>
    <div role="main" class="ui-content">

<ul  data-role="listview" data-inset="true" id="coupons" >


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
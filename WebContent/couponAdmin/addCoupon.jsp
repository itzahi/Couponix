<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page import ="il.ac.hit.samples.couponix.controller.*" %>
 <%@ page import ="il.ac.hit.samples.couponix.db.*" %>
 <%@page import ="java.util.*" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      
	    <%-- this JSP page  is managed by the Admin, responsible for adding proper Coupon 
		Adds for any Coupon: ID, name ,price,image,category and business that belong ,last date expire ,time expire,latitude ,longitude,expire or not and image .
		and no individual checks from those missing. --%>

	  <head>   
           	<%
            // checking if username seesion is open, it redirect to login 
  		if(session.getAttribute("username") == null)
  		{
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/CouponsController/admin");	
			dispatcher.forward(request, response);
  		}
  		%>
              <meta name="viewport" content="width=device-width, initial-scale=1.0">

              <title>Add New Coupon - Couponic Admin</title>
			  
              <!-- Bootstrap core CSS -->
              <link href="${pageContext.request.contextPath}/couponAdmin/css/bootstrap.css" rel="stylesheet">
              <!--custom CSS-->
              <link href="${pageContext.request.contextPath}/couponAdmin/css/sb-admin.css" rel="stylesheet">
              <link rel="stylesheet" href="${pageContext.request.contextPath}/couponAdmin/font-awesome/css/font-awesome.min.css">
              <!-- Page Specific CSS -->
              <link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
          </head>

          <body>

          <div id="wrapper">

              <!-- Sidebar -->
              <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                      <a class="navbar-brand" href="${pageContext.request.contextPath}/couponAdmin/couponAdmin.jsp">Admin-Couponic</a>
                  </div>

 <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/couponAdmin/couponAdmin.jsp"><i class="fa fa-dashboard"></i>Dashboard</a></li>           
           <li class="dropdown">
              <a href="${pageContext.request.contextPath}/couponAdmin/couponManagement.jsp" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-book fa-fw"></i> Coupon Management <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/CouponsController/addCouponInit"><i class="fa fa-plus"></i> Add Coupon</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/deleteCoupon.jsp"><i class="fa fa-trash-o"></i> Delete Coupon</a></li>
                <li><a href="${pageContext.request.contextPath}/CouponsController/updateCouponInit"><i class="fa fa-pencil"></i> Update Coupon</a></li>
              </ul>
            </li>
			 <li class="dropdown">
              <a href="${pageContext.request.contextPath}/couponAdmin/businessManagement.jsp" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-th"></i> Business Management <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/couponAdmin/addBusiness.jsp"><i class="fa fa-plus"></i> Add Business</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/deleteBusiness.jsp"><i class="fa fa-trash-o"></i> Delete Business</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/updateBusiness.jsp"><i class="fa fa-pencil "></i> Update Business</a></li>
              </ul>
            </li>
			 <li class="dropdown">
              <a href="${pageContext.request.contextPath}/couponAdmin/categoryManagement.jsp" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Categories Management <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/couponAdmin/addCategory.jsp"><i class="fa fa-plus"></i> Add Category</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/deleteCategory.jsp"><i class="fa fa-trash-o"></i> Delete Category</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/updateCategory.jsp"><i class="fa fa-pencil "></i> Update Category</a></li>
              </ul>
            </li>
          </ul>

    <ul class="nav navbar-nav navbar-right navbar-user">


            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>admin<b class="caret"></b></a>
              <ul class="dropdown-menu">            
                <li class="divider"></li>
                 <form role="form" action="${pageContext.request.contextPath}/CouponsController/logout" method="POST" onSubmit="return check();">
                   <input type="hidden" name="logout" value="logout" > 
                <li><i class="fa fa-power-off"></i> <button type="submit"  class="btn btn-default" >Logout</button></li>
                </form>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>

      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>Add Coupon<small></small></h1>
            <ol class="breadcrumb">
              <li><a href="index.html"><i class="icon-dashboard"></i> Dashboard</a></li>
              <li class="active"><i class="icon-file-alt"></i> Blank Page</li>
            </ol>
          </div>
        </div><!-- /.row -->
		<div class="row">
          <div class="col-lg-6">
            <form role="form" action="${pageContext.request.contextPath}/CouponsController/adminController" name="addCouponForm"  method="POST" onsubmit="return checkForm();">
	  		  <input type="hidden" name="controller" class="form-control" value="addCoupon" >
              <div class="form-group">
                <label>Coupon id</label>
                <input type="text" name="id" class="form-control" placeholder="Enter text" >
              </div>
              
			  <div class="form-group">
                <label>coupon Name</label>
                <input type="text" name="couponName" class="form-control" placeholder="Enter text" >
              </div>
			  <div class="form-group">
                <label>imageURL</label>
                <input type="text" name="image" class="form-control" placeholder="Enter text" >
              </div>
			  <div class="form-group">
                <label>Price</label>
                <input type="text" name="price" class="form-control" placeholder="Enter text" >
              </div>
			  	<div class="form-group">
                <label>Coupon Date Exipre</label>
				<div class="bfh-datepicker">
                <input type="date" name="Date" class="form-control" placeholder="Enter text" >
              </div>
              </div>
              	 <div class="form-group">
                <label>Coupon Time Exipre</label>
				<div class="bfh-datepicker">
                <input type="time" name="time" class="form-control" placeholder="Enter text" >
              </div>
			  </div>
			  <div class="form-group">
                <label>Details</label>
                <input type="text" name="Details" class="form-control" placeholder="Enter text" >
              </div>
                <div class="form-group">
                <label>Latitude(Go to google maps to get this)</label>
                <input type="text" name="LatitudeFromUser" class="form-control" placeholder="Enter Latitude (you can find this from google maps)" >
              </div>
               <div class="form-group">
                <label>Longitude(Go to google maps to get this))</label>
                <input type="text" name="LongitudeFromUser" class="form-control" placeholder="Enter Longitude (you can find this from google maps)" >
              </div>
				<div class="form-group">
                <label>Business Select</label>
                <select name="business" class="form-control">
                <%	
               	@SuppressWarnings("unchecked")
					ArrayList<Object> listBiz = (ArrayList<Object>)request.getAttribute("allBusiness");
					if(listBiz != null)
					{
				%>
					<option value="" disabled selected>Select your Business</option>
				<%
					for(int i= 0;i<listBiz.size();i++)
					{%>
						<% Business b = (Business)listBiz.get(i);%>

						<option value=<%=b.getBuisnessId()%>><%=b.getName()%></option>
					<%} 	
	}%>		
               </select>
              </div>
              	<div class="form-group">
                <label>Category Select</label>
               <select name="categories" class="form-control">
<%	
@SuppressWarnings("unchecked")
ArrayList<Object> listCategories = (ArrayList<Object>)request.getAttribute("allCategories");
	if(listCategories != null)
	{
		 %>
			<option value="" disabled selected>Select your Category</option>
		<%
		for(int i= 0;i<listCategories.size();i++)
		  {%>
			<% Category category = (Category)listCategories.get(i);%>

			<option value=<%= category.getCategoryId()%>><%=category.getCategoryName()%></option>
	<%} 
		
		
	
	}%>		
</select>
		</div>	  
				<% if(request.getAttribute("message") != null) {
			String massege = (String)request.getAttribute("message");
			%>
			<script>
			//get the relevant message for a servlet
			 function MYALERT() { 
			alert('${message}'); } MYALERT(); 
			</script>
			<%} %>	
		
			  <button type="submit" class="btn btn-default">Submit Button</button>
              <button type="reset" class="btn btn-default">Reset Button</button>
</form>
      </div><!-- /#page-wrapper -->
       </div>
        </div>
    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="${pageContext.request.contextPath}/couponAdmin/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/couponAdmin/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/couponAdmin/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/couponAdmin/js/formChecking.js"></script>

	<script>
	
	// function that check the form validation and shows alert to the Admin Client  
  function checkForm()
  {
	  var currentTime = new Date();							 //Getting current date by String
	  var month = (currentTime.getMonth() + 1).toString(); //Getting current month by String
	  var day = currentTime.getDate().toString();			//Getting current day by String
	  var year = currentTime.getFullYear().toString();		//Getting current year by String
	  var today = (year+ "-" + (month[1] ? month:"0"+month[0])+ "-" + (day[1] ? day:"0"+day[0])); //Component values ​​of the current date
	  var todayDate = Date.parse(today); //get current date by date parse
	
    var id = document.addCouponForm.id.value;          //ID describes the ID of the Coupon and is unique for every Coupon 
	var price = document.addCouponForm.price.value;		//price  describes the price of the Coupon in dollar 
	var details = document.addCouponForm.Details.value;  // details describes  describes of the Coupon 
	var latitudeFromUser = document.addCouponForm.LatitudeFromUser.value; // latitude describes  latitude of the Coupon
	var longitudeFromUser = document.addCouponForm.LongitudeFromUser.value;  // longitude describes  longitude of the Coupon
	var couponName = document.addCouponForm.couponName.value; // couponName describes  the name  of the Coupon
	var image = document.addCouponForm.image.value; // image describes  image of the Coupon by given url 
	var date = document.addCouponForm.Date.value; // date describes the last date of expire of the Coupon
	var time = document.addCouponForm.time.value; // time describes the last time of expire of the Coupon
	var choosenDate =Date.parse(date); // choosenDate describes choosen Date of expire of the Coupon after parse
	var business = document.addCouponForm.business.value;   // business describes the business object that coupon belong too
	var categories = document.addCouponForm.categories.value; // categories describes the categories object that coupon belong to
	var okNum = /^[0-9]+$/;	  //variable describes numbers
	var flag = true; //flag describes if  all details are valid or not 
	
		//check id field is empty or it is not a number and Displaying Appropriate message to client 
		if ((isEmpty(id)) == true ||(checkString(okNum, id)) == false)
		{
			 alert('id: you need to insert valid integet number');
			 document.addCouponForm.id.value;
			 flag = false;
		}

		//check latitude field is empty  and Displaying Appropriate message to client 
		if ((isEmpty(latitudeFromUser)) == true)
		{
			 alert('latitude: you need to insert valid latitude');
			 document.addCouponForm.LatitudeFromUser.value;
			 flag = false;
		}
		//check longitude field is empty  and Displaying Appropriate message to client
		if ((isEmpty(longitudeFromUser)) == true)
		{
			 alert('longitude: you need to insert valid longitude');
			 document.addCouponForm.LongitudeFromUser.value;
			 flag = false;
		}
		//check couponName field is empty  and Displaying Appropriate message to client
		if ((isEmpty(couponName)) == true )
		{
			 alert('couponName: you need to insert valid integet number');
			 document.addCouponForm.price.value;
			 flag = false;
		}
		//check price field is empty or it is not a number and Displaying Appropriate message to client
		if ((isEmpty(price)) == true ||(checkString(okNum, price)) == false)
		{
			 alert('price: you need to insert valid integet number');
			 document.addCouponForm.price.value;
			 flag = false;
		}
		//check details field is empty  and Displaying Appropriate message to client
		if ((isEmpty(details)) == true )
		{
			 alert('details: you need to insert valid integet number');
		 document.addCouponForm.price.value;
			 flag = false;
		}
		//check image field is empty or not valid url and Displaying Appropriate message to client
		if ((isEmpty(image)) == true || isValidURL(image) == false)
		{
			 alert('image: you need to insert valid Image');
			 document.addCouponForm.image.value;
			 flag = false;
		}
		//check business field is empty  and Displaying Appropriate message to client
		if ((isEmpty(business)) == true )
		{
			 alert('business: you need to insert valid business name');
			 document.addCouponForm.business.value;
			 flag = false;
		}
		//check categories field is empty  and Displaying Appropriate message to client
		if ((isEmpty(categories)) == true )
		{
			 alert('category: you need to insert valid category name');
			 document.addCouponForm.categories.value;
			 flag = false;
		}
		//check date field is empty  and Displaying Appropriate message to client
		if ((isEmpty(date)) == true)
		{
			 alert('Please choose a Date');
			 flag = false;
		}
		//check time field is empty  and Displaying Appropriate message to client
		if ((isEmpty(time)) == true)
		{
			 alert('Please choose a Time');
			 flag = false;
		}

		//check if choosenDate smaller then today date (if choosenDate is valid)  and Displaying Appropriate message to client
		if (choosenDate<todayDate)
		{
			 alert('date: date small then today!!');
			 flag= false;
		}
	
	//if all fields are valid it Displaying Summary and return the answer to submit form
	if(flag == true)
    {
	    return true;
	}
	else
	{
		return false;
	}

  }
 </script>

  </body>
</html>
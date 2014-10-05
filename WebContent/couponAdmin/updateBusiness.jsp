<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
 <%-- this JSP page  is managed by the Admin, responsible for Update proper Business 
		by check if Business id exist and send it to servlet Treatment. --%> 
	<head>   
           	<%
  		if(session.getAttribute("username") == null)
  		{
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/CouponsController/admin");	
			dispatcher.forward(request, response);
  		}

  		%>
              <meta name="viewport" content="width=device-width, initial-scale=1.0">

              <title>Update Business - Couponic Admin</title>
			  
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
            <h1>Update Business<small></small></h1>
            <ul class="breadcrumb">
              <li><i class="icon-dashboard"></i><a href="${pageContext.request.contextPath}/couponAdmin/couponAdmin.jsp"> Dashboard</a></li>
              <li><a href="${pageContext.request.contextPath}/couponAdmin/businessManagement.jsp"><i class="icon-file-alt"></i> Back To Business Management</a></li>
            </ul>
          </div>
        </div><!-- /.row -->
		<div class="row">
          <div class="col-lg-6">
            <form role="form" action="${pageContext.request.contextPath}/CouponsController/adminController" name="updateBusinessForm"  method="POST" onsubmit="return checkForm();" >
	  		  <input type="hidden" name="controller" class="form-control" value="updateBusiness" >
              <div class="form-group">
                <label>id</label>
                <input type="text" name="id" class="form-control" placeholder="Enter id to Update" >
              </div>
		      <div class="form-group">
                <label>Business Name</label>
                <input type="text" name="businessName" class="form-control" placeholder="Enter Business Name">
              </div>
		      <div class="form-group">
                <label>Phone</label>
                <input type="text" name="phone" class="form-control" placeholder="Enter Phone">
              </div>
		      <div class="form-group">
                <label>Adress</label>
                <input type="text" name="adress" class="form-control" placeholder="Enter Adress">
              </div>
<% if(request.getAttribute("message") != null) {
			String massege = (String)request.getAttribute("message");
			%>
			  <script type="text/javascript">
			  //get the relevant message for a servlet
			 function MYALERT() { 
			alert('${message}'); } MYALERT(); 
			</script>
			<%} %>
			  <button type="submit" class="btn btn-default">Submit Form</button>
              <button type="reset" class="btn btn-default">Reset Form</button>
</form>
      </div><!-- /#page-wrapper -->
 </div>
 
    </div><!-- /#wrapper -->
</div>
    <!-- JavaScript -->
    <script src="${pageContext.request.contextPath}/couponAdmin/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/couponAdmin/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/couponAdmin/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/couponAdmin/js/formChecking.js"></script>
	<script>
 	
	// function that check the form validation and shows alert to the Admin Client 
	// function that check the form validation and shows alert to the Admin Client 
  function checkForm()
  {
    var id = document.updateBusinessForm.id.value;                     //ID describes the ID of the business and is unique for every business 
    var businessName = document.updateBusinessForm.businessName.value; //Name describes the name of the business adding to a database
    var phone = document.updateBusinessForm.phone.value;				//Phone describes the business phone number added to a database
    var adress = document.updateBusinessForm.adress.value;				//Address describes the business's address added to a database
	var okNum = /^[0-9]+$/;											//variable describes numbers
	var flag = true;												//flag describes if  all details are valid or not 
		
		//check id field is empty or it is not a number and Displaying Appropriate message to client 
		if ((isEmpty(id)) == true ||(checkString(okNum, id)) == false)
		{
			 alert('id: you need to insert valid integet number');
			 document.updateBusinessForm.id.value;
			 flag = false;
		}
		
		//check businessName field is empty  and Displaying Appropriate message to client 
		if ((isEmpty(businessName)) == true)
		{
			 alert('name :you need to insert a valid BusinessName');
			 document.updateBusinessForm.businessName.value;
			 flag = false;
		}
		
		//check phone field is empty or it is not a valid String and Displaying Appropriate message to client
		if ((isEmpty(phone)) == true ||(checkString(okNum, phone)) == false)
		{
			 alert('phone : you need to insert valid integet number for Phone');
			 document.updateBusinessForm.phone.value;
			 flag = false;
		}
		
		//check adress field is empty  and Displaying Appropriate message to client 
		if ((isEmpty(adress)) == true)
		{
			 alert('adress: you need to insert valid adress');
			 document.updateBusinessForm.adress.value;
			 flag = false;
		}

		//check if all field are valid or not and return the answer to submit form
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
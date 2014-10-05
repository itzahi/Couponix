<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Page that Allow the user to login on a window with a name and Password  -->
<html>
   <%-- this JSP page  is responsible login administrator
		check valid user name and password. --%>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Couponic -Login Page</title>

    <!-- Core CSS - Include with every page -->
    <link href="../couponAdmin/css/bootstrap.min.css" rel="stylesheet">
    <link href="../couponAdmin/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Couponic CSS - Include with every page -->
    <link href="../couponAdmin/css/sb-admin.css" rel="stylesheet">

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="POST" action="${pageContext.request.contextPath}/CouponsController/login" >
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="UserName" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
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

                                <button type="submit"  class="btn btn-lg btn-success btn-block" >Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Core Scripts - Include with every page -->
    <script src="../couponAdmin/js/jquery-1.10.2.js"></script>
    <script src="../couponAdmin/js/bootstrap.min.js"></script>

</body>

</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<style>
		ul{
			list-style-type: none;
			margin: 0;
			padding: 0;
			overflow: hidden;
			background-color: #333;
		}
		li{
			float: left;
		}
		li a{
			display: block;
			color: white;
			text-align: center;
			padding: 14px 16px;
			text-decoration: none;
		}
		li a:hover:not(.active){
			background-color: #111;
		}
		.active{
			background-color: #4CAF50;
		}
	</style>
</head>
<body style="background-image: url("hotel_image.jpg")">
	
	<ul>
		<li><a class="active" href="#home">HOME</a></li>
		<li><a href="contact.jsp">CONTACT</a></li>
		<li><a href="#about">ABOUT US</a></li>
		<li style="float:right"><a href="">Sign up</a></li>
		<!-- <li style="float:right"><a href="login.jsp">Login</a></li> -->
	</ul>
	<pre>
		<form name="form" action="HotelMenu_FindServlet">
		
						<label style="font-size:15" >GOA</label>										     <label style="font-size:15">MUMBAI</label>
			<img src="goa.jpg" width="400" height="200">				<img src="mumbai.jpg" width="400" height="200">
						<a href="kerala.jsp" style="text-decoration:none"><input type="button" value="Book" name="hloc" /></a>										<a href="rajasthan.jsp" style="text-decoration:none"><input type="button" value="Book" name="hloc" /></a>
						
						
						<label style="font-size:15">KOLKATA</label>										     <label style="font-size:15">NEW DELHI</label>
			<img src="kolkatta.jpg" width="400" height="200">				<img src="delhi.jpg" width="400" height="200">
						 <input type="button" value="Book" name="hloc" onclick="window.location.href='Kolkata.jsp';"/>										<a href="mp.jsp" style="text-decoration:none"><input type="button" value="Book" name="hloc"/></a>

		</form>
	</pre>
</body>
</html>

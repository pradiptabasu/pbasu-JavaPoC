<%@page import="master.DAO.HotelDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="master.DTO.HotelDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
img {
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>
</head>
<body>

<h2 style="text-align:center">RAJASTHAN</h2>
<img src="../images/kolkatta.jpg.jpg"  width="600" height="300">  

 



<pre>
<h3>
Rajasthan is India's largest state by area (342,239 square kilometres (132,139 sq mi) or 10.4% of India's total area). It is located
on the northwestern side of the India, where it comprises most of the wide and inhospitable Thar Desert (also known as the "Rajasthan
Desert" and "Great Indian Desert") and shares a border with the Pakistani provinces of Punjab to the northwest and Sindh to the wst,
along the Sutlej-Indus river valley. Elsewhere it is bordered by five other Indian states: Punjab to the north; Haryana and Uttar Pra
desh to the northeast; Madhya Pradesh to the southeast; and Gujarat to the southwest.
Major features include the ruins of the Indus Valley Civilisation at Kalibanga; the Dilwara Temples, a Jain pilgrimage site at Rajasth
an's only hill station, Mount Abu, in the ancient Aravalli mountain range; and, in eastern Rajasthan, the Keoladeo National Park near 
Bharatpur, a World Heritage Site[5] known for its bird life. Rajasthan is also home to three national tiger reserves, the Ranthambore 
National Park in Sawai Madhopur, Sariska Tiger Reserve in Alwar and Mukundra Hill Tiger Reserve in Kota. 
</h3>
 </pre>
 
 
 
 <h1>BOOKING DETAILS</h1>
	<form action="" method="get">
	  <fieldset> 
		<legend>Personal Detail:</legend>
		<pre>
		<label>YOUR NAME</label>	<input type="text" name="username" id="name" required autofocus placeholder="your username"  title="please enter more than three letters"><br/>
		<label>YOUR EMAIL</label>	<input type="email" name="email" id="email" required autofocus placeholder="your email"title="enter valid email"><br/>
		<label>PHONE NUMBER</label> 	<input type="tel" name="phone" id="phone" required  placeholder="please enter your phone number" pattern="[0-9]{4}[0-9]{3}[0-9]{3}" title="please enter ph no in #### ### ### formar"><br/>
		<label>CHOOSE PLACE</label> 	
		<select name="place" required>
			<option value="">SELECT HOTEL</option>
<%
HotelDAO hdao=new HotelDAO();
HotelDTO hdto1=new HotelDTO();
ArrayList results=hdao.getHotelData(hdto1,"KOLKATA");
Iterator itr=results.iterator();
while(itr.hasNext()) {	
   hdto1=(HotelDTO)itr.next();
%>
			
			<option value="<%=hdto1.getHid()%>"><%=hdto1.getHid()%>
			</option>
			<option value="<%=hdto1.getHname()%>"><%=hdto1.getHname()%>
			</option>
			<option value="<%=hdto1.getHprice()%>"><%=hdto1.getHprice()%>
			</option>
			
<%
}
%>
			
		</select> 
		</pre>
	</fieldset>
	<br/>
	<fieldset><legend>Booking Details:</legend>
	<pre>
	<label>ARIVAL</label> 		 <input type="date" required name="date" min="2018-07-20"><br/>
	<label>DEPERTURE</label> 	 <input type="date" required name="date" min="2018-05-20"><br/>
	<label>NUMBER OF PERSON</label> <input type="number" required name="numberofguests" min="1" max="5"><br/>
	<label>NUMBER OF ROOMS</label>  <input type="number" required name="numberofrooms" min="1" max=5><br/>
	 <input type="submit" value="SUBMIT" name="submit"/>
	 </pre>
	</fieldset>	
</form> 
 
</body>


</html>
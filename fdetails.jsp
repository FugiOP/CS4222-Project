<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Faculty Detail</title>
</head>
<body>
	<div>
		Projects being worked on by ${fname}
		<table class="table table-bordered table-hovered">
			<tr> <th>Project No.</th> <th>Sponsor Name</th> <th>Start Date</th> <th>End Date</th> <th>budget</th> </tr>
			<c:forEach items="${plist}" var="item">
				<c:if test="${item.pi==fname}">
					<tr> 
						<td>${item.pno}</td> <td>${item.sponsorName}</td> <td>${item.startDate }</td> <td>${item.endDate }</td> <td>${item.budget }</td> 
					</tr>
				</c:if>
				<c:forEach items="${fdetails}" var="x">
					<c:if test="${item.pno==x}">
						<tr> 
							<td>${item.pno}</td> <td>${item.sponsorName}</td> <td>${item.startDate }</td> <td>${item.endDate }</td> <td>${item.budget }</td> 
						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
		</table>
	</div>
</body>
</html>
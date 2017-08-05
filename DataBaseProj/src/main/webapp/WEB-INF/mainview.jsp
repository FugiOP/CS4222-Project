<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Main Menu</title>
</head>
<body>
	<div>
		<div class="container">
			<form class="form-inline" action="AddFacultyProject" method="get">
				<div class="form-group">
					<label>Faculty</label>
					<input type="hidden" name="add" value="faculty">
					<button type="submit" class="btn btn-primary">Add Faculty</button>
				</div>
			</form>
			<br/>
			<table class="table table-bordered table-striped table hovered">
				<tr>
					<th>Name</th> <th>Rank</th>  <th>Age</th> <th>Gender</th> <th>Research Specialty</th> <th>Action</th>
				</tr>
				<c:forEach items="${flist }" var="item">
					<tr>
						<td>${item.name}</td> <td>${item.rank}</td> <td>${item.age}</td> <td>${item.gender}</td> <td>${item.rspec}</td>
						<td> 
							<form action="Action" method="post">
								<input type="hidden" name="ssn" value="${item.ssn}">
								<button class="btn btn-primary" name="action" value="fdetails">View Details</button>
								<button class="btn btn-danger" name="action" value="fremove">Remove</button>
							</form>
						</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<br/>
		
		<div class="container">
			<form class="form-inline" action="AddFacultyProject" method="get">
				<div class="form-group">
					<Label>Projects</Label>
					<input type="hidden" name="add" value="project">
					<button type="submit" class="btn btn-primary">Add Project</button>
				</div>
			</form>
			<br/>
			<table class="table table-bordered table-striped table hovered">
				<tr>
					<th>Project No.</th> <th>Sponsor Name</th> <th>Action</th>
				</tr>
				<c:forEach items="${plist}" var="item">
					<tr>
						<td>${item.pno}</td> <td>${item.sponsorName}</td> 
						<td> 
							<form action="Action" method="post">
								<input type="hidden" name="pno" value="${item.pno}">
								<button class="btn btn-primary" name="action" value="pdetails">View Details</button>
								<button class="btn btn-danger" name="action" value="premove">Remove</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
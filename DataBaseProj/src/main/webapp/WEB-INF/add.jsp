<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Add Menu</title>
</head>
<body>
	<c:if test="${add == 'faculty'}">
		<div class="container">
			<h3>Faculty Form</h3>
			<form action="AddFacultyProject" method="post">
				<label>Name</label>
				<div class="form-group">
					<input class="form-control" type="text" name="name">
				</div>
				
				<label>Research Specialty</label>
				<div class="form-group">
					<input class="form-control" type="text" name="rspec">
				</div>
				
				<label>Gender</label>
				<div class="form-group">
					<label class="radio-inline"><input type="radio" name="gender" value="F">Female</label>
					<label class="radio-inline"><input type="radio" name="gender" value="M">Male</label>
				</div>
				
				<label>SSN</label>
				<div class="form-group">
					<input class="form-control" type="number" name="ssn">
				</div>
		
				<label>Rank</label>
				<div class="form-group">
					<input class="form-control" type="number" name="rank">
				</div>
				
				<label>Age</label>
				<div class="form-group">
				<input class="form-control" type="number" name="age">
				</div>
				
				<input type="hidden" name="formType" value="faculty">
				<input type="submit" class="btn btn-primary" value="Submit">
			</form>
		</div>
	</c:if>	
	
	<c:if test="${add == 'project'}">
		<div class="container">
			<h3>Project Form</h3>
			<form action="AddFacultyProject" method="post">
				<label>Sponsor Name</label>
				<div class="form-group">
					<input class="form-control" type="text" name="sponsorName">
				</div>
				
				<label>Start and End Date</label>
				<div class="form-group">
					<input class="form-control" type="date" name="startDate" placeholder="Start Date YYYY-MM-DD">
					<input class="form-control" type="date" name="endDate" placeholder="End Date YYYY-MM-DD">
	    		</div>
				
				<label>Budget</label>
				<div class="form-group">
					<input class="form-control" type="number" name="budget">
				</div>
				
				<label>Principal Investigator</label>
				<div class="form-group">
					<!--  <input class="form-control" type="text" name="pi"> -->
					<select name="pi">
						<c:forEach items="${flist}" var="item">
							<option value="${item.name}">${item.name}</option>
						</c:forEach>
					</select>
				</div>
				
				<input type="hidden" name="formType" value="project">
				<input type="submit" class="btn btn-primary" value="Submit">
			</form>
		</div>
	</c:if>	
</body>
<script>
$(function () {
	   var bindDatePicker = function() {
			$(".date").datetimepicker({
	        format:'YYYY-MM-DD',
				icons: {
					time: "fa fa-clock-o",
					date: "fa fa-calendar",
					up: "fa fa-arrow-up",
					down: "fa fa-arrow-down"
				}
			}).find('input:first').on("blur",function () {
				// check if the date is correct. We can accept dd-mm-yyyy and yyyy-mm-dd.
				// update the format if it's yyyy-mm-dd
				var date = parseDate($(this).val());

				if (! isValidDate(date)) {
					//create date based on momentjs (we have that)
					date = moment().format('YYYY-MM-DD');
				}

				$(this).val(date);
			});
		}
	   
	   var isValidDate = function(value, format) {
			format = format || false;
			// lets parse the date to the best of our knowledge
			if (format) {
				value = parseDate(value);
			}

			var timestamp = Date.parse(value);

			return isNaN(timestamp) == false;
	   }
	   
	   var parseDate = function(value) {
			var m = value.match(/^(\d{1,2})(\/|-)?(\d{1,2})(\/|-)?(\d{4})$/);
			if (m)
				value = m[5] + '-' + ("00" + m[3]).slice(-2) + '-' + ("00" + m[1]).slice(-2);

			return value;
	   }
	   
	   bindDatePicker();
	 });
</script>
</html>
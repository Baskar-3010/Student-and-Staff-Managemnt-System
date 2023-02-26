<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.project.staff.*"%>
<%@ page import="com.project.staffFile.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<style type="text/css">
body {
	background-color: #c9eaf0;
}
</style>
<script>
function editRecord(id){
    var f=document.form.getElementById('editForm');
    f.method="post";
    f.action='EditStaff?id='+id;
    f.submit();
}
function DeleteRecord(id){
	
    if(confirm("Are you sure to delete the record? ")){
    	var f=document.getElementById("delete");
        f.method="post";
        f.action='DeleteStaff?id='+id;
        f.submit();
    }
    
}
</script>
</head>
<body>

	<h1 style="text-align: center" class="m-3">Staff table</h1>
	<!-- <div class="float-right mt-2 mr-2">
		<a type="button" class=" m-4 btn btn-primary position-absolute  end-0"
			href="AddStaff.html"> + Add Staff </a>
	</div> -->
	<table border="1" class="mt-5"
		style="width: 80%; margin-left: auto; margin-right: auto;">

		<%
		TreeMap<String, Staff> map = (TreeMap<String, Staff>) Read.readAll("E:/DSA project/ProjectDS/Staff.txt");
		%>


		<div class="container " style="display: flex; justify-content: end">
			<a type="button" class=" btn btn-primary text-center"
				href="AddStaff.html"> + Add Staff </a>
		</div>

		<TABLE BORDER="1" class=" container table table-striped">


			<TR>
				<TH>ID</TH>
				<TH>Name</TH>
				<TH>Qualification</TH>
				<TH>Years of Experience</TH>
				<TH>Phone</TH>
				<TH>Address</TH>
				<TH>Salary</TH>
				<%--<th>Salary Payment for this month</th> --%>
				<TD>Edit</TD>
				<TD>Delete</TD>

			</TR>
			<%
			if (map == null) {
			%>
			<tr>
				<td class="text-center m-5 h6" colspan="9">No Record Found</td>
			</tr>
			<%
			} else {
			for (Map.Entry<String, Staff> e : map.entrySet()) {
				Staff s = e.getValue();
				//out.print(s);
			%>
			<TR>
				<TD><%=s.getId()%></td>
				<TD><%=s.getName()%></TD>
				<TD><%=s.getQualfication()%></TD>
				<TD><%=s.getYearsOfExperience()%></TD>
				<TD><%=s.getPhone()%></TD>
				<TD><%=s.getAddress()%></TD>
				<TD><%=s.getSalary()%></TD>
				<%--  <TD><%if(s.isSalaryPaid()=="true"){out.println("Paid");} else{out.print("Not Paid");}%></TD>  --%>

				<td><input type="button" name="edit" value="Edit"
					style="background-color: green; font-weight: bold; color: white;"
					data-bs-toggle="modal" data-bs-target="#exampleModal<%=s.getId()%>"></td>
				<form name="form">
					<td><input type="button" name="delete" value="Delete"
						style="background-color: Red; font-weight: bold; color: white;"
						onclick="DeleteRecord(<%=s.getId()%>)"></td>
				</form>
				<div class="modal fade" id="exampleModal<%=s.getId()%>"
					tabindex="-1" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<form method="get" action="EditStaff">

									<div class="form-group" style="display: none;">
										<label for="name">Id</label> <input type="text"
											class="form-control" name="id" value="<%=s.getId()%>"
											required="required">

									</div>
									<div class="form-group">
										<label for="name">Name</label> <input type="text"
											class="form-control" name="name" value="<%=s.getName()%>"
											placeholder="Enter Standard" required="required">

									</div>
									<div class="form-group">
										<label for="standard">Qualification</label> <input type="text"
											class="form-control" name="qualification"
											value="<%=s.getQualfication()%>"
											placeholder="Enter Qualification" required="required">

									</div>
									<div class="form-group">
										<label for="standard">Years Of Experience</label> <input
											type="text" class="form-control" name="yoe"
											value="<%=s.getYearsOfExperience()%>"
											placeholder="Enter Years of Experiecnce" required="required">

									</div>
									<div class="form-group">
										<label for="address">Phone</label> <input type="text"
											class="form-control" name="phone" value="<%=s.getPhone()%>"
											placeholder="Enter Phone number" required="required">

									</div>
									<div class="form-group">
										<label for="phone">Address</label> <input type="number"
											class="form-control" name="address"
											value="<%=s.getAddress()%>" placeholder="Enter Address"
											required="required">

									</div>
									<div class="form-group">
										<label for="fees">Salary</label> <input type="number"
											value="<%=s.getSalary()%>" class="form-control" name="salary"
											placeholder="Enter salary" required="required">

									</div>
									<%--
										
											<div class="form-group">
											<label for="feesRemaing">Salary paid status</label> <input
												type="radio"  name="isPaid"
												value="<%=s.isSalaryPaid()%>"required="required">Paid</input>
											
											<input type="radio" name="isPaid"
												value="<%=s.isSalaryPaid()%>" required="required">Not Paid</input>

										</div>
										 --%>

									<div
										class="modal-footer border-top-0 d-flex justify-content-center">
										<button type="submit" class="btn btn-success">Edit
											Staff</button>
									</div>

								</form>


							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>

			</tr>
			<%
			}
			%>
			<%
			}
			%>

		</TABLE>

	</table>
	<!-- Modal code -->
	<!-- Button trigger modal -->


	<!-- Modal -->
</body>
</html>
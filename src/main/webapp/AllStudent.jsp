<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ page import="com.project.student.*"%>
<%@ page import="com.project.file.*"%>

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
    f.action='EditStudent?id='+id;
    f.submit();
}
function DeleteRecord(id){
	
    if(confirm("Are you sure to delete the record? ")){
    	var f=document.getElementById("delete");
        f.method="post";
        f.action='DeleteStudent?id='+id;
        f.submit();
    }
    
}
</script>
</head>
<body>
	
	<h1 style="text-align: center" class="m-3">Student table</h1>
	<!-- <div class="float-right mt-2 mr-2">
		<a type="button" class=" m-4 btn btn-primary position-absolute  end-0"
			href="AddStudent.html"> + Add Student </a>
	</div> -->
	<table border="1" class="mt-5"
		style="width: 80%; margin-left: auto; margin-right: auto;">

		<%
		TreeMap<String, Student> map = (TreeMap<String, Student>) Read.readAll("E:/DSA project/ProjectDS/Student.txt");
		%>
			
			<div class="container " style="display:flex; justify-content: end">
			<a type="button" class=" btn btn-primary text-center" href="AddStudent.html"> + Add Student </a>
			</div>

			<TABLE BORDER="1" class=" container table table-striped">
			
				
				<TR>
					<TH>ID</TH>
					<TH>Name</TH>
					<TH>Standard</TH>
					<TH>Address</TH>
					<TH>Phone</TH>
					<TH>Fees</TH>
					<TH>Remaining Fees</TH>
					<th>Edit</th>
					<th>Delete</th>
				</TR>
				<%
				if (map == null) {
				%>
				<tr>
					<td class="text-center m-5 h6" colspan="9">No Record Found</td>
				</tr>
				<%
				} else {
				for (Map.Entry<String, Student> e : map.entrySet()) {
					Student s = e.getValue();
				%>
				<TR>
					<TD><%=s.getId()%></td>
					<TD><%=s.getName()%></TD>
					<TD><%=s.getStandard()%></TD>
					<TD><%=s.getAddress()%></TD>
					<TD><%=s.getPhone()%></TD>
					<TD><%=s.getFees()%></TD>
					<TD><%=s.getFeesRemaining()%></TD>
					<td><input type="button" name="edit" value="Edit"
						style="background-color: green; font-weight: bold; color: white;"
						data-bs-toggle="modal"
						data-bs-target="#exampleModal<%=s.getId()%>"></td>
					<form id="delete">
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
									<h5 class="modal-title" id="exampleModalLabel">Edit Student</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">

									<form method="get" action="EditStudent">
		
										<div class="form-group">
											<label for="name">ID</label> <input type="text"
								name="id" value="<%=s.getId()%>">

										</div>
										<div class="form-group">
											<label for="name">Name</label> <input type="text"
												class="form-control" name="name"
												value="<%=s.getName()%>" placeholder="Enter Standard"
												required="required">

										</div>
										<div class="form-group">
											<label for="standard">Standard</label> <input type="text"
												class="form-control" name="standard"
												value="<%=s.getStandard()%>" placeholder="Enter Standard"
												required="required">

										</div>
										<div class="form-group">
											<label for="address">Address</label> <input type="text"
												class="form-control" name="address"
												value="<%=s.getAddress()%>" placeholder="Enter Address"
												required="required">

										</div>
										<div class="form-group">
											<label for="phone">Phone</label> <input type="number"
												class="form-control" name="phone" value="<%=s.getPhone()%>"
												placeholder="Enter Phone Number" required="required">

										</div>
										<div class="form-group">
											<label for="fees">Fees</label> <input type="number"
												value="<%=s.getFees()%>" class="form-control" name="fees"
												placeholder="Enter fees" required="required">

										</div>
										<div class="form-group">
											<label for="feesRemaing">Fees Remaining</label> <input
												type="number" class="form-control" name="feesRemaining"
												value="<%=s.getFeesRemaining()%>"
												placeholder="Enter feesRemaining" required="required">

										</div>

										<div
											class="modal-footer border-top-0 d-flex justify-content-center">
											<button type="submit" class="btn btn-success">Edit Student</button>
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
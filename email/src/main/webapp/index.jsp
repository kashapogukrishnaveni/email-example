<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<form action="sendMail.do" method="post">

		<div class="text-center" align="center">

			<span style="color: green; font-family: arial;">${key}</span> <span
				style="color: red; font-family: arial;">${failure}</span>
		</div>

		<div class="container w-50%">
			<div class="card-body" align="center">

				<div class="form-group">
					<div class="form-group col-md-3">
						<label for="emailId">Email</label> <input type="email"
							class="form-control" id="emailId" name="emailId">
					</div>
				</div>
				<div class="form-group">
					<div class="form-group col-md-3">
						<label for="subject">subject</label> <input type="text"
							class="form-control" id="subject" name="subject">
					</div>
				</div>
				<div class="form-group">
					<div class="form-group col-md-3">
						<label for="body">body</label> <input type="text"
							class="form-control" id="body" name="body">
					</div>
				</div>
			<button type="submit" class="btn btn-success">submit</button>
			</div>
		</div>
		
	</form>
</body>
</html>
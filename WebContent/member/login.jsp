<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="robots" content="noindex, nofollow">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style type="text/css">
body {
	padding-top: 4.2rem;
	padding-bottom: 4.2rem;
	background: #fff;
}

a {
	text-decoration: none !important;
}

h1, h2, h3 {
	font-family: Georgia, "Malgun Gothic", serif;
}

.logo {
	text-align: center;
}

.myform {
	position: relative;
	display: -ms-flexbox;
	display: flex;
	padding: 1rem;
	-ms-flex-direction: column;
	flex-direction: column;
	width: 100%;
	pointer-events: auto;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid rgba(0, 0, 0, .2);
	border-radius: 1.1rem;
	outline: 0;
	max-width: 500px;
}

.text1 {
	display: block;
	width: 30%;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
}

.tx-tfm {
	text-transform: uppercase;
}

.mybtn {
	border-radius: 50px;
}

form .error {
	color: #ff0000;
}

#second {
	display: none;
}
</style>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<div class="container">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div class="myform form ">
					<div class="logo">
						<a href="<%=request.getContextPath()%>/main.jsp"><img src="<%=request.getContextPath()%>/images/logo.jpg" width="150px"/></a>
						<div class="col-md-12 text-center">
							<h1>로그인</h1>
						</div>
					</div>
					<form name="login" action="<%=request.getContextPath()%>/loginProcess.me" method="post">
						<div class="form-group">
							<label for="input">아이디</label> <input type="text" name="id"
								class="form-control" id="id" aria-describedby="hlep"
								placeholder="아이디를 입력하세요.">
						</div>
						<div class="form-group">
							<label for="input">비밀번호</label> <input type="password"
								name="pw" id="pw" class="form-control"
								aria-describedby="help" placeholder="비밀번호를 입력하세요.">
						</div>
						<div class="col-md-12 text-center ">
							<button type="submit"
								class=" btn btn-block mybtn btn-primary tx-tfm">로그인</button>
						</div>
						<br>
						<div class="form-group">
							<p class="text-center">
								아직 회원이 아니신가요?<br> <a href="<%=request.getContextPath()%>/join.me">회원가입</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("form[name='login']").validate({
			rules : {
				id : {
					required : true
				},
				pw : {
					required : true,

				}
			},
			messages : {
				id : "아이디를 입력하세요.",

				pw : {
					required : "비밀번호를 입력하세요.",
				}

			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</html>
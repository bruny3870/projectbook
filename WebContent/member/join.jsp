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
							<h2>회원가입</h2>
						</div>
					</div>
					<form name="join" action="<%=request.getContextPath() %>/joinProcess.me" method="post">
						<div class="form-group">
							<label for="input">아이디</label>
							<button type="button" class="" name="idcheck" id="idcheck">중복검사</button>
							<input type="text" name="id" class="form-control"
								id="id" aria-describedby="hlep" placeholder="아이디를 입력하세요.">
						</div>
						<div class="form-group">
							<label for="input">비밀번호</label> <input type="password"
								name="pw" id="pw" class="form-control"
								aria-describedby="hlep" placeholder="비밀번호를 입력하세요.">
						</div>
						<div class="form-group">
							<label for="input">비밀번호확인</label> <input type="password"
								name="pwck" id="pwck" class="form-control"
								aria-describedby="hlep" placeholder="비밀번호를 다시 입력하세요.">
						</div>
						<div class="form-group">
							<label for="input">이름</label> <input type="text" name="name"
								id="name" class="form-control" aria-describedby="hlep"
								placeholder="이름을 입력하세요.">
						</div>
						<div class="form-group">
							<label for="input">연락처</label> <input type="text"
								name="phone" id="phone" class="form-control"
								aria-describedby="hlep" placeholder="-없이 입력해주세요.">
						</div>
						<div class="form-group">
							<label for="input">성별</label> <br> <input type="radio"
								name="gender" value="남" checked="checked" id="gender" />&nbsp;남자&nbsp;
							&nbsp;&nbsp;&nbsp; <input type="radio" name="gender" value="여">&nbsp;여자
						</div>
						<div class="form-group">
							<label for="input">이메일</label> <input type="text"
								name="email" id="email" class="form-control"
								aria-describedby="hlep" placeholder="이메일를 입력하세요.">
						</div>
						<div class="form-group">
							<label for="input">주소</label>	
							<button type="button" onclick="sample6_execDaumPostcode()">주소검색</button>
							<input type="text" name="zip" id="zip"
								class="text1" placeholder="우편주소" size="7">
							<input type="text" name="addr1" id="addr1"
								class="form-control" placeholder="주소">
							<input type="text" name="addr2" id="addr2"
								class="form-control" placeholder="상세주소">
							<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
						</div>
						<div class="col-md-12 text-center mb-3">
							<button type="submit"
								class=" btn btn-block mybtn btn-primary tx-tfm">회원가입</button>
						</div>
						<div class="col-md-12 ">
							<div class="form-group">
								<p class="text-center">
									<a href="<%=request.getContextPath()%>/login.me">회원이신가요?</a>
								</p>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {

		$("form[name='join']").validate({
			submitHandler : function() {
				var f = confirm("회원가입을 완료하겠습니까?");
				if (f) {
					return true;
				} else {
					return false;
				}
			},
			rules : {
				id : {
					required : true,
				},
				pw : {
					required : true,
					minlength : 5
				},
				pwck : {
					required : true,
					minlength : 5,
					equalTo : pw
				},
				name : {
					required : true
				},
				phone : {
					required : true,
					digits : true
				},
				email : {
					required : true,
					email : true
				},
				addr2 : {
					required : true
				}
			},

			messages : {
				id : {
					required : "필수 입력 사항입니다.",
					remote : "존재하는 아이디입니다."
				},
				pw : {
					required : "필수 입력 사항입니다.",
					minlength : "최소 5글자 이상이여야 합니다."
				},
				pwck : {
					required : "필수 입력 사항입니다.",
					minlength : "최소 5글자 이상이여야 합니다.",
					equalTo : "비밀번호가 일치하지 않습니다."
				},
				name : {
					required : "필수 입력 사항입니다."
				},
				phone : {
					required : "필수 입력 사항입니다.",
					digits : "숫자만 입력하세요."
				},
				email : {
					required : "필수 입력 사항입니다.",
					email : "메일 규칙에 어긋납니다."
				},
				addr2 : {
					required : "필수 입력 사항입니다."
				}
			}
		});
	});
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('zip').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('addr1').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('addr2').focus();
					}
				}).open();
	}
</script>
</html>
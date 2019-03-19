<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.MemberBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<!-- 부스트스랩 CSS 추가하기 -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- 제이쿼리 자바스크립트 추가하기 -->
<script src="../js/jquery-1.11.3.min.js"></script>
<!-- 부트스트랩 자바스크립트 추가하기 -->
<script src="../js/bootstrap.min.js"></script>
</head>
<style>
</style>
<body>
	<jsp:include page="../top_menu.jsp" flush="false" />
	<div class="container">
		<div class="row">
			<h3>개인정보</h3>
			<form name="modify" action="<%=request.getContextPath()%>/modify.me"
				method="post">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<tr>
						<td>아이디</td>
						<td>${member.mem_id }</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" id="pw" name="pw"></td>
					</tr>
					<tr>
						<td>비밀번화확인</td>
						<td><input type="password" id="pwck" name="pwck"></td>
					<tr>
						<td>이름</td>
						<td>${member.mem_name }</td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><input type="text" id="phone" name="phone"
							value="${member.mem_phone }"></td>
					</tr>
					<tr>
						<td>성별</td>
						<c:if test="${member.mem_gender == '남' }">
							<td><input type="radio" id="gender" name="gender" value="남"
								checked="checked" />&nbsp;남자&nbsp; &nbsp;&nbsp;&nbsp; <input
								type="radio" name="gender" value="여">&nbsp;여자</td>
						</c:if>
						<c:if test="${member.mem_gender == '여' }">
							<td><input type="radio" id="gender" name="gender" value="남" />&nbsp;남자&nbsp;
								&nbsp;&nbsp;&nbsp; <input type="radio" name="gender" value="여"
								checked="checked">&nbsp;여자</td>
						</c:if>
					</tr>
					<tr>
						<td>이메일</td>
						<td>
						<td><input type="text" id="email" name="email"
							value="${member.mem_email }"></td>
					</tr>
					<tr>
						<td>주소</td>
						<td>
							<button type="button" onclick="sample6_execDaumPostcode()">주소검색</button>
							<br> <input type="text" name="zip" id="zip"
							value="${member.mem_zip }"><br> <input type="text"
							name="addr1" id="addr1"><br> <input type="text"
							name="addr2" id="addr2"> <script
								src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
							<script>
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
																	+ data.buildingName
																	: data.buildingName);
														}
														// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
														fullAddr += (extraAddr !== '' ? ' ('
																+ extraAddr
																+ ')'
																: '');
													}

													// 우편번호와 주소 정보를 해당 필드에 넣는다.
													document
															.getElementById('zip').value = data.zonecode; //5자리 새우편번호 사용
													document
															.getElementById('addr1').value = fullAddr;

													// 커서를 상세주소 필드로 이동한다.
													document.getElementById(
															'addr2').focus();
												}
											}).open();
								}
							</script>
						</td>
					</tr>
					<tr>
						<td>가입일</td>
						<td>${member.mem_date }</td>
					</tr>
				</table>
				<div class="text-center">
					<a href="location.href='modify.jsp'" class="btn btn-primary">돌아가기</a>&nbsp;
					<a href="location.href='delete.me'" class="btn btn-primary">수정</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
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
			<form name="info" action="<%=request.getContextPath()%>/info.me"
				method="post">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<tr>
						<td>아이디</td>
						<td>${member.mem_id }</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${member.mem_name }</td>
					</tr>
					<tr>
						<td>연락처</td>
						<td>${member.mem_phone }</td>
					</tr>
					<tr>
						<td>성별</td>
						<td>${member.mem_gender }</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${member.mem_email }</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>${member.mem_zip }<br>${member.mem_addr1 }<br>${member.mem_addr2 }</td>
					</tr>
					<tr>
						<td>가입일</td>
						<td>${member.mem_date }</td>
					</tr>
				</table>
				<div class="text-center">
					<a href="<%=request.getContextPath()%>/modify.jsp" class="btn btn-primary">수정</a>&nbsp;
					<a href="<%=request.getContextPath()%>/delte.me" class="btn btn-primary">탈퇴</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
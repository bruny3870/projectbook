<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="vo.MemberBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<!-- 부스트스랩 CSS 추가하기 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- 제이쿼리 자바스크립트 추가하기 -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- 부트스트랩 자바스크립트 추가하기 -->
<script src="js/bootstrap.min.js"></script>
<%
	String id = null;
	if(session.getAttribute("id") != null){
		id = (String)session.getAttribute("id");
	}
%>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/main.jsp">BookieBookie</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				<c:choose>
					<c:when test="${id == null }">
						<li><a href="<%=request.getContextPath()%>/login.me">로그인</a></li>
						<li><a href="<%=request.getContextPath()%>/join.me">회원가입</a></li>
					</c:when>
					<c:when test="${id == 'admin' }">
						<li><a href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
						<li><a href="<%=request.getContextPath()%>/admin/admin_page.jsp">관리자페이지</a></li>
					</c:when>
					<c:otherwise>
						<li><a><%=session.getAttribute("id") %>님 환영합니다</a></li>
						<li><a href="<%=request.getContextPath()%>/logout.me">로그아웃</a></li>
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">마이페이지<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<%=request.getContextPath()%>/info.me">회원정보</a></li>
								<li><a href="#">주문/배송</a></li>
								<li><a href="#">장바구니</a></li>
							</ul>
						</li>
						<li><a href="<%=request.getContextPath()%>/note_list.jsp">공지사항</a></li>
					</c:otherwise>
				</c:choose>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">검색</button>
				</form>
			</div>
		</div>
	</nav>
</body>
</html>
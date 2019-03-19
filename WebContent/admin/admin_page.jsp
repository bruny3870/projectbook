<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	String id = (String)session.getAttribute("id");
	if(id==null) {
		out.println("<script>");
		out.println("alert('로그인이 필요한 서비스입니다.');");
		out.println("location.href='../member/login.me';");
		out.println("</script>");
	}else if(!id.equals("admin")){
		out.println("<script>");
		out.println("alert('권한이 없습니다.');");
		out.println("location.href='main.jsp';");
		out.println("</script>");
	}
%> --%>
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
<body>
<jsp:include page="../top_menu.jsp" flush="false"/>
<div class="pageform">
	<h3>관리자 페이지</h3>
	<div class="">
	<div id="">
	<br><br>
		<a href="member_list.jsp">회원관리</a>
		<a href="#">입출고관리</a>
		<a href="<%=request.getContextPath()%>/admin/itemRegist.jsp">상품등록</a>
		<a href="<%=request.getContextPath()%>/admin/itemList.jsp">상품목록</a>
		<a href="#">주문목록</a>
		<a href="#">상품문의</a>
	</div>
</div>
</div>
</body>
</html>
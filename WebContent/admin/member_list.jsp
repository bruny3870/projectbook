<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MemberBean"%>
<%@ page import="java.util.*"%>
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
<%
	ArrayList<MemberBean> list = (ArrayList<MemberBean>) request.getAttribute("list");
%>
<body>
	<jsp:include page="../top_menu.jsp" flush="false" />
	<div class="container">
		<div class="row">
			<h3>회원목록</h3>
			<form>
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<% for(int i=0;i<list.size();i++){%>
					<tr>
						<td><%=list.get(i).getMem_id() %></td>
					</tr>
					<%} %>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
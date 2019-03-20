<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.ItemBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
<body>
	<jsp:include page="../top_menu.jsp" flush="false" />
	<div class="container">
		<div class="row">
			<h3>상품등록</h3>
			<form name="itemRegist" action="itemRegist.it" method="post" enctype="multipart/form-data">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd; margin: auto; width: 450px;">
					<tr>
						<td><label>도서코드</label></td>
						<td><input type="text" name="it_code" id="it_code" /></td>
					</tr>
					<tr>
						<td><label>도서명</label></td>
						<td><input type="text" name="it_name" id="it_name" /></td>
					</tr>
					<tr>
						<td><label>분야</label></td>
						<td><input type="text" name="it_category" id="it_category" /></td>
					</tr>
					<tr>
						<td><label>저자</label></td>
						<td><input type="text" name="it_author" id="it_author" /></td>
					</tr>
					<tr>
						<td><label>ISBN</label></td>
						<td><input type="text" name="it_isbn" id="it_isbn" /></td>
					</tr>
					<tr>
						<td><label>출판사</label></td>
						<td><input type="text" name="it_publisher" id="it_publisher" /></td>
					</tr>
					<tr>
						<td><label>출판일</label></td>
						<td><input type="text" name="it_pubdate" id="it_pubdate" /></td>
					</tr>
					<tr>
						<td><label>가격</label></td>
						<td><input type="text" name="it_price" id="it_price" /></td>
					</tr>
					<tr>
						<td><label>설명</label></td>
						<td><textarea name="it_content" rows="13" cols="40"
								id="it_content"></textarea></td>
					</tr>
					<tr>
						<td><label>이미지</label></td>
						<td><input type="file" name="it_img" id="it_img" /></td>
					</tr>
				</table>
				<br>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">상품등록</button>
					<a href="<%=request.getContextPath()%>/admin/admin_page.jsp"
						class="btn btn-primary">관리자페이지</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
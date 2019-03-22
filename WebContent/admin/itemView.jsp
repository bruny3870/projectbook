<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h3>상품정보</h3>
			<form method="post" name="itemView">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<tr align="left">
						<td colspan="3">${item.it_category } | ${item.it_name }</td>
					</tr>
					<tr>
						<th rowspan="6" width="300px" height="500px"><img src="images/${item.it_img }" width="300px" height="500px" ></th>
						<td>코드</td>
						<td>${item.it_code }</td>
					</tr>
					<tr>
						<td>분류</td>
						<td>${item.it_category }</td>
					</tr>
					<tr>
						<td>상품명</td>
						<td>${item.it_name }</td>
					</tr>
					<tr>
						<td>출판사</td>
						<td>${item.it_publisher }</td>
					</tr>
					<tr>
						<td>가격</td>
						<td>${item.it_price }</td>
					</tr>
					<tr>
						<td>재고</td>
						<td>${stock.st_stock }</td>
					</tr>
					<tr align="center">
						<td colspan="3"><a href="/projecttest/itemList.it" class="btn btn-primary">목록</a>
						<a href="/projecttest/itemModForm.it?it_code=${item.it_code}" class="btn btn-primary">수정</a>
						<a href="/projecttest/itemDelete.it?it_code=${item.it_code }" class="btn btn-primary">삭제</a></td>
					</tr>
				</table>
				<br>
				<div>
					<h3>상품내용</h3>
					${item.it_content }
				</div>
				<br>
				<div class="text-center">
					<a href="/projecttest/itemRegistForm.it" class="btn btn-primary">상품등록</a>&nbsp;
					<a href="<%=request.getContextPath()%>/admin/admin_page.jsp" class="btn btn-primary">관리자페이지</a>
				</div>
			</form>	
		</div>
	</div>
</body>
</html>
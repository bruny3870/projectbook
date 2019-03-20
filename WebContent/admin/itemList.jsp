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
			<h3>상품목록</h3>
			<form method="post" name="itemList">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<tr>	
						<td>코드</td>
						<td>분류</td>
						<td>상품명</td>
						<td>출판사</td>
						<td>가격</td>
						<td>조회</td>
					</tr>
					<c:choose>
						<c:when test="${pageInfo.listCount>0 }">
							<c:forEach var="itemList" items="${itemList }">
								<tr>
									<td>${itemList.it_code }</td>
									<td>${itemList.it_category }</td>
									<td>${itemList.it_name }</td>
									<td>${itemList.it_publisher}</td>
									<td>${itemList.it_price }</td>
									<td><a href="/projecttest/itemveiw.it" class="btn btn-primary">조회</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="8">
									<c:if test="${pageInfo.page<=1 }">
									</c:if>
									<c:if test="${pageInfo.page>1 }">
									</c:if>
									<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
										<c:choose>
											<c:when test="${a==pageInfo.page }">
												<span id="nowpage">${a }</span>
											</c:when>
										</c:choose>
									</c:forEach>
									<c:choose>
										<c:when test="${pageInfo.page>=pageInfo.maxPage }">
										</c:when>
									</c:choose>
								</td>
							</tr>
						</c:when>
					<c:otherwise>
						<tr><td colspan="8">등록된 상품이 없습니다.</td></tr>
					</c:otherwise>
				</c:choose>
			</table>
				<div class="text-center">
					<a href="/projecttest/itemRegistFrom.it" class="btn btn-primary">상품등록</a>&nbsp;
					<a href="<%=request.getContextPath()%>/admin/admin_page.jsp" class="btn btn-primary">관리자페이지</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
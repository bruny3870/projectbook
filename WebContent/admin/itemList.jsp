<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.PageInfo" %>
<%@ page import="vo.ItemBean"%>
<%@ page import="java.util.*" %>
<%-- <%
	ArrayList<ItemBean> itemList = (ArrayList<ItemBean>) request.getAttribute("itemList");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%> --%>
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
			<form>
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<tr>	
						<td>코드</td>
						<td>분류</td>
						<td>상품명</td>
						<td>출판사</td>
						<td>가격</td>
					</tr>
					<tr>
						<td>${item.it_code }</td>
						<td>${item.it_category }</td>
						<td>${item.it_name }</td>
						<td>${item.it_publisher}</td>
						<td>${item.it_price }</td>
					</tr>
				</table>
				<div class="text-center">
					<a href="<%=request.getContextPath()%>/admin/itemRegist.jsp" class="btn btn-primary">상품등록</a>&nbsp;
					<a href="<%=request.getContextPath()%>/admin/admin_page.jsp" class="btn btn-primary">관리자페이지</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
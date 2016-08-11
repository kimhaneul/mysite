<%@page import="kr.ac.sungkyul.mysite.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	BoardVo vo = (BoardVo) request.getAttribute("vovo");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">

		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<!-- 공통된 부분(헤더)를 하나의 클래스로 관리 -->
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="/mysite/board">
					<input type="hidden" name="a" value="modify"> <input
						type="hidden" name="no" value="<%=vo.getNo()%>">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글수정</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title"
								value="<%=vo.getTitle()%>"></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td><textarea id="content" name="content"><%=vo.getContent()%>
						</textarea></td>
						</tr>
					</table>
					<div class="bottom">
						<a href="/mysite/board?a=view&no=<%=vo.getNo()%>">취소</a> <input
							type="submit" value="수정">
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navigation.jsp" />
		<div id="footer">
			<p>(c)opyright 2014</p>
		</div>
	</div>
</body>
</html>
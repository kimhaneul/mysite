<%@page import="kr.ac.sungkyul.mysite.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	BoardVo vo = (BoardVo) request.getAttribute("vovo");
%>



<!DOCTYPE html>
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
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td><%=vo.getTitle()%></td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								<%=vo.getContent()%>
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="/mysite/board?a=list">글목록</a> <a
						href="/mysite/board?a=modifyForm&no=<%=vo.getNo()%>">글수정</a> 
						
						
						<a href="/mysite/board?a=writeform&group=<%=vo.getGroup_no()%>&order=<%=vo.getOrder_no()%>&depth=<%=vo.getDepth()+1L%>"> 답글</a>

				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navigation.jsp" />
		<div id="footer">
			<p>(c)opyright 2014</p>
		</div>
	</div>
</body>
</html>
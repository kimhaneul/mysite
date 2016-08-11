<%@page import="kr.ac.sungkyul.mysite.vo.BoardVo"%>
<%@page import="kr.ac.sungkyul.mysite.vo.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<BoardVo> list = (List<BoardVo>) request.getAttribute("list");
%>

<%
	UserVo authUser = (UserVo) session.getAttribute("authUser");
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
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>

					<%
						for (BoardVo vo : list) {
					%>
					<tr>
						<td><%=vo.getNo()%></td>
						<td>
							<%
								for (int i = 1; i < vo.getDepth(); i++) {
							%> ↳ <%
								}
							%> <a href="/mysite/board?a=view&no=<%=vo.getNo()%>"><%=vo.getTitle()%></a>
						</td>
						<td><%=vo.getUser_name()%></td>
						<td><%=vo.getView_count()%></td>
						<td><%=vo.getReg_date()%></td>
						<td>
							<%
								try {
										if (vo.getUser_no() == authUser.getNo()) {
							%> <a href="/mysite/board?a=delete&no=<%=vo.getNo()%>"
							class="del">삭제</a> <%
 	}
 		} catch (NullPointerException e) {
 		}
 %>
						</td>
					</tr>
					<%
						}
					%>
				</table>


				<div class="bottom">
					<a href="/mysite/board?a=writeform&group=0&order=1&depth=1"
						id="new-book">글쓰기</a>
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
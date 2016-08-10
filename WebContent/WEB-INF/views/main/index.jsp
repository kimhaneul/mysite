<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/main.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<!-- 공통된 부분(헤더)를 하나의 클래스로 관리 -->
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile"
						src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xpa1/v/t1.0-1/c12.12.155.155/923435_640327239315552_1584643451_n.jpg?oh=a06148a32cfedc106b07da787095f596&oe=544C85EF&__gda__=1413520834_d2143b0d0fffb85fa6b1ab9116643c38">
					<h2>안녕하세요. 안대혁의 mysite에 오신 것을 환영합니다.</h2>
					<p>
						이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.<br> 메뉴는 사이트 소개, 방명록, 게시판이 있구요.
						JAVA 수업 + 데이터베이스 수업 + 웹프로그래밍 수업 배운 거 있는거 없는 거 다 합쳐서 만들어 놓은 사이트
						입니다.<br>
						<br> <a href="#">방명록</a>에 글 남기기<br>
					</p>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navigation.jsp" />
		<div id="footer">
			<p>(c)opyright 2015</p>
		</div>
	</div>
</body>
</html>
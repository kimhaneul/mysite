package kr.ac.sungkyul.mysite.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class LogoutAcrion implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 로그아웃 처리
		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute("authUser");
			session.invalidate(); // 새로운 세션 아이디를 발행
		}

		WebUtil.redirect("/mysite/main", request, response);

	}
}

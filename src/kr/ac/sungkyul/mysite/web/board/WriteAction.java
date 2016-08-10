package kr.ac.sungkyul.mysite.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.mysite.vo.UserVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class WriteAction implements Action {

	private ServletRequest session;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		if (session == null) {
			WebUtil.redirect("/mysite/main", request, response);
			return;
		}
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			WebUtil.redirect("/mysite/main", request, response);
			return;
		}

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Long user_no = authUser.getNo();

		BoardVo vo = new BoardVo();
		BoardDao dao = new BoardDao();

		vo.setTitle(title);
		vo.setContent(content);
		vo.setUser_no(user_no);

		dao.insert(vo);

		WebUtil.redirect("/mysite/board?a=list", request, response);

	}

}

package kr.ac.sungkyul.mysite.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Long no = Long.parseLong(request.getParameter("no"));
		BoardDao dao = new BoardDao();

		BoardVo vovo = dao.view(no);
		request.setAttribute("vovo", vovo);

		WebUtil.forward("/WEB-INF/views/board/view.jsp", request, response);
	}
}

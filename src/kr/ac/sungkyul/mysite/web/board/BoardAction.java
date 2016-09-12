package kr.ac.sungkyul.mysite.web.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class BoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pageCount = 5; // 페이지에 표시할 게시글 개수
		int pageNum = Integer.parseInt((request.getParameter("pageNum"))); // 페이지 번호

		BoardDao dao = new BoardDao();
		List<BoardVo> list = new ArrayList<BoardVo>();

		list = dao.getList(pageNum, pageCount);
		int content_Count = dao.get_Ccontent_Count();

		request.setAttribute("list", list);
		request.setAttribute("content_Count", content_Count);
		request.setAttribute("pageCount", pageCount);
		WebUtil.forward("/WEB-INF/views/board/list.jsp", request, response);
	}

}

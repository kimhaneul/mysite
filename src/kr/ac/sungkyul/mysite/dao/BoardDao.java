package kr.ac.sungkyul.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.mysite.vo.BoardVo;

public class BoardDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void insert(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into board values (seg_board.nextval, ?, ?,sysdate,?,?,?,?,?)";
			// 글 번호, 제목, 내용, 날짜, 조회수, 그룹번호, 그룹내순서, 글깊이, 회원번호

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, 1);
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 1);
			pstmt.setInt(6, 1);
			pstmt.setLong(7, vo.getUser_no());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<BoardVo> getList() {
		List<BoardVo> list = new ArrayList<BoardVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = "select no, title, (select name from users where no = user_no) as user_name, view_count, reg_date from board  order by no desc";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String user_name = rs.getString(3);
				int view_count = rs.getInt(4);
				String reg_date = rs.getString(5);

				BoardVo vo = new BoardVo();

				vo.setNo(no);
				vo.setTitle(title);
				vo.setUser_name(user_name);
				vo.setView_count(view_count);
				vo.setReg_date(reg_date);

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public BoardVo modify(BoardVo Vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardVo vo = new BoardVo();

		try {
			conn = getConnection();

			String sql = "update board set title = ?, content = ? where no=?";
			System.out.println("update sql");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setLong(3, vo.getNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	public BoardVo view(Long no) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardVo vo = new BoardVo();
		try {
			conn = getConnection();

			String sql = "select no, title, content from board where no =" + no;
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no1 = rs.getLong(1);
				String title = rs.getString(2);
				String content = rs.getString(3);

				vo.setNo(no1);
				vo.setTitle(title);
				vo.setContent(content);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

}

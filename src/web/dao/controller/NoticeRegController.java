package web.dao.controller;
/*package web.dao.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer/notice-reg")
public class NoticeRegController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		NoticeDao noticeDao = new MybatisNoticeDao();

		Notice n = new Notice();
		n.setTitle(title);
		n.setContent(content);
		n.setWriter("Deok");

		
		noticeDao.insert(n);

		
		reponse.sendRedirect("notice");
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {

		// _code '_'�� ���ǰ˻�, Ȯ���ϰ� ������ �ӽú���
		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MybatisNoticeDao();
		Notice notice;

		notice = noticeDao.get(_code);

		request.setAttribute("n", notice);

		request.getRequestDispatcher("/WEB-INF/views/customer/notice-reg.jsp").forward(request, reponse);

	}

}
*/
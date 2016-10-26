package web.dao.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.NoticeDao;
import web.dao.mybatis.notice.MybatisNoticeDao;
import web.entities.Notice;

@WebServlet("/admin/notice-detail")
public class NoticeDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MybatisNoticeDao();
		Notice notice;
		notice = noticeDao.get(_code);

		request.setAttribute("n", notice);
		request.getRequestDispatcher("/WEB-INF/views/admin/notice/notice-detail.jsp").forward(request, reponse);

	}

}

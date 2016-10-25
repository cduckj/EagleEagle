package web.dao.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.NoticeDao;
import web.dao.mybatis.MybatisNoticeDao;
import web.model.NoticeModel;

@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		String p = request.getParameter("p");
		String t = request.getParameter("t");
		String q = request.getParameter("q");
		
		int page = 1;
		String field = "TITLE";
		String query = "";
		
		
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);
		
		if(t != null && !t.equals(""))
			field = t;
		
		if(q != null)
			query = q;
		
		
		NoticeDao noticeDao = new MybatisNoticeDao();
		noticeDao.getList(page, field, query);
		
		
		List<NoticeModel> list = new MybatisNoticeDao().getList(page, field, query);
		int count = noticeDao.getCount(field, query);

		request.setAttribute("list", list);
		request.setAttribute("count", count);

		request.getRequestDispatcher("/WEB-INF/views/customer/notice.jsp").forward(request, reponse);

	}

}

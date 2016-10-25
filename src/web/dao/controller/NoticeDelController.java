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

@WebServlet("/customer/notice-del")
public class NoticeDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		String code = request.getParameter("code");
		NoticeDao noticeDao = new MybatisNoticeDao();

		Notice n = new Notice();
		n.setCode(code);
		
		noticeDao.delete(code);
		
		reponse.sendRedirect("notice");
		
	}

}
*/
package web.dao.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import web.dao.NoticeDao;
import web.dao.mybatis.notice.MybatisNoticeDao;
import web.entities.Notice;

@WebServlet("/admin/notice-reg")
public class NoticeRegController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
/*		String title = request.getParameter("title");
		String content = request.getParameter("content");
*/
		
		ServletContext ctx = request.getServletContext();
		
		String path = ctx.getRealPath("/admin/upload");
		System.out.println(path);
		MultipartRequest req = new MultipartRequest(request, 
				path,
				1024*1024*300,
				"UTF-8",
				new DefaultFileRenamePolicy()
				
				);
		String content = req.getParameter("content");
		String title = req.getParameter("title");
		
		NoticeDao noticeDao = new MybatisNoticeDao();

		Notice n = new Notice();
		n.setTitle(title);
		n.setContent(content);
		n.setMember_id("test101");

		noticeDao.insert(n);
		
		reponse.sendRedirect("notice");
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {

		/*String _code = request.getParameter("code");

		NoticeDao noticeDao = new MybatisNoticeDao();
		Notice notice;

		notice = noticeDao.get(_code);

		request.setAttribute("n", notice);*/

		request.getRequestDispatcher("/WEB-INF/views/admin/notice/notice-reg.jsp").forward(request, reponse);

	}

}

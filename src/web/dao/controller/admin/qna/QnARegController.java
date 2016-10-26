package web.dao.controller.admin.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import web.dao.QnADao;
import web.dao.mybatis.MyBatisQnADao;
import web.dto.QnADto;

@WebServlet("/admin/qna-reg")
public class QnARegController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*	String _code = request.getParameter("code");
		NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice notice = noticeDao.get(_code);
		request.setAttribute("n", notice);*/
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/admin/qna/qna-reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx = request.getServletContext();
		
		String path = ctx.getRealPath("/admin/upload");
		System.out.println(path);
		MultipartRequest req = new MultipartRequest(request, 
				path,
				1024*1024*300,
				"UTF-8",
				new DefaultFileRenamePolicy()
				
				);
		
		
/*		String content = request.getParameter("content");
		String title = request.getParameter("title");*/
		
		String content = req.getParameter("content");
		String title = req.getParameter("title");
		
		
		
		QnADao qnaDao = new MyBatisQnADao();
		
		QnADto qna = new QnADto();
		
		qna.setContent(content);
		qna.setTitle(title);
		//현재 로그인 사용자 정보를 얻는 로직
		qna.setMember_id("Watasi");
		
		
		qnaDao.insert(qna);
		
		response.sendRedirect("qna");
	}
	
}

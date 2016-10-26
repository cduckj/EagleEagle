package web.dao.controller.admin.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.QnADao;
import web.dao.mybatis.MyBatisQnADao;
import web.dto.QnADto;

//이 파일 경로 지정 > 실제 이 파일이 있는건 아님
@WebServlet("/admin/qna-detail")
public class QnADetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<QnADto> list;
		String _code = request.getParameter("code");

		QnADao noticeDao = new MyBatisQnADao();
		QnADto notice = noticeDao.get(_code);

		request.setAttribute("n", notice);

		/*
		 * //1. 그냥 부르기 : 네가 새로 햇! 내가 하는일을 뷰가 이용할 수 없음
		 * response.sendRedirect("notice.jsp");
		 */

		// 2. 자원 공유하면서 부르기 : 일을 이어서 계속햇!

		request.getRequestDispatcher("/WEB-INF/views/admin/qna/qna-detail.jsp").forward(request, response);

	}

}

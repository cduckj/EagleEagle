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
@WebServlet("/admin/qna-edit")
public class QnAEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<QnADto> list;
		try {

			String _code = request.getParameter("code");

			QnADao qnaDao = new MyBatisQnADao();
			QnADto qna = qnaDao.get(_code);

			request.setAttribute("n", qna);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * //1. 그냥 부르기 : 네가 새로 햇! 내가 하는일을 뷰가 이용할 수 없음
		 * response.sendRedirect("qna.jsp");
		 */

		// 2. 자원 공유하면서 부르기 : 일을 이어서 계속햇!

		request.getRequestDispatcher("/WEB-INF/views/admin/qna/qna-edit.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("code : "+  code);
		System.out.println("title : "+  title);
		System.out.println("컨트롤러 : "+  content);
		
		QnADao qnaDao = new MyBatisQnADao();
		
		QnADto n = new QnADto();
		
		n.setCode(code);
		n.setTitle(title);
		n.setContent(content);
		
		qnaDao.update(n);

		response.sendRedirect("qna-detail?code="+code);
		
	}
}

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

@WebServlet("/admin/qna")
public class QnAController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		String p = request.getParameter("p");
		String t = request.getParameter("t");
		String q = request.getParameter("q");

		int page = 1;
		String field = "title";
		String query = "";
		
		
		System.out.println(p+"/"+t+"/"+q);
		
		if(p!=null && !p.equals("")){
			page = Integer.parseInt(p);
		}
		
		if(t!=null && !t.equals("")){
			field = t;
		}   
		if(q!=null){
			query = q;
		}
		
		
		QnADao qnaDao = new MyBatisQnADao();
		List<QnADto> list = qnaDao.getList(page, field, query);
		
		
		//int count = qnaDao.getCount(field,query);
		//request.setAttribute("count", count);
		
		
		request.setAttribute("list", list);
		
		
		
		
		/*
		 * //1. 그냥 부르기 : 네가 새로 햇! 내가 하는일을 뷰가 이용할 수 없음
		 * response.sendRedirect("notice.jsp");
		 */

		// 2. 자원 공유하면서 부르기 : 일을 이어서 계속햇!

		request.getRequestDispatcher("/WEB-INF/views/admin/qna/qna.jsp").forward(request, response);

	}

}
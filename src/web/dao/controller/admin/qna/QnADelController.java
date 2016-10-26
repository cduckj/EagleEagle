package web.dao.controller.admin.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.mybatis.MyBatisQnADao;

@WebServlet("/admin/qna-del")
public class QnADelController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");

		/*
		qnaDao qnaDao = new MyBatisqnaDao();
		
		qnaDao.delete(code);
		*/
		
		int reulst = new MyBatisQnADao().delete(code);
		
		
		response.sendRedirect("qna");
	}

}

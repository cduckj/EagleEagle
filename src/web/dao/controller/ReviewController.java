package web.dao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.mybatis.MyBatisReviewDao;
import web.entities.Review;
import web.model.ReviewModel;

import web.dao.ReviewDao;

@WebServlet("/review")
public class ReviewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ReviewModel> list;
		List<ReviewModel> userreview;
		List<ReviewModel> hituserreview;

		String p = request.getParameter("p");

		int page = 1;

		if (p != null && !p.equals(""))
			page = Integer.parseInt(p);
		
		
		ReviewDao reviewDao = new MyBatisReviewDao();

		list = reviewDao.getad();
		userreview = reviewDao.getuser(page);
		hituserreview=reviewDao.gethituser();
		int count = reviewDao.getCount();
		request.setAttribute("list", list);
		request.setAttribute("userlist", userreview);
		request.setAttribute("hituserlist", hituserreview);
		request.setAttribute("count", count);
		/* response.sendRedirect("notice.jsp"); */
		// 2. �ڿ��� �����ϸ鼭 �θ��� :
		request.getRequestDispatcher("/WEB-INF/views/review.jsp").forward(request, response);

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content = request.getParameter("content");
		
		
		
		ReviewDao reviewDao = new MyBatisReviewDao(); 
		
		Review n= new Review();
		n.setContent(content);
		n.setWriter("원석");
		n.setSort("회원");
		n.setCode("301");
		//n.setNum("4");
		reviewDao.insert(n);
		
		
		response.sendRedirect("review");
		
	
	}

}

package web.dao.controller.admin.member;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.MemberDao;
import web.dao.mybatis.member.MyBatisMemberDao;
import web.entities.Member;

@WebServlet("/admin/member-join")
public class JoinController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/admin/member/member-join.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = new String(request.getParameter("id"));
		String pwd = new String(request.getParameter("pwd"));
		String nickName = new String(request.getParameter("nickName"));
		
		MemberDao memberDao = new MyBatisMemberDao();
		
		Member m = new Member();

		m.setId(id);
		m.setPwd(pwd);
		m.setNickName(nickName);
		
		
		memberDao.insert(m);
		
		//if(noticeDao.update(n) ==1 )
		response.sendRedirect("member-login");
		//request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
		
	}


}

package web.dao.controller.admin.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.mybatis.member.MyBatisMemberDao;
import web.entities.Member;



@WebServlet("/admin/member-login")
public class LoginController extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/admin/member/member-login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String login_id = request.getParameter("id");
		String login_pwd;
		String login_id;

		Member m = new MyBatisMemberDao().check(request.getParameter("id"));
		
		// System.out.println(i);
		
		if (m == null) {
			response.sendRedirect("member-error");
		} else {
			login_id = m.getId();

			if (login_id.equals(request.getParameter("id"))) {

				login_pwd = m.getPwd();

				if (login_pwd.equals(request.getParameter("pwd"))) {
					
					HttpSession session = request.getSession();
					session.setAttribute("sm", m);

					response.sendRedirect("member-main");
				} else {
					
					
					response.sendRedirect("member-error");
				}

			} else {
				response.sendRedirect("member-error");

			}

		}
	}

}

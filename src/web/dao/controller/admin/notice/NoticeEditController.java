package web.dao.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.NoticeDao;
import web.dao.mybatis.notice.MybatisNoticeDao;
import web.entities.Notice;

@WebServlet("/admin/notice-edit")
public class NoticeEditController extends HttpServlet{
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String code = request.getParameter("code");
      String title = request.getParameter("title");
      String content = request.getParameter("content");
       
       NoticeDao noticeDao = new MybatisNoticeDao();
       
       Notice n = new Notice();
       n.setCode(code);
       n.setTitle(title);
       n.setContent(content);
       
       noticeDao.update(n);
       
       response.sendRedirect("notice-detail?code="+code);
       
       
      
   }
   
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String code = request.getParameter("code");
       
      NoticeDao noticeDao = new MybatisNoticeDao();
      Notice notice;

      notice = new MybatisNoticeDao().get(code);
      request.setAttribute("n", notice);

      request.getRequestDispatcher("/WEB-INF/views/admin/notice/notice-edit.jsp").forward(request, response);

   }

}
package web.dao.mybatis.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import web.dao.NoticeDao;
import web.dao.mybatis.SessionFactoryBuilder;
import web.entities.Notice;
import web.model.NoticeModel;



public class MybatisNoticeDao implements NoticeDao{
	
	SqlSessionFactory ssf;
	
	public MybatisNoticeDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}


	@Override
	public Notice get(String code)  {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		Notice result = noticeDao.get(code);
		session.close();
		return result;
	}

	@Override
	public List<NoticeModel> getList(int page, String field, String query)  {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		List<NoticeModel> result = noticeDao.getList(page, field, query);
		session.close();
		return result;
	}

	@Override
	public List<NoticeModel> getList(int page)  {
		
		return getList(1, "TITLE", "");
	}

	@Override
	public List<NoticeModel> getList()  {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		List<NoticeModel> result = noticeDao.getList();
		
		session.close();
		return result;
	}

	@Override
	public int insert(Notice notice)  {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.insert(notice);
		session.commit();
		session.close();
		
		return result;
		
		
	}

	@Override
	public int update(Notice notice)  {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.update(notice);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int delete(String code)  {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.delete(code);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int count = noticeDao.getCount(field, query);
		
		session.close();
		
		return count;
	}

}

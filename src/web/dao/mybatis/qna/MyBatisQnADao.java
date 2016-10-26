package web.dao.mybatis.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import web.dao.mybatis.SessionFactoryBuilder;

import web.dao.QnADao;
import web.dto.QnADto;

public class MyBatisQnADao implements QnADao{
	
	SqlSessionFactory ssf;
	
	public MyBatisQnADao(){
		
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}

	@Override
	public QnADto get(String code) {
		SqlSession session = ssf.openSession();
		QnADao qnaDao = session.getMapper(QnADao.class);
		return qnaDao.get(code);
	}

	@Override
	public List<QnADto> getList(int page, String field, String query) {
		SqlSession session = ssf.openSession();
		QnADao qnaDao = session.getMapper(QnADao.class);		
		
		return qnaDao.getList(page,field,query);
	}

	@Override
	public List<QnADto> getList(int page) {
		SqlSession session = ssf.openSession();
		QnADao qnaDao = session.getMapper(QnADao.class);
		
		return getList(page,"title","");
	}

	@Override
	public List<QnADto> getList() {
		SqlSession session = ssf.openSession();
		QnADao qnaDao = session.getMapper(QnADao.class);
		
		return getList(1,"title","");
	}

	@Override
	public int getCount(String field, String query) {
		SqlSession session = ssf.openSession();
		QnADao qnaDao = session.getMapper(QnADao.class);
		
		int count = qnaDao.getCount(field,query);
		
		session.commit();
		session.close();
		
		return count;
	}

	@Override
	public int insert(QnADto qnaDto) {
		SqlSession session = ssf.openSession();
		QnADao qnaDao = session.getMapper(QnADao.class);
		
		int result = qnaDao.insert(qnaDto);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int update(QnADto qnaDto){
		SqlSession session = ssf.openSession();
		QnADao qnaDao = session.getMapper(QnADao.class);
		
		int result = qnaDao.update(qnaDto);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int delete(String code){
		SqlSession session = ssf.openSession();
		QnADao qnaDao = session.getMapper(QnADao.class);	
		
		int result = qnaDao.delete(code);
		session.commit();
		session.close();
		return result;
	}
}

package web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import web.entities.Review;
import web.model.ReviewModel;

import web.dao.ReviewDao;

public class MyBatisReviewDao implements ReviewDao {

	SqlSessionFactory ssf;

	public MyBatisReviewDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}

	/*@Override
	public Review get(String code)  {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		return reviewDao.get(code);
	}*/
	@Override
	public List<ReviewModel> getad()  {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		List<ReviewModel> result=reviewDao.getad();
		return result;
	}
	@Override
	public List<ReviewModel> getuser(int page)  {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		List<ReviewModel> result=reviewDao.getuser(page);
		session.close();
		
		return result;
	}
	public List<ReviewModel> gethituser()  {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		List<ReviewModel> result=reviewDao.gethituser();
		session.close();
		
		return result;
	}
	
	@Override
	public int getCount() {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		int result=reviewDao.getCount();
		session.close();
		return result;
	}
	/*@Override
	public List<ReviewModel> getList(int page, String field, String query)  {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		return reviewDao.getList(page,field,query);
	}

	@Override
	public List<ReviewModel> getList(int page)  {
		
		return getList(page,"TITLE","");// TODO Auto-generated method stub

	}
	@Override
	public List<ReviewModel> getList()  {
		
		return getList(1,"TITLE","");
	}
	*/
	

	@Override
	public int insert(Review review)   {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		
		int result =reviewDao.insert(review);
		session.commit();
		session.close();
		return  result;
	}

	/*@Override
	public int update(Review notice) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		
		int result =reviewDao.update(notice);
		session.commit();
		session.close();
		return  result;
	}

	@Override
	public int delete(Review notice)   {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		
		int result =reviewDao.delete(notice);
		session.commit();
		session.close();
		return  result;
	}
*/
	

}

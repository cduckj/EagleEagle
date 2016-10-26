package web.dao.mybatis.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import web.dao.MemberDao;
import web.dao.mybatis.SessionFactoryBuilder;
import web.entities.Member;



public class MyBatisMemberDao implements MemberDao {

	SqlSessionFactory ssf;

	public MyBatisMemberDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}

	@Override
	public Member get(String id, String pwd) {
		SqlSession session = ssf.openSession(); //
		MemberDao memberDao = session.getMapper(MemberDao.class);

		return memberDao.get(id, pwd);
	}



	@Override
	public int insert(Member member) {
		SqlSession session = ssf.openSession(); //
		MemberDao memberDao = session.getMapper(MemberDao.class);

		int result = memberDao.insert(member);

		session.commit();
		session.close();

		return result;
	}
	
	@Override
	public List<Member> getList(String id, String nickName, String pwd) {
		SqlSession session = ssf.openSession(); //
		MemberDao memberDao = session.getMapper(MemberDao.class);
		
		
		return getList(id,nickName, pwd);
	}

	@Override
	public Member check(String id) {
		SqlSession session = ssf.openSession(); //
		MemberDao memberDao = session.getMapper(MemberDao.class);
		
		
		return memberDao.check(id);
	}

}

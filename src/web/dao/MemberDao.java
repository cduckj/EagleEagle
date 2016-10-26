package web.dao;

import java.util.List;

import web.entities.Member;



public interface MemberDao {
	
	Member get(String id, String pwd);
	List<Member> getList(String id, String nickName, String pwd);
	int insert(Member member);
	Member check(String id);
}

package web.dao;

import java.util.List;
import web.dto.QnADto;

public interface QnADao {
	
	QnADto get(String code);
	List<QnADto> getList(int page, String field, String query);
	List<QnADto> getList(int page);
	List<QnADto> getList();
	int getCount(String field, String query);
	int insert(QnADto qna);
	int update(QnADto n);
	int delete(String code);
}

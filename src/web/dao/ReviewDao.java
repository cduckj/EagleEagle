package web.dao;

import java.util.List;


import web.entities.Review;
import web.model.ReviewModel;

public interface ReviewDao {
	List<ReviewModel> getad()  ;
	List<ReviewModel> getuser(int page)  ;
	List<ReviewModel> gethituser();
	int insert(Review review) ;
	int getCount();
}

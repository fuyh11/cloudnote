package mapper;

import service.starts.dataobject.StarsDAO;

public interface StarsMapper {
	StarsDAO findStarsByUserId(String userId);
	
	int insertStars(StarsDAO stars);
	
	int updateStars(StarsDAO stars);
}

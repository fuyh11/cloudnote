package mapper;

import service.post.dataobject.PostDAO;

public interface PostMapper {
	PostDAO findPostById(Integer id);
}

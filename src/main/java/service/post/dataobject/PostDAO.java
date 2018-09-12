package service.post.dataobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import service.comment.dataobject.CommentDAO;
import service.person.dataobject.PersonDAO;

@Data
public class PostDAO implements Serializable {
    private static final long serialVersionUID = -4722438109030592372L;

    private Integer id;
    private String title;

    /**
     * 发帖人
     */
    private PersonDAO person;

    /**
     * 当前帖子收到的回复
     */
    private List<CommentDAO> comments = new ArrayList<CommentDAO>();

    public PostDAO() {
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", person=" + person + ", comments=" + comments + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PostDAO other = (PostDAO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}





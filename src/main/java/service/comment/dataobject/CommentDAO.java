package service.comment.dataobject;

import java.io.Serializable;

import lombok.Data;

/**
 * 代表回帖
 */
@Data
public class CommentDAO implements Serializable {
    private static final long serialVersionUID = -5881249634665160256L;

    private Integer id;
    private String title;

    public CommentDAO() {
    }

    public CommentDAO(String title) {
        super();
        this.title = title;
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
        CommentDAO other = (CommentDAO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", title=" + title + "]";
    }

}

package service.starts.dataobject;

import java.io.Serializable;

import lombok.Data;

@Data
public class StarsDAO implements Serializable {
    private static final long serialVersionUID = 5369654765376944252L;

    private String id;
    private String userId;
    private Integer stars;

    public StarsDAO() {
    }

    public StarsDAO(String id, String userId, Integer stars) {
        super();
        this.id = id;
        this.userId = userId;
        this.stars = stars;
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
        StarsDAO other = (StarsDAO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Stars [id=" + id + ", userId=" + userId + ", stars=" + stars + "]";
    }

}

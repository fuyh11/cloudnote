package service.notebook.dataobject;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class NotebookDAO implements Serializable {
    private static final long serialVersionUID = -8341731366267651270L;

    private String id;
    private String name;
    private String typeId;
    private String userId;
    private String desc;
    private Timestamp createtime;

    public NotebookDAO() {
    }

    public NotebookDAO(String id, String name, String typeId, String userId, String desc, Timestamp createtime) {
        super();
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.userId = userId;
        this.desc = desc;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "NotebookDAO [id=" + id + ", name=" + name + ", typeId=" + typeId + ", userId=" + userId + ", desc="
            + desc + ", createtime=" + createtime + "]";
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
        NotebookDAO other = (NotebookDAO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}

package service.note.dataobject;

import java.io.Serializable;

import lombok.Data;

@Data
public class NoteDAO implements Serializable {
    private static final long serialVersionUID = -8176239102696538864L;

    private String id;
    private String notebookId;
    private String userId;
    private String statusId;
    private String typeId;
    private String title;
    private String body;
    private Long createTime;
    private Long lastModifyTime;

    public NoteDAO() {
    }

    public NoteDAO(String id, String notebookId, String userId, String statusId, String typeId, String title,
        String body, Long createTime, Long lastModifyTime) {
        super();
        this.id = id;
        this.notebookId = notebookId;
        this.userId = userId;
        this.statusId = statusId;
        this.typeId = typeId;
        this.title = title;
        this.body = body;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
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
        NoteDAO other = (NoteDAO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "NoteDAO [id=" + id + ", notebookId=" + notebookId + ", userId=" + userId + ", statusId=" + statusId
            + ", typeId=" + typeId + ", title=" + title + ", body=" + body + ", createTime=" + createTime
            + ", lastModifyTime=" + lastModifyTime + "]";
    }

}

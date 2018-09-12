package service.person.dataobject;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonDAO implements Serializable {
    private static final long serialVersionUID = -2365398342302306276L;

    private Integer id;

    private String name;

    public PersonDAO() {
    }

    public PersonDAO(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
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
        PersonDAO other = (PersonDAO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

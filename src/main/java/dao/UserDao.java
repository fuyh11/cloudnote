package dao;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDao implements Serializable{
	private static final long
		serialVersionUID = -288301177049569372L;

	private String id;
	private String name;
	private String password;
	private String token;
	private String nick;


	public UserDao() {
	}

	public UserDao(String id, String name, String password, String token, String nick) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.token = token;
		this.nick = nick;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", token=" + token + ", nick=" + nick
				+ "]";
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
		UserDao other = (UserDao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;


		return true;
	}

	 

	
}

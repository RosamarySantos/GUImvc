package modelo;

public class Usuario implements Comparable<Usuario> {
	
	private String login;
	private String password;
	private String code;
	private String gender;
	
	public Usuario(String login, String password, String code, String gender) {
		this.login = login;
		this.password = password;
		this.code = code;
		this.gender = gender;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", password=" + password + ", code=" + code + ", gender=" + gender + "]";
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return login.compareTo(o.login);
	}

	
	
	
}

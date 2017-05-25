package modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

	private static Connection conexion = Conexion.getInstance();
	
	@Override
	public List<Usuario> getListaUsuarios() {
		// select * from user order by login;
		List<Usuario> listaUsuarios = new ArrayList<>();
		String sql = "SELECT * FROM user ORDER BY login";
		try {
			Statement statement = conexion.createStatement();
			ResultSet resulset = statement.executeQuery(sql);
			while(resulset.next()){
				String login = resulset.getString("login");
				String password = resulset.getString("password");
				String code = resulset.getString("code");
				String gender = resulset.getString("gender");
				Usuario usuario = new Usuario(login, password, code, gender);
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println("Error en la lectura de la BD");
		}
		return listaUsuarios;
	}

	@Override
	public boolean existeUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		int resultado = 0;
		String sql = "INSERT INTO user VALUES (?,?,?,?);";
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			pStatement.setString(1, usuario.getLogin());
			pStatement.setString(2, usuario.getPassword());
			pStatement.setString(3, usuario.getCode());
			pStatement.setString(4, usuario.getGender());
			resultado = pStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error en la inserccion del usuario");
		}
		
		return resultado != 0;
	}

	@Override
	public Usuario getUsuario(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		UserDAO userDao =  new UserDAO();
		System.out.println(userDao.getListaUsuarios());
	}

}

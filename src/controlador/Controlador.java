package controlador;

import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.UserDAO;
import vista.Vista;
import modelo.Usuario;
public class Controlador implements ActionListener {
	
	private Vista vista;
	private UserDAO userDAO;
	private List<Usuario> listaUsuarios;
	private static int contador1 = 0;
	
	
	
	
	public Controlador(Vista vista, UserDAO userDAO) {
		this.vista = vista;
		this.userDAO = userDAO;
		actionListener(this);
		listaUsuarios = userDAO.getListaUsuarios();
		mostraUsuario(0);
	}



	//respuesta a los eventos de la vista
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(">")){
			deshabilitarTextField();
			contador1++;
			if (contador1 == listaUsuarios.size())
				contador1 = 0;
			mostraUsuario(contador1);
		}
		if (e.getActionCommand().equals("Insertar")){
			limpiarCampos();
			habilitarTextField();
			vista.getBtnGuardar().setEnabled(true);
			vista.getBtnInsertar().setEnabled(false);
		}
		if (e.getActionCommand().equals("Guardar")){
			Usuario usuario = recogerUsuario();
			listaUsuarios.add(usuario);
			Collections.sort(listaUsuarios);
			userDAO.addUsuario(usuario);
			vista.getBtnGuardar().setEnabled(false);
			vista.getBtnInsertar().setEnabled(true);
			deshabilitarTextField();
		}
		if (e.getActionCommand().equals("<<")){
			deshabilitarTextField();
			contador1 = contador1 - 25;
			if (contador1 < 0)
				contador1 = listaUsuarios.size() - 1;
			mostraUsuario(contador1);
		}
			

	}
	
	//registro los eventos de la vista
	public void actionListener(ActionListener escuchador){
		vista.getButtonAvance1().addActionListener(escuchador);
		vista.getBtnInsertar().addActionListener(escuchador);
		vista.getBtnGuardar().addActionListener(escuchador);
		vista.getButtonRetroceso25().addActionListener(escuchador);
	}
	
	private void mostraUsuario(int indice){
		vista.getTextFieldLogin().setText(
				listaUsuarios.get(indice).getLogin());
		vista.getTextFieldPassword().setText(
				listaUsuarios.get(indice).getPassword());
		vista.getTextFieldCode().setText(
				listaUsuarios.get(indice).getCode());
		vista.getTextFieldGender().setText(
				listaUsuarios.get(indice).getGender());
	}
	
	private void habilitarTextField(){
		vista.getTextFieldLogin().setEditable(true);
		vista.getTextFieldPassword().setEditable(true);
		vista.getTextFieldCode().setEditable(true);
		vista.getTextFieldGender().setEditable(true);
	}
	
	private void deshabilitarTextField(){
		vista.getTextFieldLogin().setEditable(false);
		vista.getTextFieldPassword().setEditable(false);
		vista.getTextFieldCode().setEditable(false);
		vista.getTextFieldGender().setEditable(false);
	}
	
	private void limpiarCampos(){
		vista.getTextFieldLogin().setText("");
		vista.getTextFieldPassword().setText("");
		vista.getTextFieldCode().setText("");
		vista.getTextFieldGender().setText("");
	}
	
	private Usuario recogerUsuario(){
		String login = vista.getTextFieldLogin().getText();
		String password = vista.getTextFieldPassword().getText();
		String code = vista.getTextFieldCode().getText();
		String gender = vista.getTextFieldGender().getText();
		Usuario usuario = new Usuario(login, password, code, gender);
		return usuario;
	}

}

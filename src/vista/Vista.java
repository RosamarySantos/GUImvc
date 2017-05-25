package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.UserDAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextField textFieldCode;
	private JTextField textFieldGender;
	private JButton buttonAvance1;
	private JButton buttonRetroceso1;
	private JButton buttonAvance25;
	private JButton buttonRetroceso25;
	private JButton btnGuardar;
	private JButton btnInsertar;

	
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}

	public JTextField getTextFieldCode() {
		return textFieldCode;
	}

	public JTextField getTextFieldGender() {
		return textFieldGender;
	}

	public JButton getButtonAvance1() {
		return buttonAvance1;
	}

	public JButton getButtonRetroceso1() {
		return buttonRetroceso1;
	}

	public JButton getButtonAvance25() {
		return buttonAvance25;
	}

	public JButton getButtonRetroceso25() {
		return buttonRetroceso25;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					UserDAO userDAO = new UserDAO();
					new Controlador(frame, userDAO);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLogin = new JLabel("Login");
		
		textFieldLogin = new JTextField();
		textFieldLogin.setEditable(false);
		textFieldLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		textFieldPassword = new JTextField();
		textFieldPassword.setEditable(false);
		textFieldPassword.setColumns(10);
		
		JLabel lblCode = new JLabel("Code");
		
		textFieldCode = new JTextField();
		textFieldCode.setEditable(false);
		textFieldCode.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		
		textFieldGender = new JTextField();
		textFieldGender.setEditable(false);
		textFieldGender.setColumns(10);
		
		buttonAvance1 = new JButton(">");
		/*buttonAvance1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		
		buttonAvance25 = new JButton(">>");
		
		buttonRetroceso1 = new JButton("<");
		
		buttonRetroceso25 = new JButton("<<");
		
		btnInsertar = new JButton("Insertar");
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblPassword))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(lblLogin))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGender)
								.addComponent(lblCode)
								.addComponent(buttonAvance1))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldGender)
								.addComponent(textFieldCode)
								.addComponent(textFieldPassword)
								.addComponent(textFieldLogin, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(buttonAvance25)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(buttonRetroceso25)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonRetroceso1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnInsertar)
						.addComponent(btnGuardar))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInsertar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnGuardar)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(lblCode))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(textFieldCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblGender)
						.addComponent(textFieldGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonAvance1)
						.addComponent(buttonAvance25)
						.addComponent(buttonRetroceso1)
						.addComponent(buttonRetroceso25))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.Objects;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
private JTextField nombreUsuario, focus;
private JToggleButton botonAccerder, botonRegistro,verPassword,registro;
private JPasswordField password;
private JLabel labeUsuario, labelpassword, aviso,error;
private JPanel panel1;
private static Login instance;
//setEchoChar('*');


private Login() {
	setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(255, 160, 122));

    error = new JLabel("Debe registrarse");
    error.setFont(new Font("Andale Mono", 1, 14));
    error.setForeground(new Color(255, 160, 122));
    error.setBounds(78, 145, 200, 100);
    add(error);
    
    /*labeUsuario = new JLabel("Nombre de usuario");
    labeUsuario.setBounds(80,40,150,20);
    add(labeUsuario);*/
    
    labelpassword = new JLabel("Contraseña");//("Contraseña");
    labelpassword.setBounds(100,120,150,20);
    add(labelpassword);
    
    /*aviso = new JLabel("Pase el cursor sobre la clave para ver");
    aviso.setBounds(25,200,300,20);
    add(aviso);*/
    focus = new JTextField();
    focus.setBounds(0,0,0,0);
    add(focus);
    
	nombreUsuario = new JTextField("Nombre");
	nombreUsuario.setBounds(80,70,130,20);
	nombreUsuario.setForeground(Color.gray);
	nombreUsuario.setFont(new Font("Courier New", 1, 14));
	nombreUsuario.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (nombreUsuario.getText().equals("Nombre")) {
	        	nombreUsuario.setText("");
	        	nombreUsuario.setForeground(Color.BLACK);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (nombreUsuario.getText().isEmpty()) {
	        	nombreUsuario.setForeground(Color.GRAY);
	        	nombreUsuario.setText("Nombre");
	        }
			
		}});
	add(nombreUsuario);
	
	
	
	aviso = new JLabel("¿Deseas registrarte?");
	aviso.setBounds(85,250,200,100 );
	add(aviso);
		 
	botonAccerder = new JToggleButton("Ingresar");
	botonAccerder.setBounds(95,220,100,40);
	botonAccerder.addActionListener(this);
	add(botonAccerder);
	
	
	password = new JPasswordField();
	password.setBounds(80,150,130,20);
	add(password);

	
	
	registro = new JToggleButton("Registrar");
	registro.setBounds(95,310,100,40);
	registro.addActionListener(this);
	//registro.setMargin(new Insets(3, 5, 3, 5));
	registro.setMargin(new Insets(1,1,1,1));
	registro.setBackground(Color.orange);
	add(registro);
	


	
}

public void actionPerformed(ActionEvent e)  {
	char[] arrayC = password.getPassword();
	String pass = new String(arrayC);
	String textoUsuario = nombreUsuario.getText().trim();
	String nombre = nombreUsuario.getText(), contraseña = password.getText();
	if(e.getSource() == botonAccerder) {
		if((textoUsuario.isEmpty()||(pass.isEmpty()))) {
		     JOptionPane.showMessageDialog(null,"Asegurese de llenar todos los campos","¡Por favor!", JOptionPane.INFORMATION_MESSAGE);
		}else {
	try {
	    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");
        Statement set = cn.createStatement();
		ResultSet resultado = set.executeQuery("select * from Registro where NombreUsuario like'"+nombreUsuario.getText().trim()+"'");		
		//para ejecutar lo que estmos mandando a la base de datos.
        if(resultado.next()) {
        	getToolkit().beep();
        	prueba principal =  prueba.getInstance();
        	principal.setBounds(0,0,750,700);
        	principal.setLocationRelativeTo(null);
        	principal.setVisible(true);
        	principal.setResizable(false);
        	this.setVisible(false);
        	//nombreUsuario.requestFocus();
        }else {
            error.setForeground(new Color(104, 255, 51));
        }
		
	      } catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"Error al buscar su info","INFO",JOptionPane.INFORMATION_MESSAGE);

			 }
		}
	}

	if(e.getSource() == registro) {
    	SingUp singup = SingUp.getInstance();
    	singup.setBounds(0,0,300,500);
    	singup.setLocationRelativeTo(null);
    	singup.setVisible(true);
    	singup.setResizable(false);
    	this.setVisible(false);
	}
		
	
}

public static Login getInstance() {
	if(Objects.isNull(instance)) {
		instance = new Login();
	}
	return instance;
}
}

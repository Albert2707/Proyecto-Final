import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SingUp extends JFrame implements ActionListener{
	private static SingUp instance;
private JLabel password, confirmPassword;
private JToggleButton registrarse,back;
private JTextField text_nombre, text_nombreUsurio, text_apellido, text_correo, text_telefono;
private JPasswordField text_password, text_confirmPassword;
private JToggleButton elpa;
private SingUp() {
	setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
	
	text_nombre = new JTextField("Nombre");
	text_nombre.setBounds(65,40,170,30);
	text_nombre.setForeground(Color.gray);
	text_nombre.setFont(new Font("Courier New", 1, 14));
	text_nombre.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (text_nombre.getText().equals("Nombre")) {
	        	text_nombre.setText("");
	        	text_nombre.setForeground(Color.BLACK);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (text_nombre.getText().isEmpty()) {
	        	text_nombre.setForeground(Color.GRAY);
	        	text_nombre.setText("Nombre");
	        }
			
		}});
	add(text_nombre);
	
	
	text_nombreUsurio = new JTextField("Usuario");
	text_nombreUsurio.setBounds(65,90,170,30);
	text_nombreUsurio.setForeground(Color.gray);
	text_nombreUsurio.setFont(new Font("Courier New", 1, 14));
	text_nombreUsurio.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (text_nombreUsurio.getText().equals("Usuario")) {
	        	text_nombreUsurio.setText("");
	        	text_nombreUsurio.setForeground(Color.BLACK);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (text_nombreUsurio.getText().isEmpty()) {
	        	text_nombreUsurio.setForeground(Color.GRAY);
	        	text_nombreUsurio.setText("Usuario");
	        }
			
		}});
	add(text_nombreUsurio);
	
	
	
	//////////////////////////////
	
	
	text_apellido = new JTextField("Apellido");
	text_apellido.setBounds(65,140,170,30);
	text_apellido.setForeground(Color.gray);
	text_apellido.setFont(new Font("Courier New", 1, 14));
	text_apellido.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (text_apellido.getText().equals("Apellido")) {
	        	text_apellido.setText("");
	        	text_apellido.setForeground(Color.BLACK);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (text_apellido.getText().isEmpty()) {
	        	text_apellido.setForeground(Color.GRAY);
	        	text_apellido.setText("Apellido");
	        }
			
		}});
	add(text_apellido);
	
	
	
	
	
	
	
	
	text_correo = new JTextField("Correo");
	text_correo.setBounds(65,190,170,30);
	text_correo.setForeground(Color.gray);
	text_correo.setFont(new Font("Courier New", 1, 14));
	text_correo.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (text_correo.getText().equals("Correo")) {
	        	text_correo.setText("");
	        	text_correo.setForeground(Color.BLACK);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (text_correo.getText().isEmpty()) {
	        	text_correo.setForeground(Color.GRAY);
	        	text_correo.setText("Correo");
	        }
			
		}});
	add(text_correo);	
	
	
	
	
	
	
	
	
	text_telefono = new JTextField("Telefono");
	text_telefono.setBounds(65,240,170,30);
	text_telefono.setForeground(Color.gray);
	text_telefono.setFont(new Font("Courier New", 1, 14));
	text_telefono.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (text_telefono.getText().equals("Telefono")) {
	        	text_telefono.setText("");
	        	text_telefono.setForeground(Color.BLACK);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (text_telefono.getText().isEmpty()) {
	        	text_telefono.setForeground(Color.GRAY);
	        	text_telefono.setText("Telefono");
	        }
			
		}});
	add(text_telefono);	
	
	
	
	
	
	
	password = new JLabel("Contraseña");
	password.setBounds(69,290,100,30);
    password.setForeground(Color.gray);
	password.setFont(new Font("Courier New", 1, 14));
    String pas  = password.getText();
	add(password);
	
	text_password = new JPasswordField();
	text_password.setBounds(65,290,170,30);
	text_password.setForeground(Color.gray);
	char[] arrayC =  text_password.getPassword();
	String pass = new String(arrayC);
	text_password.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	    	if(pas.equals("Contraseña"))
	         password.setText("");
	    	text_password.setForeground(Color.black);
	        
	    }

		@Override
		public void focusLost(FocusEvent e) {

	        if (pas.equals("")) {
	        		
	        	
	        	password.setForeground(Color.GRAY);
	        	password.setText("Contraseña");
	        	


	        }
			
		}});
	add(text_password);
	

	
	text_confirmPassword = new JPasswordField();
	text_confirmPassword.setBounds(65,340,170,30);
	add(text_confirmPassword);

	
	
	
	
	
	
	
	elpa = new JToggleButton("Sing Up");
	elpa.setBounds(100,400, 100,35);
 
	elpa.addActionListener(this);
	add(elpa);
	
	
	back = new JToggleButton("Regresar");
	back.setBounds(0,0, 75,35);
	back.addActionListener(this);
	add(back);
	
}

public void actionPerformed(ActionEvent e) {
	char[] arrayC =  text_password.getPassword();
	String pass = new String(arrayC);
	
	char[] arrayr =  text_confirmPassword.getPassword();
	String pass2 = new String(arrayr);
	
	String usuario1 =  text_nombreUsurio.getText().trim();
	String nombre1 = text_nombre.getText().trim();
	String apellido1 = text_apellido.getText().trim();
	String telefono1 = text_telefono.getText().trim();
	String correo1 = text_correo.getText().trim();
	if(e.getSource() == elpa) {
		if(usuario1.equals("")) {
			JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Nombre Usuario\"","INFO",JOptionPane.INFORMATION_MESSAGE);
		}else if(nombre1.equals("")) {
			JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Nombre\"","INFO",JOptionPane.INFORMATION_MESSAGE);
		}else if(apellido1.equals("")) {
			JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Apellido\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		}else if(telefono1.equals("")) {
			JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Telefono\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		}else if(pass.equals("")) {
			JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Contraseña\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		}else if(correo1.equals("")) {
			JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Correo\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		}else if(pass2.equals("")) {
			JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Confirmar contraseña\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		}else if((nombre1.equals(""))&&(apellido1.equals(""))&&(telefono1.equals(""))&&(pass.equals(""))&&(correo1.equals(""))&&(pass2.equals(""))) {
			JOptionPane.showMessageDialog(null,"¡Favor completar todos los campos!","INFO",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
		try {
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");
		PreparedStatement pst = cn.prepareStatement("insert into Registro values(?,?,?,?,?,?,?)");
		
		pst.setString(1,"0");
		pst.setString(2,text_nombreUsurio.getText().trim());
		pst.setString(3,text_nombre.getText().trim());
		pst.setString(4,text_apellido.getText().trim());
		pst.setString(5,text_telefono.getText().trim());
		pst.setString(6,pass.trim());
		pst.setString(7,text_correo.getText().trim());
		pst.executeUpdate();
		
		JOptionPane.showMessageDialog(null,"Registrado","INFO",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null,"Error al registrar","INFO",JOptionPane.INFORMATION_MESSAGE);
		}
		}
		
		
	}
	if(e.getSource() == back) {
		Login login =  Login.getInstance();
		login.setBounds(0,0,290,400);
		login.setVisible(true);
		login.setLocationRelativeTo(null);
		login.setResizable(false);
		this.setVisible(false);
	}
	}


public static SingUp getInstance() {
	if(Objects.isNull(instance)) {
		instance = new SingUp();
	}
	return instance;
}
}

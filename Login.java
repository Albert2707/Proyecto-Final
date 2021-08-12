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
private JToggleButton botonAccerder, botonRegistro,verPassword,registro,ver;
private JPasswordField password;
private JLabel labeUsuario, labelpassword, aviso,error;
private JPanel panel1;
private static Login instance;
//setEchoChar('*');


private Login() {
	setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(255, 160, 122));
    volver();

    error = new JLabel("Debe registrarse");
    error.setFont(new Font("Andale Mono", 1, 14));
    error.setForeground(new Color(255, 160, 122));
    error.setBounds(78, 145, 200, 100);
    add(error);
    
    /*labeUsuario = new JLabel("Nombre de usuario");
    labeUsuario.setBounds(80,40,150,20);
    add(labeUsuario);*/
    
    /*labelpassword = new JLabel("Contraseña");//("Contraseña");
    labelpassword.setBounds(100,120,150,20);
    add(labelpassword);*/
    
    /*aviso = new JLabel("Pase el cursor sobre la clave para ver");
    aviso.setBounds(25,200,300,20);
    add(aviso);*/

    
	
	aviso = new JLabel("¿Deseas registrarte?");
	aviso.setBounds(85,250,200,100 );
	add(aviso);
		 
	botonAccerder = new JToggleButton("Ingresar");
	botonAccerder.setBounds(95,220,100,40);
	botonAccerder.addActionListener(this);
	botonAccerder.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			botonAccerder.setSize(130,50);
			botonAccerder.setLocation(81,220);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			botonAccerder.setSize(100,40);
			botonAccerder.setLocation(95,220);
			
		}
		
	});
	add(botonAccerder);	
	
	
	
	
	
	
	
	
	
	
	
	
	registro = new JToggleButton("Registrar");
	registro.setBounds(95,310,100,40);
	registro.addActionListener(this);
	//registro.setMargin(new Insets(3, 5, 3, 5));
	registro.setMargin(new Insets(1,1,1,1));
	registro.setBackground(Color.orange);
	registro.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			registro.setSize(130,50);
			registro.setLocation(81,310);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			registro.setSize(100,40);
			registro.setLocation(95,310);
			
		}
		
	});
	add(registro);


	
}

public void actionPerformed(ActionEvent e)  {
	char[] arrayC = password.getPassword();
	String pass = new String(arrayC);
	String textoUsuario = nombreUsuario.getText().trim();
	String nombre = nombreUsuario.getText(), contraseña = password.getText();
	String password2 = String.valueOf(password.getPassword());
	if(e.getSource() == botonAccerder) {
		if((textoUsuario.equals("Nombre Usuario")||(password2.equals("Contraseña")))) {
		     JOptionPane.showMessageDialog(null,"Debe ingresar su usuario y contraseña, si no está registrado debe registrarse","¡Importante!", JOptionPane.INFORMATION_MESSAGE);
		}else {
	try {
	    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");
        Statement set = cn.createStatement();
		//ResultSet resultado = set.executeQuery("select * from Registro where NombreUsuario like'"+nombreUsuario.getText().trim()+"'");	
		ResultSet resultado = set.executeQuery("select NombreUsuario,Contraseña from Registro where NombreUsuario like'"+nombreUsuario.getText().trim()+"'and Contraseña like '"+pass.trim()+"'");		

		//para ejecutar lo que estmos mandando a la base de datos.
        if(resultado.next()) {
        	getToolkit().beep();
        	prueba principal =  prueba.getInstance();
        	principal.setBounds(0,0,750,700);
        	principal.setLocationRelativeTo(null);
        	principal.setVisible(true);
        	principal.setResizable(false);
        	limpiarCampos();
        	this.setVisible(false);
        	//nombreUsuario.requestFocus();
        }else {
            error.setForeground(new Color(104, 255, 51));
			JOptionPane.showMessageDialog(null,"Al parecer el \"Nombre de usuraio o la Contraseña no son correctos \"","INFO",JOptionPane.INFORMATION_MESSAGE);

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
    	limpiarCampos();
    	this.setVisible(false);
	}


}

public static Login getInstance() {
	if(Objects.isNull(instance)) {
		instance = new Login();
	}
	return instance;
}




public void volver() {
    focus = new JTextField();
    focus.setBounds(0,0,0,0);
    add(focus);
    
	nombreUsuario = new JTextField("Nombre Usuario");
	nombreUsuario.setBounds(80,70,130,20);
	nombreUsuario.setForeground(Color.gray);
	nombreUsuario.setFont(new Font("Courier New", 1, 14));
	nombreUsuario.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (nombreUsuario.getText().equals("Nombre Usuario")) {
	        	nombreUsuario.setText("");
	        	nombreUsuario.setForeground(Color.BLACK);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (nombreUsuario.getText().isEmpty()) {
	        	nombreUsuario.setForeground(Color.GRAY);
	        	nombreUsuario.setText("Nombre Usuario");
	        }
			
		}});
	add(nombreUsuario);

	
	
	password = new JPasswordField("Contraseña");
	password.setBounds(80,150,130,20);
	password.setForeground(Color.gray);
	password.setFont(new Font("Courier New", 1, 14));
	password.setEchoChar((char)0);
	password.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        String password2 = String.valueOf(password.getPassword());
	        if(password2.equals("Contraseña"))
	        {
	        	password.setText("");
	        	password.setEchoChar(('*'));
	        	password.setForeground(Color.black);
	        }
	        
	    }

		@Override
		public void focusLost(FocusEvent e) {

		    String password2 = String.valueOf(password.getPassword());
		    
		    
		   //if(password.toLowerCase().equals("Contraseña") || password.toLowerCase().equals("") )
		    if(password2.isEmpty())
		    {
		    	password.setForeground(Color.GRAY);
		    	password.setText("Contraseña");
		    	password.setEchoChar((char)0);
		    	password.setForeground(new Color(153, 153, 153));
		    }
	        
			
		}});
	add(password);
}




public void limpiarCampos() {
	nombreUsuario.setText("Nombre Usuario");
	nombreUsuario.setForeground(Color.gray);
	nombreUsuario.setFont(new Font("Courier New", 1, 14));
	nombreUsuario.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (nombreUsuario.getText().equals("Nombre Usuario")) {
	        	nombreUsuario.setText("");
	        	nombreUsuario.setForeground(Color.BLACK);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (nombreUsuario.getText().isEmpty()) {
	        	nombreUsuario.setForeground(Color.GRAY);
	        	nombreUsuario.setText("Nombre Usuario");
	        }
			
		}});
	
	
	
	
	
	
	password.setText("Contraseña");
	password.setForeground(Color.gray);
	password.setFont(new Font("Courier New", 1, 14));
	password.setEchoChar((char)0);
	password.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        String password2 = String.valueOf(password.getPassword());
	        if(password2.equals("Contraseña"))
	        {
	        	password.setText("");
	        	password.setEchoChar(('*'));
	        	password.setForeground(Color.black);
	        }
	        
	    }

		@Override
		public void focusLost(FocusEvent e) {

		    String password2 = String.valueOf(password.getPassword());
		    
		    
		   //if(password.toLowerCase().equals("Contraseña") || password.toLowerCase().equals("") )
		    if(password2.isEmpty())
		    {
		    	password.setForeground(Color.GRAY);
		    	password.setText("Contraseña");
		    	password.setEchoChar((char)0);
		    	password.setForeground(new Color(153, 153, 153));
		    }
	        
			
		}});
}
}

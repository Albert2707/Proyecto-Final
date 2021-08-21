//Albert Joan Agramonte Suero
//Matricula.2020-10652
//Patron de diseño singleton
//Polimorfismo en cada notacion @Override
//Herencia, encapsulamiento, abstracion.
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Desvanecimiento.Desvanecimiento;

import java.util.Objects;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements metodos{
private JTextField nombreUsuario, focus;
private JToggleButton botonAccerder,verPassword,registro,ver;
private JPasswordField password;
private JLabel labeUsuario, labelpassword, aviso,error, imagen, imagen2;
private JPanel panel1;
private static Login instance;
private JCheckBox verpassword;
private Desvanecimiento efecto;
Conector cn = new Conector();
Connection conectar = cn.conexion();
//setEchoChar('*');
private Login() {
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //setUndecorated(true);
   // getContentPane().setBackground(new Color(255, 160, 122));
    TextFields();
    Labels();
    Botones();
    getContentPane().setBackground(new Color(224, 255, 255));   
 
    
}



public static Login getInstance() {
    if(Objects.isNull(instance)) {
        instance = new Login();
    }
    return instance;
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



@Override
public void Botones() {
	  ImageIcon icono = new ImageIcon("src/imagenes/entrar (2) (1).png");
	    int  y =20;
	    int  x = -1;
	    ImageIcon iconoEscala2 = new ImageIcon(icono.getImage().getScaledInstance(x, y, java.awt.Image.SCALE_DEFAULT));
	    imagen2 = new JLabel(iconoEscala2);
	    imagen2.setBounds(95,266,20,50);
	    add(imagen2);
	    botonAccerder = new JToggleButton("Ingresar");
	    botonAccerder.setBounds(95,270,105,40);
	    botonAccerder.setForeground(new Color(255, 190, 51));
	    botonAccerder.setFont(new Font("Times New Roman", 1, 14));
	    botonAccerder.setHorizontalAlignment(SwingConstants.RIGHT) ;
	    botonAccerder.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
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

	                Statement set = conectar.createStatement();
	                //ResultSet resultado = set.executeQuery("select * from Registro where NombreUsuario like'"+nombreUsuario.getText().trim()+"'");    
	                ResultSet resultado = set.executeQuery("select UserName,Password from usuarios where UserName like'"+nombreUsuario.getText().trim()+"'and Password like '"+pass.trim()+"'");      

	                //para ejecutar lo que estmos mandando a la base de datos.
	                if(resultado.next()) {
	                    getToolkit().beep();
	                    
	                	Elegir ele = Elegir.getInstance();
	                	ele.setSize(500,300);
	                	ele.setLocationRelativeTo(null);
	                	ele.setVisible(true);
	                	ele.setResizable(false);
	                    limpiarCampos();
	                    setVisible(false);
	                    //efect.Ocultar(this, 10);
	                    error.setVisible(false);

	                    //nombreUsuario.requestFocus();
	                }else {
	                    error.setVisible(true);
	                    JOptionPane.showMessageDialog(null,"Al parecer el \"Nombre de usuraio o la Contraseña no son correctos \"","INFO",JOptionPane.INFORMATION_MESSAGE);

	                }
	                
	                  } catch (Exception e1) {
	                        JOptionPane.showMessageDialog(null,"Error al buscar su info","INFO",JOptionPane.INFORMATION_MESSAGE);

	                     }
	                }
	            }
	            
	        }
	        
	    });
	    botonAccerder.addMouseListener(new MouseAdapter() {


	        @Override
	        public void mouseEntered(MouseEvent e) {
	            // TODO Auto-generated method stub
	        	//95,270,100,40
	            botonAccerder.setSize(125,40);
	            botonAccerder.setLocation(95,270);
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            botonAccerder.setSize(100,40);
	            botonAccerder.setLocation(95,270);
	            
	        }

	        
	    });
	    add(botonAccerder); 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		  ImageIcon icono2 = new ImageIcon("src/imagenes/sitio-web (1).png");
		    int  y2 =20;
		    int  x2 = -1;
		    ImageIcon iconoEscala22 = new ImageIcon(icono2.getImage().getScaledInstance(x2, y2, java.awt.Image.SCALE_DEFAULT));
		   JLabel imagen3 = new JLabel(iconoEscala22);
		   imagen3.setBounds(100,356,20,50);
		    add(imagen3);
	    
		    
	    registro = new JToggleButton("Registrar");
	    registro.setHorizontalAlignment(SwingConstants.RIGHT);
	    registro.setBounds(95,360,105,40);
	    registro.setFont(new Font("Times New Roman", 1, 14));
	    registro.setForeground(new Color(255, 190, 51));


	    registro.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {

	            if(e.getSource() == registro) {
	                SingUp singup = SingUp.getInstance();
	                singup.setBounds(0,0,300,500);
	                singup.setLocationRelativeTo(null);
	                singup.setVisible(true);
	                singup.setResizable(false);
	                limpiarCampos();
	                setVisible(false);
                    error.setVisible(false);

	            }
	            
	        }
	        
	    });
	    //registro.setMargin(new Insets(3, 5, 3, 5));
	    registro.setMargin(new Insets(1,1,1,1));
	    registro.setBackground(Color.orange);
	    registro.addMouseListener(new MouseAdapter() {

	        @Override
	        public void mouseEntered(MouseEvent e) {
	        	registro.setBounds(95,360,125,40);
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	        	registro.setBounds(95,360,105,40);
	            
	        }
	        
	    });
	    add(registro);

	    verpassword = new JCheckBox();
	    verpassword.setBounds(200,185,150,50);
	    verpassword.setBackground(new Color(224, 255, 255));
	    
	    verpassword.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
			    if(verpassword.isSelected() == true){
			        password.setEchoChar((char)0); 

			     } else {
			    	    password.setEchoChar(('*')); 

			     }
			}
	    	
	    });
	    add(verpassword);
	    
	    	
}






@Override
public void TextFields() {
    focus = new JTextField();
    focus.setBounds(0,0,0,0);
    add(focus);
    
    nombreUsuario = new JTextField("Nombre Usuario");
    nombreUsuario.setBounds(80,120,130,20);
    nombreUsuario.setForeground(Color.gray);
    nombreUsuario.setFont(new Font("Times New Roman", 1, 14));
    nombreUsuario.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (nombreUsuario.getText().equals("Nombre Usuario")) {
                nombreUsuario.setText("");
                nombreUsuario.setForeground(Color.black);
                nombreUsuario.setFont(new Font("Times New Roman", 1, 14));

            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (nombreUsuario.getText().isEmpty()) {
                nombreUsuario.setForeground(Color.GRAY);
                nombreUsuario.setFont(new Font("Times New Roman", 1, 14));
                nombreUsuario.setText("Nombre Usuario");
            }
            
        }});
    add(nombreUsuario);

    
    
    password = new JPasswordField("Contraseña");
    password.setBounds(80,200,130,20);
    password.setForeground(Color.gray);
    password.setFont(new Font("Times New Roman", 1, 14));
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
                password.setFont(new Font("Times New Roman", 1, 14));

            }
            
        }

        @Override
        public void focusLost(FocusEvent e) {

            String password2 = String.valueOf(password.getPassword());
            
            
           //if(password.toLowerCase().equals("Contraseña") || password.toLowerCase().equals("") )
            if(password2.isEmpty())
            {
                password.setForeground(Color.GRAY);
                password.setFont(new Font("Times New Roman", 1, 14));
                password.setText("Contraseña");
                password.setEchoChar((char)0);
                password.setForeground(new Color(153, 153, 153));
            }
            
            
        }});
    add(password);	
}



@Override
public void Labels() {

    error = new JLabel("Debe registrarse");
    error.setFont(new Font("Times New Roman", 1, 14));
    error.setForeground(new Color(255,0,0));
    error.setVisible(false);
    error.setBounds(95, 195, 200, 100);
    add(error);
    
    
    aviso = new JLabel("¿Ya estas registrado?");
    aviso.setForeground(new Color(110, 44, 0));
    aviso.setFont(new Font("Times New Roman", 1, 14));

    aviso.setBounds(85,290,250,100 );
    add(aviso);	
    
   
    ImageIcon iconolbl = new ImageIcon("src/imagenes/grupo (2) (1).png");
    int  ancho1 =100;
    int  alto1 = -1;
    ImageIcon iconoEscala = new ImageIcon(iconolbl.getImage().getScaledInstance(ancho1, alto1, java.awt.Image.SCALE_DEFAULT));
    imagen = new JLabel(iconoEscala);
    imagen.setBounds(97,5,100,100);

    add(imagen);
}



@Override
public void mostrar() {
	// TODO Auto-generated method stub
	
}

}


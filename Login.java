
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.Objects;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements metodos{
private JTextField nombreUsuario, focus;
private JToggleButton botonAccerder, botonRegistro,verPassword,registro,ver;
private JPasswordField password;
private JLabel labeUsuario, labelpassword, aviso,error, imagen, imagen2;
private JPanel panel1;
private static Login instance;
private JCheckBox verpassword;
//setEchoChar('*');


private Login() {
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(255, 160, 122));
    TextFields();
    Labels();
    Botones();


    
 
    
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
	    botonAccerder.setBounds(95,270,100,40);
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
	                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");
	                Statement set = cn.createStatement();
	                //ResultSet resultado = set.executeQuery("select * from Registro where NombreUsuario like'"+nombreUsuario.getText().trim()+"'");    
	                ResultSet resultado = set.executeQuery("select NombreUsuario,Contraseña from Registro where NombreUsuario like'"+nombreUsuario.getText().trim()+"'and Contraseña like '"+pass.trim()+"'");      

	                //para ejecutar lo que estmos mandando a la base de datos.
	                if(resultado.next()) {
	                    getToolkit().beep();
	                    
	                    Principal principal =  Principal.getInstance();
	                    principal.setBounds(0,0,750,700);
	                    principal.setLocationRelativeTo(null);
	                    principal.setVisible(true);
	                    principal.setResizable(false);
	                    limpiarCampos();
	                    setVisible(false);
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
	            
	        }
	        
	    });
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
	        	//95,270,100,40
	            botonAccerder.setSize(120,40);
	            botonAccerder.setLocation(95,270);
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            botonAccerder.setSize(100,40);
	            botonAccerder.setLocation(95,270);
	            
	        }
	        
	    });
	    add(botonAccerder); 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    registro = new JToggleButton("Registrar");
	    registro.setBounds(95,360,100,40);
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
	            }
	            
	        }
	        
	    });
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
	        	//95,360,100,40
	        	//95,310,100,40
	            registro.setSize(130,50);
	            registro.setLocation(81,360);
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            registro.setSize(100,40);
	            registro.setLocation(95,360);
	            
	        }
	        
	    });
	    add(registro);

	    verpassword = new JCheckBox();
	    verpassword.setBounds(200,185,150,50);
	    verpassword.setBackground(Color.orange);
	    
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
public void mostrar() {
Principal mostrar = Principal.getInstance();
mostrar.mostrar();
}



@Override
public void TextFields() {
    focus = new JTextField();
    focus.setBounds(0,0,0,0);
    add(focus);
    
    nombreUsuario = new JTextField("Nombre Usuario");
    nombreUsuario.setBounds(80,120,130,20);
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
    password.setBounds(80,200,130,20);
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



@Override
public void Labels() {
    error = new JLabel("Debe registrarse");
    error.setFont(new Font("Andale Mono", 1, 14));
    error.setForeground(new Color(255, 160, 122));
    error.setBounds(78, 195, 200, 100);
    add(error);
    
    
    aviso = new JLabel("¿Deseas registrarte?");
    aviso.setBounds(85,290,200,100 );
    add(aviso);	
    
   
    ImageIcon iconolbl = new ImageIcon("src/imagenes/usuario (1).png");
    int  ancho1 =100;
    int  alto1 = -1;
    ImageIcon iconoEscala = new ImageIcon(iconolbl.getImage().getScaledInstance(ancho1, alto1, java.awt.Image.SCALE_DEFAULT));
    imagen = new JLabel(iconoEscala);
    imagen.setBounds(94,5,100,100);

    add(imagen);
}
}


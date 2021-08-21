//Albert Joan Agramonte Suero
//Matricula.2020-10652
//Patron de diseño singleton
//Polimorfismo en cada notacion @Override
//Herencia, encapsulamiento, abstracion.
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.Border;

import Desvanecimiento.Desvanecimiento;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SingUp extends JFrame implements metodos{
    private static SingUp instance;
private JLabel password, confirmPassword,imagen;
private JTextField text_nombre, text_nombreUsurio, text_apellido, text_correo, text_telefono;
private JPasswordField text_password, text_confirmPassword;
private JToggleButton elpa,back;
private Desvanecimiento efecto;
private SingUp() {
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    TextFields();
    Botones();
    setUndecorated(true);
    getContentPane().setBackground(new Color(174, 214, 241));
    efecto = new Desvanecimiento();
    efecto.Abrir(this, 20);


    
  
}
@Override
public void TextFields() {
    text_nombre = new JTextField("Nombre");
    text_nombre.setBounds(65,40,180,30);
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
    text_nombreUsurio.setBounds(65,90,180,30);
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
    text_apellido.setBounds(65,140,180,30);
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
    text_correo.setBounds(65,190,180,30);
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
    text_telefono.setBounds(65,240,180,30);
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
    

    
    text_password = new JPasswordField("Contraseña");
    text_password.setBounds(65,290,180,30);
    text_password.setForeground(Color.gray);
    text_password.setFont(new Font("Courier New", 1, 14));
    text_password.setEchoChar((char)0); 
    char[] arrayC =  text_password.getPassword(); 
    String pass = new String(arrayC);
    text_password.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            String password = String.valueOf(text_password.getPassword());
            if(password.equals("Contraseña"))
            {
                text_password.setText("");
                text_password.setEchoChar(('*'));
                text_password.setForeground(Color.black);
            }
            
        }

        @Override
        public void focusLost(FocusEvent e) {

            String password = String.valueOf(text_password.getPassword());
            
            
           //if(password.toLowerCase().equals("Contraseña") || password.toLowerCase().equals("") )
            if(password.isEmpty())
            {
                text_password.setForeground(Color.GRAY);
                text_password.setText("Contraseña");
                text_password.setEchoChar((char)0);
                text_password.setForeground(new Color(153, 153, 153));
            }
            
            
        }});
    add(text_password);
    

    
    
    
    
    
    
    text_confirmPassword = new JPasswordField("Confirmar Contraseña");
    text_confirmPassword.setBounds(65,340,180,30);
    text_confirmPassword.setForeground(Color.gray);
    text_confirmPassword.setFont(new Font("Courier New", 1, 14));
    text_confirmPassword.setEchoChar((char)0);
    text_confirmPassword.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            String password = String.valueOf(text_confirmPassword.getPassword());
            if(password.equals("Confirmar Contraseña"))
            {
                text_confirmPassword.setText("");
                text_confirmPassword.setEchoChar(('*'));
                text_confirmPassword.setForeground(Color.black);
            }
            
        }

        @Override
        public void focusLost(FocusEvent e) {

            String password = String.valueOf(text_confirmPassword.getPassword());
            
            
           //if(password.toLowerCase().equals("Contraseña") || password.toLowerCase().equals("") )
            if(password.isEmpty())
            {
                text_confirmPassword.setForeground(Color.GRAY);
                text_confirmPassword.setText("Confirmar Contraseña");
                text_confirmPassword.setEchoChar((char)0);
                text_confirmPassword.setForeground(new Color(153, 153, 153));
            }
            
            
        }});
    add(text_confirmPassword);

    
}

public static SingUp getInstance() {
    if(Objects.isNull(instance)) {
        instance = new SingUp();
    }
    return instance;
}

public void limpiarCampos() {
	
	text_nombre.setText("Nombre");
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
    
    
    text_nombreUsurio.setText("Usuario");
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
    
    
    
    //////////////////////////////
    
    
    text_apellido.setText("Apellido");
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
    
    
    
    
    
    
    
    
    text_correo.setText("Correo");
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
    
    
    
    
    
    
    
    
    text_telefono.setText("Telefono");
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
    
    
    text_password.setText("Contraseña");
    text_password.setForeground(Color.gray);
    text_password.setFont(new Font("Courier New", 1, 14));
    text_password.setEchoChar((char)0); 
    char[] arrayC =  text_password.getPassword(); 
    String pass = new String(arrayC);
    text_password.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            String password = String.valueOf(text_password.getPassword());
            if(password.equals("Contraseña"))
            {
                text_password.setText("");
                text_password.setEchoChar(('*'));
                text_password.setForeground(Color.black);
            }
            
        }

        @Override
        public void focusLost(FocusEvent e) {

            String password = String.valueOf(text_password.getPassword());
            
            
           //if(password.toLowerCase().equals("Contraseña") || password.toLowerCase().equals("") )
            if(password.isEmpty())
            {
                text_password.setForeground(Color.GRAY);
                text_password.setText("Contraseña");
                text_password.setEchoChar((char)0);
                text_password.setForeground(new Color(153, 153, 153));
            }
            
            
        }});
    

    
    
    
    
    
    
    text_confirmPassword.setText("Confirmar Contraseña");
    text_confirmPassword.setBounds(65,340,180,30);
    text_confirmPassword.setForeground(Color.gray);
    text_confirmPassword.setFont(new Font("Courier New", 1, 14));
    text_confirmPassword.setEchoChar((char)0);
    text_confirmPassword.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            String password = String.valueOf(text_confirmPassword.getPassword());
            if(password.equals("Confirmar Contraseña"))
            {
                text_confirmPassword.setText("");
                text_confirmPassword.setEchoChar(('*'));
                text_confirmPassword.setForeground(Color.black);
            }
            
        }

        @Override
        public void focusLost(FocusEvent e) {

            String password = String.valueOf(text_confirmPassword.getPassword());
            
            
           //if(password.toLowerCase().equals("Contraseña") || password.toLowerCase().equals("") )
            if(password.isEmpty())
            {
                text_confirmPassword.setForeground(Color.GRAY);
                text_confirmPassword.setText("Confirmar Contraseña");
                text_confirmPassword.setEchoChar((char)0);
                text_confirmPassword.setForeground(new Color(153, 153, 153));
            }
            
            
        }});

    
}

@Override
public void Botones() {
	  
    ImageIcon iconolbl = new ImageIcon("src/imagenes/registro (1).png");
    int  ancho1 =30;
    int  alto1 = -1;
    ImageIcon iconoEscala = new ImageIcon(iconolbl.getImage().getScaledInstance(ancho1, alto1, java.awt.Image.SCALE_DEFAULT));
    imagen = new JLabel(iconoEscala);
    imagen.setSize(30,50);
    imagen.setLocation(90,400);
    add(imagen);
    elpa = new JToggleButton("Registrarme");
    elpa.setHorizontalAlignment(SwingConstants.RIGHT) ;
    elpa.setBounds(83,400, 140,50);
 
    elpa.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    
		    String password = String.valueOf(text_password.getPassword());
		    String pass2 = String.valueOf(text_confirmPassword.getPassword());


		    String usuario1 =  text_nombreUsurio.getText().trim();
		    String nombre1 = text_nombre.getText().trim();
		    String apellido1 = text_apellido.getText().trim();
		    String telefono1 = text_telefono.getText().trim();
		    String correo1 = text_correo.getText().trim();


		    
		    if(e.getSource() == elpa) {
		        if(nombre1.equals("Nombre")) {
		            JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Nombre\"","INFO",JOptionPane.INFORMATION_MESSAGE);
		        }else if(usuario1.equals("Usuario")) {
		            JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Usuario\"","INFO",JOptionPane.INFORMATION_MESSAGE);
		        }else if(apellido1.equals("Apellido")) {
		            JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Apellido\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		        }else if(telefono1.equals("Telefono")) {
		            JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Telefono\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		        }else if(password.equals("Contraseña")) {
		            JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Contraseña\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		        }else if(correo1.equals("Correo")) {
		            JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Correo\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		        }else if(pass2.equals("Confirmar Contraseña")) {
		            JOptionPane.showMessageDialog(null,"Favor llenar el campo de \"Confirmar contraseña\"","INFO",JOptionPane.INFORMATION_MESSAGE);

		        }else if((nombre1.equals("Nombre"))&&(apellido1.equals("Apellido"))&&(telefono1.equals("Telefono"))&&(password.equals("Contraseña"))&&(correo1.equals("Correo"))&&(pass2.equals("Confirmar Contraseña"))) {
		            JOptionPane.showMessageDialog(null,"¡Favor completar todos los campos!","INFO",JOptionPane.INFORMATION_MESSAGE);
		        }
		                
		        else {

		            if((password.equals(pass2))) {
		            
		        try {
	               Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacenitlafinal?useSSL=false","root","albert2707");
		        PreparedStatement pst = cn.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?)");
		        
		        pst.setString(1,"0");
		        pst.setString(2,text_nombreUsurio.getText().trim());
		        pst.setString(3,text_nombre.getText().trim());
		        pst.setString(4,text_apellido.getText().trim());
		        pst.setString(5,text_telefono.getText().trim());
		        pst.setString(6,text_correo.getText().trim());
		        pst.setString(7,password.trim());
		        pst.executeUpdate();
		        limpiarCampos();
		        
		        JOptionPane.showMessageDialog(null,"Registrado","INFO",JOptionPane.INFORMATION_MESSAGE);
		        }catch(Exception e1) {
		            JOptionPane.showMessageDialog(null,"Error al registrar","INFO",JOptionPane.INFORMATION_MESSAGE);
		        }
		            
		        }
		            else{
		                JOptionPane.showMessageDialog(null,"Al parecer las Contraseñas no coinciden ","INFO",JOptionPane.INFORMATION_MESSAGE);

		            }
		        }
		    } 
		    	
		}
    	
    });
    elpa.addMouseListener(new MouseListener() {

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
            elpa.setSize(160,50);
            elpa.setLocation(83,400);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            elpa.setSize(140,50);
            elpa.setLocation(83,400);
            
        }
        
    });
    add(elpa);
    
    
    
    
    back = new JToggleButton("Back");
    back.setBounds(0,0, 80,35);
    back.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			limpiarCampos();
	        Login login =  Login.getInstance();
	        login.setBounds(0,0,290,450);
	        login.setVisible(true);
	        login.setLocationRelativeTo(null);
	        login.setResizable(false);
	        setVisible(false);			
		}
    	
    });
    back.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
        	
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
            back.setSize(90,40);
            back.setLocation(0,0);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            back.setSize(80,35);
            back.setLocation(0,0);
            
        }
        
    });
    add(back);
    
	
}

public void oculta(ActionEvent e) {
	efecto.Ocultar(this, 20);
}

@Override
public void Labels() {
	// TODO Auto-generated method stub
	
}
@Override
public void mostrar() {
	// TODO Auto-generated method stub
	
}




}


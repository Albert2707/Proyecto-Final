//Albert Joan Agramonte Suero
//Matricula.2020-10652
//Patron de diseño singleton
//Polimorfismo en cada notacion @Override
//Herencia, encapsulamiento, abstracion.

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Desvanecimiento.Desvanecimiento;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public class Principal extends JFrame implements metodos{
    private static Principal instance;
    private JTextField txtnombre,txt_buscar, txtnombreUsuario, txtapellido, txttelefono, txtcorreo, txtpassword, txtID;
    private JTable tabla;
    private String user_update;
    private JLabel nombre, lID,nombreUsuario, apellido, telefono, correo, password, aviso,actua;
    private JToggleButton botonModificar, botonEliminar, BotonCerrar, actualizar, botonAtras;
    private int ID;
    private Desvanecimiento efecto;
    Conector cn = new Conector();
    Connection conectar = cn.conexion();
    
    private Principal() {
    setTitle("DATOS");
      setLayout(null);
      setUndecorated(true);
efecto = new Desvanecimiento();
efecto.Abrir(this, 20);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      Botones();
      TextFields();
      Labels();
     getContentPane().setBackground(new Color(155, 211, 167));
      
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		scrollPane.setBounds(0,0,750,200);
		add(scrollPane);
		
		tabla = new JTable();
		
		tabla.setOpaque(true);
		tabla.setFillsViewportHeight(true);
		tabla.setBackground(new Color(251, 238, 230));
		tabla.setFont(new Font("HOLLYWOOD STARFIRE", Font.BOLD, 12));
		tabla.setBackground(new Color(195, 155, 211));
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    int fila = tabla.rowAtPoint(e.getPoint());
			    

			    if(fila >-1) {
				
		        txtID.setText(tabla.getValueAt(fila,0).toString());
		        txtnombreUsuario.setText(tabla.getValueAt(fila,1).toString());
		         txtnombre.setText(tabla.getValueAt(fila,2).toString());
		          txtapellido.setText(tabla.getValueAt(fila,3).toString());
		           txttelefono.setText(tabla.getValueAt(fila,4).toString());
		           txtpassword.setText(tabla.getValueAt(fila,6).toString());
		           txtcorreo.setText(tabla.getValueAt(fila,5).toString());
			    }
				
			}		
		});
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane.setViewportView(tabla);
      
      

}


public void Botones() {
	ImageIcon volver = new ImageIcon("src/imagenes/hacia-atras (1)e.png");
    ImageIcon volver2 = new ImageIcon(volver.getImage().getScaledInstance(100, -1, java.awt.Image.SCALE_DEFAULT));

	botonAtras = new JToggleButton(volver);
	botonAtras.setBounds(100,600,100,50);
	botonAtras.setBorderPainted(false);
	botonAtras.setContentAreaFilled(false);
	botonAtras.setFocusPainted(false);
	botonAtras.setOpaque(false);
	botonAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== botonAtras);{
				Elegir ele = Elegir.getInstance();
				ele.setSize(500,300);
				ele.setLocationRelativeTo(null);
				ele.setVisible(true);
				ele.setResizable(false);
				setVisible(false);
			}
		}
	});
	add(botonAtras);
	
	ImageIcon actu = new ImageIcon("src/imagenes/atras-en-el-tiempo (1).png");
    ImageIcon iconoEscala3 = new ImageIcon(actu.getImage().getScaledInstance(60, -1, java.awt.Image.SCALE_DEFAULT));

	actua = new JLabel(iconoEscala3);
	actua.setBounds(475,320,100,100);
	add(actua);
	actualizar = new JToggleButton("RETORNAR");
	actualizar.setHorizontalAlignment(SwingConstants.RIGHT);
	actualizar.setForeground(new Color(255, 150, 51));
	actualizar.setFont(new Font("Times New Roman", 1, 14));
	actualizar.setBounds(490,320,170,100);
	actualizar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
        	Elegir ele = Elegir.getInstance();
        	ele.setSize(500,300);
        	ele.setLocationRelativeTo(null);
        	ele.setVisible(true);
        	ele.setResizable(false);
        	limpiarCampos();
            setVisible(false);
		}
		
	});
	actualizar.addMouseListener(new MouseAdapter() {



		@Override
		public void mouseEntered(MouseEvent e) {
actualizar.setBounds(490,320,190,100);			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			actualizar.setBounds(490,320,170,100);
			
		}
		
	});
	add(actualizar);
	
	
	
	ImageIcon salir = new ImageIcon("src/imagenes/puerta-de-salida (1).png");
    ImageIcon iconoEscala4 = new ImageIcon(salir.getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_DEFAULT));
JLabel exit =new JLabel(iconoEscala4);
exit.setBounds(490,520,70,100);
add(exit);
    BotonCerrar = new JToggleButton("SIGN OUT");
    BotonCerrar.setBounds(490,520,170,100);
    BotonCerrar.setForeground(new Color(255, 51, 51 ));
    BotonCerrar.setHorizontalAlignment(SwingConstants.RIGHT);

    BotonCerrar.setFont(new Font("Times New Roman", 1, 14));
    BotonCerrar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

	        Login login =  Login.getInstance();
	        login.setBounds(0,0,290,450);
	        login.setVisible(true);
	        login.setLocationRelativeTo(null);
	        login.setResizable(false);
	        setVisible(false);
		}
    	
    });
    BotonCerrar.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

            BotonCerrar.setBounds(490,520,190,100);

        }

        @Override
        public void mouseExited(MouseEvent e) {
        	 BotonCerrar.setBounds(490,520,170,100);
            
        }
        
    });
    add(BotonCerrar);
    
    ImageIcon iconolbl = new ImageIcon("src/imagenes/editar (2).png");
    int  ancho1 =50;
    int  alto1 = -1;
    ImageIcon iconoEscala = new ImageIcon(iconolbl.getImage().getScaledInstance(ancho1, alto1, java.awt.Image.SCALE_DEFAULT));
    JLabel imagen3 = new JLabel(iconoEscala);
    imagen3.setBounds(480,220,100,100);
    add(imagen3);
    botonModificar = new JToggleButton("MODIFICAR");
    botonModificar.setHorizontalAlignment(SwingConstants.RIGHT);
    botonModificar.setBounds(490,220,170,100);
    botonModificar.setForeground(new Color(255, 150, 51));
    botonModificar.setFont(new Font("Times New Roman", 1, 14));
    botonModificar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

		    

	        try {

	            String ID = txtID.getText().trim();

	            PreparedStatement pasar=conectar.prepareStatement("Update usuarios set UserName=?, Nombre=?,Apellido=?,Telefono=?,Password=?,Email=? where idUser= " + ID);
	            pasar.setString(1, txtnombreUsuario.getText().trim());
	            pasar.setString(2, txtnombre.getText().trim());
	            pasar.setString(3, txtapellido.getText().trim());
	            pasar.setString(4, txttelefono.getText().trim());
	            pasar.setString(5, txtpassword.getText().trim());
	            pasar.setString(6, txtcorreo.getText().trim());

	            pasar.executeUpdate();

	            mostrar();
	            limpiarCampos();



	        

	            
	        } catch (SQLException ex) {
	            


	        }
		}
    	
    });
    botonModificar.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
            //TODO Auto-generated method stub
            botonModificar.setBounds(490,220,190,100);

        }

        @Override
        public void mouseExited(MouseEvent e) {
            botonModificar.setBounds(490,220,170,100);
            
        }
        
    });
    add(botonModificar);    
    
    
    ImageIcon iconol = new ImageIcon("src/imagenes/borrar-usuario (1).png");
   int  ancho =50;
   int  alto = -1;
    ImageIcon iconoEscala1 = new ImageIcon(iconol.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
    JLabel imagen2 = new JLabel(iconoEscala1);
    imagen2.setBounds(480,420,100,100);
    add(imagen2);
    botonEliminar = new JToggleButton("ELIMINAR");
    botonEliminar.setHorizontalAlignment(SwingConstants.RIGHT) ;
    botonEliminar.setBounds(490,420,170,100);
    botonEliminar.setForeground(new Color(255, 51, 51 ));
    botonEliminar.setFont(new Font("Times New Roman", 1, 14));
    botonEliminar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			    String ID = txtID.getText().trim();


			    PreparedStatement pasar=conectar.prepareStatement(" delete from usuarios where idUser= " + ID);
			        pasar.executeUpdate();
			        mostrar();   		   
			        limpiarCampos();

			   
			       

			} catch (Exception e2) {
			    // TODO: handle exception
			}
			    			// TODO Auto-generated method stub
			
		}
    	
    });
    botonEliminar.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            botonEliminar.setBounds(490,420,190,100);

        }

        @Override
        public void mouseExited(MouseEvent e) {
            botonEliminar.setBounds(490,420,170,100);

            
        }
        
    });
    add(botonEliminar); 
    
  
    
    
}



public void mostrar(){
	String [] columnas = {"ID","NombreUsuario","Nombre","Apellido","Telefono","Email","Password"};
    String fila[]=new String[7];
	DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
         }
    };
try {
   Statement set = conectar.createStatement(); 
    ResultSet r=set.executeQuery("SELECT * FROM usuarios");

    while(r.next()){
    fila[0]=r.getString(1);
    fila[1]=r.getString(2);
    fila[2]=r.getString(3);
    fila[3]=r.getString(4);
    fila[4]=r.getString(5);
    fila[5]=r.getString(6);
    fila[6]=r.getString(7);

    modelo.addRow(fila);
    }
tabla.setModel(modelo);
}

catch(SQLException e) {
    JOptionPane.showMessageDialog(null,"Error al mostrar los datos","INFO",JOptionPane.INFORMATION_MESSAGE);
}
    }
    


public void TextFields() {

    txtnombre = new JTextField();
    txtnombre.setBounds(150,320,200,30);
    txtnombre.setForeground(Color.gray);
    txtnombre.setFont(new Font("Courier New", 1, 14));
add(txtnombre);
    
txtID = new JTextField();
txtID.setEditable(false);
txtID.setBounds(150,220,200,30);
txtID.setForeground(Color.gray);
txtID.setFont(new Font("Courier New", 1, 14));
add(txtID);




 txtnombreUsuario = new JTextField();
 txtnombreUsuario.setBounds(150,270,200,30);
 txtnombreUsuario.setForeground(Color.gray);
 txtnombreUsuario.setFont(new Font("Courier New", 1, 14));
add(txtnombreUsuario);
 
 
 
 
txtapellido = new JTextField();
txtapellido.setBounds(150,370,200,30);
txtapellido.setForeground(Color.gray);
txtapellido.setFont(new Font("Courier New", 1, 14));
add(txtapellido);





txttelefono = new JTextField();
txttelefono.setBounds(150,420,200,30);
txttelefono.setForeground(Color.gray);
txttelefono.setFont(new Font("Courier New", 1, 14));
add(txttelefono);


txtcorreo = new JTextField();
txtcorreo.setBounds(150,520,200,30);
txtcorreo.setForeground(Color.gray);
txtcorreo.setFont(new Font("Courier New", 1, 14));
add(txtcorreo);

txtpassword = new JTextField();
txtpassword.setBounds(150,470,200,30);
txtpassword.setForeground(Color.gray);
add(txtpassword);
}

public static Principal getInstance() {
    if(Objects.isNull(instance)) {
        instance = new Principal();
    }
    return instance;
}


public void Labels() {

    
	lID = new JLabel("ID(non-editable)");
	lID.setBounds(20, 183, 180,100);
	lID.setForeground(Color.black);
	lID.setFont(new Font("Courier New", 1, 14));
	add(lID);
    
    nombreUsuario = new JLabel("Nombre Usuario");
    nombreUsuario.setBounds(30,233,150,100);
    nombreUsuario.setForeground(Color.black);
    nombreUsuario.setFont(new Font("Courier New", 1, 14));
    add(nombreUsuario);
    
    nombre = new JLabel("Nombre");
    nombre.setBounds(88,283,100,100);
    nombre.setForeground(Color.black);
    nombre.setFont(new Font("Courier New", 1, 14));
    add(nombre);
    
    apellido = new JLabel("Apellido");
    apellido.setBounds(80,333,100,100);
    apellido.setForeground(Color.black);
    apellido.setFont(new Font("Courier New", 1, 14));
    add(apellido);
    
    telefono = new JLabel("Telefono");
    telefono.setBounds(80, 383, 100,100);
    telefono.setForeground(Color.black);
    telefono.setFont(new Font("Courier New", 1, 14));
    add(telefono);
    
	password = new JLabel("Contraseña");
	password.setBounds(63,433,100,100);
	password.setForeground(Color.black);
	password.setFont(new Font("Courier New", 1, 14));
    add(password);
    
    correo = new JLabel("Correo");
    correo.setBounds(85,483,100,100);
    correo.setForeground(Color.black);
    correo.setFont(new Font("Courier New", 1, 14));
    add(correo);
    
}
public void limpiarCampos() {
    

   
txtID.setText(null);
   txtnombreUsuario.setText(null);
   txtnombre.setText(null);
   txtapellido.setText(null);
   txttelefono.setText(null);
   txtpassword.setText(null);
   txtcorreo.setText(null);
   

}

}







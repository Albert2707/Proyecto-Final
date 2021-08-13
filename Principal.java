


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public class Principal extends JFrame implements metodos{
    private static Principal instance;

    private JScrollPane scroll;
    private JTextField txtnombre,txt_buscar, txtnombreUsuario, txtapellido, txttelefono, txtcorreo, txtpassword, txtID;
    private JTable tabla;
    private String user_update;
    private JLabel nombre, lID,nombreUsuario, apellido, telefono, correo, password, aviso;
    private JToggleButton botonModificar, botonEliminar, BotonCerrar;
    
    private Principal() {
    setTitle("DATOS");
      setLayout(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      Botones();
      mostrar();
      TextFields();
      Labels();


}

public void Botones() {
    BotonCerrar = new JToggleButton("Cerrar sesion");
    BotonCerrar.setBounds(0,0,750,20);
    BotonCerrar.setForeground(new Color(255, 51, 51 ));
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
    BotonCerrar.addMouseListener(new MouseListener() {

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
            BotonCerrar.setSize(750,35);
            BotonCerrar.setLocation(0,0);
            BotonCerrar.setForeground(new Color(255, 51, 51 ));
            BotonCerrar.setFont(new Font("Times New Roman", 1, 14));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            BotonCerrar.setSize(750,20);
            BotonCerrar.setLocation(0,0);
            
        }
        
    });
    add(BotonCerrar);
    
    ImageIcon iconolbl = new ImageIcon("src/imagenes/editar (2).png");
    int  ancho1 =70;
    int  alto1 = -1;
    ImageIcon iconoEscala = new ImageIcon(iconolbl.getImage().getScaledInstance(ancho1, alto1, java.awt.Image.SCALE_DEFAULT));
    JLabel imagen3 = new JLabel(iconoEscala);
    imagen3.setBounds(480,300,100,100);
    add(imagen3);
    botonModificar = new JToggleButton("MODIFICAR");
    botonModificar.setHorizontalAlignment(SwingConstants.RIGHT);
    botonModificar.setBounds(490,300,170,100);
    botonModificar.setForeground(new Color(255, 150, 51));
    botonModificar.setFont(new Font("Times New Roman", 1, 14));
    botonModificar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

		    

	        try {
	            String ID = txtID.getText().trim();
	            Connection  conectar = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");

	            PreparedStatement pasar=conectar.prepareStatement("Update Registro set NombreUsuario=?, Nombre=?,Apellido=?,Telefono=?,Contraseña=?,Correo=? where ID= " + ID);
	            pasar.setString(1, txtnombreUsuario.getText().trim());
	            pasar.setString(2, txtnombre.getText().trim());
	            pasar.setString(3, txtapellido.getText().trim());
	            pasar.setString(4, txttelefono.getText().trim());
	            pasar.setString(5, txtpassword.getText().trim());
	            pasar.setString(6, txtcorreo.getText().trim());

	            pasar.executeUpdate();
	            limpiarCampos();
	            mostrar();



	        

	            
	        } catch (SQLException ex) {
	            


	        }
		}
    	
    });
    botonModificar.addMouseListener(new MouseListener() {

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
            //TODO Auto-generated method stub
           botonModificar.setSize(190,100);
           botonModificar.setLocation(490,300);

        }

        @Override
        public void mouseExited(MouseEvent e) {
          botonModificar.setSize(170,100);
           botonModificar.setLocation(490,300);
            
        }
        
    });
    add(botonModificar);    
    
    
    ImageIcon iconol = new ImageIcon("src/imagenes/eliminar (1).png");
   int  ancho =70;
   int  alto = -1;
    ImageIcon iconoEscala1 = new ImageIcon(iconol.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
    JLabel imagen2 = new JLabel(iconoEscala1);
    imagen2.setBounds(480,500,100,100);
    add(imagen2);
    botonEliminar = new JToggleButton("ELIMINAR");
    botonEliminar.setHorizontalAlignment(SwingConstants.RIGHT) ;
    botonEliminar.setBounds(490,500,170,100);
    botonEliminar.setForeground(new Color(255, 51, 51 ));
    botonEliminar.setFont(new Font("Times New Roman", 1, 14));
    botonEliminar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			    String ID = txtID.getText().trim();
			    Connection  conectar = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");

			    PreparedStatement pasar=conectar.prepareStatement(" delete from Registro where ID= " + ID);
			        pasar.executeUpdate();
			        mostrar();   
			        limpiarCampos();

			   
			       

			} catch (Exception e2) {
			    // TODO: handle exception
			}
			    			// TODO Auto-generated method stub
			
		}
    	
    });
    botonEliminar.addMouseListener(new MouseListener() {

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
           botonEliminar.setSize(190,100);
           botonEliminar.setLocation(490,500);

        }

        @Override
        public void mouseExited(MouseEvent e) {
           botonEliminar.setSize(170,100);
            botonEliminar.setLocation(490,500);
            
        }
        
    });
    add(botonEliminar); 
    
  
    
    
}


private JTable getJTable() {
    String[] colName = { "Name", "Email", "Contact No. 1", "Contact No. 2",
            "Group", "" };
    if (tabla == null) {
        tabla = new JTable() {
            public boolean isCellEditable(int nRow, int nCol) {
                return false;
            }
        };
    }
    DefaultTableModel contactTableModel = (DefaultTableModel) tabla
            .getModel();
    contactTableModel.setColumnIdentifiers(colName);
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    return tabla;
}


public void mostrar(){
try {


   Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");

    
  /*DefaultTableModel modelo = new DefaultTableModel() {
       public boolean isCellEditable(int row, int column) {
           //all cells false
           return false;
        }
   };*/
   
   DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

    
    tabla = new JTable();
    tabla.setGridColor(Color.MAGENTA);
    scroll = new JScrollPane(tabla);
    scroll.setBounds(0,30,750,200);
    add(scroll);
    
    modelo.addColumn("ID");
    modelo.addColumn("NombreUsuario");
    modelo.addColumn("Nombre");
    modelo.addColumn("Apellido");
    modelo.addColumn("Telefono");
    modelo.addColumn("Contraseña");
    modelo.addColumn("Correo");
    tabla.setModel(modelo);
    Statement  set = cn.createStatement();
    ResultSet resultado = set.executeQuery("select * from Registro");


while(resultado.next()) {
    Object [] fila = new Object[7];
    for(int i = 0;i<7;i++) {
        fila[i] = resultado.getObject( i + 1);
    }
    modelo.addRow(fila);
    
}
//modelo.setRowCount(0);
JTable.setModel(modelo);

modelo.fireTableDataChanged();
//tabla.repaint();
cn.close();

}


catch(SQLException e) {
    JOptionPane.showMessageDialog(null,"Error al mostrar los datos","INFO",JOptionPane.INFORMATION_MESSAGE);
}
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
           txtpassword.setText(tabla.getValueAt(fila,5).toString());
           txtcorreo.setText(tabla.getValueAt(fila,6).toString());
    }
    }
});
}



public void TextFields() {

    txtnombre = new JTextField();
    txtnombre.setBounds(150,350,200,30);
    txtnombre.setForeground(Color.gray);
    txtnombre.setFont(new Font("Courier New", 1, 14));
add(txtnombre);
    
txtID = new JTextField();
txtID.setEditable(false);
txtID.setBounds(150,250,200,30);
txtID.setForeground(Color.gray);
txtID.setFont(new Font("Courier New", 1, 14));
add(txtID);




 txtnombreUsuario = new JTextField();
 txtnombreUsuario.setBounds(150,300,200,30);
 txtnombreUsuario.setForeground(Color.gray);
 txtnombreUsuario.setFont(new Font("Courier New", 1, 14));
add(txtnombreUsuario);
 
 
 
 
txtapellido = new JTextField();
txtapellido.setBounds(150,400,200,30);
txtapellido.setForeground(Color.gray);
txtapellido.setFont(new Font("Courier New", 1, 14));
add(txtapellido);





txttelefono = new JTextField();
txttelefono.setBounds(150,450,200,30);
txttelefono.setForeground(Color.gray);
txttelefono.setFont(new Font("Courier New", 1, 14));
add(txttelefono);


txtcorreo = new JTextField();
txtcorreo.setBounds(150,550,200,30);
txtcorreo.setForeground(Color.gray);
txtcorreo.setFont(new Font("Courier New", 1, 14));
add(txtcorreo);

txtpassword = new JTextField();
txtpassword.setBounds(150,500,200,30);
txtpassword.setForeground(Color.gray);
add(txtpassword);
}

public static Principal getInstance() {
    if(Objects.isNull(instance)) {
        instance = new Principal();
    }
    return instance;
}
public static void main(String[] args) {
    Principal principal =  Principal.getInstance();
    principal.setBounds(0,0,750,700);
    principal.setLocationRelativeTo(null);
    principal.setVisible(true);
    principal.setResizable(false);
}
public void Labels() {

    aviso = new JLabel();
    aviso.setBounds(580,620,300,30);
    aviso.setFont(new Font("Comic Sans MS", 1, 32));
    aviso.setForeground(new Color(51, 147, 255 ));

    add(aviso);
    
	lID = new JLabel("ID(no editable)");
	lID.setBounds(50, 213, 100,100);
	add(lID);
    
    nombreUsuario = new JLabel("Nombre Usuario");
    nombreUsuario.setBounds(40,263,150,100);
    add(nombreUsuario);
    
    nombre = new JLabel("Nombre");
    nombre.setBounds(90,313,100,100);
    add(nombre);
    
    apellido = new JLabel("Apellido");
    apellido.setBounds(90,363,100,100);
    add(apellido);
    
    telefono = new JLabel("Telefono");
    telefono.setBounds(90, 413, 100,100);
    add(telefono);
    
	password = new JLabel("Contraseña");
	password.setBounds(73,463,100,100);
    add(password);
    
    correo = new JLabel("Correo");
    correo.setBounds(95,513,100,100);
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







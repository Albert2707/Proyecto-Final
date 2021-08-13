



import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public class Main extends JFrame implements MouseListener{
    private static Principal instance;

    private JScrollPane scroll;
    private JTextField txtnombre,txt_buscar, txtnombreUsuario, txtapellido, txttelefono, txtcorreo, txtpassword, txtID;
    private JTable tabla;
    private String user_update;
    private JLabel nombre, lID,nombreUsuario, apellido, telefono, correo, password, aviso;
    private JToggleButton botonModificar, botonEliminar, BotonCerrar;
    
    private Main() {
    setTitle("DATOS");
      setLayout(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      Botones();
      mostrar("");
      TextFields();
      Labels();


}
protected void Botones() {
	
	BotonCerrar = new JToggleButton();
	BotonCerrar.setBounds(490,250,170,100);
	BotonCerrar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mostrar("");
		}
		
	});
	add(BotonCerrar);
	

    botonModificar = new JToggleButton("MODIFICAR");
    botonModificar.setHorizontalAlignment(SwingConstants.RIGHT);
    botonModificar.setBounds(490,300,170,100);
    botonModificar.setForeground(new Color(255, 150, 51));
    botonModificar.setFont(new Font("Times New Roman", 1, 14));
    botonModificar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			modificar();			
		}
    	
    });
    add(botonModificar);    
    

    botonEliminar = new JToggleButton("ELIMINAR");
    botonEliminar.setHorizontalAlignment(SwingConstants.RIGHT) ;
    botonEliminar.setBounds(490,500,170,100);
    botonEliminar.setForeground(new Color(255, 51, 51 ));
    botonEliminar.setFont(new Font("Times New Roman", 1, 14));
    botonEliminar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			eliminar();
		}
    	
    });
    add(botonEliminar); 
    
    
    
}
public void modificar() {

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
            mostrar("");
            limpiarCampos();
            
        } catch (SQLException ex) {
            


        }
}
public void eliminar() {
    

try {

	String ID = txtID.getText().trim();
	Connection  conectar = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");

    PreparedStatement pasar=conectar.prepareStatement("	delete from Registro where ID= " + ID);
        pasar.executeUpdate();
        mostrar("");
        limpiarCampos();

} catch (Exception e2) {
    // TODO: handle exception
}
}
    
    



protected void mostrar(String Nombre) {
    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
         }
    };

    
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
try {


   Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");

    

   PreparedStatement set = cn.prepareStatement("select * from Registro"); 
    ResultSet r=set.executeQuery();
    String fila[]=new String[7];
    while(r.next()){
    fila[0]=r.getString("ID");
    fila[1]=r.getString("NombreUsuario");
    fila[2]=r.getString("Nombre");
    fila[3]=r.getString("Apellido");
    fila[4]=r.getString("Telefono");
    fila[5]=r.getString("Contraseña");
    fila[6]=r.getString("Correo");

    modelo.addRow(fila);
    }
tabla.setModel(modelo);
cn.close();
}



catch(SQLException e) {
    JOptionPane.showMessageDialog(null,"Error al mostrar los datos","INFO",JOptionPane.INFORMATION_MESSAGE);
}
/*tabla.addMouseListener(new MouseAdapter() {
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
});*/
}

public void mouseClicked(MouseEvent e) {
   
    int fila = tabla.rowAtPoint(e.getPoint());
    
    if(fila >-1) {
    	mostrar("");
        txtID.setText(tabla.getValueAt(fila,0).toString());
        txtnombreUsuario.setText(tabla.getValueAt(fila,1).toString());
         txtnombre.setText(tabla.getValueAt(fila,2).toString());
          txtapellido.setText(tabla.getValueAt(fila,3).toString());
           txttelefono.setText(tabla.getValueAt(fila,4).toString());
           txtpassword.setText(tabla.getValueAt(fila,5).toString());
           txtcorreo.setText(tabla.getValueAt(fila,6).toString());
    }

    
}

public void TextFields() {

    txtnombre = new JTextField();
    txtnombre.setBounds(150,350,200,30);
    txtnombre.setForeground(Color.gray);
    txtnombre.setFont(new Font("Courier New", 1, 14));



    
    


    
    
txtID = new JTextField();
//txtID.setEditable(false);
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






txttelefono = new JTextField();
txttelefono.setBounds(150,450,200,30);
txttelefono.setForeground(Color.gray);
txttelefono.setFont(new Font("Courier New", 1, 14));



txtcorreo = new JTextField();
txtcorreo.setBounds(150,550,200,30);
txtcorreo.setForeground(Color.gray);
txtcorreo.setFont(new Font("Courier New", 1, 14));


txtpassword = new JTextField();
txtpassword.setBounds(150,500,200,30);
txtpassword.setForeground(Color.gray);

}

public static void main(String[] args) {
    Main principal = new Main();
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
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

}








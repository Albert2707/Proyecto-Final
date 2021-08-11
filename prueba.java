import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
public class prueba extends JFrame implements ActionListener{
	private static prueba instance;
	private JScrollPane scroll;
	private JTextField txtnombre,txt_buscar, txtnombreUsuario, txtapellido, txttelefono, txtcorreo, txtpassword;
	private JTable tabla;
	private String user_update;
	private JLabel nombre, nombreUsuario, apellido, telefono, correo, password;
	private JToggleButton botonModificar, botonEliminar, BotonCerrar;
	
	private prueba() {
	setTitle("DATOS");
	  setLayout(null);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
      Botones();
	  mostrar();
	  TextFields();


}
protected void Botones() {
	BotonCerrar = new JToggleButton("Cerrar sesion");
	BotonCerrar.setBounds(0,0,750,20);
	BotonCerrar.setForeground(new Color(255, 51, 51 ));
	BotonCerrar.setFont(new Font("Times New Roman", 1, 14));
	BotonCerrar.addActionListener(this);
	add(BotonCerrar);
}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==BotonCerrar) {
		Login login =  Login.getInstance();
		login.setBounds(0,0,290,400);
		login.setVisible(true);
		login.setLocationRelativeTo(null);
		login.setResizable(false);
		this.setVisible(false);
	}
	}

protected void mostrar() {
try {


   Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");
    PreparedStatement  set = cn.prepareStatement("select * from Registro");
	ResultSet resultado = set.executeQuery();
	
    DefaultTableModel modelo = new DefaultTableModel();

    
    tabla = new JTable(modelo);
    tabla.setGridColor(Color.black);
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

while(resultado.next()) {
	Object [] fila = new Object[6];
	for(int i = 0;i<6;i++) {
		fila[i] = resultado.getObject( i + 1);
	}
	modelo.addRow(fila);
}
cn.close();

}


catch(SQLException e) {
	JOptionPane.showMessageDialog(null,"Error al mostrar los datos","INFO",JOptionPane.INFORMATION_MESSAGE);
}
tabla.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
	int fila = tabla.rowAtPoint(e.getPoint());
	int columna = 2;
	if(fila >-1) {
		modificar();
	}
	}
});
}
protected void modificar() {
    int fila=tabla.getSelectedRow();
    if(fila>=0){
        txtnombre.setText(tabla.getValueAt(fila,0).toString());
         txtnombreUsuario.setText(tabla.getValueAt(fila,1).toString());
          txtapellido.setText(tabla.getValueAt(fila,2).toString());
           txttelefono.setText(tabla.getValueAt(fila,3).toString());
            txtcorreo.setText(tabla.getValueAt(fila,4).toString());
            txtpassword.setText(tabla.getValueAt(fila,4).toString());
    }else {
    	 JOptionPane.showMessageDialog(null,"Seleccione fila");
    }
}




/*public void ModificarDatos() {
    try {
        PreparedStatement pasar=conectar.prepareStatement("Update usuarios set Nombre='"+txtNombre.getText()+"',Dirección='"+txtDireccion.getText()+"',Telefono='"+txtTelefono.getText()
                +"',Email='"+txtEmail.getText()+"' where Identidad='"+txtIdentidad.getText()+"'");
        pasar.executeUpdate();
        Mostrar("");
        
    } catch (SQLException ex) {
        Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
    }
}*/




protected void TextFields() {
	txtnombre = new JTextField("Nombre");
	txtnombre.setBounds(30,300,100,30);
	txtnombre.setForeground(Color.gray);
	txtnombre.setFont(new Font("Courier New", 1, 14));
	txtnombre.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (txtnombre.getText().equals("Nombre")) {
	        	txtnombre.setText("");
	        	txtnombre.setForeground(Color.BLACK);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (txtnombre.getText().isEmpty()) {
	        	txtnombre.setForeground(Color.GRAY);
	        	txtnombre.setText("Nombre");
	        }
			
		}});
	add(txtnombre);


	
	
	txt_buscar =  new JTextField("Buscar Datos");
	txt_buscar.setBounds(30,500,200,30);
	txt_buscar.setForeground(Color.gray);
	txt_buscar.setFont(new Font("Courier New", 1, 14));
	txt_buscar.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (txt_buscar.getText().equals("Buscar Datos")) {
	        	txt_buscar.setText("");
	        	txt_buscar.setForeground(Color.gray);
	        }
	    }

		@Override
		public void focusLost(FocusEvent e) {
	        if (txt_buscar.getText().isEmpty()) {
	        	txt_buscar.setForeground(Color.GRAY);
	        	txt_buscar.setText("Buscar Datos");
	        }
			
		}});
	add(txt_buscar);
	
	// txtnombreUsuario txtapellido txttelefono txtcorreo txtpassword;
}

public static prueba getInstance() {
	if(Objects.isNull(instance)) {
		instance = new prueba();
	}
	return instance;
}
}




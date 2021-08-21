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
//Albert Joan Agramonte Suero
//Matricula.2020-10652
//Patron de diseño singleton
//Polimorfismo en cada notacion @Override
//Herencia, encapsulamiento, abstracion.
public class almacen  extends JFrame implements metodos{
	private JTable tabla;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private static almacen instance;
	private JButton botonNuevo, botonAtras;
	private JLabel imagenAtras;
	private Desvanecimiento efecto;
	private almacen(){
		setLayout(null);
	    setUndecorated(true);

	      setDefaultCloseOperation(EXIT_ON_CLOSE);
		Botones();
	     getContentPane().setBackground(new Color(215, 189, 226));
	     efecto = new Desvanecimiento();
	     efecto.Abrir(this, 20);
		
		
		
		
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
		tabla.setBackground(new Color(234, 250, 241));
		tabla.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    int fila = tabla.rowAtPoint(e.getPoint());
			    modificarProducto ventana = modificarProducto.getInstance();
			    ventana.setSize(350,500);
			    ventana.setVisible(true);
			    ventana.setLocationRelativeTo(null);
			    ventana.setResizable(false);
			    if(fila >-1) {
				
			        tabla.setModel(modelo);
			        modelo.fireTableDataChanged();
			        ventana.idUser.setText(tabla.getValueAt(fila,0).toString());
			        ventana.Nombre.setText(tabla.getValueAt(fila,1).toString());
			        ventana.marca.setText(tabla.getValueAt(fila,2).toString());
			        ventana.categoria.setText(tabla.getValueAt(fila,3).toString());
			         ventana.precio.setText(tabla.getValueAt(fila,4).toString());
			         ventana. cantidadDisponible.setText(tabla.getValueAt(fila,5).toString());
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
	
	public static almacen getInstance() {
	   if(Objects.isNull(instance)) {
	        instance = new almacen();
	    }
		return instance;
		
	}
	
	public void mostrar(){
	     modelo = new DefaultTableModel() {
	        public boolean isCellEditable(int row, int column) {
	            //all cells false
	            return false;
	         }
	    };

	    modelo.addColumn("idProducto");
	    modelo.addColumn("NombreProducto");
	    modelo.addColumn("Marca");
	    modelo.addColumn("Categoria");
	    modelo.addColumn("Precio");
	    modelo.addColumn("Stock");
	try {


    	Class.forName("com.mysql.jdbc.Driver");
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacenitlafinal?useSSL=false","root","albert2707");
	    

	   PreparedStatement set = cn.prepareStatement("select * from productos"); 
	    ResultSet r=set.executeQuery();
	    String fila[]=new String[6];
	    while(r.next()){
	    fila[0]=r.getString(1);
	    fila[1]=r.getString(2);
	    fila[2]=r.getString(3);
	    fila[3]=r.getString(4);
	    fila[4]=r.getString(5);
	    fila[5]=r.getString(6);


	    modelo.addRow(fila);
	    }
	tabla.setModel(modelo);
	}

	catch(SQLException e) {
	    JOptionPane.showMessageDialog(null,"Error al mostrar los datos","INFO",JOptionPane.INFORMATION_MESSAGE);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	}
	
	
	
	public void Botones() {
		ImageIcon nuevo = new ImageIcon("src/imagenes/anadir-producto (1).png");
	    ImageIcon iconoEscala2 = new ImageIcon(nuevo.getImage().getScaledInstance(80, -1, java.awt.Image.SCALE_DEFAULT));

		JLabel agregar = new JLabel(iconoEscala2);
		agregar.setBounds(88,248,100,100);
		
		botonNuevo = new JButton("NUEVO");
		botonNuevo.setBackground(new Color(253, 237, 236));
		botonNuevo.setOpaque(false);
		botonNuevo.setBorderPainted(false);
		botonNuevo.setHorizontalAlignment(SwingConstants.RIGHT) ;
		botonNuevo.setBounds(100,250,140,90);
		add(agregar);

		botonNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
             if(e.getSource() == botonNuevo) {	

            	 almacen Almacen = null;
            	 AgregarProducto nuevoProducto= AgregarProducto.getInstance(Almacen, true);
            	 nuevoProducto.setSize(280,500);
            	 nuevoProducto.setLocationRelativeTo(null);
            	 nuevoProducto.setVisible(true);
            	 nuevoProducto.setResizable(false);
             }
			}
			
		});
		botonNuevo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				agregar.setBounds(88,248,120,100);
				botonNuevo.setBounds(100,250,160,90);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				agregar.setBounds(88,248,100,100);
				botonNuevo.setBounds(100,250,140,90);

				
			}
			
		});
			
		
		add(botonNuevo);

		
		ImageIcon atras = new ImageIcon("src/imagenes/atras.png");
	    ImageIcon Atras = new ImageIcon(atras.getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_DEFAULT));

	    imagenAtras = new JLabel(Atras);
	    imagenAtras.setBounds(410,245,100,100);
	    add(imagenAtras);
	    botonAtras = new JButton("ATRAS");
	   // botonAtras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	    botonAtras.setBackground(new Color(253, 237, 236));
		botonAtras.setOpaque(false);
		botonAtras.setBorderPainted(false);
		botonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botonAtras) {
					Elegir elegir = Elegir.getInstance();
					elegir.setSize(500,300);
					elegir.setLocationRelativeTo(null);
					elegir.setVisible(true);
					elegir.setResizable(false);
					setVisible(false);
				}
			}
			
		});
		botonAtras.setBounds(470,250,110,90);
		botonAtras.addMouseListener(new MouseAdapter() {


			@Override
			public void mouseEntered(MouseEvent e) {
				 imagenAtras.setBounds(410,245,120,100);
				botonAtras.setBounds(470,250,130,90);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonAtras.setBounds(470,250,100,90);
				 imagenAtras.setBounds(410,245,110,100);

				
			}
			
		});
		add(botonAtras);
	}

	@Override
	public void TextFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Labels() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpiarCampos() {
		// TODO Auto-generated method stub
		
	}


}

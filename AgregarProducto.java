//Albert Joan agramonte Suero
//Patron singleton
import javax.swing.*;
import Desvanecimiento.Desvanecimiento;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;
//patron singleton 
//herencia y abstraccion
//Polimorfismo en cada anotacion @Override
public class AgregarProducto extends JDialog implements metodos {
private JTextField Nombre, marca, categoria, precio, cantidadDisponible;
private JToggleButton botonAtras, botonGuardar;
private Desvanecimiento efecto;
private static AgregarProducto instance;
	private  AgregarProducto(almacen ventana, boolean b) {
		super(ventana,b);
		setResizable(false);
		TextFields();
		Botones();
	    setUndecorated(true);
		setLayout(null);
		getContentPane().setBackground(new Color(249, 235, 234));
	}

	public void TextFields(){
		Nombre = new JTextField("Nombre");
		Nombre.setBounds(50,50 ,180, 30);
		Nombre.setForeground(Color.gray);
		Nombre.setFont(new Font("Times New Roman", 1, 14));
		Nombre.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (Nombre.getText().equals("Nombre")) {
	            	Nombre.setText("");
	            	Nombre.setForeground(Color.BLACK);
	        		Nombre.setFont(new Font("Times New Roman", 1, 14));

	            }
	        }

	        @Override
	        public void focusLost(FocusEvent e) {
	            if (Nombre.getText().isEmpty()) {
	            	Nombre.setForeground(Color.GRAY);
	        		Nombre.setFont(new Font("Times New Roman", 1, 14));
	            	Nombre.setText("Nombre");
	            }
	            
	        }});
		add(Nombre);
		
		
		
		
		marca = new JTextField("Marca");
		marca.setBounds(50,100,180,30);
		marca.setForeground(Color.gray);
		marca.setFont(new Font("Times New Roman", 1, 14));
		
		marca.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (marca.getText().equals("Marca")) {
	            	marca.setText("");
	            	marca.setForeground(Color.BLACK);
	        		marca.setFont(new Font("Times New Roman", 1, 14));

	            }
	        }

	        @Override
	        public void focusLost(FocusEvent e) {
	            if (marca.getText().isEmpty()) {
	            	marca.setForeground(Color.GRAY);
	        		marca.setFont(new Font("Times New Roman", 1, 14));
	            	marca.setText("Marca");
	            }
	            
	        }});
		add(marca);
		
		
		
		categoria = new JTextField("Categoria");
		categoria.setBounds(50,150,180,30);
		categoria.setForeground(Color.gray);
		categoria.setFont(new Font("Times New Roman", 1, 14));
		categoria.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (categoria.getText().equals("Categoria")) {
	            	categoria.setText("");
	            	categoria.setForeground(Color.BLACK);
	        		categoria.setFont(new Font("Times New Roman", 1, 14));

	            }
	        }

	        @Override
	        public void focusLost(FocusEvent e) {
	            if (categoria.getText().isEmpty()) {
	            	categoria.setForeground(Color.GRAY);
	        		categoria.setFont(new Font("Times New Roman", 1, 14));

	            	categoria.setText("Categoria");
	            }
	            
	        }});
		add(categoria);
		
		precio = new JTextField("Precio");
		precio.setBounds(50,200,180,30);
		precio.setForeground(Color.gray);
		precio.setFont(new Font("Times New Roman", 1, 14));
		precio.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (precio.getText().equals("Precio")) {
	            	precio.setText("");
	            	precio.setForeground(Color.BLACK);
	        		precio.setFont(new Font("Times New Roman", 1, 14));

	            }
	        }

	        @Override
	        public void focusLost(FocusEvent e) {
	            if (precio.getText().isEmpty()) {
	            	precio.setForeground(Color.GRAY);
	        		precio.setFont(new Font("Times New Roman", 1, 14));

	            	precio.setText("Precio");
	            }
	            
	        }});
		add(precio);
		
		cantidadDisponible = new JTextField("Cantidad Disponible");
		cantidadDisponible.setBounds(50,250,180,30);
		cantidadDisponible.setForeground(Color.gray);
		cantidadDisponible.setFont(new Font("Times New Roman", 1, 14));
		cantidadDisponible.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (cantidadDisponible.getText().equals("Cantidad Disponible")) {
	            	cantidadDisponible.setText("");
	            	cantidadDisponible.setForeground(Color.BLACK);
	        		cantidadDisponible.setFont(new Font("Times New Roman", 1, 14));

	            }
	        }

	        @Override
	        public void focusLost(FocusEvent e) {
	            if (cantidadDisponible.getText().isEmpty()) {
	            	cantidadDisponible.setForeground(Color.GRAY);
	        		cantidadDisponible.setFont(new Font("Times New Roman", 1, 14));

	            	cantidadDisponible.setText("Cantidad Disponible");
	            }
	            
	        }});
		add(cantidadDisponible);
		
	}
	
	public static AgregarProducto getInstance(almacen ventana, boolean b) {
		   if(Objects.isNull(instance)) {
		        instance = new AgregarProducto(ventana, b);
		    }
		return instance;
		
	}
	
	public void Botones() {
		botonAtras =  new JToggleButton("Atras");
		botonAtras.setFont(new Font("Times New Roman", 1, 14));
botonAtras.setForeground(new Color(255,0,0));
		botonAtras.setBounds(0,0,100,30);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			setVisible(false);
			limpiarCampos();
			}
		});
		add(botonAtras);
		
		
		
		ImageIcon guardar = new ImageIcon("src/imagenes/disquete (1).png");
	    ImageIcon iconoEscala = new ImageIcon(guardar.getImage().getScaledInstance(30, -1, java.awt.Image.SCALE_DEFAULT));
JLabel imagenGuardar = new JLabel(iconoEscala);
imagenGuardar.setBounds(75,350,30,50);
	   add(imagenGuardar);
	   
		botonGuardar = new JToggleButton("GUARDAR");
		botonGuardar.setHorizontalAlignment(SwingConstants.RIGHT);
		botonGuardar.setForeground(new Color(51, 255, 233));
		botonGuardar.setBounds(70,350,130,50);
		botonGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				if((Nombre.getText().equals("Nombre"))&&(marca.getText().equals("Marca"))&&(categoria.getText().equals("Categoria"))&&(precio.getText().equals("Precio"))&&(cantidadDisponible.getText().equals("Cantidad Disponible"))) {
					
				
				    JOptionPane.showMessageDialog(null,"Algo ha salido mal, al parcer no haz llenado ninguno de los campos","INFO",JOptionPane.INFORMATION_MESSAGE);
		
				}
				
				else if(Nombre.getText().equals("Nombre")) {
				    JOptionPane.showMessageDialog(null,"Favor llene el campo \"Nombre\"","INFO",JOptionPane.INFORMATION_MESSAGE);

				}
				else if (marca.getText().equals("Marca")) {
				    JOptionPane.showMessageDialog(null,"Favor llene el campo \"Marca\"","INFO",JOptionPane.INFORMATION_MESSAGE);

				}
				else if (categoria.getText().equals("Categoria")) {
				    JOptionPane.showMessageDialog(null,"Favor llene el campo \"Categoria\"","INFO",JOptionPane.INFORMATION_MESSAGE);

				}
				else if (precio.getText().equals("Precio")) {
				    JOptionPane.showMessageDialog(null,"Favor llene el campo \"Precio\"","INFO",JOptionPane.INFORMATION_MESSAGE);

				}
				else if (cantidadDisponible.getText().equals("Cantidad Disponible")) {
				    JOptionPane.showMessageDialog(null,"Favor llene el campo \"Cantidad Disponible\"","INFO",JOptionPane.INFORMATION_MESSAGE);

				}else {
					
		            
		        try {

		        Class.forName("com.mysql.jdbc.Driver");
		        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacenitlafinal?useSSL=false","root","albert2707");
		        PreparedStatement pst = cn.prepareStatement("insert into productos values(?,?,?,?,?,?)");
		        
		        pst.setString(1,"0");
		        pst.setString(2,Nombre.getText().trim());
		        pst.setString(3,marca.getText().trim());
		        pst.setString(4,categoria.getText().trim());
		        pst.setString(5,precio.getText().trim());
		        pst.setString(6,cantidadDisponible.getText().trim());
		        pst.executeUpdate();
		        almacen mostrarDatos = almacen.getInstance();
		        mostrarDatos.mostrar();
		        limpiarCampos();
		        setVisible(false);

		        
		        JOptionPane.showMessageDialog(null,"Guardado","INFO",JOptionPane.INFORMATION_MESSAGE);
		        }catch(Exception e1) {
		            JOptionPane.showMessageDialog(null,"Error al registrar","INFO",JOptionPane.INFORMATION_MESSAGE);
		        }				}
				
			
			
		}});
		botonGuardar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				botonGuardar.setBounds(70,350,150,50);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonGuardar.setBounds(70,350,130,50);

				
			}
		});
		add(botonGuardar);
		
	}
	public void efectos(JFrame ventana) {
		efecto.Abrir(ventana, 20);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Labels() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpiarCampos() {
		Nombre.setText("Nombre"); 
		marca.setText("Marca");
		categoria.setText("Categoria");
		precio.setText("Precio");
		cantidadDisponible.setText("Cantidad Disponible");		
	}
	
}

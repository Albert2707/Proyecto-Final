import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;
import javax.swing.*;
import Desvanecimiento.Desvanecimiento;
//Albert Joan Agramonte Suero. 2020-10652
// Patron singleton
// Herencia y abstraccion
// encapsulamiento
// polimorfismo en cada anotacion @Override
public class modificarProducto extends JFrame implements metodos{
 private static modificarProducto instance;
private JLabel nombre, lmarca, lcategoria, id, lprecio, cantidad; 
private JButton botonAtras, eliminar, modificar;
public JTextField Nombre, marca, categoria,precio,idUser ,cantidadDisponible;
private Desvanecimiento efecto;
private modificarProducto() {
	setLayout(null);
	setResizable(false);
    setUndecorated(true);
    Botones();
    TextFields();
    Labels();
    getContentPane().setBackground(new Color(246, 221, 204));
    efecto = new Desvanecimiento();
    efecto.Abrir(this, 20);

}

public static modificarProducto getInstance() {
    if(Objects.isNull(instance)) {
        instance = new modificarProducto();
    }
    return instance;
}
public void Botones() {
	String text;
	botonAtras = new JButton("Atras");
	botonAtras.setBounds(0,0, 150, 30);
	botonAtras.setForeground(new Color(255,0,0));
	botonAtras.setFont(new Font("Times New Roman",1,14));
	botonAtras.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    almacen Almacen =   almacen.getInstance();
		    Almacen.setBounds(0,0,750,400);
		    Almacen.setLocationRelativeTo(null);
		    Almacen.setVisible(true);
		    Almacen.setResizable(false);
		    Almacen.mostrar();
		    limpiarCampos();
		    setVisible(false);			
		}
	});
	add(botonAtras);
    ImageIcon iconolbl = new ImageIcon("src/imagenes/editar (1).png");
    int  ancho1 =30;
    int  alto1 = -1;
    ImageIcon iconoEscala = new ImageIcon(iconolbl.getImage().getScaledInstance(ancho1, alto1, java.awt.Image.SCALE_DEFAULT));
	
	JLabel modify = new JLabel(iconoEscala);
	modify.setBounds(50, 400, 30, 50);
	add(modify);
	modificar=new JButton("Modificar");
	modificar.setBounds(40,400,130,50);
    modificar.setHorizontalAlignment(SwingConstants.RIGHT) ;

	modificar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
	        	Class.forName("com.mysql.jdbc.Driver");
                Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacenitlafinal?useSSL=false","root","albert2707");
	            String ID = idUser.getText().trim();

	            PreparedStatement pasar=conectar.prepareStatement("Update productos set NombreProducto=?, MarcaProducto=?,CategoriaProducto=?,PrecioProducto=?,StockProducto=? where idProducto= " + ID);
	            pasar.setString(1, Nombre.getText().trim());
	            pasar.setString(2, marca.getText().trim());
	            pasar.setString(3, categoria.getText().trim());
	            pasar.setString(4, precio.getText().trim());
	            pasar.setString(5, cantidadDisponible.getText().trim());
	            pasar.executeUpdate();
	            almacen mostrar = almacen.getInstance();
	            mostrar.mostrar();
	            setVisible(false);
	            limpiarCampos();
			}catch(Exception e1) {
				System.out.print("error");
				
			}
		}
		
	});
	add(modificar);
    ImageIcon icono = new ImageIcon("src/imagenes/borrar-cuenta (1).png");
    int  ancho =40;
    int  alto = -1;
    ImageIcon icono2 = new ImageIcon(icono.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
	
	JLabel modify1 = new JLabel(icono2);
	modify1.setBounds(187, 403, 100, 50);
	add(modify1);
	
	eliminar  = new JButton("Eliminar");
	eliminar.setBounds(200, 400, 130,50);
    eliminar.setHorizontalAlignment(SwingConstants.RIGHT) ;

	eliminar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
	        	Class.forName("com.mysql.jdbc.Driver");
                Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacenitlafinal?useSSL=false","root","albert2707");
	            String ID = idUser.getText().trim();

	            PreparedStatement pasar=conectar.prepareStatement("delete from productos where idProducto="+ID);
	            pasar.executeUpdate();
	            almacen mostrar = almacen.getInstance();
	            mostrar.mostrar();
	            setVisible(false);
	            limpiarCampos();
			}catch(Exception e1) {
				System.out.print("error");
				
			}
		}
		
	});
	add(eliminar);
	
}

public void TextFields() {
	idUser = new JTextField();
	idUser.setBounds(170,50,150,30);
	idUser.setEditable(false);
	idUser.setForeground(Color.gray);
	idUser.setFont(new Font("Times New Roman", 1, 14));
	add(idUser);


	Nombre = new JTextField();
	Nombre.setBounds(170,100 ,150, 30);
	Nombre.setForeground(Color.gray);
	Nombre.setFont(new Font("Times New Roman", 1, 14));
	add(Nombre);
	
	
	
	
	marca = new JTextField();
	marca.setBounds(170,150,150,30);
	marca.setForeground(Color.gray);
	marca.setFont(new Font("Times New Roman", 1, 14));
	add(marca);
	
	
	
	categoria = new JTextField();
	categoria.setBounds(170,200,150,30);
	categoria.setForeground(Color.gray);
	categoria.setFont(new Font("Times New Roman", 1, 14));
	add(categoria);
	
	precio = new JTextField();
	precio.setBounds(170,250,150,30);
	precio.setForeground(Color.gray);
	precio.setFont(new Font("Times New Roman", 1, 14));
	add(precio);
	
	cantidadDisponible = new JTextField();
	cantidadDisponible.setBounds(170,300,150,30);
	cantidadDisponible.setForeground(Color.gray);
	cantidadDisponible.setFont(new Font("Times New Roman", 1, 14));
	add(cantidadDisponible);
	
	
}
 public void Labels() {
	id = new JLabel("IdProducto(non-editable)");
	id.setBounds(10,13,200,100);
	id.setForeground(Color.black);
	id.setFont(new Font("Times New Roman", 1, 14));
	add(id);
	
	nombre = new JLabel("NombreProducto");
	nombre.setBounds(50,63, 200,100);
	nombre.setForeground(Color.black);
	nombre.setFont(new Font("Times New Roman", 1, 14));
	add(nombre);
	
	lmarca = new JLabel("MarcaProducto");
	lmarca.setBounds(50, 113, 200, 100);
	lmarca.setForeground(Color.black);
	lmarca.setFont(new Font("Times New Roman", 1, 14));
	add(lmarca);
	
	lcategoria = new JLabel("CategoriaProducto");
	lcategoria.setBounds(40,163, 200,100);
	lcategoria.setForeground(Color.black);
	lcategoria.setFont(new Font("Times New Roman", 1, 14));
	add(lcategoria);
	
	lprecio = new JLabel("PrecioProducto");
	lprecio.setBounds(50, 213, 200, 100);
	lprecio.setForeground(Color.black);
	lprecio.setFont(new Font("Times New Roman", 1, 14));
	add(lprecio);
	
	cantidad = new JLabel("StockProducto");
	cantidad.setBounds(50,263,200,100);
	cantidad.setForeground(Color.black);
	cantidad.setFont(new Font("Times New Roman", 1, 14));
	add(cantidad);
}
 
 public void limpiarCampos(){


idUser.setText("");
Nombre.setText("");
marca.setText("");
categoria.setText("");
precio.setText("");
cantidadDisponible.setText("");
		
 }

@Override
public void mostrar() {
	// TODO Auto-generated method stub
	
}
}

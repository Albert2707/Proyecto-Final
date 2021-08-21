import javax.swing.JFrame;
import javax.swing.JLabel;

import Desvanecimiento.Desvanecimiento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;

import javax.swing.*;
//Albert Joan Agramonte Suero
//Matricula.2020-10652
//Patron de diseño singleton
//Polimorfismo en cada notacion @Override
//Herencia, encapsulamiento, abstracion.
public class Elegir extends JFrame implements metodos{
JLabel imagen1, imagen2, atras;
JButton boton1,boton2,botonSalir;
private static Elegir instance;
private Desvanecimiento efecto;
private Elegir() {
	setLayout(null);
	Labels();
    setUndecorated(true);
efecto = new Desvanecimiento();
efecto.Abrir(this, 20);
	Botones();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(255, 239, 213));
    


}

public static Elegir getInstance() {
    if(Objects.isNull(instance)) {
        instance = new Elegir();
    }
    return instance;
}

public void Labels() {


	imagen1 = new 	JLabel("Usuarios");
	imagen1.setBounds(63,120,100,100);
    imagen1.setFont(new Font("Times New Roman", 1, 14));
	add(imagen1);
	imagen2 = new JLabel("Almacen de Datos");
	imagen2.setBounds(180,120,150,100);
    imagen2.setFont(new Font("Times New Roman", 1, 14));
	add(imagen2);


}





public void Botones() {
	ImageIcon atras2 = new ImageIcon("src/imagenes/volver-a-publicar (1).png");
	atras = new JLabel("Volver atras");
	atras.setBounds(365,120,200,100);
	atras.setFont(new Font("Times New Roman", 1, 14));

	add(atras);
	botonSalir = new JButton(atras2);
	botonSalir.setBorderPainted(false);
	botonSalir.setContentAreaFilled(false);
	botonSalir.setFocusPainted(false);
	botonSalir.setOpaque(false);
	botonSalir.setBounds(320,55,150,100);

	botonSalir.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) { 
			 
			 Login main = Login.getInstance();
				main.setBounds(0,0,290,450);
				main.setVisible(true);
			    main.setLocationRelativeTo(null);
				main.setResizable(false);
				setVisible(false);
		}
		
	});
	add(botonSalir);
	
	ImageIcon perfil = new ImageIcon("src/imagenes/perfil (1).png");
	
	ImageIcon almacen2 = new ImageIcon("src/imagenes/almacen (1).png");
	boton1 = new JButton(perfil);
	//boton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	boton1.setBorderPainted(false);
	boton1.setContentAreaFilled(false);
	boton1.setFocusPainted(false);
	boton1.setOpaque(false);
	boton1.setBounds(40,55,100,100);
	boton1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Principal main= Principal.getInstance();
			main.mostrar();
			main.setBounds(0,0,750,700);
			main.setLocationRelativeTo(null);
			main.setVisible(true);
			main.setResizable(false);
            setVisible(false);
			}
		
	});
	add(boton1);
	
	boton2 = new JButton(almacen2);
	boton2.setBorderPainted(false);
	boton2.setContentAreaFilled(false);
	boton2.setFocusPainted(false);
	boton2.setOpaque(false);
	boton2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
if(e.getSource() == boton2) {
    almacen Almacen =   almacen.getInstance();
    Almacen.mostrar();
    Almacen.setBounds(0,0,750,400);
    Almacen.setLocationRelativeTo(null);
    Almacen.setVisible(true);
    Almacen.setResizable(false);
    setVisible(false);
}
		}
		
	});
    boton2.setBounds(180,50,110,110);
    add(boton2);

}

@Override
public void mostrar() {
	// TODO Auto-generated method stub
	
}

@Override
public void TextFields() {
	// TODO Auto-generated method stub
	
}

@Override
public void limpiarCampos() {
	// TODO Auto-generated method stub
	
}

}

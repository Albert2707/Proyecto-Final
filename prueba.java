import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public class prueba extends JFrame implements ActionListener{
	private static prueba instance;

	private JScrollPane scroll;
	private JTextField txtnombre,txt_buscar, txtnombreUsuario, txtapellido, txttelefono, txtcorreo, txtpassword, txtID;
	private JTable tabla;
	private String user_update;
	private JLabel nombre, nombreUsuario, apellido, telefono, correo, password, aviso;
	private JToggleButton botonModificar, botonEliminar, BotonCerrar;
	
	private prueba() {
	setTitle("DATOS");
	  setLayout(null);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
      Botones();
	  mostrar();
	  TextFields();
	  Labels();


}
protected void Botones() {
	BotonCerrar = new JToggleButton("Cerrar sesion");
	BotonCerrar.setBounds(0,0,750,20);
	BotonCerrar.setForeground(new Color(255, 51, 51 ));
	BotonCerrar.setFont(new Font("Times New Roman", 1, 14));
	BotonCerrar.addActionListener(this);
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
	
	
	
	botonModificar = new JToggleButton("Modificar");
	botonModificar.setBounds(450,300,140,60);
	botonModificar.setForeground(new Color(255, 150, 51));
	botonModificar.setFont(new Font("Times New Roman", 1, 14));
	botonModificar.addActionListener(this);
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
			// TODO Auto-generated method stub
			botonModificar.setSize(170,75);
			botonModificar.setLocation(450,300);
			//botonModificar.setForeground(new Color(51, 51, 255 ));
			//botonModificar.setFont(new Font("Times New Roman", 1, 14));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			botonModificar.setSize(140,60);
			botonModificar.setLocation(450,300);
			
		}
		
	});
	add(botonModificar);	
	
	
	
	botonEliminar = new JToggleButton("Eliminar");
	botonEliminar.setBounds(450,500,140,60);
	botonEliminar.setForeground(new Color(199, 255, 51 ));
	botonEliminar.setFont(new Font("Times New Roman", 1, 14));
	botonEliminar.addActionListener(this);
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
			botonEliminar.setSize(170,75);
			botonEliminar.setLocation(450,500);
			//botonModificar.setForeground(new Color(51, 51, 255 ));
			//botonModificar.setFont(new Font("Times New Roman", 1, 14));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			botonEliminar.setSize(140,60);
			botonEliminar.setLocation(450,500);
			
		}
		
	});
	add(botonEliminar);	
	
	
	
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
	if(e.getSource() ==botonModificar) {
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
	if(e.getSource() == botonEliminar) {
try {
	String ID = txtID.getText().trim();
	Connection  conectar = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");

    PreparedStatement pasar=conectar.prepareStatement("	delete from Registro where ID= " + ID);
        pasar.executeUpdate();
        mostrar();   

       

   	txtnombre.setForeground(Color.gray);
   	txtnombre.setFont(new Font("Courier New", 1, 14));
   	txtnombre.addFocusListener(new FocusListener() {
   	    @Override
   	    public void focusGained(FocusEvent e) {
   	        if (txtnombre.getText().equals("Nombre")) {
   	        	txtnombre.setText("");
   	        	txtnombre.setForeground(Color.black);
   	        }
   	    }

   		@Override
   		public void focusLost(FocusEvent e) {
   	        if (txtnombre.getText().isEmpty()) {
   	        	txtnombre.setForeground(Color.GRAY);
   	        	txtnombre.setText("Nombre");
   	        }
   			
   		}});



   	
   	


   	
   	

   txtID.setEditable(false);

   txtID.setForeground(Color.gray);
   txtID.setFont(new Font("Courier New", 1, 14));
   txtID.addFocusListener(new FocusListener() {
       @Override
       public void focusGained(FocusEvent e) {
           if (txtID.getText().equals("ID")) {
           	txtID.setText("");
           	txtID.setForeground(Color.black);
           }
       }

   	@Override
   	public void focusLost(FocusEvent e) {
           if (txtID.getText().isEmpty()) {
           	txtID.setForeground(Color.GRAY);
           	txtID.setText("ID");
           }
   		
   	}});




    txtnombreUsuario.setForeground(Color.gray);
    txtnombreUsuario.setFont(new Font("Courier New", 1, 14));
    txtnombreUsuario.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (txtnombreUsuario.getText().equals("Usuario")) {
           	 txtnombreUsuario.setText("");
            	txtnombreUsuario.setForeground(Color.black);
            }
        }

    	@Override
    	public void focusLost(FocusEvent e) {
            if (txtnombreUsuario.getText().isEmpty()) {
           	 txtnombreUsuario.setForeground(Color.GRAY);
            	txtnombreUsuario.setText("Usuario");
            }
    		
    	}});

    
    
    

   txtapellido.setForeground(Color.gray);
   txtapellido.setFont(new Font("Courier New", 1, 14));
   txtapellido.addFocusListener(new FocusListener() {
       @Override
       public void focusGained(FocusEvent e) {
           if (txtapellido.getText().equals("Apellido")) {
           	txtapellido.setText("");
           	txtapellido.setForeground(Color.black);
           }
       }

   	@Override
   	public void focusLost(FocusEvent e) {
           if (txtapellido.getText().isEmpty()) {
           	txtapellido.setForeground(Color.GRAY);
           	txtapellido.setText("Apellido");
           }
   		
   	}});








   txttelefono.setForeground(Color.gray);
   txttelefono.setFont(new Font("Courier New", 1, 14));
   txttelefono.addFocusListener(new FocusListener() {
       @Override
       public void focusGained(FocusEvent e) {
           if (txttelefono.getText().equals("Telefono")) {
           	txttelefono.setText("");
           	txttelefono.setForeground(Color.black);
           }
       }

   	@Override
   	public void focusLost(FocusEvent e) {
           if (txttelefono.getText().isEmpty()) {
           	txttelefono.setForeground(Color.GRAY);
           	txttelefono.setText("Telefono");
           }
   		
   	}});




   txtcorreo.setForeground(Color.gray);
   txtcorreo.setFont(new Font("Courier New", 1, 14));
   txtcorreo.addFocusListener(new FocusListener() {
       @Override
       public void focusGained(FocusEvent e) {
           if (txtcorreo.getText().equals("Correo")) {
           	txtcorreo.setText("");
           	txtcorreo.setForeground(Color.black);
           }
       }

   	@Override
   	public void focusLost(FocusEvent e) {
           if (txtcorreo.getText().isEmpty()) {
           	txtcorreo.setForeground(Color.GRAY);
           	txtcorreo.setText("Correo");
           }
   		
   	}});


   txtpassword.setForeground(Color.gray);
   txtpassword.setFont(new Font("Courier New", 1, 14));
   txtpassword.addFocusListener(new FocusListener() {
       @Override
       public void focusGained(FocusEvent e) {
           if (txtpassword.getText().equals("Contraseña")) {
           	txtpassword.setText("");
           	txtpassword.setForeground(Color.black);
           }
       }

   	@Override
   	public void focusLost(FocusEvent e) {
           if (txtpassword.getText().isEmpty()) {
           	txtpassword.setForeground(Color.GRAY);
           	txtpassword.setText("Contraseña");
           }
   		
   	}});

       
       
       
       
       
       
       
       
       
       
       
       

} catch (Exception e2) {
	// TODO: handle exception
}
	}
	}



protected void mostrar() {
try {


   Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");

	
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
	
    Statement  set = cn.createStatement();
    ResultSet resultado = set.executeQuery("select * from Registro");


while(resultado.next()) {
	Object [] fila = new Object[7];
	for(int i = 0;i<7;i++) {
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
        txtID.setText(tabla.getValueAt(fila,0).toString());
         txtnombreUsuario.setText(tabla.getValueAt(fila,1).toString());
          txtnombre.setText(tabla.getValueAt(fila,2).toString());
           txtapellido.setText(tabla.getValueAt(fila,3).toString());
            txttelefono.setText(tabla.getValueAt(fila,4).toString());
            txtpassword.setText(tabla.getValueAt(fila,4).toString());
            txtcorreo.setText(tabla.getValueAt(fila,5).toString());

    }else {
    	 JOptionPane.showMessageDialog(null,"Seleccione fila");
    }
}


protected void TextFields() {

	txtnombre = new JTextField("Nombre");
	txtnombre.setBounds(30,350,200,30);
	txtnombre.setForeground(Color.gray);
	txtnombre.setFont(new Font("Courier New", 1, 14));
	txtnombre.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
	        if (txtnombre.getText().equals("Nombre")) {
	        	txtnombre.setText("");
	        	txtnombre.setForeground(Color.black);
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


	
	


	
	
txtID = new JTextField("ID");
txtID.setEditable(false);
txtID.setBounds(30,250,200,30);
txtID.setForeground(Color.gray);
txtID.setFont(new Font("Courier New", 1, 14));
txtID.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (txtID.getText().equals("ID")) {
        	txtID.setText("");
        	txtID.setForeground(Color.black);
        }
    }

	@Override
	public void focusLost(FocusEvent e) {
        if (txtID.getText().isEmpty()) {
        	txtID.setForeground(Color.GRAY);
        	txtID.setText("ID");
        }
		
	}});
add(txtID);



 txtnombreUsuario = new JTextField("Usuario");
 txtnombreUsuario.setBounds(30,300,200,30);
 txtnombreUsuario.setForeground(Color.gray);
 txtnombreUsuario.setFont(new Font("Courier New", 1, 14));
 txtnombreUsuario.addFocusListener(new FocusListener() {
     @Override
     public void focusGained(FocusEvent e) {
         if (txtnombreUsuario.getText().equals("Usuario")) {
        	 txtnombreUsuario.setText("");
         	txtnombreUsuario.setForeground(Color.black);
         }
     }

 	@Override
 	public void focusLost(FocusEvent e) {
         if (txtnombreUsuario.getText().isEmpty()) {
        	 txtnombreUsuario.setForeground(Color.GRAY);
         	txtnombreUsuario.setText("Usuario");
         }
 		
 	}});
 add(txtnombreUsuario);
 
 
 
 
txtapellido = new JTextField("Apellido");
txtapellido.setBounds(30,400,200,30);
txtapellido.setForeground(Color.gray);
txtapellido.setFont(new Font("Courier New", 1, 14));
txtapellido.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (txtapellido.getText().equals("Apellido")) {
        	txtapellido.setText("");
        	txtapellido.setForeground(Color.black);
        }
    }

	@Override
	public void focusLost(FocusEvent e) {
        if (txtapellido.getText().isEmpty()) {
        	txtapellido.setForeground(Color.GRAY);
        	txtapellido.setText("Apellido");
        }
		
	}});
add(txtapellido);






txttelefono = new JTextField("Telefono");
txttelefono.setBounds(30,450,200,30);
txttelefono.setForeground(Color.gray);
txttelefono.setFont(new Font("Courier New", 1, 14));
txttelefono.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (txttelefono.getText().equals("Telefono")) {
        	txttelefono.setText("");
        	txttelefono.setForeground(Color.black);
        }
    }

	@Override
	public void focusLost(FocusEvent e) {
        if (txttelefono.getText().isEmpty()) {
        	txttelefono.setForeground(Color.GRAY);
        	txttelefono.setText("Telefono");
        }
		
	}});
add(txttelefono);



txtcorreo = new JTextField("Correo");
txtcorreo.setBounds(30,550,200,30);
txtcorreo.setForeground(Color.gray);
txtcorreo.setFont(new Font("Courier New", 1, 14));
txtcorreo.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (txtcorreo.getText().equals("Correo")) {
        	txtcorreo.setText("");
        	txtcorreo.setForeground(Color.black);
        }
    }

	@Override
	public void focusLost(FocusEvent e) {
        if (txtcorreo.getText().isEmpty()) {
        	txtcorreo.setForeground(Color.GRAY);
        	txtcorreo.setText("Correo");
        }
		
	}});
add(txtcorreo);

txtpassword = new JTextField("Contraseña");
txtpassword.setBounds(30,500,200,30);
txtpassword.setForeground(Color.gray);
txtpassword.setFont(new Font("Courier New", 1, 14));
txtpassword.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (txtpassword.getText().equals("Contraseña")) {
        	txtpassword.setText("");
        	txtpassword.setForeground(Color.black);
        }
    }

	@Override
	public void focusLost(FocusEvent e) {
        if (txtpassword.getText().isEmpty()) {
        	txtpassword.setForeground(Color.GRAY);
        	txtpassword.setText("Contraseña");
        }
		
	}});
add(txtpassword);








}

public static prueba getInstance() {
	if(Objects.isNull(instance)) {
		instance = new prueba();
	}
	return instance;
}
public static void main(String[] args) {
	prueba principal =  prueba.getInstance();
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
	
}

public void limpiarCampos() {
	

   txtID.setText("ID");
   txtnombreUsuario.setText("Usuario");
   txtnombre.setText("Nombre");
   txtapellido.setText("Apellido");
   txttelefono.setText("Telefono");
   txtpassword.setText("Contraseña");
   txtcorreo.setText("Correo");
   

}

}






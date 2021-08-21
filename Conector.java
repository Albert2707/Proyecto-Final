import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
//Albert Joan Agramonte Suero
//Matricula.2020-10652
public class Conector {
	Connection cn = null;
public Connection conexion() {

	try {
		Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacenitlafinal?useSSL=false","root","albert2707");

	} catch (Exception e) {
        JOptionPane.showMessageDialog(null,"No fue posible conectarse a la base de datos","INFO",JOptionPane.INFORMATION_MESSAGE);
	}
	return cn;
}
}

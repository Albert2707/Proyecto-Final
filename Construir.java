//Albert Joan Agramonte Suero
//Matricula.2020-10652
//Patron de diseño singleton
//Herencia
public class Construir{
 public static void main(String args[]) {

	 
	 Login main = Login.getInstance();
		main.setBounds(0,0,290,450);
		main.setVisible(true);
	    main.setLocationRelativeTo(null);
		main.setResizable(false);
 }

}

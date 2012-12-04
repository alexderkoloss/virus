
  
	import java.awt.*;
	import java.awt.event.*; //attention il faut importer explicitement chaque sous-paquetage
	public class test {
	class fenetre extends Frame implements ActionListener
	{
	Button b;
	TextField texte;
	public fenetre() //constructeur
	{
	super(); //construction d'un Frame
	b = new Button("Cliquez ici"); //construction du bouton
	b.addActionListener(this); //b abonne la fenetre à ses événements
	texte = new TextField("Bouton pas encore cliqué :-( "); //construction du champ de texte
	this.add(b, BorderLayout.SOUTH); //ajout des composants dans la fenetre
	this.add(texte, BorderLayout.NORTH);
	this.setBounds(200, 200, 200, 80); //définition de la position et de la taille
	this.show();
	}
	public void actionPerformed(ActionEvent e) //gestionnaire de l'événement ActionEvent
	{
	texte.setText("Bouton cliqué! :-)");
	}
	}
	class essai //classe principale d'entrée dans le programme
	{
	public  void main(String args[])
	{
	fenetre f = new fenetre();
	}
	}
	}


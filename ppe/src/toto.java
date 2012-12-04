  import java.awt.*;
  class toto extends Frame
  {
  Button leBouton;
  TextField leChamp;
public toto(String titre)
{
super(titre);
this.setLayout(null);
this.setBounds(200, 100, 300, 200);
leBouton = new Button("Cliquez ici");
leBouton.setBounds(50, 50, 100, 50);
leChamp = new TextField( );
leChamp.setBounds(50, 120, 200, 50);
this.add(leBouton);
this.add(leChamp);
}
}

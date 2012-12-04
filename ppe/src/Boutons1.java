    import java.applet.Applet;
	import javax.swing.* ;

	import java.awt.* ;
import java.awt.event.* ;
	class FenBoutons extends JFrame implements ActionListener
	{ public FenBoutons (int nBout)
	  { this.nBout = nBout ;
	    setTitle ("BOUTONS") ;
	    setSize (200, 150) ;
	    Container contenu = getContentPane() ;
	    contenu.setLayout (new FlowLayout()) ;
	    boutons = new JButton [nBout] ;
	    for (int i=0 ; i<nBout ; i++)
	    { boutons[i] = new JButton ("BOUTON"+(i+1)) ;
	      contenu.add(boutons[i]) ;
	      boutons[i].addActionListener (this) ;
	    
	    }
	  }
	  public void actionPerformed (ActionEvent e)
	  { Object source = e.getSource() ;
	    for (int i=0 ; i<nBout ; i++)
	      if (source == boutons[i])
	        System.out.println ("Action sur bouton " + (i+1)) ;
	      JFrame f = new JFrame();
	      for (int i=0 ; i<nBout ; i++)
		      if (source == boutons[i]){
		  Label la = new Label("Action sur bouton: " +(i+1));
		  f.add(la);
	      f.setVisible(true);
		  f.setSize(400, 100);
	      f.setLocationRelativeTo(null);
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
	  }
	  private int nBout ;
	  private JButton[] boutons ;
	}
	public class Boutons1
	{ public static void main (String args[])
	  { System.out.print ("Combien de boutons ? ") ;
	    int nBoutons = Clavier.lireInt() ;
	    
	    FenBoutons fen = new FenBoutons(nBoutons) ;
	    fen.setVisible(true) ;
	  }
	}





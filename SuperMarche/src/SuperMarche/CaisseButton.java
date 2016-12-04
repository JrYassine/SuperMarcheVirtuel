package isn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

// bouton cache qui affiche le contenu de la caisse
public class CaisseButton extends Button {

   public CaisseButton(FenetreMagasin  pan) {
      super(pan);
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      // TODO Auto-generated method stub
      JOptionPane.showMessageDialog(null, Caisse.contenuCaisse() , "Contenue Caisse", JOptionPane.INFORMATION_MESSAGE);
   }

}

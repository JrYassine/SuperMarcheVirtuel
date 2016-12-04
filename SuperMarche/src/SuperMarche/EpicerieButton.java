package isn;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class EpicerieButton extends Button {
   
  public EpicerieButton(FenetreMagasin pan) {
     super(pan); 
   }

   public void actionPerformed(ActionEvent arg0) { // lorsqu'on clique sur produit frais...
      if (MainBDProgram.debug) {
         System.out.println("buttonClicked produit Epicerie");
      }
  
      Produit oréo = new Produit("Oréo", 405, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images\\Alcoolménager.jpg"); 
      Produit BN = new Produit("BN", 599, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/BN2.jpg");
      Produit kinder = new Produit("Kinder", 499, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Kinder.png");
      Produit prince = new Produit("Prince", 599, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Prince.jpg");
      Produit bonbon = new Produit("Bonbon", 187, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Bonbon.jpg");
      Produit tableauProduitFrais[] = { oréo, BN, kinder, prince, bonbon };
    
      JPanel pan=BoutonProduit.initPanel(tableauProduitFrais);
      getMainPanel().afficherPanel(pan);

   }

}
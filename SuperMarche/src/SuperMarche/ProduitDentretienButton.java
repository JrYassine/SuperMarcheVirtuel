package isn;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class ProduitDentretienButton extends Button {

   public ProduitDentretienButton(FenetreMagasin pan) {
      super(pan); // pan (deja existant) = au nouveau qui est dans la
                  // classe produit frais
   }

   public void actionPerformed(ActionEvent arg0) { // lorsqu'on clique sur
                                                   // produit frais...
      if (MainBDProgram.debug) {
         System.out.println("buttonClicked produit d'entretiens");
      }

      Produit eauDeJavel = new Produit("Eau de Javel", 405, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Eaudejavel.jpg"); 
      Produit nettoyantSol = new Produit("Nettoyant sol", 879, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Nettoyantsol.jpg");
      Produit alcoolM�nager = new Produit("Alcool M�nager", 536, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Alcoolm�nager.jpg");
      Produit d�tergent = new Produit("D�tergent", 799, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/D�tergent.jpg");
      Produit nettoyantLaveVaisselle = new Produit("Nettoyant pour Lave Vaisselle", 561,
                                                   "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/nettoyantLaveVaisselle.jpg");
      Produit tableauProduitFrais[] = { eauDeJavel, nettoyantSol, alcoolM�nager, d�tergent,
                                        nettoyantLaveVaisselle };
      JPanel pan=BoutonProduit.initPanel(tableauProduitFrais);
      pan.setName(getClass().getName());
      getMainPanel().afficherPanel(pan);
   }
}

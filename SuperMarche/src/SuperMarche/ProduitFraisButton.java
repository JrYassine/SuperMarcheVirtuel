package isn;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class ProduitFraisButton extends Button {

   public ProduitFraisButton(FenetreMagasin pan) {
      super(pan);
   }

   public void actionPerformed(ActionEvent arg0) { // lorsqu'on clique sur produit frais...
      if (MainBDProgram.debug) {System.out.println("buttonClicked produit frais");}
      Produit petitSuisse = new Produit("Petit Suisse", 246, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/PetitSuisse.jpg");
      Produit lait = new Produit("Lait", 189, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Lait.jpg");
      Produit beurre = new Produit("Beurre", 235, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Beurre.jpg");
      Produit pates = new Produit("Pates", 405, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Pate.png");
      Produit jambon = new Produit("Jambon Cru", 479, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/JambonCru.jpg");
      Produit tableauProduitFrais[] = { petitSuisse, lait, beurre, pates, jambon };

      JPanel pan=BoutonProduit.initPanel(tableauProduitFrais);
      pan.setName(getClass().getName());
      getMainPanel().afficherPanel(pan);
   }

}
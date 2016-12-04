package isn;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class ProduitBebeButton extends Button {

   public ProduitBebeButton(FenetreMagasin pan) {
      super(pan);
   }

   public void actionPerformed(ActionEvent arg0) { // lorsqu'on clique sur produit frais...
      if (MainBDProgram.debug) {
         System.out.println("buttonClicked produit bébé");
      }

      // cree un produit Peluche avec ses caractéristiques
      Produit peluche = new Produit("Peluche", 405, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Peluche.jpg");
      Produit compote = new Produit("Compote", 599, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Compote.jpg");
      Produit laitEnPoudre = new Produit("Lait en poudre", 499, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Laitenpoudre.jpg");
      Produit couche = new Produit("Couche", 599, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Couche.jpg");
      Produit lingette = new Produit("Lingette", 202, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Lingette.jpg");
      Produit tableauProduitFrais[] = { peluche, compote, laitEnPoudre, couche, lingette };

      JPanel pan = BoutonProduit.initPanel(tableauProduitFrais);
      pan.setName(getClass().getName());
      getMainPanel().afficherPanel(pan);

   }
}
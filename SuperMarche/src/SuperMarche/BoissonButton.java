package isn;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class BoissonButton extends Button {

   public BoissonButton(FenetreMagasin pan) {
      super(pan);// appelle le constructeur superieur (button)
   }

   public void actionPerformed(ActionEvent arg0) {// defini l'action quand on clique
      if (MainBDProgram.debug) { System.out.println("buttonClicked Boisson");}
      
      Produit coca = new Produit("Coca", 135, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Coca.jpg"); 
      Produit pepsi = new Produit("Pepsi", 299, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Pepsi.png");
      Produit orangina = new Produit("Orangina", 99, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Orangina.jpg");
      Produit sprite = new Produit("Sprite", 315, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Sprite.jpg");
      Produit champagne = new Produit("Champagne", 3999, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Champagne.jpg");
      Produit vinBlanc = new Produit("Vin Blanc", 555, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/VinBlanc.jpg");
      Produit vinRouge = new Produit("Vin Rouge", 515, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/VinRouge.jpg");
      Produit vodka = new Produit("Vodka", 4100, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/vodka.jpg");
      Produit tableauProduitFrais[] = { coca, pepsi, orangina, sprite, champagne, vinBlanc, 
                                         vinRouge,vodka };
   
      // appelle la methode initPanel qui cree les boutons produits dans un nouveaux panel de produit pan
      JPanel pan=BoutonProduit.initPanel(tableauProduitFrais);
      //  pan.setName(getClass().getName());
      getMainPanel().afficherPanel(pan);//affiche le panel des produits dans la fenetre principale

   }

}

package isn;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class SoinsBeauteButton extends Button {
   public SoinsBeauteButton(FenetreMagasin  pan) {
     super(pan);
   }

   public void actionPerformed(ActionEvent arg0) { // lorsqu'on clique sur produit frais...
      if (MainBDProgram.debug) {System.out.println("buttonClicked soins beaut�");}
      Produit shampoing = new Produit("Shampoing", 405, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Shampoing.jpg"); 
      Produit gelDouche = new Produit("Gel Douche", 389, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Geldouche.jpg");
      Produit parfum = new Produit("Parfum", 6455, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Parfum.png");
      Produit cr�me = new Produit("Cr�me", 205, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Cr�me.jpg");
      Produit deodorant = new Produit("Deodorant", 436, "C:\\Users\\Yassine\\Desktop\\eclipse\\isn\\Images/Deodorant.jpg");
      Produit tableauProduitFrais[] = { shampoing, gelDouche, parfum, cr�me, deodorant };
      JPanel pan=BoutonProduit.initPanel(tableauProduitFrais);
      getMainPanel().afficherPanel(pan);  
   }
}

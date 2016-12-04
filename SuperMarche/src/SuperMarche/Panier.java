package isn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panier implements ActionListener {
   private static ArrayList<String> listeNomProduit = new ArrayList<String>();
   private static ArrayList<String> listePrix = new ArrayList<String>();
   private static int prixPanier = 0;

   public Panier() {
      Panier.prixPanier = 0;
   }

   public void ajouterProduit(String monProduit) {
      Panier.prixPanier = Panier.prixPanier + (int) (Double.parseDouble(monProduit) * 100.0);
      // ajoute un nouveau produit
      if (MainBDProgram.debug) {System.out.println(Panier.getPrixPanier());}
   }

   public static int getPrixPanier() {
      return prixPanier;
   }

   public static void setPrixPanier(int prixPanier) {
      Panier.prixPanier = prixPanier;
   }

   public static void videPanier() {
      Panier.setPrixPanier(0);
      setListeNomProduit(new ArrayList<String>());// cree une nouvelle liste vide
      setListePrix(new ArrayList<String>());
   }

   public void actionPerformed(ActionEvent arg0) {
      // System.out.println("buttonClicked button2" + arg0.getActionCommand());
      String[] BoutonClick = arg0.getActionCommand().split(":");
      // System.out.println("buttonClick:" + BoutonClick[1]);
      String[] Prix = BoutonClick[1].split("€");
      String ProduitChoisi = BoutonClick[0];
      // System.out.println(ProduitChoisi);
      Panier.getListeNomProduit().add(ProduitChoisi);
      Panier.getListePrix().add(BoutonClick[1]);
      this.ajouterProduit(Prix[0].trim());
      
      if (MainBDProgram.debug) {
         System.out.println("prix du produit: " + BoutonClick [1]);
         System.out.println(Panier.getListeNomProduit());
         System.out.println(Panier.getListePrix());
    }
   }

   public static  ArrayList<String> getListeNomProduit() {
      return listeNomProduit;
   }

   public static void setListeNomProduit(ArrayList<String> listeNomProduit) {
      Panier.listeNomProduit = listeNomProduit;
   }

   public static ArrayList<String> getListePrix() {
      return listePrix;
   }

   public static void setListePrix(ArrayList<String> listePrix) {
      Panier.listePrix = listePrix;
   }
}


package isn;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Produit {// stock les caracteristiques d'un produit

   String nom;
   int prix;
   String cheminIcon;
   ImageIcon ProduitIcon;

   public Produit(String nom, int prix, String cheminIcon) {
      this.nom = nom;
      this.prix = prix;
      this.cheminIcon = cheminIcon;
      if (cheminIcon != null) { // si le chemin icon n'est pas vide
         try {
            this.ProduitIcon = new ImageIcon(ImageIO.read(new File(cheminIcon))); // essaye
                                                                                  // de
                                                                                  // creer
                                                                                  // un
                                                                                  // objet
                                                                                  // icon
                                                                                  // à
                                                                                  // partir
                                                                                  // du
                                                                                  // chemin

         } catch (IOException e) { // si exeption..(erreur)

            System.err.println("fichier pas trouvé " + cheminIcon); // afficher
                                                                    // message
                                                                    // d'erreur
            this.ProduitIcon = null; // produit icon est vide

         }
      } else { // si chemin icon est vide...
         this.ProduitIcon = null; // alors produit icon est vide
      }

   }

   public String getNom() { // permet de recuperer le nom depuis une autre
                            // classe
      return nom;
   }

   public void setNom(String nom) { // permet de modifier le nom d'un produit
                                    // depuis une autre classe
      this.nom = nom;
   }

   public int getPrix() {
      return prix;
   }

   public void setPrix(int prix) {
      this.prix = prix;
   }

   public String getCheminIcon() {
      return cheminIcon;
   }

   public void setCheminIcon(String cheminIcon) {
      this.cheminIcon = cheminIcon;
   }

   public ImageIcon getProduitIcon() {
      return ProduitIcon;
   }

   public void setProduitIcon(ImageIcon produitIcon) {
      ProduitIcon = produitIcon;
   }

}

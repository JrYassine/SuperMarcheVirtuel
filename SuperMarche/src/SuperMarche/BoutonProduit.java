package isn;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoutonProduit extends JButton { // Caracteristique et cree des
                                              // boutons produits
   static Panier monPanier = new Panier(); // cree un panier

   // methode qui cree et affiche des boutons sur buttonPan
   public static JPanel initPanel(Produit tableauProduit[]) {
      JPanel buttonPan=new JPanel();// creer un panel pour les produits
      
      buttonPan.setLayout(new GridBagLayout());// defini le layout manager pour chaque bouton produit
      buttonPan.setPreferredSize(new Dimension(200,200));// taille prefere
      
      // i=0 tableau commence a 0, length = longueur du tableau, i++ = passe au suivant (i+1)
      for (int i = 0; i < tableauProduit.length; i++) { 
         // cree des boutons nommée dans un tableau
         JButton button = new JButton(tableauProduit[i].getNom() + " : "
                                      + String.valueOf(tableauProduit[i].getPrix() / 100.0) + "€",
                                      tableauProduit[i].getProduitIcon());
         // cree une contrainte c pour chaque boutons (i eme bouton)
         GridBagConstraints c =new GridBagConstraints(); 
         c.gridx=i%5;// x de 0 a 4 (i modulo 5 -> reste de la division)
         c.gridy=(int)(i/5);// y = le nombre de groupe de 5
         
         button.addActionListener(monPanier);// lorsqu'on clique sur un produit on active l'action du panier
         
         buttonPan.add(button,c);// on ajoute le bouton dans le panel
        
      } 
      if (MainBDProgram.debug) {buttonPan.setBackground(Color.ORANGE);}
      return buttonPan;// retourne le panel remplit de produits

   }

}


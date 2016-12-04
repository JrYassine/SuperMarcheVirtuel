package isn;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class PayerButton extends Button {
   // private JPanel mainPanel;
   private int argentSaisie = 0; // Argent deja saisie, 0 au depart

   public int getArgentSaisie() {
      return argentSaisie;
   }

   public void setArgentSaisie(int argentSaisie) {
      this.argentSaisie = argentSaisie;
   }

   private int totalPrixPanier = 0; // total du panier
   DecimalFormat df = new DecimalFormat("0.00"); // format d'affichage avec deux
                                                 // chiffres après la virgule

   public PayerButton(FenetreMagasin contentPane) {
      super(contentPane);
   }
   // methode qui crée des boutons billet et qui associe l'action et actualise l'argent saisie et caisse
   private JButton ajouterBoutonBillet(final int billet, final JButton btnArgentSaisie) {
      JButton boutonBillet = null;
      if (billet == 1) {
         boutonBillet = new JButton(String.valueOf(billet) + "ct");
      } else if (billet < 100) {
         boutonBillet = new JButton(String.valueOf(billet) + "cts");
      } else {
         boutonBillet = new JButton(String.valueOf(billet / 100) + "€");
      }

      boutonBillet.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int argent = getArgentSaisie(); // recupere la valeur d'argent saisie = argent
            argent += billet;// ajoute un billet a argent
            Caisse.ajouteCaisse(billet);// ajoute a la caisse
            
           if (MainBDProgram.debug) {System.out.println(df.format(argent));}
            // actualise le bouton argent saisie
            btnArgentSaisie.setText("Argent Saisie: " + df.format(argent / 100.0) + "€");
            setArgentSaisie(argent);// actualise la variable 
            if (MainBDProgram.debug) {System.out.println(df.format(argent));}
         }
      });
      return boutonBillet;
   }

   public void actionPerformed(ActionEvent arg1) { // lorsqu'on clique sur payer
      JPanel contentPane = new JPanel(); // creer un panel pour la zone payer
      if (MainBDProgram.debug) {contentPane.setBackground(Color.PINK);}
      contentPane.setBorder(new LineBorder(Color.BLACK));// contour noir
      contentPane.setLayout(new GridBagLayout());// defini le layout manager

      totalPrixPanier = Panier.getPrixPanier();// recupere le prix du panier 
      final JButton btnArgentSaisie = new JButton("Argent Saisie: " + df.format(argentSaisie / 100.0) + "€");
   
      // appelle la methode pour creer la contrainte
      GridBagConstraints c = creerContraintePayerArgent(4); 
      contentPane.add(btnArgentSaisie, c);//ajoute au panel

      final JButton btnTotalPanier = new JButton("Somme à Payer: " + df.format(totalPrixPanier / 100.0) + "€");
      c = creerContraintePayerArgent(3);
      contentPane.add(btnTotalPanier, c);

      JPanel bourrage = new JPanel(); // cree un panel pour pousser les boutons vers le haut
      c = new GridBagConstraints();
      c.gridy = 10;
      c.gridx = 0;
      c.weightx = 0.0;
      c.weighty = 1.0;// donne un poids plus important que les autres boutons
      contentPane.add(bourrage, c);

      // bouton Payer
      JButton Payer = new JButton("Payer");
      Payer.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (argentSaisie > totalPrixPanier) {
               double monaie = (argentSaisie - totalPrixPanier);
               JOptionPane.showMessageDialog(null, " Voici votre monnaie " + df.format(monaie / 100) + "€\n"
                                                   + RenduMonaie.calculMonaie(monaie), "Caisse",
                                             JOptionPane.INFORMATION_MESSAGE);
               // remet les compteur a zero et vide le panier
               argentSaisie = 0;//
               totalPrixPanier = 0;
               Panier.videPanier();
               // et réaffiche les boutons a zero
               btnArgentSaisie.setText("Argent Saisie: " + df.format(argentSaisie / 100.0) + "€");
               // btnArgentSaisie.revalidate(); // actualise le bouton
               btnTotalPanier.setText("Somme à Payer: " + df.format(totalPrixPanier / 100.0) + "€");
               // btnTotalPanier.revalidate();
            } else if (argentSaisie == totalPrixPanier) {
               JOptionPane.showMessageDialog(null, " Merci pour vos achats", "Caisse",
                                             JOptionPane.INFORMATION_MESSAGE);
               // remet les compteur a zero et vide le panier
               argentSaisie = 0;
               totalPrixPanier = 0;
               Panier.videPanier();
               // et réaffiche les boutons a zero
               btnArgentSaisie.setText("Argent Saisie: " + df.format(argentSaisie / 100.0) + "€");
               // btnArgentSaisie.revalidate();
               btnTotalPanier.setText("Somme à Payer: " + df.format(totalPrixPanier / 100.0) + "€");
               // btnTotalPanier.revalidate();
            } else if (argentSaisie < totalPrixPanier) {
               JOptionPane.showMessageDialog(null,
                                             " Achat impossible il reste "
                                                + df.format((totalPrixPanier - argentSaisie) / 100.0) + "€",
                                             "Caisse", JOptionPane.INFORMATION_MESSAGE);
            }
         }
      });
      c = creerContraintePayerArgent(2);// cree la contraire selon la methode en position 2
      contentPane.add(Payer, c);// ajoute le bouton payer au contentPane

      // METTRE DES IMAGES DE PIECES ET BILLET A LA PLACE DU TEXTE !

      GridBagConstraints c2 = new GridBagConstraints();// cree une nouvelle contrainte pour les boutons billets
      c2.gridx = 1;
      c2.gridy = 2;
      c2 = creerContrainte(c2);// premier bouton en 2,2 grace a la contrainte modifie
      // crée des boutons billet, associe leur action,actualise l'argent saisie et caisse 
      //et ajoute le tout au panel avec la contraint c2
      contentPane.add(ajouterBoutonBillet(1, btnArgentSaisie), c2);// bouton 1ct
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(2, btnArgentSaisie), c2);
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(5, btnArgentSaisie), c2);
      
      c2 = creerContrainte(c2);//5,2
      c2.gridx = 2;// passe a la ligne (repart a 2,3)
      c2.gridy = 3;
      contentPane.add(ajouterBoutonBillet(10, btnArgentSaisie), c2); 
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(20, btnArgentSaisie), c2);
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(50, btnArgentSaisie), c2);
      
      c2 = creerContrainte(c2);
      c2.gridx = 2;
      c2.gridy = 4;
      contentPane.add(ajouterBoutonBillet(100, btnArgentSaisie), c2);
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(200, btnArgentSaisie), c2);
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(500, btnArgentSaisie), c2);
      
      c2 = creerContrainte(c2);
      c2.gridx = 2;
      c2.gridy = 5;
      contentPane.add(ajouterBoutonBillet(1000, btnArgentSaisie), c2);
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(2000, btnArgentSaisie), c2);
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(5000, btnArgentSaisie), c2);
      
      c2 = creerContrainte(c2);
      c2.gridx = 2;
      c2.gridy = 6;
      contentPane.add(ajouterBoutonBillet(10000, btnArgentSaisie), c2);
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(20000, btnArgentSaisie), c2);
      c2 = creerContrainte(c2);
      contentPane.add(ajouterBoutonBillet(50000, btnArgentSaisie), c2);

      getMainPanel().afficherPanel(contentPane);//affiche dans le panel

   }
//Methode pour modifier la contrainte pour les billets 
   private GridBagConstraints creerContrainte(GridBagConstraints old) {
      GridBagConstraints c = new GridBagConstraints();
      c.gridy = old.gridy;
      c.gridx = old.gridx +1;
      c.anchor = GridBagConstraints.NORTH;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.insets = new Insets(4, 4, 4, 4);
      c.weightx = 0.0;
      c.weighty = 0.0;
      return c;
   }
   // Methode pour creer la contrainte des 3 boutons de gauche
   private GridBagConstraints creerContraintePayerArgent(int y) {
   GridBagConstraints c = new GridBagConstraints();
   c.gridy = y;
   c.gridx = 0;
   c.weightx = 0.0;
   c.weighty = 0.0;
   c.insets = new Insets(4, 4, 4, 40);
   c.fill = GridBagConstraints.HORIZONTAL;
   c.anchor = GridBagConstraints.NORTH;
   return c;
   }
}
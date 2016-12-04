package isn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//cree la fenetre selon le modele : JFrame
public class FenetreMagasin extends JFrame { 

   private JPanel menuPan = new JPanel(); // cree un Jpanel pan (menu du haut)
   
   // cree les boutons
   private JButton boutonFrais = new JButton("Produits frais");
   private JButton boutonBoissons = new JButton("Boissons");
   private JButton boutonEntretiens = new JButton("Produits Entretiens");
   private JButton boutonBebe = new JButton("Produits Bebe");
   private JButton boutonEpicerie = new JButton("Produits Epicerie");
   private JButton boutonSoinsBeaute = new JButton("Produits Soins beaute");
   private JButton boutonSeparateur = new JButton(" ");
   private JButton boutonPanier = new JButton("Votre panier");
   private JButton boutonPayer = new JButton("Payer");

   private JPanel containerPrincipal = null; // creer un JPanel vide (container principal)
   private JComponent ancienContainer = null; // creer un JComponent vide 

   // methode pour effacer le panel precedent et afficher le nouveau  
   public void afficherPanel(JPanel panel) {
      if (ancienContainer != null) { // si il y a un panel affiche, : l'effacer
    	  containerPrincipal.remove(ancienContainer); 
      }
      ancienContainer = panel; // garde en memoire le panel qui va etre afficher
      containerPrincipal.add(panel, BorderLayout.CENTER); // ajouter le panel au container
 //     container.repaint();
      this.revalidate(); // affiche container
      
   }
   
   // methode pour creer une contrainte pour le layout manager 
   private GridBagConstraints createConstraint(int x, int y) {
      GridBagConstraints contrainte = new GridBagConstraints(); // cree new contrainte
      contrainte.insets = new Insets(4, 4, 4, 4); // definit les marges autour des boutons
      contrainte.gridx = x; // defini position en x
      contrainte.gridy = y; // defini position en y
      contrainte.fill = GridBagConstraints.BOTH; // rempli en hauteur et en largeur au maximum  
      contrainte.anchor = GridBagConstraints.NORTH; // positon au nord (en haut)
      return contrainte; // rend la contrainte
   }
   // methode pour ajouter un bouton
   private GridBagConstraints addButton(JPanel panel, JComponent component, int x, int y) {
   // cree un new contraite de position x et y + la contrainte au dessus 
      GridBagConstraints bagConstraints = createConstraint(x, y);
      panel.add(component, bagConstraints);// ajoute le component dans le panel avec la contraite
      return bagConstraints; // retourne la contrainte
   }
   //methode pour creer la fenetre principale
   private void CreerFenetre() {
      this.setTitle("Magasin"); // titre de la fenetre
      this.setSize(1200, 800); // taille de la fenetre
      this.setLocationRelativeTo(null); // position de la fentre au centre
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fin lorsque
      // clique croix rouge
      menuPan.setBackground(Color.LIGHT_GRAY); // couleur de fond du pan (menu)
      menuPan.setLayout(new GridBagLayout()); //defini le layout des menus du haut
      menuPan.setBorder(new LineBorder(Color.BLACK)); // trait autour du pan
      menuPan.setPreferredSize(new Dimension(200, 50)); // taille préféré du pan
      
      // appelle la methode addButton pour creer/afficher les boutons
      addButton(menuPan, boutonFrais, 0, 0); // 1
      addButton(menuPan, boutonBoissons, 1, 0); // 2
      addButton(menuPan, boutonEntretiens, 2, 0); // 3
      addButton(menuPan, boutonBebe, 3, 0); // 4
      addButton(menuPan, boutonSoinsBeaute, 4, 0); // 5
      addButton(menuPan, boutonEpicerie, 5, 0); // 6
      addButton(menuPan, boutonSeparateur, 6, 0); // 7
      addButton(menuPan, boutonPanier, 7, 0);// 8
      addButton(menuPan, boutonPayer, 8, 0);// 9
      // GridBagConstraints c=addButton(pan, boutonSoinsBeaute, 2, 2);
      // c.gridwidth=2;
    }

   public FenetreMagasin() {
      super(); // appelle le constructeur superieur (JFrame)
      CreerFenetre();// appelle la methode
      
      // cree le container principal dans la fenetre
      containerPrincipal = new JPanel(); 
      // container.setPreferredSize(new Dimension(1000,1000));
      containerPrincipal.setLayout(new BorderLayout());// defini le layout manager du conteneur principal
      this.getContentPane().add(containerPrincipal);//ajoute le container principal dans la fenetre
      containerPrincipal.add(menuPan ,BorderLayout.NORTH); //ajoute le pan (menu) dans la container
      if (MainBDProgram.debug) {containerPrincipal.setBackground(Color.BLUE);}
      
      // ajoute les actions listener a tous les boutons
      boutonFrais.addActionListener(new ProduitFraisButton(this));
      boutonBoissons.addActionListener(new BoissonButton(this));
      boutonBebe.addActionListener(new ProduitBebeButton(this));
      boutonEpicerie.addActionListener(new EpicerieButton(this));
      boutonEntretiens.addActionListener(new ProduitDentretienButton(this));
      boutonSoinsBeaute.addActionListener(new SoinsBeauteButton(this));
      boutonPanier.addActionListener(new PanierButton(this));
      boutonPayer.addActionListener(new PayerButton(this));
      boutonSeparateur.addActionListener(new CaisseButton(this));

      this.setVisible(true); // rend visible la fenetre

   }
}

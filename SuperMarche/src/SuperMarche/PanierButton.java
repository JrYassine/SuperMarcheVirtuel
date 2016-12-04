package isn;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class PanierButton extends Button {
   // JPanel mainPanel; // cree un nouveau panel pour afficher le panier

   public PanierButton(FenetreMagasin pan) {
      super(pan);
   }

   public void actionPerformed(ActionEvent arg0) { // lorsqu'on clique sur le panier
      if (MainBDProgram.debug) {
         System.out.println("buttonClicked panier");
      }
 
      DefaultTableModel model = new DefaultTableModel() { // cree un model
         public boolean isCellEditable(int row, int column) {
            // empeche d'ecrire dans les cellules du panier
            return false;
         }
      };
      JTable table = new JTable(model); // cree une jtable sur le model ci dessus.

      model.addColumn("Article"); // cree une colonne article
      model.addColumn("Prix"); // cree une colonne prix

      // Append a row
      DecimalFormat df = new DecimalFormat("#.##€");// deux chiffres apres la
                                                    // virgule + €
      // model.addRow(new Object[]{"Article", "Prix"}); // ajoute la 1e ligne
      // avec article et prix
      for (int i = 0; i < Panier.getListeNomProduit().size(); i++) {// i=0
                                                                    // tableau
         // commence a 0 tant que i est
         // plus petit que la longueur du tableau
         // alors il continu à afficher
         String[] strPrix = Panier.getListePrix().get(i).split("€"); 
         // déclare une variable pour récupérer le prix du pannier dans le
         // tableau de produit et sépare la valeur de €
         
         if (MainBDProgram.debug) {System.out.println("strprix:" + strPrix[0]);}

         double prix = Double.parseDouble(strPrix[0]); 
         // déclare une variable prix et converti en double le prix du produit
         model.addRow(new Object[] { Panier.getListeNomProduit().get(i), df.format(prix) }); 
         // crée un nouvelle ligne pour le prix et le nom et ajoute le tout au model
      }
      // Diviser le prix par 100 (string -> double -> /100 -> String)
      model.addRow(new Object[] { "Total",df.format(Panier.getPrixPanier() / 100.0) });
      // add row ajoute une ligne
      // affiche le prix total avec un format
      table.setRowHeight(50);// défini la hauteur
      table.getColumnModel().getColumn(0).setPreferredWidth(100);// defini la
                                                                 // largeur
      //table.getColumnModel().getColumn(1).setMaxWidth(150);

      // Mettre une scroll bar dans la jtable du panier
      JScrollPane scrollpane = new JScrollPane(table);
      scrollpane.setViewportView(table);
      scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      
      JPanel panel = new JPanel();
      //panel.setMaximumSize(new Dimension(500,2000));
      //panel.setLayout(new BorderLayout());
      //panel.add(table, BorderLayout.NORTH);
      panel.add(scrollpane);
      getMainPanel().afficherPanel(panel);
   }
}
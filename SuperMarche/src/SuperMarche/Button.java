package isn;
import java.awt.event.ActionListener;

public abstract class Button implements ActionListener {
   
   // declare une variable pour y stocker un objet de type fenetre magasin
   private FenetreMagasin fenetre; 

   public FenetreMagasin getMainPanel() { // methode pour recuperer la fenetre magasin 
      return fenetre; 
   }

   public void setMainPanel(FenetreMagasin mainPanel) { // methode pour stocker fenetre magasin
      this.fenetre = mainPanel;
   }

   public Button(FenetreMagasin pan) { // constructeur
      this.fenetre = pan; 
   }

}
// classe abstraite 
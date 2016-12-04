package isn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Caisse {
	public Caisse() {
	     if (MainBDProgram.debug) {System.out.println("caisseMonaie:"+caisseMonaie[0][0]+","+caisseMonaie[0][1]);};
	     if (MainBDProgram.debug) {System.out.println("caisseMonaie:"+caisseMonaie[0][0]+","+caisseMonaie.length);};
	  }


 	 static private int caisseMonaie[][] = { {50000,1}, {20000,2}, {10000,10}, {5000,10} , {2000,10}, {1000,10},
 	                                         {500,10}, {200,10}, {100,10}, {50,10}, {20,10}, {10,10}, {5,10},
 	                                         {2,10},{ 1,10} };
 
   public static int ajouteCaisse(int billet){  
      for (int i=0; i<caisseMonaie.length;i++) {// examine dans l'ordre du tableau
         if (caisseMonaie[i][0]==billet) {// si le billet correspond
            caisseMonaie[i][1]+=1;// ajoute le billet a la caisse
            
            if (MainBDProgram.debug) {
               System.out.println("caisseMonaie bcle: "+ caisseMonaie[i][0]);
               System.out.println("caisseMonaie bcle: "+ caisseMonaie[i][1]);    
            };
            
            return 0;//retourne ok (0=ok)
         }  
      }
      if (MainBDProgram.debug) {System.out.println("billet: "+billet+" pas trouve");};
      
      return -2; // creer fenetre d'erreur 'billet inconnue' sur cet erreur code
      
    }
     
   
   public static int enleveCaisse(int billet) {  
      for (int i=0; i<caisseMonaie.length;i++) {
         if (caisseMonaie[i][0]==billet) {
            if (caisseMonaie[i][1]>0) { // si il reste des billets
               caisseMonaie[i][1]-=1;// enleve 1 billet a la caisse 
               return 0;
            } else {//si il en reste pas
               System.out.println("Caisse vide pour billet:"+billet);
                return -1; // passer au billet suivant DANS le rendu de monaie sur cet erreur code
            }
         }     
      }
      
      System.out.println("billet: "+billet+" pas trouve");
      return -2; // creer fenetre d'erreur 'billet inconnue' sur cet erreur code
   }
   // rend le contenu de la caisse en string
	public static String contenuCaisse() {
	   String contenuCaisse="";
	   for (int i=0; i<caisseMonaie.length;i++) {
	      contenuCaisse=contenuCaisse+String.valueOf(caisseMonaie[i][0]/100.0)+"€ : "+String.valueOf(caisseMonaie[i][1])+"\n";
	   }
	return contenuCaisse; 
	}
	}
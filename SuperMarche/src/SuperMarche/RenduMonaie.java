package isn;
public class RenduMonaie {
   static private int listeMonaie[] = { 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5,
                                       2, 1 };// liste des billet et pièce en centime

   public static String calculMonaie(double monaieARendre) {

      String listBillets = "";// liste billet vide
      // monaieARendre*=100; // le prix du pannier x100 pour qu'il soit en
      // centime
      for (int billet : listeMonaie) { // Pour tous les billets de liste monnaie
                                       // en commencant par le plus gros
         while (monaieARendre - billet >= 0) { // si le billet est plus petit on
                                               // rentre dans la boule sinon
                                               // passe au billet suivent
            if (MainBDProgram.debug) {System.out.println(monaieARendre);}
            
            int status = Caisse.enleveCaisse(billet);// appelle la methode pour enlever le billet
           
            if (MainBDProgram.debug) {System.out.println("status:"+status);}
            
            if (status==-1) break; // si la caisse n'a plus ce billet on sort du while et on continue avec des billets plus petits
            
              
            monaieARendre -= billet; // on enleve le prix du billet
            if (billet > 99) { // si le billet est supérieur à 99 centime
               listBillets += String.valueOf(billet / 100) + "€ ";// on divise
                                                                  // le prix par
                                                                  // 100 et
                                                                  // ajoute euro
                                                                  // et on
                                                                  // transforme
                                                                  // en chaine
                                                                  // de
                                                                  // caractere
            } else if(billet==1){
               listBillets += String.valueOf(billet) + "ct "; 
            } 
            else{// sinon
               listBillets += String.valueOf(billet) + "cts ";// on ajoute cts
                                                              // et transforme
                                                              // en chaine de
                                                              // caractere
            }     
         }
         
      }
      if (MainBDProgram.debug) {System.out.println("billets rendu:"+listBillets+" reste pas rendu:"+monaieARendre/100);};
      if (monaieARendre!=0){listBillets=listBillets + "\n manque: "+monaieARendre/100+"€";}
      return listBillets; // rend une chaine de caractere et la listBillets
   }

}

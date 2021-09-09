
package e_commerce.domaine;

import java.util.HashSet;
import java.util.Set;


public class Basket {
    
    private static int  next_id ; // = 0 en premier temps 
    private int id ;    
    private  Set<LineBasket> lines_commandes; //hashset pas deux fois la même ligne de commande =>deux ligne de commande sont pareils si ils ont la même ref   
    private int montant ;
    private boolean validate ;
          
    public Basket(){       
        this.id=next_id++;
        lines_commandes =new HashSet<LineBasket>();
        this.montant=0;
        this.validate=false;
    }
    
    public int getId() {
        return id;
    }
    public int getMontant() {
        return montant;
    }
    public Set<LineBasket> getLines_commandes() {
        return lines_commandes;
    }
    public void validate(){
        this.validate=true;
    }
           
    public void addReference(Reference ref , int quantite ){
        
        if(!this.validate){
            LineBasket newLineBasket =new LineBasket(ref, quantite);

            if(this.lines_commandes.add(newLineBasket)==false){

                System.out.println("objet déjà existant");

                for(LineBasket one : lines_commandes){
                    if(one.equals(newLineBasket))
                        one.addQuantite(quantite);
                }
            }    
            this.montant=this.montant+newLineBasket.getMontant();
        }
        else 
            System.out.println("add Reference impossible panier déjà validé!");
    }
    
    public void removeReference(Reference ref){
        if(!this.validate){            
            LineBasket Line_to_remove =new LineBasket(ref);

            if(this.lines_commandes.contains(Line_to_remove)){
                
                for(LineBasket one : lines_commandes){
                    if(one.equals(Line_to_remove))                     
                        this.montant=this.montant-one.getMontant();
                }
                this.lines_commandes.remove(Line_to_remove);
                  
            }
            else
                System.out.println("l'objet n'existe pas ");
        }
        else 
           System.out.println("remove Reference impossible panier déjà validé!");                 
    } 

    @Override
    public String toString() {
        return "Basket{" + "id=" + id + ",\nlines_commandes=" + lines_commandes + ",\nmontant=" + montant + '}';
    }
    
    
    
    
    
    
    
}




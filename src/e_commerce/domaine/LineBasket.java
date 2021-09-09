
package e_commerce.domaine;


public class LineBasket {
    
    private Reference reference;
    private int quantitee;
    private int montant;

    
    public LineBasket(Reference reference, int quantitee) {
        this.reference = reference;
        this.quantitee= quantitee;
        this.montant=this.quantitee*this.reference.getPrix();
    }

    public LineBasket(Reference reference) {
        this.reference = reference;   
    }
    
    public int getMontant() {
        return montant;
    }
    
    public void addQuantite(int quantitee){
        this.quantitee=this.quantitee+quantitee;
        this.montant=this.quantitee*this.montant;
    } 
    
    //hashset implementer equals et hashCode
    @Override
    public boolean equals(Object obj) {
       if(!(obj instanceof LineBasket )||obj == null)
           return false;   
       
       LineBasket other = (LineBasket)obj;
       
       return this.reference.equals(other.reference);        
    }  
    @Override
    public int hashCode() {
        return reference.hashCode();
    }

    @Override
    public String toString() {
        return "\n  -LineBasket{" + "reference=" + reference + ", quantit\u00e9=" + quantitee + ", montant=" + montant + '}';
    }
}    
    
    
    
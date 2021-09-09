package e_commerce.domaine;

import java.util.Objects;

public class Reference {      
	private final String REF;
    private final String NOM ;
    private final String  DESCRIPTION;
    private final int PRIX ;

    public Reference(String ref, String nom, String description, int prix) {
        this.REF = ref;
        this.NOM = nom;
        this.DESCRIPTION = description;
        this.PRIX = prix;
    }
    public String getRef() {
        return REF;
    }
    public String getNom() {
        return NOM;
    }
    public String getDescription() {
        return DESCRIPTION;
    }
    public int getPrix() {
        return PRIX;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.REF);
        hash = 53 * hash + Objects.hashCode(this.NOM);
        hash = 53 * hash + Objects.hashCode(this.DESCRIPTION);
        hash = 53 * hash + this.PRIX;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reference other = (Reference) obj;
        if (!Objects.equals(this.REF, other.REF)) 
            return false;       
        if (!Objects.equals(this.NOM, other.NOM)) 
            return false;     
        if (!Objects.equals(this.DESCRIPTION, other.DESCRIPTION)) 
            return false;    
        if (this.PRIX != other.PRIX) 
            return false;
        return true;
    }
}
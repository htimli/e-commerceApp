
package e_commerce;

import e_commerce.Infra.*;
import e_commerce.application.PanierService;
import e_commerce.domaine.*;
import e_commerce.ui.CLI;


public class Main {
    
    
    public static void main(String[] args) {

        Reference ref0 = new Reference("ref0","iphone6", "lolol", 400);
        Reference ref1 = new Reference("ref1","iphone7", "lala", 800);
        Reference ref3 = new Reference("ref3","iphoneX", "lala", 600);
        
        
    
        BasketRepository repository = new BasketRepositoryInMemory();
        
         
         PanierService panierService= new PanierService(repository);
         int id_panier = panierService.createNewBasket();
         panierService.add_product_to_basket(id_panier, ref0,3);
         panierService.add_product_to_basket(id_panier, ref0,1);
         panierService.add_product_to_basket(id_panier, ref1,2);
         panierService.add_product_to_basket(id_panier, ref3,1);
         
        // panierService.remove_product_in_basket(id_panier, ref3);
         
         System.out.println(panierService.get_All_products_in_basket(id_panier));
         
         //System.out.println(repository.findById(id_panier));
        
    	
    	/*
    	BasketRepository repository = new BasketRepositoryInMemory();
    	PanierService panierService = new PanierService(repository);
    	
    	CLI cli = new CLI(panierService);
    	cli.createOrLoadBasket();
    	
        */
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package e_commerce.Infra;

import e_commerce.domaine.Basket;
import e_commerce.domaine.BasketRepository;
import java.util.HashMap;
import java.util.Map;


public class BasketRepositoryInMemory implements BasketRepository {
    
    private Map<Integer,Basket>  baskets ;
    

    public BasketRepositoryInMemory() {
        this.baskets = new HashMap<Integer,Basket>();
    }
      
    @Override
    public  Basket findById(int id){  
       return baskets.get(id);       
    }
    @Override
    public void save(Basket basket){
        baskets.put(basket.getId(), basket);
    }
    @Override
    public void delete(Basket basket){   	
    	baskets.remove(basket.getId());
    }
	@Override
	public void update(Basket basket) {
		if(baskets.replace(basket.getId(), basket)==null)
			System.out.println("basket not found to update");
		
	}
    
            
    
}

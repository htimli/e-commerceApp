package e_commerce.application;

import java.util.Set;
import e_commerce.domaine.*;

public class PanierService {
	
	private PanierFactory factory ;
	private BasketRepository repository ;
	private CommandQueue commands;
	private Worker worker;
	
	private Basket cache;
	
	public PanierService(BasketRepository basketRepository) {		
		this.factory = new PanierFactory();
		this.cache = null; 
		this.repository = basketRepository;
		this.commands = new CommandQueue();
		this.worker= new Worker(commands);
		this.worker.start();		
	}	
	//commande
	public int createNewBasket() { 
		cache = factory.createBasket() ;
		repository.save(cache);
		return cache.getId();		
	}
	public void deleteBasket(int basketId) {
		if(cache.getId() != basketId)
			cache = repository.findById(basketId);
		
		 if(cache!=null) {
			 repository.delete(cache);
			 this.cache=null;
		 }
	}
	public void add_product_to_basket(int basketId,Reference ref,int quantite) {		
		if(cache.getId() != basketId)
			cache = repository.findById(basketId);
		
		this.commands.pushCommand(new AddProductCommand(ref, cache,this.repository,quantite));
	}
	public void remove_product_in_basket(int basketId,Reference ref) {
		if(cache.getId() != basketId)
			cache = repository.findById(basketId);
		
		cache.removeReference(ref);
		repository.update(cache);
	}
	//query
	public Set<LineBasket> get_All_products_in_basket(int basketId){	
		if(cache.getId() != basketId)
			cache = repository.findById(basketId);
		return cache.getLines_commandes();
	}
}
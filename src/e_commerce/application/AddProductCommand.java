package e_commerce.application;


import e_commerce.domaine.Basket;
import e_commerce.domaine.BasketRepository;
import e_commerce.domaine.Reference;

public class AddProductCommand extends Command {
	
	private Reference ref;
	private Basket basket;
	private int quantite;
	private BasketRepository repository ;
	
	public AddProductCommand(Reference ref,Basket basket,BasketRepository repository ,int quantite)
	{
		this.basket = basket;
		this.ref=ref;
		this.quantite=quantite;
		this.repository= repository;		
	}
	
	@Override
	public void execute() {	
		this.basket.addReference(ref, quantite);
		this.repository.update(basket);		
	}

}

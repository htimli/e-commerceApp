package e_commerce.ui;


import java.util.Scanner;

import e_commerce.application.PanierService;


public class CLI {
	
	
	private PanierService service;
	private int BasketId;
	
	public CLI(PanierService panierService) {
		this.service = panierService;		
	}

	public void createOrLoadBasket() {
		boolean done = false ; 
		
		Scanner clavier = new Scanner(System.in);
		
		while(!done) {
			System.out.println("type (1) to create a game or (2) to find an existing Basket: ");
			
			String answer = clavier.nextLine();
			int intAnswer = Integer.parseInt(answer);
			if(intAnswer == 1 ) {
				this.BasketId=this.service.createNewBasket();
				System.out.println("Your Basket is created");
				done = true;
				
			}
			else if(intAnswer ==2 ) {
				System.out.println("Enter a basket Id : ");
				String answerGameId = clavier.nextLine();
				this.BasketId = Integer.parseInt(answerGameId);
				this.service.get_All_products_in_basket(this.BasketId);
				System.out.println("Your game has been found");	
				done=true;
			}
			else{
				System.out.println("Error !");
			}
		}
		
		
	}
}

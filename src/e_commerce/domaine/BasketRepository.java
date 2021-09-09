/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package e_commerce.domaine;


public interface BasketRepository {
    
    abstract Basket findById(int id);
    abstract void save(Basket basket);
    abstract void delete(Basket basket);
    abstract void update(Basket basket);
    
    
}

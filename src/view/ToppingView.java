/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Topping;

/**
 *
 * @author Victor
 */
public class ToppingView
{
    private Topping topping;

    public ToppingView(Topping topping)
    {
        this.topping = topping;
    }
    
    public String displayTopping()
    {
        return this.topping.getNombre() + "(" + this.topping.getCosto() + ") ";
    }
}

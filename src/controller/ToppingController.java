package controller;


import model.Bebida;
import model.Topping;
import view.ToppingView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class ToppingController
{
    private Topping model;
    private ToppingView view;

    public ToppingController(Topping model, ToppingView view)
    {
        this.model = model;
        this.view = view;
    }

    public Topping getModel()
    {
        return this.model;
    }
    
    public String getNombre()
    {
        return this.model.getNombre();
    }
    
    public String getDescripcion()
    {
        return this.model.getDescripcion();
    }
    
    public int getCosto()
    {
        return this.model.getCosto();
    }
    
    public void updateView()
    {
        // we rip
    }
    
}

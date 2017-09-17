package controller;


import java.util.ArrayList;
import model.Bebida;
import model.Topping;
import view.BebidaView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class BebidaController
{
    private Bebida model;
    private BebidaView view;

    public BebidaController(Bebida model, BebidaView view)
    {
        this.model = model;
        this.view = view;
    }
    
    public void setBebidaNombre(String nombre)
    {
        this.model.setNombre(nombre);
    }
    
    public String getBebidaNombre()
    {
        return this.model.getNombre();
    }
    
    public void setBebidaDescripcion(String descripcion)
    {
        this.model.setDescripcion(descripcion);
    }
    
    public String getBebidaDescripcion()
    {
        return this.model.getDescripcion();
    }
    
    public void setBebidaCosto(int costo)
    {
        this.model.setCosto(costo);
    }
    
    public int getBebidaCosto()
    {
        return this.model.getCosto();
    }
    
    public void addTopping(ToppingController topping)
    {
        this.model.addTopping(topping.getModel());
    }
    
    public boolean removeTopping(Topping topping)
    {
        return this.model.removeTopping(topping);
    }
    
    public int sizeExtras()
    {
        return this.model.sizeExtras();
    }
    
    public ArrayList<Topping> getToppings()
    {
        return this.model.getToppings();
    }
    
    public void updateBebidaView()
    {
        // we rip
    }
}

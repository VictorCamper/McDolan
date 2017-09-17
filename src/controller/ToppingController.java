package controller;

import model.Topping;
import view.ToppingView;

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

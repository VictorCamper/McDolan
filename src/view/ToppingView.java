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

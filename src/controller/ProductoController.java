package controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import model.Topping;

/**
 *
 * @author Victor
 */
public class ProductoController
{
    private SimpleStringProperty bebida;
    private SimpleStringProperty descripcion;
    private SimpleStringProperty precioBase;
    private SimpleStringProperty extras;
    
    private BebidaController bebidaController;
    private ToppingController toppingController;

    public ProductoController(BebidaController bebida, ToppingController topping)
    {
        this.bebidaController = bebida;
        this.toppingController = topping;
        this.bebida = new SimpleStringProperty(bebidaController.getBebidaNombre());
    }

    public String getBebida()
    {
        return this.bebida.get();
    }
    
    public void setBebida(SimpleStringProperty bebida)
    {
        this.bebidaController.setBebidaNombre(bebida.get());
    }

    public String getDescripcion()
    {
        return this.bebidaController.getBebidaDescripcion();
    }

    public void setDescripcion(SimpleStringProperty descripcion)
    {
        this.bebidaController.setBebidaDescripcion(descripcion.get());
    }

    public String getPrecioBase()
    {
        return "$" + this.bebidaController.getBebidaCosto();
    }

    public void setPrecioBase(SimpleIntegerProperty precioBase)
    {
        this.bebidaController.setBebidaCosto(precioBase.get());
    }

    public String getExtras()
    {
        String extras = "";
        boolean aux = false;
        for (Topping topping : this.bebidaController.getToppings())
        {
            if(aux)
                extras += "\n";
            extras += topping.getNombre() + " ($" + topping.getCosto() + ")";
            aux = true;
        }
        return extras;
    }
    
    public int getTotal()
    {
        int costo = 0;
        for (Topping topping : this.bebidaController.getToppings())
            costo += topping.getCosto();
        return costo + this.bebidaController.getBebidaCosto();
    }

    public void setExtras(SimpleStringProperty extras)
    {
        //
    }
    
    
}

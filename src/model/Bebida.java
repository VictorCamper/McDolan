package model;


import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Bebida
{
    private String nombre;
    private String descripcion;
    private int costo;
    private ArrayList<Topping> extras;
    
    public Bebida(String nombre, String descripcion, int costo)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.extras = new ArrayList<>();
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public int getCosto()
    {
        int extraCost = 0;
        
        for (Topping extra : extras)
            extraCost += extra.getCosto();
        return this.costo + extraCost;
    }

    public void setCosto(int costo)
    {
        this.costo = costo;
    }
    
    public void addTopping(Topping topping)
    {
        this.extras.add(topping);
    }
    
    public boolean removeTopping(Topping topping)
    {
        return this.extras.remove(topping);
    }
    
    public ArrayList<Topping> getToppings()
    {
        return this.extras;
    }
    
    public int sizeExtras()
    {
        return this.extras.size();
    }
}

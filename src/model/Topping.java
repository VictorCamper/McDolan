package model;

/**
 *
 * @author Victor
 */
public class Topping
{
    private String nombre;
    private String descripcion;
    private int costo;

    public Topping(String nombre, String descripcion, int costo)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
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
        return costo;
    }

    public void setCosto(int costo)
    {
        this.costo = costo;
    }
    
    
}

package view;

import model.Bebida;

/**
 *
 * @author Victor
 */
public class BebidaView
{
    private Bebida bebida;

    public BebidaView(Bebida bebida)
    {
        this.bebida = bebida;
    }
    
    public String displayBebidaNombre()
    {
        return this.bebida.getNombre();
    }
    
    public String displayBebidaDesc()
    {
        return this.bebida.getDescripcion();
    }
    
    public String displayBebidaCosto()
    {
        return (new Integer(this.bebida.getCosto())).toString();
    }
}

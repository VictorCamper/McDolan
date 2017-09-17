package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Bebida;
import model.Topping;
import view.BebidaView;
import view.ToppingView;
/**
 *
 * @author Victor
 */
public class DBConnection
{

    private static Connection connection = null;
    
    public static Connection getInstance()
    {
        if(DBConnection.connection != null)
        {
            return DBConnection.connection;
        }
        else
        {
            try
            {
                DBConnection.connection = DBConnection.connect();
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
            return DBConnection.connection;
        }
    }
    
    private static Connection connect() throws SQLException
    {
        Connection conn = null;
        
        try 
        {
            String url = "jdbc:sqlite:./bd/McDolan.db";
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite hsa been established");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    private static void closeConnection(Connection conn)
    {
        try
        {
            if(conn != null)
                conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertBebida(String nombre, String descripcion, int costo)
    {
        String sql = "INSERT INTO bebida(nombre,descripcion,costo) VALUES(?,?,?) ";
        Connection conn = DBConnection.getInstance();
        try
        {
            //conn = DBConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.setInt(3, costo);
            pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        DBConnection.closeConnection(conn);
    }

    public static void insertTopping(String nombre, String descripcion, int costo)
    {
        String sql = "INSERT INTO topping(nombre,descripcion, costo) VALUES (?,?,?)";
        Connection conn = DBConnection.getInstance();
        
        try
        {
            //conn = DBConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.setInt(3, costo);
            pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        DBConnection.closeConnection(conn);
    }
    
    public static ArrayList<String> selectBebidaNombre()
    {
        String sql = "SELECT id, nombre, costo FROM bebida";
        Connection conn = DBConnection.getInstance();
        try 
        {
            //conn = DBConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<String> nombres = new ArrayList<>();
            
            while(rs.next()) {
                String element = rs.getInt("id") + ":" + " " + rs.getString("nombre") + " ( $" + rs.getInt("costo") + " )";
                nombres.add(element);
            }
            return nombres;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        DBConnection.closeConnection(conn);
        return null;
    }

    public static ArrayList<String> selectToppingNombre()
    {
        String sql = "SELECT id, nombre, costo FROM topping";
        Connection conn = DBConnection.getInstance();
        try 
        {
            //conn = DBConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<String> nombres = new ArrayList<>();
            
            while(rs.next()) {
                String element =  rs.getInt("id") + ":" + " " + rs.getString("nombre") + " ( $" + rs.getInt("costo") + " )";
                nombres.add(element);
            }
            return nombres;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        DBConnection.closeConnection(conn);
        return null;
    }
    
    public static BebidaController selectBebida(int idBebida)
    {
        String sql = "SELECT id, nombre, descripcion, costo FROM bebida WHERE id = ?";
        Connection conn = DBConnection.getInstance();
        try
        {
            //conn = DBConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idBebida);
            
            ResultSet rs = pstmt.executeQuery();
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            int costo = rs.getInt("costo");
            Bebida bebida = new Bebida(nombre, descripcion, costo);
            BebidaView view = new BebidaView(bebida);
            return new BebidaController(bebida, view);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        DBConnection.closeConnection(conn);
        
        return null;
    }

    public static ToppingController selectTopping(int idTopping)
    {
        String sql = "SELECT id, nombre, descripcion, costo FROM topping WHERE id = ?";
        Connection conn = DBConnection.getInstance();
        try
        {
            //conn = DBConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idTopping);
            
            ResultSet rs = pstmt.executeQuery();
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            int costo = rs.getInt("costo");
            Topping topping = new Topping(nombre, descripcion, costo);
            ToppingView view = new ToppingView(topping);
            return new ToppingController(topping, view);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        DBConnection.closeConnection(conn);
        
        return null;
    }

    
}

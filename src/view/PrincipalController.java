package view;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.ProductoController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class PrincipalController implements Initializable
{

    private static ObservableList productos = FXCollections.observableList(new ArrayList<ProductoController>());
    private static SimpleStringProperty costo = new SimpleStringProperty("$0");
    
    @FXML
    private MenuItem nuevaBebida;
    @FXML
    private MenuItem nuevoTopping;
    @FXML
    private Button botonAgregar;
    @FXML
    private TableColumn<ProductoController, String> bebidaCol;
    @FXML
    private TableColumn<ProductoController, String> descripcionCol;
    @FXML
    private TableColumn<ProductoController, String> costoCol;
    @FXML
    private TableColumn<ProductoController, String> toppingCol;
    @FXML
    private TableView<?> tabla;
    @FXML
    private Label costoTotal;
    
    //private static SimpleIntegerProperty costo = new SimpleIntegerProperty(0);
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      //  costoTotal.setLabelFor(costo);
        costoTotal.textProperty().bind(costo);
        tabla.setItems(productos);
        bebidaCol.setCellValueFactory(new PropertyValueFactory("bebida"));
        descripcionCol.setCellValueFactory(new PropertyValueFactory("descripcion"));
        costoCol.setCellValueFactory(new PropertyValueFactory("precioBase"));
        toppingCol.setCellValueFactory(new PropertyValueFactory("extras"));
    }    
    
    public static void addProducto(ProductoController producto)
    {
        int costo = 0;

        PrincipalController.productos.add(producto);
        
        for(Object prod : PrincipalController.productos)
            costo += ((ProductoController) prod).getTotal();
        //PrincipalController.costo.setValue(costo);
        System.out.println("costo :" + costo);
        //int actual = Integer.parseInt(PrincipalController.costo.get().substring(1));
        PrincipalController.costo.setValue("$"+ costo);
    }
    
    @FXML
    private void crearBebida()
    {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CrearBebida.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Crear nueva bebida");
            stage.setScene(new Scene(root1));  
            stage.setResizable(false);
            stage.show();
        }
        catch(Exception ex)
        {
             
        }
    }
    
    @FXML
    private void agregarBebida()
    {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/BebidaTopping.fxml"));
            BebidaToppingController controller = fxmlLoader.<BebidaToppingController>getController();
            
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Agregar nueva bebida");
            stage.setScene(new Scene(root1));  
            stage.setResizable(false);
            stage.show();
          }
         catch(Exception ex)
         {
             
         }
    }

    @FXML
    private void crearTopping(ActionEvent event)
    {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CrearTopping.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Crear nueva bebida");
            stage.setScene(new Scene(root1));  
            stage.setResizable(false);
            stage.show();
        }
        catch(Exception ex)
        {
             
        }
    }
}

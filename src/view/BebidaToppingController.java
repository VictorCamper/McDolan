/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BebidaController;
import controller.DBConnection;
import controller.ProductoController;
import controller.ToppingController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Topping;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class BebidaToppingController implements Initializable
{

    @FXML
    private Button aceptar;
    @FXML
    private Button cancelar;
    @FXML
    private ComboBox<?> comboBebida;
    @FXML
    private ComboBox<?> comboTopping;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ArrayList<String> bebidas = DBConnection.selectBebidaNombre();
        ObservableList list = FXCollections.observableList(bebidas);
        comboBebida.getItems().removeAll(comboBebida.getItems());
        comboBebida.getItems().addAll(list);
        
        ArrayList<String> toppings = DBConnection.selectToppingNombre();
        ObservableList toppingsList = FXCollections.observableList(toppings);
        toppingsList.add(0, "Sin agregados");
        comboTopping.getItems().removeAll(comboTopping.getItems());
        comboTopping.getItems().addAll(toppingsList);
        comboTopping.getSelectionModel().selectFirst();


    }    
    
    @FXML
    private void aceptarCotizacion(ActionEvent event)
    {
        BebidaController bebida = null;
        ToppingController topping = null;
        
        if(this.comboBebida.getValue() == null || this.comboTopping.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Debe seleccionar al menos la bebida");
            alert.showAndWait();
            return;
        }
        
        int idBebida = Integer.parseInt(comboBebida.getValue().toString().split(":")[0]);
        bebida = DBConnection.selectBebida(idBebida);
        
        if(!comboTopping.getValue().toString().equals("Sin agregados"))
        {
            int idTopping = Integer.parseInt(comboTopping.getValue().toString().split(":")[0]);
            topping = DBConnection.selectTopping(idTopping);
            bebida.addTopping(topping);
        }
        
        ProductoController producto;
        if(topping != null)
        {
            producto = new ProductoController(bebida, topping);
        }
        else 
        {
            producto = new ProductoController(bebida, new ToppingController(new Topping("", "", 0), null));
        }
        PrincipalController.addProducto(producto);
        this.cerrar();
    }

    private void cerrar()
    {
        Stage stage = (Stage) this.cancelar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void cancelar(ActionEvent event)
    {
        Stage stage = (Stage) this.cancelar.getScene().getWindow();
        stage.close();
    }    
}

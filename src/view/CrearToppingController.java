/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class CrearToppingController implements Initializable
{

    @FXML
    private Button botonAceptar;
    @FXML
    private Button botonCancelar;
    @FXML
    private TextField inputNombre;
    @FXML
    private TextArea inputDescripcion;
    @FXML
    private TextField inputCosto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void crearTopping(ActionEvent event)
    {
        if(this.inputNombre.getText().equals("") || this.inputDescripcion.getText().equals("") || this.inputCosto.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error en el ingreso de datos");
            alert.showAndWait();
        }
        else {
            String nombre = this.inputNombre.getText();
            String descripcion = this.inputDescripcion.getText();
            int costo = 0;
            try
            {
                costo = Integer.parseInt(this.inputCosto.getText());
            }
            catch(NumberFormatException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("El costo del agregado debe ser un valor entero");
                alert.showAndWait();
                this.cerrar();
                return;
            }
            if(costo > 0)
                controller.DBConnection.insertTopping(nombre, descripcion, costo);
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("El costo del agregado debe ser mayor que 0");
                alert.showAndWait();
                this.cerrar();
            }
            this.cerrar();;
        }
    }
    
    private void cerrar()
    {
        Stage stage = (Stage) this.botonCancelar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void cancelar(ActionEvent event)
    {
    }
    
}

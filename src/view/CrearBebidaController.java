/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DBConnection;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class CrearBebidaController implements Initializable
{

    @FXML
    private TextField inputNombre;
    @FXML
    private TextField inputCosto;
    @FXML
    private TextArea inputDescripcion;
    @FXML
    private Button botonAceptar;
    @FXML
    private Button botonCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void crearBebida(ActionEvent event)
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
                alert.setHeaderText("El costo de la bebida debe ser un valor entero");
                alert.showAndWait();
                Stage stage = (Stage) this.botonCancelar.getScene().getWindow();
                stage.close();
                return;
            }
            if(costo > 0)
                DBConnection.insertBebida(nombre, descripcion, costo);
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("El costo de la bebida debe ser un valor entero");
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
        Stage stage = (Stage) this.botonCancelar.getScene().getWindow();
        stage.close();
    }
    
}

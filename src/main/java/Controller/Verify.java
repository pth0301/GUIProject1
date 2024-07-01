package Controller;

import Features.Owner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Verify {

    @FXML
    private TextField ClientIDButton;

    @FXML
    private TextField SecreteIDButton;

    @FXML
    private TextField TenantIDButton;

    @FXML
    private Button VertifyButton;

    @FXML
    private Label clientIDError;

    @FXML
    private Label secreteIDError;

    @FXML
    private Label tenantIDError;



    private Owner owner = new Owner();

    public Verify(Owner owner){
        this.owner = owner;
    }
    public Verify(){

    }

    public Owner getOwner(){
        return owner;
    }

    @FXML
    void VertifyButtonClicked(ActionEvent event) {
        boolean valid = validateClientID(ClientIDButton.getText()) &&
                validateSecreteID(SecreteIDButton.getText()) &&
                validateTenantID(TenantIDButton.getText());
        if (valid) {
            // if IDs are correct, then switch to new scene
            try {
                // Load the To Channel scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Team.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) VertifyButton.getScene().getWindow();

                // Set the new scene
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        new TeamsController(validTenantId, validClientId, validSecretId);

    }


    @FXML
    void validateClientIDTyped(KeyEvent event) {
        validateClientID(ClientIDButton.getText()); // check the valid of Text is entered
    }

    @FXML
    void validateSecreteIDTyped(KeyEvent event) {
        validateSecreteID(SecreteIDButton.getText());
    }

    @FXML
    void validateTenantIDTyped(KeyEvent event) {
        validateTenantID(TenantIDButton.getText());
    }

    private boolean validateClientID(String clientID) {
        if (clientID == null || clientID.trim().isEmpty()) { // how to check validation
            clientIDError.setText("Please enter your clientID.");
            return false;
        }
        if (clientID.equals(validClientId)) {
            return true;
        }
        clientIDError.setText("Client ID is not correct.");
        return false;
    }

    private boolean validateSecreteID(String secreteID) {
        if (secreteID == null || secreteID.trim().isEmpty()) {
            secreteIDError.setText("Please enter your Secrete ID.");
            return false;
        }
        if (secreteID.equals(validSecretId)) {
            return true;
        }
        secreteIDError.setText("Secrete ID is not correct.");
        return false;
    }

    private boolean validateTenantID(String tenantID) {
        if (tenantID == null || tenantID.trim().isEmpty()) {
            tenantIDError.setText("Please enter your tenant ID.");
            return false;
        }
        if (tenantID.equals(validTenantId)) {
            return true;
        }
        tenantIDError.setText("Tenant ID is not correct.");
        return false;
    }

}

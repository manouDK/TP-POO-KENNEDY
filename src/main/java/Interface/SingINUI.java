package Interface;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.find.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingINUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Création de compte");

        // Création de la grille
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        //grid.setStyle("-fx-background-color: #87CEEB;"); // Fond bleu clair

        // Labels et champs de saisie
        Label nomLabel = new Label("Nom d'utilisateur:");
        TextField nomTextField = new TextField();

        Label PRELabel = new Label("Prenom d'utilisateur:");
        TextField PRETextField = new TextField();


        Label LocalisationLabel = new Label("Localisation:");
        TextField locTextField = new TextField();

        Label TelLabel = new Label("Telephone:");
        TextField TelTextField = new TextField();

        Label passLabel = new Label("Mot de passe:");
        PasswordField passField = new PasswordField();

        Label confirmPassLabel = new Label("Confirmer le mot de passe:");
        PasswordField confirmPassField = new PasswordField();

        // Bouton d'inscription
        Button registerButton = new Button("Créer un compte");
        Label messageLabel = new Label(); // Message de confirmation ou d'erreur

        // Bouton retour
        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #6A5ACD; -fx-text-fill: white; -fx-font-weight: bold;");
        backButton.setOnAction(e -> {
            try {
                AccueilUI accueilUI = new AccueilUI();
                accueilUI.start(primaryStage); // Retour à l'accueil
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Action sur le bouton d'inscription
        registerButton.setOnAction(e -> {
            String nom = nomTextField.getText();
            String prenom = PRETextField.getText();
            String Localisation = locTextField.getText();
            Integer Telephone = Integer.valueOf(TelTextField.getText());
            String password = passField.getText();
            String confirmPassword = confirmPassField.getText();
            Connection conn = DataBaseConnection.connect();
            UtilisateurDAO ooo = new UtilisateurDAO();

            if (nom.isEmpty() || prenom.isEmpty() || Localisation.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                messageLabel.setText("Veuillez remplir tous les champs.");
            } else if (!password.equals(confirmPassword)) {
                messageLabel.setText("Les mots de passe ne correspondent pas.");
            } else {
                if (ooo.insertUserIntoDatabase( nom,prenom, Localisation, Integer.valueOf(Telephone),  password)) {
                    messageLabel.setText("Compte créé avec succès !");
                    try {
                        MenuPrincipal menuPrincipal = new MenuPrincipal();
                        menuPrincipal.start(primaryStage); // Aller au menu principal
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    messageLabel.setText("Erreur lors de la création du compte.");
                }
            }
        });

        // Ajout des éléments à la grille
        grid.add(nomLabel, 0, 0);
        grid.add(nomTextField, 1, 0);
        grid.add(PRELabel, 0, 1);
        grid.add(PRETextField, 1, 1);
        grid.add(LocalisationLabel, 0, 2);
        grid.add(locTextField, 1, 2);
        grid.add(TelLabel, 0,3);
        grid.add(TelTextField, 1,3);
        grid.add(passLabel, 0, 4);
        grid.add(passField, 1, 4);
        grid.add(confirmPassLabel, 0, 5);
        grid.add(confirmPassField, 1, 5);
        grid.add(registerButton, 0, 6);
        grid.add(backButton, 0, 7);
        grid.add(messageLabel, 1, 8);

        VBox layout = new VBox(20);
        layout.getChildren().add(grid);
        layout.setAlignment(Pos.CENTER);

        // Création de la scène
        Scene scene = new Scene(layout, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
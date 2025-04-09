package Interface;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.find.DataBaseConnection;
import org.example.find.TelephoneDAO;

import java.sql.Connection;

public class TelephoneGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ajout Annonce de telepone");

        // Création de la grille
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        //grid.setStyle("-fx-background-color: #87CEEB;"); // Fond bleu clair

        // Labels et champs de saisie

        Label nomLabel = new Label("Nom");
        TextField nomTextField = new TextField();

        Label colorLabel = new Label("Couleur:");
        TextField colorTextField = new TextField();

        Label StockLabel = new Label("Stockage:");
        TextField StockTextField = new TextField();

        Label MarqueLabel = new Label("Marque:");
        TextField MarqueTextField = new TextField();

        // Bouton d'inscription
        Button registerButton = new Button("Ajouter l'annonce");
        Label messageLabel = new Label(); // Message de confirmation ou d'erreur

        // Bouton retour
        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #6A5ACD; -fx-text-fill: white; -fx-font-weight: bold;");
        backButton.setOnAction(e -> {
            try {
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.start(primaryStage); // Retour à l'accueil
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Action sur le bouton d'inscription
        registerButton.setOnAction(e -> {
            String Nom_Appareil = nomTextField.getText();
            String Couleur= colorTextField.getText();
            Integer Stockage = Integer.valueOf(StockTextField.getText());
            String Marque= MarqueTextField.getText();

            Connection conn = DataBaseConnection.connect();
            TelephoneDAO ppp = new TelephoneDAO();
            if (Nom_Appareil.isEmpty() || Couleur.isEmpty()||  Marque.isEmpty()) {
                messageLabel.setText("Les mots de passe ne correspondent pas.");
            } else {
                if (ppp.insererTelephone( Nom_Appareil, Couleur, Stockage,Marque)) {
                    messageLabel.setText("Annonce ajoutéé avec succès !");
                    try {
                        MenuPrincipal menuPrincipal = new MenuPrincipal();
                        menuPrincipal.start(primaryStage); // Aller au menu principal
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    messageLabel.setText("Erreur lors de l'ajout de l'annonce.");
                }
            }
        });

        // Ajout des éléments à la grille
        grid.add(nomLabel, 0, 0);
        grid.add(nomTextField, 1, 0);
        grid.add(colorLabel, 0, 1);
        grid.add(colorTextField, 1, 1);
        grid.add(StockLabel, 0,2);
        grid.add(StockTextField, 1,2);
        grid.add(MarqueLabel, 0,3);
        grid.add(MarqueTextField, 1,3);


        grid.add(registerButton, 1, 4);
        grid.add(backButton, 1, 5);
        grid.add(messageLabel, 1, 6);

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
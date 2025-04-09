package Interface;
import com.example.appareilsvoles.Ordinateur;
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
import org.example.find.OrdinateurDAO;
import org.example.find.DataBaseConnection;

import java.sql.Connection;

public class OrdinateurGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ajout Annonce d'Ordinateur");

        // Création de la grille
        GridPane grid = createGrid();

        // Création des éléments de l'interface avec PromptText
        TextField nomTextField = createTextField(grid, "Nom", 0, "MacBook Pro");
        TextField marqueTextField = createTextField(grid, "Marque", 1, "Apple");
        TextField modeleTextField = createTextField(grid, "Modèle", 2, "M1");
        TextField sysTextField = createTextField(grid, "Système d'Exploitation", 3, "macOS");
        TextField capTextField = createTextField(grid, "Capacité RAM", 4, "16 Go");
        TextField capDTextField = createTextField(grid, "Capacité Disque Dur", 5, "512 Go SSD");
        TextField proTextField = createTextField(grid, "Processeur", 6, "Apple M1");
        TextField porTextField = createTextField(grid, "Est Portable (true/false)", 7, " true");
        TextField tailTextField = createTextField(grid, "Taille Écran", 8, "13.3");
        TextField carteTextField = createTextField(grid, "Carte Graphique", 9, "Apple GPU");
        TextField stockTextField = createTextField(grid, "Stockage", 10, " 256");

        // Message de confirmation ou d'erreur
        Label messageLabel = new Label();

        // Boutons
        Button registerButton = createRegisterButton(primaryStage, nomTextField, marqueTextField, modeleTextField, sysTextField,
                capTextField, capDTextField, proTextField, porTextField,
                tailTextField, carteTextField, stockTextField, messageLabel);
        Button backButton = createBackButton(primaryStage);

        // Ajout des éléments à la grille
        grid.add(registerButton, 0, 11);
        grid.add(backButton, 0, 12);
        grid.add(messageLabel, 0, 13);

        // Création de la scène
        VBox layout = new VBox(20);
        layout.getChildren().add(grid);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        return grid;
    }

    private TextField createTextField(GridPane grid, String label, int row, String promptText) {
        Label newLabel = new Label(label + ":");
        TextField textField = new TextField();
        textField.setPromptText(promptText); // Ajout du PromptText
        grid.add(newLabel, 0, row);
        grid.add(textField, 1, row);
        return textField;
    }

    private Button createRegisterButton(Stage primaryStage, TextField nomTextField, TextField marqueTextField, TextField modeleTextField, TextField sysTextField,
                                        TextField capTextField, TextField capDTextField, TextField proTextField, TextField porTextField,
                                        TextField tailTextField, TextField carteTextField, TextField stockTextField, Label messageLabel) {
        Button registerButton = new Button("Ajouter l'annonce");
        registerButton.setOnAction(e -> {
            String nom = nomTextField.getText();
            String marque = marqueTextField.getText();
            String modele = modeleTextField.getText();
            String systemeEXploitation = sysTextField.getText();
            Integer capaciteRam = Integer.valueOf(capTextField.getText());
            Integer capaciteDisqueDur = Integer.valueOf(capDTextField.getText());
            String processeur = proTextField.getText();
            Boolean estPortable = Boolean.valueOf(porTextField.getText());
            Double tailleEcran = Double.valueOf(tailTextField.getText());
            String carteGraphique = carteTextField.getText();
            Integer Stockage = Integer.valueOf(stockTextField.getText());

            Ordinateur ppp = new Ordinateur();
            if (nom.isEmpty() || marque.isEmpty() || modele.isEmpty() || systemeEXploitation.isEmpty() || processeur.isEmpty()) {
                messageLabel.setText("Veuillez remplir tous les champs obligatoires.");
            } else {
                Connection conn = DataBaseConnection.connect();
                if (ppp.insererOrdinateur(nom, marque, modele, Integer.valueOf(Stockage),systemeEXploitation, capaciteRam, capaciteDisqueDur, processeur, estPortable, tailleEcran, carteGraphique)) {
                    messageLabel.setText("Annonce ajoutée avec succès !");
                    // Retour au menu principal
                    try {
                        MenuPrincipal menuPrincipal = new MenuPrincipal();
                        menuPrincipal.start(primaryStage);
                        primaryStage.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    messageLabel.setText("Erreur lors de l'ajout de l'annonce.");
                }
            }
        });
        return registerButton;
    }

    private Button createBackButton(Stage primaryStage) {
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
        return backButton;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
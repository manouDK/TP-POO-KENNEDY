package Interface;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AccueilUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création du message de bienvenue, placer le message à la bonne place
        VBox welcomeBox = new VBox(50);
        welcomeBox.setAlignment(Pos.CENTER);
        welcomeBox.setPadding(new Insets(100));

        // Message de bienvenue
        javafx.scene.control.Label welcomeLabel = new javafx.scene.control.Label("Recherche d'appareils volés, téléphone, machine");
        // appliquer le style sur les message de bienvenue
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;-fx-style:italic;");

        // Boutons S'inscrire et Se connecter
        Button signUpButton = new Button("  S'inscrire");
        Button loginButton = new Button("  Se connecter");
        signUpButton.setStyle("-fx-font-size: 15px; -fx-text-fill: #6a1b9a;"); // Violet foncé
        loginButton.setStyle("-fx-font-size: 15px; -fx-text-fill: #6a1b9a;"); // Violet foncé

        // Actions des boutons
        signUpButton.setOnAction(e -> {
            // Lancer l'interface d'inscription (SignUpUI)
            SingINUI singINUI = new SingINUI();
            try {

                singINUI.start(primaryStage); // Lancer l'interface d'inscription

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        loginButton.setOnAction(e -> {
            // Lancer l'interface de connexion (LoginUI)
            LoginUI loginUI = new LoginUI();
            try {
                loginUI.start(primaryStage); // Lancer l'interface de connexion

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        // Ajouter le message et les boutons dans le VBox, ordre d'affichage
        //on fait d'abord le bouton de bienvenue
        welcomeBox.getChildren().addAll(welcomeLabel, signUpButton, loginButton);

        // Mise en page générale
        BorderPane root = new BorderPane();
        root.setCenter(welcomeBox);
        Image backgroundImage = new Image(getClass().getResource("/Back.png").toExternalForm());

        BackgroundImage bgImage = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        root.setBackground(new Background(bgImage));

        // Création et affichage de la scène
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("Page d'Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package Interface;
import com.example.appareilsvoles.UtilisateurDAO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.find.DataBaseConnection;
import org.example.find.UtilisateurDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connexion à l'app :  Utilisateur");

        // --- Création de la grille de connexion ---
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        Label userLabel = new Label("Nom de l'utilisateur:");
        TextField userTextField = new TextField();
        userTextField.setPromptText("nom utilisateur");

        Label passLabel = new Label("Mot de passe:");
        PasswordField passField = new PasswordField();
        passField.setPromptText("mot de passe");

        Button loginButton = new Button("Se connecter");
        loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        loginButton.setPadding(new Insets(10));

        Label messageLabel = new Label();

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold;");
        backButton.setPadding(new Insets(10));

        // Action du bouton retour
        backButton.setOnAction(e -> {
            try {
                AccueilUI mainUI = new AccueilUI();
                mainUI.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        UtilisateurDAO lll = new UtilisateurDAO();

        // Action du bouton connexion
        loginButton.setOnAction(e -> {
            String username = userTextField.getText();
            String password = passField.getText();

            if (lll.verifierIdentifiants(username, password)) {
                messageLabel.setText("✅ Connexion réussie !");
                messageLabel.setStyle("-fx-text-fill: green;");
                try {
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.start(primaryStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                messageLabel.setText("❌ Identifiants incorrects !");
                messageLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            }
        });

        // Ajout des éléments à la grille
        grid.add(userLabel, 0, 0);
        grid.add(userTextField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginButton, 0, 2);
        grid.add(backButton, 1, 2);
        grid.add(messageLabel, 1, 4);

        grid.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20);
        layout.getChildren().add(grid);
        layout.setAlignment(Pos.CENTER);

        // --- Ajout de l'image de fond ---
        Image backgroundImage = new Image(getClass().getResource("/Back.png").toExternalForm());
        BackgroundImage bgImage = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(800, 800, true, true, true, false)
        );

        StackPane root = new StackPane();
        root.setBackground(new Background(bgImage));
        root.getChildren().add(layout); // ajout du layout sur le fond

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
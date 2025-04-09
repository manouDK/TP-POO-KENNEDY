package Interface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.example.find.*;

        import java.util.List;

public class ShowOrdi extends Application {

    @Override
    public void start(Stage primaryStage) {
        OrdinateurDAO ordinateurDAO = new OrdinateurDAO();
        VBox vbox = new VBox(12); // Espacement vertical
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #f3e5f5;"); // Violet très clair

        List<String> ordinateurs = ordinateurDAO.showOrdinateurs();

        // Créer un bouton retour
        Button retourButton = new Button("Retour vers Menu Principal");
        retourButton.setStyle("-fx-font-size: 14px; -fx-background-color: #8e24aa; -fx-text-fill: white;");
        retourButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Action de retour : on revient à l'écran principal (MenuPrincipalDAO)
                MenuPrincipal menu = new MenuPrincipal();
                try {
                    menu.start(primaryStage); // Remplacer par le lancement de la fenêtre principale
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Ajouter le bouton retour en haut de la VBox
        vbox.getChildren().add(0, retourButton);

        // Créer un ScrollPane pour afficher les annonces
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // Barre de défilement verticale
        scrollPane.setFitToWidth(true); // Ajuste la largeur du contenu au ScrollPane

        VBox annoncesBox = new VBox(12); // Conteneur pour les annonces
        annoncesBox.setPadding(new Insets(10));

        // Pour chaque ordinateur, créer une annonce avec un bouton "Signaler"
        for (String ordinateur : ordinateurs) {
            HBox annonceBox = createAnnonceBox(ordinateur);
            annoncesBox.getChildren().add(annonceBox);
        }

        scrollPane.setContent(annoncesBox); // Mettre les annonces dans le ScrollPane

        // Ajouter le ScrollPane à la VBox principale
        vbox.getChildren().add(scrollPane);

        Scene scene = new Scene(vbox, 800, 800);
        primaryStage.setTitle("Ordinateurs disponibles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Créer un bloc d'annonce pour chaque ordinateur avec un bouton "Signaler"
    private HBox createAnnonceBox(String ordinateur) {
        // Label avec les informations de l'ordinateur
        Label label = new Label(" " + ordinateur);
        label.setStyle("-fx-font-size: 15px; -fx-text-fill: #6a1b9a;"); // Violet foncé

        // Créer un bouton "Signaler"
        Button signalerButton = new Button("Signaler");
        signalerButton.setStyle("-fx-font-size: 14px; -fx-background-color: #d32f2f; -fx-text-fill: white;");
        signalerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Action à effectuer lorsque le bouton "Signaler" est cliqué
                // Exemple d'affichage d'un message d'alerte
                System.out.println("L'ordinateur " + ordinateur + " a été signalé.");
            }
        });

        // Créer un HBox pour l'annonce
        HBox hbox = new HBox(10, label, signalerButton);
        hbox.setPadding(new Insets(20));
        hbox.setSpacing(15); // Espacement plus grand entre le texte et le bouton
        hbox.setBackground(new Background(new BackgroundFill(Color.web("#ede7f6"), new CornerRadii(20), Insets.EMPTY))); // Fond violet doux
        hbox.setBorder(new Border(new BorderStroke(
                Color.web("#7b1fa2"), // Bordure violet foncé
                BorderStrokeStyle.SOLID,
                new CornerRadii(20),
                new BorderWidths(5)
        )));

        // Ajuster la taille et la visibilité du texte
        label.setMaxWidth(600); // Limiter la largeur du label pour éviter qu'il dépasse
        label.setWrapText(true); // Permet de faire passer le texte à la ligne

        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
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
import org.example.find.TelephoneDAO;

import java.util.List;

public class ShowPhone extends Application {

    @Override
    public void start(Stage primaryStage) {
        TelephoneDAO telephoneDAO = new TelephoneDAO();
        VBox vbox = new VBox(12); // Espacement vertical
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #f3e5f5;"); // Violet très clair

        // Créer le bouton retour
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

        // Créer un ScrollPane pour afficher les téléphones
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // Barre de défilement verticale
        scrollPane.setFitToWidth(true); // Ajuste la largeur du contenu au ScrollPane

        VBox phoneBoxContainer = new VBox(12); // Conteneur pour les téléphones
        phoneBoxContainer.setPadding(new Insets(10));

        List<String> telephones = telephoneDAO.showTelephones();

        // Pour chaque téléphone, créer une boîte avec le bouton "Signaler"
        for (String phone : telephones) {
            HBox phoneBox = createPhoneBox(phone);
            phoneBoxContainer.getChildren().add(phoneBox);
        }

        scrollPane.setContent(phoneBoxContainer); // Mettre les téléphones dans le ScrollPane
        vbox.getChildren().add(scrollPane); // Ajouter le ScrollPane à la VBox principale

        Scene scene = new Scene(vbox, 800, 800);
        primaryStage.setTitle("Téléphones disponibles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createPhoneBox(String phone) {
        // Label avec les informations du téléphone
        Label label = new Label("  " + phone);
        label.setStyle(
                "-fx-font-size: 15px;\n" +               // Taille du texte
                        "-fx-text-fill: #6a1b9a;\n" +             // Couleur violet foncé
                        "-fx-font-weight: bold;\n"                // Gras pour le texte
        );

        // Créer un bouton "Signaler"
        Button signalerButton = new Button("Signaler");
        signalerButton.setStyle("-fx-font-size: 14px; -fx-background-color: #d32f2f; -fx-text-fill: white;");
        signalerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Action à effectuer lorsque le bouton "Signaler" est cliqué
                System.out.println("Le téléphone " + phone + " a été signalé.");
            }
        });

        // Créer une HBox pour la présentation du téléphone et du bouton "Signaler"
        HBox hbox = new HBox(10, label, signalerButton);
        hbox.setPadding(new Insets(12));            // Padding autour du contenu
        hbox.setSpacing(10);                        // Espacement entre le texte et le bouton
        hbox.setBackground(new Background(
                new BackgroundFill(Color.web("#ede7f6"), new CornerRadii(10), Insets.EMPTY)  // Fond violet doux
        ));
        hbox.setBorder(new Border(new BorderStroke(
                Color.web("#7b1fa2"),                   // Bordure violet foncé
                BorderStrokeStyle.SOLID,
                new CornerRadii(10),                    // Coins arrondis
                new BorderWidths(2)                     // Épaisseur de la bordure
        )));

        // Retourner le HBox créé
        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
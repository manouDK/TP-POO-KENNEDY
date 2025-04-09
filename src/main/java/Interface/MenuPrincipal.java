package Interface;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MenuPrincipal extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Création des menus
        MenuBar menuBar = new MenuBar();

        Menu notifications = new Menu("Notifications");
        Menu addAnnonce = new Menu("Ajouter une annonce");
        Menu viewAnnonces = new Menu("Voir les annonces");
        Menu Help = new Menu("Aide");
        Menu Profil = new Menu("Profil");

        MenuItem addTelephone = new MenuItem("Ajouter téléphone");
        MenuItem addOrdi = new MenuItem("Ajouter ordinateur");
        MenuItem seePhone = new MenuItem("Voir les téléphones");
        MenuItem seeOrdi = new MenuItem("Voir les ordinateurs");

        // Ajout des items au menu
        addAnnonce.getItems().addAll(addTelephone, new SeparatorMenuItem(), addOrdi);
        viewAnnonces.getItems().addAll(seePhone, new SeparatorMenuItem(), seeOrdi);
        menuBar.getMenus().addAll(Profil,notifications, addAnnonce, viewAnnonces,Help);

        // Initialisation des classes à afficher
        ShowPhone pp = new ShowPhone();
        ShowOrdi oo = new ShowOrdi();
        TelephoneGUI telephoneGUI = new TelephoneGUI();
        OrdinateurGUI ordinateurGUI = new OrdinateurGUI();

        // Actions des boutons de menu
        addTelephone.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setResizable(false);
            telephoneGUI.start(stage);
            primaryStage.close();
        });

        addOrdi.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setResizable(false);
            ordinateurGUI.start(stage);
            primaryStage.close();
        });

        seePhone.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setResizable(false);
            pp.start(stage);
            primaryStage.close();
        });

        seeOrdi.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setResizable(false);
            oo.start(stage);
            primaryStage.close();
        });

        // Bouton de déconnexion
        Button deconnecterButton = new Button("Déconnexion");
        deconnecterButton.setStyle("-fx-background-color: #6A5ACD; -fx-text-fill: white; -fx-font-weight: bold;");
        deconnecterButton.setOnAction(e -> {
            try {
                AccueilUI accueilUI = new AccueilUI();
                accueilUI.start(primaryStage);
                primaryStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Création du layout principal
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: lightblue;"); // Fond bleu

// Espace vide extensible pour pousser le bouton en bas
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

// Menu en haut
        root.getChildren().addAll(menuBar, spacer);

// Bouton en bas à gauche
        HBox bottomBox = new HBox(deconnecterButton);
        bottomBox.setAlignment(Pos.BOTTOM_LEFT);
        bottomBox.setPadding(new Insets(50));

        root.getChildren().add(bottomBox);



        // Affichage de la scène
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu Principal");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

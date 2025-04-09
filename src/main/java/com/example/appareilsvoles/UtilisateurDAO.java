package com.example.appareilsvoles;
import java.io.PipedInputStream;
import java.sql.*;

public class UtilisateurDAO {

    public boolean verifierIdentifiants(String username, String password) {
        String query = "SELECT * FROM Utilisateur  WHERE nom = ? AND mot_de_passe = ?";
        try (Connection conn = DriverManager.getConnection("jdbc : mysql://localhost:3306/objetsvoles", "manuellaDKM", "Manuella_DKM00");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean insertUserIntoDatabase( String nom, String prenom, String Localisation, Integer telephone,String password) {
        String query = "INSERT INTO Utilisateur (nom, prenom, Localisation, telephone , mot_de_passe) VALUES (?, ?, ?,?,?)";


        PipedInputStream DataBaseConnection;
        try(Connection conn = DriverManager.getConnection("jdbc : mysql://localhost:3306/objetsvoles", "manuellaDKM", "Manuella_DKM00");) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, Localisation);
            stmt.setInt(4, telephone);
            stmt.setString(5, password);

            // executer commande
            int affectedrows = stmt.executeUpdate();
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;



        }
    }
}
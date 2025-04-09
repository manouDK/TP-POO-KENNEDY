package com.example.appareilsvoles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data_Base_Connection  {
    private static final String URL = "jdbc:mysql://localhost:3306/Find"; // Remplacez par votre base de données
    private static final String USER = "root"; // Remplacez par votre utilisateur
    private static final String PASSWORD = "nana"; // Remplacez par votre mot de passe

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion : " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
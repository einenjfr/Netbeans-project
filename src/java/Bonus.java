
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan
 */

//CLASS POUR SE COMMUNIQUER AVEC LA BASE DE DONNÉES
public class Bonus {
    
    private List<String> messages = new ArrayList<String>();
    private String url = "jdbc:derby://localhost:1527/Users";
    private String name = "admin1";
    private String pass = "admin";
    
    //FONCTION QUI VA METTRE LES DONNÉES DANS LA BDD
    public List<String> set (List<String> data) {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        
        try {
            connexion = DriverManager.getConnection(url,name,pass);
            statement = connexion.createStatement();
            
            //On va mettre les données. Tantes files comme ssn il y ait
            int i = 0;
            while (i < data.size()) {
                statement.executeUpdate("INSERT INTO Users VALUES ('"+data.get(i++)
                        +"', '"+data.get(i++)+"', '"+data.get(i++)+"')");
            }
        } catch (SQLException e) {
            data.add("Erreur : " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ignore){
                }
            }
        }
        return data;
        
    }
    
    public List<String> get () {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        List<String> data = new ArrayList<String>();
        
        try {
            connexion = DriverManager.getConnection(url,name,pass);
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT fname,lname,uname FROM users");
            
            int i = 0;
            while (resultat.next()) {
                data.add(resultat.getString("uname"));
                data.add(resultat.getString("fname"));
                data.add(resultat.getString("lname"));
            }
        } catch (SQLException e) {
            data.add("Erreur : " + e.getMessage());
        } finally {
            if (resultat != null) {
                try {
                    resultat.close();
                } catch (SQLException ignore) {
                }
            }
        
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ignore){
                }
            }
        }
        
        return data;
    }
    
    public void dest () {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        
        try {
            connexion = DriverManager.getConnection(url,name,pass);
            
            statement = connexion.createStatement();
            statement.executeUpdate("DELETE FROM Users");
        } catch (SQLException e) {
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ignore){
                }
            }
        }
    }
    
}

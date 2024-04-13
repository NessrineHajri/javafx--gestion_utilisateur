package tn.esprit;

import tn.esprit.entities.User;
import tn.esprit.services.ServiceUser;
import tn.esprit.utils.MyDB;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyDB.getInstance(); // Assurez-vous que cette ligne est utile pour initialiser la connexion à la base de données
/*
        // Création d'un utilisateur
        User u1 = new User("recruteur5@gmail.com", "[\"ROLE_RECRUTEUR\"]", "recruteur5", "recruteur5", false);

        // Service pour gérer les utilisateurs
        ServiceUser su = new ServiceUser();

        try {
            // Ajout de l'utilisateur
            su.add(u1);
            System.out.println("Utilisateur ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }

        try {
            // Affichage de la liste des utilisateurs
            List<User> users = su.afficher();
            System.out.println("Liste des utilisateurs :");
            for (User user : users) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des utilisateurs : " + e.getMessage());
        }
    }
*/

    // suppression


     //public static void main(String[] args) {
      //  MyDB.getInstance(); // Assurez-vous que cette ligne est utile pour initialiser la connexion à la base de données

        // Service pour gérer les utilisateurs
        ServiceUser su = new ServiceUser();

        try {
            // Suppression de l'utilisateur avec ID 14
            User userToDelete = new User();
            userToDelete.setId(24); // ID de l'utilisateur à supprimer
            su.delete(userToDelete);
            System.out.println("Utilisateur supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }

        try {
            // Affichage de la liste des utilisateurs après la suppression
            List<User> users = su.afficher();
            System.out.println("Liste des utilisateurs après suppression :");
            for (User user : users) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des utilisateurs : " + e.getMessage());
        }
    }
}


        // update
        /*
        MyDB.getInstance(); // Assurez-vous que cette ligne est utile pour initialiser la connexion à la base de données

        // Service pour gérer les utilisateurs
        ServiceUser su = new ServiceUser();

        try {


            // Mise à jour de l'utilisateur avec ID 15
            User userToUpdate = new User();
            userToUpdate.setId(17); // ID de l'utilisateur à mettre à jour
            userToUpdate.setEmail("recruteur4@gmail.com");
            userToUpdate.setPassword("recruteur4");
            userToUpdate.setUsername("recruteur4");
            userToUpdate.setRoles("[\"ROLE_RECRUTEUR\"]");
            userToUpdate.setIs_verified(1);
            su.update(userToUpdate);
            System.out.println("Utilisateur mis à jour avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout ou de la mise à jour de l'utilisateur : " + e.getMessage());
        }

        try {
            // Affichage de la liste des utilisateurs
            List<User> users = su.afficher();
            System.out.println("Liste des utilisateurs :");
            for (User user : users) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des utilisateurs : " + e.getMessage());
        }
    }
         */




package tn.esprit.services;

import org.mindrot.jbcrypt.BCrypt;
import tn.esprit.entities.User;
import tn.esprit.utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceUser implements IServices<User> {
    public Connection con;
    public Statement ste;


    public ServiceUser(){
        con= MyDB.getInstance().getCon();
    }


    @Override
    public void add(User user) throws SQLException{
        String password = user.getPassword();
        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        String req = "INSERT INTO user (email, password, username, roles, is_verified) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pre = con.prepareStatement(req)) {
            pre.setString(1, user.getEmail());
            pre.setString(2, encryptedPassword);
            pre.setString(3, user.getUsername());
            pre.setString(4, user.getRoles());
            pre.setBoolean(5, user.getIs_verified());
            pre.executeUpdate();
        }
    }

    @Override
    public void update(User user) throws SQLException {

        String req = "UPDATE user SET email=?, password=?, username=?, roles=?, is_verified=? WHERE id=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1, user.getEmail());
        pre.setString(2, user.getPassword());
        pre.setString(3, user.getUsername());
        pre.setString(4, user.getRoles());
        pre.setBoolean(5, user.getIs_verified());
        pre.setInt(6, user.getId());
        pre.executeUpdate();
    }

    @Override
    public void delete(User user) throws SQLException {
        String req = "DELETE FROM user WHERE id=?";
        try (PreparedStatement pre = con.prepareStatement(req)) {
            pre.setInt(1, user.getId());
            pre.executeUpdate();
        }
    }

    @Override
    public List<User> afficher() throws SQLException {
        List<User> users = new ArrayList<>();
        String req = "SELECT * FROM user";
        ste = con.createStatement();
        ResultSet res =ste.executeQuery(req);
            while (res.next()) {
                int id = res.getInt("id");
                String email = res.getString("email");
                String roles = res.getString("roles");
                String password = res.getString("password");
                String username = res.getString("username");
                boolean is_verified = res.getBoolean("is_verified");
                User u = new User(id, email, roles, password, username, is_verified);
                users.add(u);
            }
        return users;
    }


}

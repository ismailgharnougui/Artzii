/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import IServices.IUtilisateur;
import utils.MyConnection;
import Entites.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CRUDUtilisateur implements IUtilisateur{
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
 ObservableList<Utilisateur>obList = FXCollections.observableArrayList();       

    public void ajouterUtilisateur(Utilisateur U) {
    try {
        ste = conn.createStatement();
        String req = "Insert into utilisateur values(0,'"+U.getnomU()+"','"+U.getprenomU()+"','"+U.getemailU()+"','"+U.getmdpU()+"','"+U.getroleU()+"','"+U.getadresse()+"')";
        ste.executeUpdate(req);
        System.out.println("utilisateur ajouté");
    } catch (SQLException ex) {
            System.out.println("utilisateur non ajouté!!!!");    }
    }

     
    public void modifierUtilisateur(Utilisateur U) {
        try {
            String req = "UPDATE `utilisateur` SET `nomU` = '" + U.getnomU() + "', `emailU` = '" + U.getemailU() + "', `mdpU` = '" + U.getmdpU() + "', `prenomU` = '" + U.getprenomU() +"', `roleU` = '" + U.getroleU() + "',`adresse` = '" + U.getadresse() + "' WHERE `utilisateur`.`idU` = " + U.getidU();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("utilisateur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerUtilisateur (int idU) {
        try {
            String req = "DELETE FROM `utilisateur` WHERE idU = " + idU;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("utilisateur deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObservableList<Utilisateur> afficherUtilisateur() {
       List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "Select * from utilisateur";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Utilisateur U  = new Utilisateur();
             U.setidU(RS.getInt(1));
             U.setnomU(RS.getString(2));
             U.setprenomU(RS.getString(3));
             U.setemailU(RS.getString(4));
             U.setmdpU(RS.getString(5));
             U.setroleU(RS.getString(6));
             U.setadresse(RS.getString(7));
             obList.add(U);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return obList;
    }

    public void ajouterUtilisateur2(Utilisateur U) {
        try {
            String req = "INSERT INTO `utilisateur` (`nomU`, `prenomU`,`emailU`,`mdpU`,`roleU`,`adresse`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
             ps.setString(1, U.getnomU());
            ps.setString(2, U.getprenomU());
            ps.setString(3, U.getemailU());
            ps.setString(4, U.getmdpU());
            ps.setString(5, U.getroleU());
            ps.setString(6, U.getadresse());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
  
}
 


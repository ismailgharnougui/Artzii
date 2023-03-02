/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import db.MyConnection;
import models.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Command;


public class ServiceArticle implements InterfaceServiceArticle{
Statement ste =null;

Connection conn = MyConnection.getInstance().getConnection();
 
   

    @Override
    public Article get(int id) {
          try {
        String req = "SELECT * FROM `article` WHERE refA = ?";
        PreparedStatement pste=conn.prepareStatement(req);
        pste.setInt(1, id);
        
        ResultSet result = pste.executeQuery();
       result.next();
           Article resultArticle = new Article(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4), result.getFloat(5), result.getString(7));
        return resultArticle;
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
    return null;
    }

    @Override
    public List<Article> getArticles(int id) {
  List<Article> articles = new ArrayList<>();
        try {
        String req = "SELECT * FROM article where idArtiste = "+id;
        ste=conn.createStatement();
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) { 
            Article resultArticle = new Article(result.getInt(1),result.getInt(2), result.getString(3), result.getString(4), result.getFloat(5),result.getString(7));

            articles.add(resultArticle);
        }
        System.out.println(articles);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return articles;    
    }
    


    @Override
    public List<Article> afficherArticles() {
    List<Article> articles = new ArrayList<>();
        try {
        String req = "SELECT * FROM article";
        ste=conn.createStatement();
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) { 
            Article resultArticle = new Article(result.getInt(1),result.getInt(2), result.getString(3), result.getString(4), result.getFloat(5),result.getString(7));

            articles.add(resultArticle);
        }
        System.out.println(articles);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return articles;    
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpanier;

import java.sql.SQLException;
import models.Article;
import models.Command;
import services.ServiceArticle;
import services.ServiceBasket;
import services.ServiceUser;
import services.ServiceCommand;

/**
 *
 * @author medmo
 */
public class GestionPanier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        Command c =new Command(4,"Livré");
        
        ServiceArticle sa = new ServiceArticle();
        //System.out.println( sa.get(2));
        //sa.afficherArticles();
        //sa.getArticles(12);
        //sa.ajouter(new Article(12,"Article","50*60",45,"czdzdzdzd"));
        //sa.supprimerArticle(12, 8);
        
        ServiceUser scl = new ServiceUser();
        //System.out.println(scl.get(4));
        //System.out.println(scl.getByEmail("mokl@gmail.cim"));
        //scl.ajouterUser(new User("moklll", "mplll", "mokh11@gmail.com", "Mokhtar1234", "Client", "Manzel Bourguiba"));
        //System.out.println(scl.login("mokh11@gmail.com", "Mokhtar1234"));//scl.login("mokh11@gmail.com", "Mokhtar1234");
        
        ServiceBasket sb = new ServiceBasket();
        //sb.ajouter(12, 7);
        //sb.vider(2);
        //sb.supprimerArticle(4,6);
        //System.out.println(sb.get(4));
        
        ServiceCommand sc = new ServiceCommand();
        // sc.ajouter(c);
        //sc.supprimer(3);
        //System.out.println(sc.recupererCommClient(2));      
        //sc.afficherCommands();
        //sc.modifierCommand(c);
        
       
    }
    
}






















        
        /*Client cl = new Client(2,"ramzi", "mohsen", "123 Main St");
        ArrayList<Article> articles = new ArrayList<Article>();
        articles.add(new Article(2,"15*51", (float) 15.99));
        articles.add(new Article(3,"51*48", (float) 29.99));
        articles.add(new Article(4,"7*65", (float) 5.99));
        String comDate = "2023-02-14";
        double totalCost = 51.97;
        String payMethod = "Credit Card";
        Command command = new Command(cl, articles, comDate, totalCost, payMethod);*/

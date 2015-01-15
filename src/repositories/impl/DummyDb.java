package repositories.impl;

import domain.*;
import java.util.*;


public class DummyDb {
   List<User> users = new ArrayList<User>();
   List<Auto> auta;
   
    public void Dane(){
       
     
        User user1 = new User("pol", "przy");
        User user2 = new User("adl", "ann");
        Auto auto1= new Auto("BMW", "E36",200000);
        Auto auto2= new Auto("Audi", "A6",124000);
    
        users.add(user1);
        users.add(user2);
        auta.add(auto1);
        auta.add(auto2);
    }
    
    
}

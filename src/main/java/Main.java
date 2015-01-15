package main.java;

import domain.Auto;
import domain.Motor;


import domain.Naped;

import java.sql.*;
import java.util.List;

import repositories.IRepository;
import repositories.impl.AutoBuilder;
import repositories.impl.AutoRepository;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;

public class Main {

    
    public static void main(String[] args) {  
    	String url="jdbc:hsqldb:hsql://localhost/workdb";
        try {
            Connection connection = DriverManager.getConnection(url);
            IUnitOfWork uow = new UnitOfWork(connection);
            
            IRepository<Auto> auta = new AutoRepository(connection, new AutoBuilder(),uow);
            
            Auto auto= new Auto("BMW", "E46", 150000);
           
        	Naped naped = new Naped("przygodaSA", 2, "super");
        	Motor motor= new Motor("Harley-Davidson", "Fatboy", 15000, naped);
        	
            
        	       	
            List<Auto> autaZBazy = auta.getAll();
            System.out.println("auta z bazy:\n");
            for(Auto zBazy : autaZBazy) {
                System.out.println(" Marka: " + zBazy.getMarka()+ " Przebieg: " + zBazy.getPrzebieg() + "s");   
            }
            
                        
            uow.commit();
                    
          
            
        }  catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();                      
        }
    }
}


package repositories.impl;

import domain.*;


import java.util.*;

import repositories.IAutoRepository;



public class DummyAutoRepository implements IAutoRepository {
        private final DummyDb db;
  
    
    public DummyAutoRepository(DummyDb db) {
        super();
        this.db = db;
    }
    @Override
    public void add(Auto entity){
        db.auta.add(entity);
    }
    @Override
     public void delete(Auto entity){
        db.auta.remove(entity);
    }
    @Override
     public void update(Auto entity, Auto entity1){
        db.auta.remove(entity);
        db.auta.add(entity1);
    }
    @Override
    public Auto get(int id) {
        for (Auto p: db.auta){
            if(p.id == id){
                return p;
            }
        }
         return null;
    }
    @Override
    public List<Auto> pokaz_przebieg(int przebieg) {
    
    List<Auto> wynik = new ArrayList<>();
    for (Auto p: db.auta){
    if(p.getPrzebieg() < przebieg){
    wynik.add(p);
    }
    }
    return wynik;
    } 

    @Override
    public List<Auto> getAll(){
        return db.auta;
    }
	@Override
	public List<Auto> pokaz_marke(String marka) {
		
		return null;
	}
	@Override
	public List<Auto> pokaz_model(String model) {
		
		return null;
	}

    

}

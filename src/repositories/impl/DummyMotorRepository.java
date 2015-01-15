
package repositories.impl;

import domain.*;

import java.util.*;

import repositories.IMotorRepository;


public class DummyMotorRepository implements IMotorRepository {
   
    private DummyDb db;
    
      public DummyMotorRepository(DummyDb db) {
        super();
        this.db = db;
    }
    public void save(Motor entity){
        db.auta.add(entity);
    }
     public void delete(Motor entity){
        db.auta.remove(entity);
    }
     Naped naped1 = new Naped("Hundaj", 4, "³añcuchowy");
     public void update(Motor entity,String marka, String model, int przebieg, Naped naped){
        db.auta.remove(entity);
        
        Motor entity1 = new Motor(marka,model,przebieg, naped1);
        db.auta.add(entity1);
    }
    public Auto pobierz(int id) {
        for (Auto p: db.auta){
            if(p.id == id){
                return p;
            }
        }
         return null;
    }
  
    
   
	@Override
	public void add(Motor entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Motor entity, Motor entity1) {
		// TODO Auto-generated method stub
		
	}
		@Override
	public Motor get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Motor> pokaz_marke(String marka) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Motor> pokaz_model(String model) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Motor> pokaz_przebieg(int przebieg) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Motor> pokaz_naped(Naped naped) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Motor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

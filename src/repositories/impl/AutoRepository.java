
package repositories.impl;

import domain.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import unitofwork.IUnitOfWork;
import repositories.impl.IEntityBuilder;


public class AutoRepository extends Repository<Auto> implements IRepository<Auto> {
    
    public AutoRepository(Connection connection, IEntityBuilder<Auto> builder, IUnitOfWork uow) {
        super(connection,builder,uow);
    }
    
   

	@Override
	protected void setUpUpdateQuery(Auto entity) throws SQLException {
            update.setString(1, entity.getMarka());
            update.setString(2, entity.getModel());
            update.setInt(1, entity.getPrzebieg());
            update.setInt(2, entity.getId());
	}
	
	@Override
	protected void setUpInsertQuery(Auto entity) throws SQLException {
            insert.setString(1, entity.getModel());
            insert.setString(2, entity.getMarka());
            insert.setInt(1, entity.getPrzebieg());
            insert.setInt(2, entity.getId());
	}
	
	@Override
	protected String getTableName() {
            return "auto";
	}
	
	
	 @Override
     protected String getUpdateQuery() {
	        return "update auto set (marka,model,przebieg)=(?,?,?)" + "where id=?";
	    }
	  
	 @Override
	 protected String getInsertQuery() {
	        return "insert into auto (marka,model,przebieg) values(?,?,?)";
	    }
    
	
	 @Override
		public void delete(Auto entity) {
			try {
				delete.setInt(1, entity.getId());
				delete.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}

	   public List<Auto> get_przebieg(int przebieg) {
           
           ArrayList<Auto> result = new ArrayList<Auto>();
           try {
                   ResultSet rs = selectAll.executeQuery();
                   while(rs.next())
                   {
                           Auto auto = new Auto();
                           auto.setId(rs.getInt("id"));
                           auto.setMarka(rs.getString("marka"));
                           auto.setModel(rs.getString("model"));
                           auto.setPrzebieg(rs.getInt("przebieg"));
                           if (auto.getPrzebieg() < przebieg) {
                               result.add(auto);
                           }
                           return result;
                   }
           } catch (SQLException e) {
               System.out.println("wystapil blad");
               e.printStackTrace();
           }
           return null;
   }
	   @Override
		public void add(Auto entity) {
			
			try {
				insert.setString(2, entity.getMarka());
	                        insert.setString(3, entity.getModel());
				insert.setInt(4, entity.getPrzebieg());
				insert.executeUpdate();
			} catch (SQLException e) {
	                        System.out.println("wystapil blad");
				e.printStackTrace();
			}
		}

	



		@Override
		public void update(Auto entity, Auto entity1) {
			
			
		}

	

	
		
}
    
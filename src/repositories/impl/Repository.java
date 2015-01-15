package repositories.impl;

import java.sql.*;
import java.util.*;

import repositories.IRepository;
import unitofwork.IUnitOfWork;
import unitofwork.IUnitOfWorkRepozytorium;
import domain.Entity;


public abstract class Repository<TEntity extends Entity> 
	implements IRepository<TEntity>, IUnitOfWorkRepozytorium {
    
	protected IUnitOfWork uow;
	protected Connection connection;
	protected PreparedStatement selectByID;
	protected PreparedStatement insert;
	protected PreparedStatement delete;
	protected PreparedStatement update;
	protected PreparedStatement selectAll;
	protected PreparedStatement selectByMarka;
	protected PreparedStatement selectByModel;
	protected IEntityBuilder<TEntity> builder;

	private String selectByIDSql=
			"SELECT * FROM "
			+ getTableName()
			+ " WHERE id=?";
	private String deleteSql=
			"DELETE FROM "
					+ getTableName()
			+ " WHERE id=?";
	private String selectAllSql=
			"SELECT * FROM "+ getTableName();
        private String selectByMarkaSql=
                    "SELECT * FROM" + getTableName() + " WHERE marka=?";
        private String selectByModelSql=
                "SELECT * FROM" + getTableName() + " WHERE model=?";

	protected Repository(Connection connection,IEntityBuilder<TEntity> builder, IUnitOfWork uow)
        {
            this.uow=uow;
            this.builder=builder;
            this.connection = connection;
            try  {
            	selectByID=connection.prepareStatement(selectByIDSql);
            	insert = connection.prepareStatement(getInsertQuery());
                    update=connection.prepareStatement(getUpdateQuery());
                    delete=connection.prepareStatement(deleteSql);
                    selectAll=connection.prepareStatement(selectAllSql);
                    selectByMarka=connection.prepareStatement(selectByMarkaSql);
                    selectByModel=connection.prepareStatement(selectByModelSql);
            } catch (Exception e) {
                    e.printStackTrace();
            }
	}
	
	@Override
	public void add(TEntity entity) {
            uow.markAsNew(entity, this);
	}

	@Override
	public void update(TEntity entity, TEntity entity1) {
            uow.markAsDirty(entity, this);
	}

	@Override
	public void delete(TEntity entity) {
            uow.markAsDelete(entity, this);
	}
	
	@Override
	public void persistAdd(Entity entity) {
            try {
                setUpInsertQuery((TEntity)entity);
                insert.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
	}

	@Override
	public void persistUpdate(Entity entity) {
            try {
                setUpUpdateQuery((TEntity)entity);
                update.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }	
	}
	
	@Override
	public void persistDelete(Entity entity) {
            try {
                delete.setInt(1, entity.getId());
                delete.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }	
	}
	
	@Override
	public TEntity get(int id) {
            try {
                selectByID.setInt(1, id);
                ResultSet rs = selectByID.executeQuery();
                while(rs.next()) {
                    return builder.build(rs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
	}
	
	@Override
	public List<TEntity> getAll() {
            List<TEntity> result = new ArrayList<>();
            try {
                ResultSet rs = selectAll.executeQuery();
                while(rs.next()) {
                        result.add(builder.build(rs));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
	}


	protected abstract void setUpUpdateQuery(TEntity entity) throws SQLException;
	protected abstract void setUpInsertQuery(TEntity entity) throws SQLException;
	protected abstract String getInsertQuery();
	protected abstract String getUpdateQuery();
	protected abstract String getTableName();
	
}
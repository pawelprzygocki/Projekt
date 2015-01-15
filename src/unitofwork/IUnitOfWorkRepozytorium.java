package unitofwork;

import domain.Entity;

public interface IUnitOfWorkRepozytorium {

	public void persistAdd(Entity entity);
	public void persistUpdate(Entity entity);
	public void persistDelete(Entity entity);
}
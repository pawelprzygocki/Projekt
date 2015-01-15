package unitofwork;

import domain.Entity;

public interface IUnitOfWork {

	public void commit();
	public void rollback();
	public void markAsNew(Entity entity, IUnitOfWorkRepozytorium repository);
	public void markAsDirty(Entity entity, IUnitOfWorkRepozytorium repository);
	public void markAsDelete(Entity entity, IUnitOfWorkRepozytorium repository);
}
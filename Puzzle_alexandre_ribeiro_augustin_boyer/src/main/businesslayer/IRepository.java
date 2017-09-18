package main.businesslayer;

public interface IRepository<T> {
	void close();

	public T select(String id);

	public void insert(T t);

	public void update(T t, String id);
}

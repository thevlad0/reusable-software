package mobile.util;

import mobile.users.User;

public class Manager<T> {
    protected Repository<T> repo = new Repository<>();

    public void add(T item) {
        repo.add(item);
    }

    public T get(String id) {
        return repo.get(id);
    }

    public void remove(T item) {
        repo.remove(item);
    }
}

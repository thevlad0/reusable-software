package mobile.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Repository<T> implements Iterable<T> {
    Map<String, T> storage;

    public Repository() {
        storage = new HashMap<>();
    }

    public void add(T item) {
        storage.put(item.toString(), item);
    }

    public void remove(T item) {
        storage.remove(item.toString());
    }

    public T get(String id) {
        return storage.get(id);
    }

    @Override
    public Iterator<T> iterator() {
        return storage.values().iterator();
    }
}

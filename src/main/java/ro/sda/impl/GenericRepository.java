package ro.sda.impl;
import ro.sda.model.Entity;
import ro.sda.repository.BaseRepository;
import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T extends Entity> implements BaseRepository<T> {
    protected List<T> entityList = new ArrayList<T>();

    public T findById(int id) {
        return entityList.stream()
                .filter((s) -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void createEntity(T entity) {
        entityList.add(entity);
    }

    public void updateEntity(T entity) {
        entityList.remove(entity);
        entityList.add(entity);
    }

    public void deleteEntity(T entity) {
        entityList.remove(entity);
    }
}

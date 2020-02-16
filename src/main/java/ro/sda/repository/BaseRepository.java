package ro.sda.repository;
import org.springframework.stereotype.Repository;
import ro.sda.model.Entity;

@Repository
public interface BaseRepository<T extends Entity> {

     T findById(int id);
     void createEntity(T entity);
     void updateEntity(T entity);
     void deleteEntity(T entity);

}

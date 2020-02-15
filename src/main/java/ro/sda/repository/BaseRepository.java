package ro.sda.repository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T> {

     T findById(int id);
     void createEntity(T entity);
     void updateEntity(T entity);
     void deleteEntity(T entity);

}

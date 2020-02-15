package ro.sda.impl;

import org.springframework.stereotype.Repository;
import ro.sda.model.School;
import ro.sda.repository.SchoolRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DefaultSchoolRepository implements SchoolRepository {

    private List<School> schoolList = new ArrayList<School>();

    public School findById(int id) {
        return schoolList.stream()
                .filter((s) -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<School> findByName(String name) {
        return schoolList.stream()
                .filter((s) -> s.getName().equals(name))
                .collect(Collectors.toList());
    }

    public void createEntity(School entity) {
        schoolList.add(entity);
    }

    public void updateEntity(School entity) {

    }

    public void deleteEntity(School entity) {
        for (School s : schoolList) {
            if(s.equals(entity)) {
                schoolList.remove(entity);
            }
        }
    }
}

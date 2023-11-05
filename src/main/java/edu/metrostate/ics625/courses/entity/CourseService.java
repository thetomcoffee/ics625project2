
package edu.metrostate.ics625.courses.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
    
    @Autowired
    private CourseRepo repo;
    
    public void add(String number, String title, boolean offered){
        Course c = new Course(number, title, offered);
        repo.save(c);
    }
    
    public  Optional<Course> get(long id){
        return repo.findById(id);
    }
    
    public List<Course> getAll(){
        List<Course> courses = new ArrayList<>();
        repo.findAll().forEach(courses::add);
        return courses;
    }
    
    public void remove(long id){
        repo.deleteById(id);
    }
    
    public void update(long id, String number, String title, boolean offered){
        Optional<Course> op = repo.findById(id);
        if (op.isEmpty()) return;
        Course c = op.get();
        c.setNumber(number);
        c.setTitle(title);
        c.setOffered(offered);
        repo.save(c);
    }
}

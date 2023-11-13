package com.example.demo_serverlet.services;

import com.example.demo_serverlet.entities.Student;
import com.example.demo_serverlet.repository.StudentRepository;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class StudentService {
    private  StudentRepository repository = new StudentRepository();
    public List<Student> getAll(){
        return repository.getAll();
    }
    public Student findById(int id){
        return  repository.findById(id);
    }
    public int update(Student student){
        return repository.update(student);
    }

    public int delete(int id){
        return repository.delete(id);
    }


}

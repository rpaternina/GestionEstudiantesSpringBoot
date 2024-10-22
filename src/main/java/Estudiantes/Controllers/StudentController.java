package Estudiantes.Controllers;


import Estudiantes.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<Student> estudiantes = new ArrayList<>(Arrays.asList(
            new Student(1, "Robert Paternina", "paterninayolir@gmail.com", 24, "Noveno"),
            new Student(2, "Samuel Paternina", "paterninaSamuel@gmail.com", 24, "Noveno"),
            new Student(3, "Keiry Diaz", "keiry@gmail.com", 24, "Noveno")
    ));

    @GetMapping
    public List<Student> getStudents(){
        return estudiantes;
    }

    @GetMapping("/{email}")
    public Student getStuden(@PathVariable String email){
        for(Student StudendByEmail : estudiantes){
            if (StudendByEmail.getEmail().equals(email)){
                return StudendByEmail;
            }
        }
        return null;
    }

    @PostMapping
    public Student postStuden(@RequestBody Student estudiante){
    estudiantes.add(estudiante);
    return estudiante;
    }



}

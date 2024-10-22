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

    /**
     * Metodo para obtener todos los estudiantes
     * @return
     */
    @GetMapping
    public List<Student> getStudents(){
        return estudiantes;
    }

    /**
     * Metodo para buscar un estudiante por email
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public Student getStuden(@PathVariable String email){
        for(Student StudendByEmail : estudiantes){
            if (StudendByEmail.getEmail().equals(email)){
                return StudendByEmail;
            }
        }
        return null;
    }

    /**
     * Metodo para agregar un estudiante
     * @param estudiante
     * @return
     */
    @PostMapping
    public Student postStuden(@RequestBody Student estudiante){
    estudiantes.add(estudiante);
    return estudiante;
    }

    @PutMapping
    public Student putStuden(@RequestBody Student estudiante){
        for(Student updateStudent : estudiantes){
            if(updateStudent.getId() == estudiante.getId()){
                updateStudent.setName(estudiante.getName());
                updateStudent.setEmail(estudiante.getEmail());
                updateStudent.setAge(estudiante.getAge());
                updateStudent.setCourse(estudiante.getCourse());
                return updateStudent;
            }
        }
        return null;
    }


}

package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import com.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/apis")
public class StudentController {

    @Autowired
    StudentService studentService;

    //standard way for returning response - ResponseEntity (it contains http status code and response body)


    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        try{
            String response = studentService.saveStudent(studentRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occurred : "+e.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Long id){
        try{
            Student response = studentService.findStudentById(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occurred : "+e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllStudents(){
        try{
            List<Student> response = studentService.findAllStudents();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occurred : "+e.getMessage());
        }
    }

    @GetMapping("/findByPage")
    public ResponseEntity<?> findAllStudentsByPage(@RequestParam int pageNo,@RequestParam int pageSize){
        try{
            Page<Student> response = studentService.findStudentByPage(pageNo,pageSize);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occurred : "+e.getMessage());
        }
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        try{
            String response = studentService.deleteStudentById(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occurred : "+e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto){
        try{
            String response = studentService.updateStudent(id, studentRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occurred : "+e.getMessage());
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findStudentByEmail(@RequestParam String email) {
        try {
            Student response = studentService.findStudentByEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occurred : " + e.getMessage());
        }
    }
    @GetMapping("/findByGender")
    public ResponseEntity<?> findStudentsByGender(@RequestParam String gender) {
        try {
            List<Student> response = studentService.findStudentByGender(gender);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occurred : " + e.getMessage());
        }
    }
}

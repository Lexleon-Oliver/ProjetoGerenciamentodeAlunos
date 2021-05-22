package com.development.studentapi.controller;

import com.development.studentapi.dto.request.StudentDTO;
import com.development.studentapi.dto.response.MessageResponseDTO;
import com.development.studentapi.exception.StudentNotFoundException;
import com.development.studentapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {

    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createStudent(@RequestBody @Valid StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> listAll(){
        return studentService.listAll();
    }

    @GetMapping("/{registration}")
    public StudentDTO findByRegistration(@PathVariable Long registration) {
        return studentService.findByRegistration(registration);
    }

    @DeleteMapping("/{registration}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByRegistration(@PathVariable Long registration){
        studentService.deleteStudent(registration);
    }

    @PutMapping("/{registration}")
    public MessageResponseDTO updateByRegistration(@PathVariable Long registration, @RequestBody @Valid StudentDTO studentDTO){
        return studentService.updateByRegistration(registration,studentDTO);
    }
}

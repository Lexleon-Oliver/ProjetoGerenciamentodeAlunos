package com.development.studentapi.service.impl;

import com.development.studentapi.dto.request.StudentDTO;
import com.development.studentapi.dto.response.MessageResponseDTO;
import com.development.studentapi.entity.Student;
import com.development.studentapi.exception.StudentNotFoundException;
import com.development.studentapi.mapper.StudentMapper;
import com.development.studentapi.repository.StudentRepository;
import com.development.studentapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    private static final StudentMapper studentMapper= StudentMapper.INSTANCE;

    public MessageResponseDTO updateByRegistration(Long registration, StudentDTO studentDTO){
        verifyIfExists(registration);
        Student studentToUpdate = studentMapper.toModel(studentDTO);
        Student updatedStudent = studentRepository.save(studentToUpdate);
        return createMessageResponse(updatedStudent.getRegistration(), "Updated student with ID Registration ");
    }

    public MessageResponseDTO createStudent(StudentDTO studentDTO){
        Student studentToSave = studentMapper.toModel(studentDTO);
        Student savedStudent = studentRepository.save(studentToSave);
        return createMessageResponse(savedStudent.getRegistration(), "Created student with ID Registration ");
    }

    public List<StudentDTO> listAll() {
        List<Student> allStudents = studentRepository.findAll();
        return allStudents.stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO findByRegistration(Long registration){
        Student student = verifyIfExists(registration);

        return studentMapper.toDTO(student);
    }

    public void deleteStudent(Long registration){
        verifyIfExists(registration);
        studentRepository.deleteById(registration);
    }

    private MessageResponseDTO createMessageResponse(Long registration, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + registration)
                .build();
    }

    private Student verifyIfExists(Long registration){
        return studentRepository.findById(registration)
                .orElseThrow(StudentNotFoundException::new);
    }
}

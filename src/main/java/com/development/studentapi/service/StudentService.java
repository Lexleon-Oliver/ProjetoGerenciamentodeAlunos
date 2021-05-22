package com.development.studentapi.service;

import com.development.studentapi.dto.request.StudentDTO;
import com.development.studentapi.dto.response.MessageResponseDTO;

import java.util.List;

public interface StudentService {
    public MessageResponseDTO updateByRegistration(Long registration, StudentDTO studentDTO);
    public MessageResponseDTO createStudent(StudentDTO studentDTO);
    public List<StudentDTO> listAll();
    public StudentDTO findByRegistration(Long registration);
    public void deleteStudent(Long registration);
}

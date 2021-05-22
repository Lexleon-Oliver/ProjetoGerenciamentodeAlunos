package com.development.studentapi.mapper;

import com.development.studentapi.dto.request.StudentDTO;
import com.development.studentapi.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper((StudentMapper.class));

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Student toModel(StudentDTO studentDTO);
    StudentDTO toDTO(Student student);
}

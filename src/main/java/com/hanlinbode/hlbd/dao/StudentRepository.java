package com.hanlinbode.hlbd.dao;

import com.hanlinbode.hlbd.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByPhone(String phone);


    List<Student> findStudentsByName(String name);


    List<Student> findStudentsByPhone(String phone);

    @Query("select s from Student s where s.id=:id")
    Student findStudentById(@Param("id") int id);

    Student findStudentByStudentId(String id);
}

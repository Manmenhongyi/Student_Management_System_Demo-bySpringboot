package com.mmhy.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//访问数据库的jpa接口
@Repository
//定义spring数据访问层组件
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByEmail(String email);


}

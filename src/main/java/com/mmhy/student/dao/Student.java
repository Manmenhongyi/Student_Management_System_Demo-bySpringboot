package com.mmhy.student.dao;

import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
/* @Entity注解表示这是一个实体类且映射到数据库中
   @Table注解用于指定数据库表名 */
@Table(name = "student")
public class Student {
    //用@Id注解指定主键
    @Id
    //用@GeneratedValue注解中的strategy=IDENTITY指定主键生成策略为自增长
    @GeneratedValue(strategy=IDENTITY)
    private long id;


    /* 这里的"name"属性和数据库中的列名如果不一致，需要通过@Column注解指定数据库列名
     如果数据库列名和属性名一致，则可以省略@Column注解 */
    @Column(name="name")
    private String name;

    private String email;

    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

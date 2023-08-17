package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;


@ToString
@NoArgsConstructor
@Entity
@EntityScan
@Table(name = "user_table") // DB 테이블의 이름과 class의 이름이 다를 경우 사용!
public class CrudEntity {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Builder
    public CrudEntity(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}

package com.quanlybanhang.entites;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "feedback")
public class FeedbackEntity extends BaseEntity {

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phonenumber")
    private Integer phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
}

package com.code.spring.taskmanagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "Users")
@Data
@ToString(exclude = "projects")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String email;
    private String role;
    private Boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<Project> projects;

    @JsonIgnore
    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
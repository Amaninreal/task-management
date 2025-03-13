package com.code.spring.taskmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String title;
    private String status;
    private String priority;
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "projectId")
    @JsonBackReference
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assignedTo")
    private User assignedTo;
}

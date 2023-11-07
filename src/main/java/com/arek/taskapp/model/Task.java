package com.arek.taskapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    private LocalDate creationDate;

    public Task(String content) {
        this.content = content;
        this.creationDate = LocalDate.now();
    }

    public Task(String content, LocalDate creationDate) {
        this.content = content;
        this.creationDate = creationDate;
    }
}

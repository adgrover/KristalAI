package com.example.kristalai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "random_data_repository")
public class RandomNumberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "random_number", nullable = false)
    private long randomNumber;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    public RandomNumberModel(){}

    public RandomNumberModel(long randomNumber, Date createdAt){
        this.randomNumber=randomNumber;
        this.createdAt=createdAt;
    }

    public long getRandomNumber() {
        return randomNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setRandomNumber(long randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "RandomNumberModel{" +
                "randomNumber=" + randomNumber +
                ", createdAt=" + createdAt +
                '}';
    }

}

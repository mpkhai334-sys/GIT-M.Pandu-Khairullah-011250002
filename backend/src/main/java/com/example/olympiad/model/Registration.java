package com.example.olympiad.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Registration {
    private UUID id = UUID.randomUUID();

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private String school;
    private String grade;
    private String category;
    private String phone;
    private OffsetDateTime createdAt = OffsetDateTime.now();

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSchool() { return school; }
    public void setSchool(String school) { this.school = school; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}

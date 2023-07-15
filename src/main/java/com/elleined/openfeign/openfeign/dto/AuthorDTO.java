package com.elleined.openfeign.openfeign.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class AuthorDTO {
    private int id;
    private String name;
    private String biography;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> books;
    private int bookCount;
}

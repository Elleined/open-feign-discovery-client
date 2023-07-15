package com.elleined.openfeign.openfeign.controller;

import com.elleined.openfeign.openfeign.client.AuthorClient;
import com.elleined.openfeign.openfeign.dto.AuthorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorClient authorClient;

    @GetMapping
    public List<AuthorDTO> getAll() {
        return authorClient.getAll();
    }
}

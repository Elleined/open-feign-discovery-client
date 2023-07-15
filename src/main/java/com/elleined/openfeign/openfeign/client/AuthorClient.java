package com.elleined.openfeign.openfeign.client;

import com.elleined.openfeign.openfeign.dto.AuthorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "author-api", url = "http://localhost:8080/api/v1/authors")
public interface AuthorClient {
    @GetMapping
    List<AuthorDTO> getAll();
}

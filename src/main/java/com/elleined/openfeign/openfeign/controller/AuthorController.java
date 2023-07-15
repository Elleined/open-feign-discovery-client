package com.elleined.openfeign.openfeign.controller;

import com.elleined.openfeign.openfeign.client.AuthorClient;
import com.elleined.openfeign.openfeign.dto.AuthorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorClient authorClient;
    @GetMapping
    List<AuthorDTO> getAll()  {
        return authorClient.getAll();
    }

    @GetMapping("/get-all-by-id")
    List<AuthorDTO> getAllById(@RequestParam("ids") List<Integer> authorIds) {
        return authorClient.getAllById(authorIds);
    }

    @GetMapping("/{id}")
    AuthorDTO getById(@PathVariable("id") int authorId)  {
        return authorClient.getById(authorId);
    }

    @GetMapping("/{id}/books")
    List<String> getAllBooks(@PathVariable("id") int authorId)  {
        return authorClient.getAllBooks(authorId);
    }

    @GetMapping("/{id}/books/count")
    int getBookCount(@PathVariable("id") int authorId)  {
        return authorClient.getBookCount(authorId);
    }

    @GetMapping("/name")
    List<String> searchByFirstLetter(@RequestParam("firstLetter") char firstLetter)  {
        return authorClient.searchByFirstLetter(firstLetter);
    }

    @GetMapping("/name/{name}")
    AuthorDTO getByName(@PathVariable("name") String authorName)  {
        return authorClient.getByName(authorName);
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    List<AuthorDTO> getAll(@PathVariable int pageNumber,
                           @PathVariable int pageSize) {
        return authorClient.getAll(pageNumber, pageSize);
    }

    @GetMapping("/{pageNumber}/{pageSize}/{sortDirection}/{sortProperty}")
    List<AuthorDTO> getAll(@PathVariable int pageNumber,
                           @PathVariable int pageSize,
                           @PathVariable String sortDirection,
                           @PathVariable String sortProperty) {
        return authorClient.getAll(pageNumber, pageSize, sortDirection, sortProperty);
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody AuthorDTO authorDTO) {
        return authorClient.save(authorDTO);
    }

    @PostMapping("/save-all")
    ResponseEntity<?> saveAll (@RequestBody List<AuthorDTO> authors) {
        return authorClient.saveAll(authors);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int authorId,
                             @RequestBody AuthorDTO authorDTO) {
        return authorClient.update(authorId, authorDTO);
    }
}

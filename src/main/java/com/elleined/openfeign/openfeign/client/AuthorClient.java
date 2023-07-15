package com.elleined.openfeign.openfeign.client;

import com.elleined.openfeign.openfeign.dto.AuthorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "author-api", url = "http://localhost:8080/api/v1/authors")
public interface AuthorClient {
    @GetMapping
    List<AuthorDTO> getAll() ;

    @GetMapping("/get-all-by-id")
    List<AuthorDTO> getAllById(@RequestParam("ids") List<Integer> authorIds);

    @GetMapping("/{id}")
    AuthorDTO getById(@PathVariable("id") int authorId) ;

    @GetMapping("/{id}/books")
    List<String> getAllBooks(@PathVariable("id") int authorId) ;

    @GetMapping("/{id}/books/count")
    int getBookCount(@PathVariable("id") int authorId) ;

    @GetMapping("/name")
    List<String> searchByFirstLetter(@RequestParam("firstLetter") char firstLetter) ;

    @GetMapping("/name/{name}")
    AuthorDTO getByName(@PathVariable("name") String authorName) ;

    @GetMapping("/{pageNumber}/{pageSize}")
    List<AuthorDTO> getAll(@PathVariable int pageNumber,
                           @PathVariable int pageSize);

    @GetMapping("/{pageNumber}/{pageSize}/{sortDirection}/{sortProperty}")
    List<AuthorDTO> getAll(@PathVariable int pageNumber,
                           @PathVariable int pageSize,
                           @PathVariable String sortDirection,
                           @PathVariable String sortProperty);

    @PostMapping
    ResponseEntity<?> save(@RequestBody AuthorDTO authorDTO);

    @PostMapping("/save-all")
    ResponseEntity<?> saveAll (@RequestBody List<AuthorDTO> authors);

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int authorId,
                             @RequestBody AuthorDTO authorDTO);
}

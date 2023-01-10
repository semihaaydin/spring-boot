package com.saydin.api;

import com.github.javafaker.Faker;
import com.saydin.model.Book;
import com.saydin.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookApi {

    @Autowired
    private final BookRepository bookRepository;

    public BookApi(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @PostMapping
    public void save() {
        Faker faker = new Faker();
        for(int i=0;i<=1000;i++){
            Book book=new Book();
            book.setId(faker.random().nextLong());
            book.setTitle(faker.book().title());
            book.setIsbn(faker.book().genre());
            book.setAuthor(faker.book().author());
            bookRepository.save(book);
        }
    }

    //http://localhost:8080/books?pageSize=5&page=1
    @GetMapping
    public Page<Book> pagination(@RequestParam  Integer pageSize,
                                            @RequestParam Integer page){


        Pageable pageable= PageRequest.of(page,pageSize);
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/s")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}

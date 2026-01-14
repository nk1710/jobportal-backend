package com.example.joblisting.controller;

import com.example.joblisting.model.Post;
import com.example.joblisting.repository.PostRepository;
import com.example.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:8080")
public class PostController {

    @Autowired
    private PostRepository repo;

    @Autowired
    private SearchRepository srepo;

    // ✅ GET all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    // ✅ SEARCH posts
    @GetMapping("/search/{text}")
    public List<Post> search(@PathVariable String text) {
        return srepo.findByText(text);
    }

    // ✅ CREATE post
    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return repo.save(post);
    }
}

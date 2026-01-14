package com.example.joblisting.repository;

import java.util.List;
import com.example.joblisting.model.Post;

public interface SearchRepository {
    List<Post> findByText(String text);
}

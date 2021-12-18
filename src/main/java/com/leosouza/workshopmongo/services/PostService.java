package com.leosouza.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leosouza.workshopmongo.domain.Post;
import com.leosouza.workshopmongo.repository.PostRepository;
import com.leosouza.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
    public Post findById(String id) {
        Optional<Post> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }
    
    public List<Post> findByTitle(String text) {
    	return repo.findByTitleContainingIgnoreCase(text);
    }

}

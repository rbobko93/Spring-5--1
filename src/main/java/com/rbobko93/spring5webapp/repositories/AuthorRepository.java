package com.rbobko93.spring5webapp.repositories;

import com.rbobko93.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

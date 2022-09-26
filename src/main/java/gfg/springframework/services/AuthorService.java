package gfg.springframework.services;

import java.util.List;

import gfg.springframework.model.Author;

public interface AuthorService extends CrudService<Author, Long> {

    Author findByLastName(String lastName);

    List<Author> findAllByLastNameLike(String lastName);
 }

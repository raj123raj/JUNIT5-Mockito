package gfg.springframework.repositories;


import java.util.List;

import gfg.springframework.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByLastName(String lastName);

    List<Author> findAllByLastNameLike(String lastName);
}

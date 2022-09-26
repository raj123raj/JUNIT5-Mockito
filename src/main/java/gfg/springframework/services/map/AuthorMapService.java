package gfg.springframework.services.map;

import java.util.List;
import java.util.Set;

import gfg.springframework.model.Author;
import gfg.springframework.services.AuthorService;

public class AuthorMapService extends AbstractMapService<Author, Long> implements AuthorService {   

    @Override
    public Set<Author> findAll() {
        return super.findAll();
    }

    @Override
    public Author findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Author save(Author object) {

        if(object != null){
            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public void delete(Author object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Author findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(author -> author.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Author> findAllByLastNameLike(String lastName) {

        //todo - impl
        return null;
    }
}

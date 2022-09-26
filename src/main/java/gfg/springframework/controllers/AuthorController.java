package gfg.springframework.controllers;

import javax.validation.Valid;

import gfg.springframework.model.Author;
import gfg.springframework.services.AuthorService;
import gfg.springframework.spring.BindingResult;
import gfg.springframework.spring.Model;
import gfg.springframework.spring.ModelAndView;
import gfg.springframework.spring.WebDataBinder;

import java.util.List;


public class AuthorController {
    private static final String VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM = "authors/createOrUpdateAuthorForm";

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public String findAuthors(Model model){
        model.addAttribute("author", new Author(null, null, null));
        return "authors/findAuthors";
    }

    public String processFindForm(Author author, BindingResult result, Model model){
        // allow parameterless GET request for /authors to return all records
        if (author.getLastName() == null) {
            author.setLastName(""); // empty string signifies broadest possible search
        }

        // find authors by last name
        List<Author> results = authorService.findAllByLastNameLike("%"+ author.getLastName() + "%");

        if (results.isEmpty()) {
            // no authors found
            result.rejectValue("lastName", "notFound", "not found");
            return "authors/findAuthors";
        } else if (results.size() == 1) {
            // 1 author found
            author = results.get(0);
            return "redirect:/authors/" + author.getId();
        } else {
            // multiple authors found
            model.addAttribute("selections", results);
            return "authors/authorsList";
        }
    }

    public ModelAndView showAuthor(Long authorId) {
        ModelAndView mav = new ModelAndView("authors/authorDetails");
        mav.addObject(authorService.findById(authorId));
        return mav;
    }

    public String initCreationForm(Model model) {
        model.addAttribute("author", new Author(null, null, null));
        return VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM;
    }

    public String processCreationForm(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM;
        } else {
            Author savedAuthor =  authorService.save(author);
            return "redirect:/authors/" + savedAuthor.getId();
        }
    }

    public String initUpdateAuthorForm(Long authorId, Model model) {
        model.addAttribute(authorService.findById(authorId));
        return VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM;
    }

    public String processUpdateAuthorForm(@Valid Author author, BindingResult result, Long authorId) {
        if (result.hasErrors()) {
            return VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM;
        } else {
            author.setId(authorId);
            Author savedAuthor = authorService.save(author);
            return "redirect:/authors/" + savedAuthor.getId();
        }
    }

}

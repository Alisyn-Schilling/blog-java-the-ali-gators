package org.wcci.blog;

import org.springframework.ui.Model;

public class TagsController {

    private CategoryStorage categoryStorage;
    private AuthorStorage authorStorage;
    private TagStorage tagStorage;

    public TagsController(CategoryStorage categoryStorage, AuthorStorage authorStorage, TagStorage tagStorage) {

        this.categoryStorage = categoryStorage;
        this.authorStorage = authorStorage;
        this.tagStorage = tagStorage;
    }

    public String showSingleTag(String tagName, Model model) {
        model.addAttribute("tag", tagStorage.getTagByName(tagName));
        model.addAttribute("categories", categoryStorage.getAllCategories());
        model.addAttribute("tags", tagStorage.getAllTags());
        model.addAttribute("authors", authorStorage.getAllAuthors());
        return "tag-template";
    }
}
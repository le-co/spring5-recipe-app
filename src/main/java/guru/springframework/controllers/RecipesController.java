package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipesController {

    private RecipeRepository repository;

    public RecipesController(RecipeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("recipes", repository.findAll());
        return "recipes/index";
    }

    @RequestMapping(value = {"/view/{id}"})
    public String index(Model model, @PathVariable Integer id) {
        Recipe recipe = repository.findById(id).get();
        model.addAttribute("recipe", recipe);
        return "recipes/view";
    }
}

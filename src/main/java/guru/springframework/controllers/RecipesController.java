package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/recipes")
public class RecipesController {

    private RecipeRepository repository;

    public RecipesController(RecipeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"})
    public String index(Model model) {
        List<Recipe> recipes = (List<Recipe>) repository.findAll();
        log.debug("Recipes find, list size is {}", recipes.size());
        model.addAttribute("recipes", recipes);
        return "recipes/index";
    }

    @RequestMapping(value = {"/view/{id}"})
    public String index(Model model, @PathVariable Integer id) {
        Recipe recipe = null;

        Optional<Recipe> result = repository.findById(id);

        if (!result.isPresent()) {
            log.debug("Recipe not found, return new object empty");
            recipe = new Recipe();
        } else {
            recipe = result.get();
        }

        model.addAttribute("recipe", recipe);
        return "recipes/view";
    }
}

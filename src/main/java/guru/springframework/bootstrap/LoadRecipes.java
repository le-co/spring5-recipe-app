package guru.springframework.bootstrap;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.NotesRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class LoadRecipes implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;
    private NotesRepository notesRepository;

    public LoadRecipes(CategoryRepository categoryRepository,
                       UnitOfMeasureRepository unitOfMeasureRepository,
                       RecipeRepository recipeRepository,
                       NotesRepository notesRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
        this.notesRepository = notesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Recipe recipe = new Recipe();
        recipe.setCookTime(0);
        recipe.setName("Perfect Guaca Mole");
        recipe.setDescription("Be careful handling chiles if using. Wash your hands " +
                "thoroughly after handling and do not touch your eyes or the area " +
                "near your eyes with your hands for several hours.");
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setServings(2);

        recipe.addCategory(this.categoryRepository.findByDescription("Mexican").get());
        recipe.addCategory(this.categoryRepository.findByDescription("Fast Food").get());

        recipe.setPrepTime(10);
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        recipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of " +
                "the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.)" +
                " Place in a bowl." +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide" +
                " some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness." +
                " So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with " +
                "this recipe and adjust to your taste." +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to" +
                " prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) " +
                "Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "Variations\n" +
                "\n" +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it" +
                " (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients" +
                " stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be " +
                "horrified, but so what? It tastes great.");

        Set<Ingredient> ingredients = new HashSet<>();

        Ingredient ingredient = new Ingredient();
        ingredient.setDescription("ripe avocados");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Ounce").get());

        recipe.addIngredients(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("teaspoon Kosher salt");
        ingredient.setAmount(new BigDecimal(0.5));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Teaspoon").get());

        recipe.addIngredients(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("Tbsp of fresh lime juice or lemon juice");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Tablespoon").get());

        recipe.addIngredients(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("Tbsp");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Tablespoon").get());

        recipe.addIngredients(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("minced red onion or thinly sliced green onion");
        ingredient.setAmount(new BigDecimal(0.25));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Cup").get());

        recipe.addIngredients(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("minced red onion or thinly sliced green onion");
        ingredient.setAmount(new BigDecimal(0.25));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Cup").get());

        recipe.addIngredients(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("serrano chiles, stems and seeds removed, minced");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Ounce").get());

        recipe.addIngredients(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("cilantro (leaves and tender stems), finely chopped");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Tablespoon").get());

        recipe.addIngredients(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("dash of freshly grated black pepper");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Ounce").get());

        recipe.addIngredients(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("ripe tomato, seeds and pulp removed, chopped");
        ingredient.setAmount(new BigDecimal(0.5));
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Ounce").get());

        recipe.addIngredients(ingredient);

        Recipe recipeSaved = this.recipeRepository.save(recipe);

        log.debug("save recipe on database");

        Notes notes = new Notes();

        notes.setRecipNotes("All you really need to make guacamole is ripe avocados and salt. " +
                "After that, a little lime or lemon juice—a splash of acidity—will help to balance" +
                " the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion," +
                " and/or tomato. Once you have basic guacamole down, feel free to experiment with variations" +
                " including strawberries, peaches, pineapple, mangoes, even watermelon. You can get creative" +
                " with homemade guacamole!");

        notes.setRecipe(recipeSaved);

        this.notesRepository.save(notes);

        log.debug("Create note associated the recipe {} ", recipe.getName());
    }

}

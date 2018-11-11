package guru.springframework.bootstrap;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.NotesRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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

//        File file = new File("../../resource/guaca-mole.jpg");
//        byte[] images = Files.readAllBytes(file.toPath());
//        Byte[] bytes = new Byte[images.length];
//        for (int i = 0; i < images.length; i++) {
//            bytes[i] = Byte.valueOf(images[i]);
//        }
//        recipe.setImage(bytes);

        Set<Ingredient> ingredients = new HashSet<>();

        Ingredient ingredient = new Ingredient();
        ingredient.setDescription("ripe avocados");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Ounce").get());

        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("teaspoon Kosher salt");
        ingredient.setAmount(new BigDecimal(0.5));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Teaspoon").get());

        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("Tbsp of fresh lime juice or lemon juice");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Tablespoon").get());

        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("Tbsp");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Tablespoon").get());

        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("minced red onion or thinly sliced green onion");
        ingredient.setAmount(new BigDecimal(0.25));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Cup").get());

        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("minced red onion or thinly sliced green onion");
        ingredient.setAmount(new BigDecimal(0.25));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Cup").get());

        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("serrano chiles, stems and seeds removed, minced");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Ounce").get());

        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("cilantro (leaves and tender stems), finely chopped");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Tablespoon").get());

        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("dash of freshly grated black pepper");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Ounce").get());

        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("ripe tomato, seeds and pulp removed, chopped");
        ingredient.setAmount(new BigDecimal(0.5));
        ingredient.setRecipe(recipe);
        ingredient.setUom(this.unitOfMeasureRepository.findByDescription("Ounce").get());

        ingredients.add(ingredient);

        recipe.setIngredients(ingredients);

        Recipe recipeSaved = this.recipeRepository.save(recipe);

        Notes notes = new Notes();

        notes.setRecipNotes("All you really need to make guacamole is ripe avocados and salt. " +
                "After that, a little lime or lemon juice—a splash of acidity—will help to balance" +
                " the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion," +
                " and/or tomato. Once you have basic guacamole down, feel free to experiment with variations" +
                " including strawberries, peaches, pineapple, mangoes, even watermelon. You can get creative" +
                " with homemade guacamole!");

        notes.setRecipe(recipeSaved);

        this.notesRepository.save(notes);
    }

}

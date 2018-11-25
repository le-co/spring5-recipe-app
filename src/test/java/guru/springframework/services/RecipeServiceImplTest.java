package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository repository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.recipeService = new RecipeServiceImpl(repository);
    }

    @Test
    public void getRecipes() throws Exception {

        HashSet recipes = new HashSet();
        recipes.add(new Recipe());

        when(this.repository.findAll()).thenReturn(recipes);

        Set<Recipe> result = this.recipeService.getRecipes();
        verify(this.repository, times(1)).findAll();
        assertEquals(1, result.size());
    }

}
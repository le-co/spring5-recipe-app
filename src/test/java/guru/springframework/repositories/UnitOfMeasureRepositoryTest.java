package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void findByDescriptionTeaspoon() throws Exception {

        Optional<UnitOfMeasure> teaspoon = this.unitOfMeasureRepository.findByDescription("Teaspoon");
        assertTrue(teaspoon.isPresent());
        assertEquals("Teaspoon", teaspoon.get().getDescription());
    }

}
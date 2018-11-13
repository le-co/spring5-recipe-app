package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "recipes")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}

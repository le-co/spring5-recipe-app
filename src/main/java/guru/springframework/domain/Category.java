package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Recipe> recipes;

}

package gaetanomiscio.U5_W1_D4.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "pizzas")

public class Pizza extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long pizza_id;
    @ManyToMany
    @JoinTable(name = "pizzas_toppings",
            joinColumns = @JoinColumn(name = "pizza_id", nullable = false)
            , inverseJoinColumns = @JoinColumn(name = "topping_id", nullable = false))
    private List<Topping> toppings;
}

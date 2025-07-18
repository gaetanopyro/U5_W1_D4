package gaetanomiscio.U5_W1_D4.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name = "toppings")

public class Topping extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long topping_id;
    @ManyToMany(mappedBy = "pizzas")
    private List<Pizza> pizzas;
}

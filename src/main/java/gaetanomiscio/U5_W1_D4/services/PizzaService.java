package gaetanomiscio.U5_W1_D4.services;

import gaetanomiscio.U5_W1_D4.entities.Pizza;
import gaetanomiscio.U5_W1_D4.exceptions.NotFoundException;
import gaetanomiscio.U5_W1_D4.exceptions.ValidationException;
import gaetanomiscio.U5_W1_D4.repositories.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public void saveItem(Pizza newPizza) {
        if (newPizza.getName().length() < 2)
            throw new ValidationException("Il nome non può essere più corto di 2 caratteri!");
        pizzaRepository.save(newPizza);
        log.info(("La pizza " + newPizza.getName() + " è stata salvata correttamente!"));
    }

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public Pizza findById(long pizzaId) {
        return pizzaRepository.findById(pizzaId).orElseThrow(() -> new NotFoundException(pizzaId));
    }

    public void saveMany(List<Pizza> newPizza) {
        for (Pizza pizza : newPizza) {
            try {
                this.saveItem(pizza);
            } catch (ValidationException ex) {
                log.error(ex.getMessage());
            }
        }
    }

}

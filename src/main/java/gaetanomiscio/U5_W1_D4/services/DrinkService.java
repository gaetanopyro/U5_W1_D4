package gaetanomiscio.U5_W1_D4.services;

import gaetanomiscio.U5_W1_D4.entities.Drink;
import gaetanomiscio.U5_W1_D4.exceptions.NotFoundException;
import gaetanomiscio.U5_W1_D4.exceptions.ValidationException;
import gaetanomiscio.U5_W1_D4.repositories.DrinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    public void saveItem(Drink newDrink) {
        if (newDrink.getName().length() < 2)
            throw new ValidationException("Il nome non può essere più corto di 2 caratteri!");
        drinkRepository.save(newDrink);
        log.info(("Il drink " + newDrink.getName() + " è stato salvato correttamente!"));
    }

    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    public Drink findById(long drinkId) {
        return drinkRepository.findById(drinkId).orElseThrow(() -> new NotFoundException(drinkId));
    }

    public void saveMany(List<Drink> newDrink) {
        for (Drink drink : newDrink) {
            try {
                this.saveItem(drink);
            } catch (ValidationException ex) {
                log.error(ex.getMessage());
            }
        }
    }

}

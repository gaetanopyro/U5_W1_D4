package gaetanomiscio.U5_W1_D4.services;

import gaetanomiscio.U5_W1_D4.entities.Topping;
import gaetanomiscio.U5_W1_D4.exceptions.NotFoundException;
import gaetanomiscio.U5_W1_D4.exceptions.ValidationException;
import gaetanomiscio.U5_W1_D4.repositories.ToppingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ToppingService {
    @Autowired
    private ToppingRepository toppingRepository;

    public void saveItem(Topping newTopping) {
        if (newTopping.getName().length() < 2)
            throw new ValidationException("Il nome non può essere più corto di 2 caratteri!");
        toppingRepository.save(newTopping);
        log.info(("Il topping " + newTopping.getName() + " è stato salvato correttamente!"));
    }

    public List<Topping> findAll() {
        return toppingRepository.findAll();
    }

    public Topping findById(long toppingId) {
        return toppingRepository.findById(toppingId).orElseThrow(() -> new NotFoundException(toppingId));
    }

    public void saveMany(List<Topping> newTopping) {
        for (Topping topping : newTopping) {
            try {
                this.saveItem(topping);
            } catch (ValidationException ex) {
                log.error(ex.getMessage());
            }
        }
    }

}

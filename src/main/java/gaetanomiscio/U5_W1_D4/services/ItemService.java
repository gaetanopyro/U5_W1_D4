package gaetanomiscio.U5_W1_D4.services;

import gaetanomiscio.U5_W1_D4.entities.Item;
import gaetanomiscio.U5_W1_D4.exceptions.NotFoundException;
import gaetanomiscio.U5_W1_D4.exceptions.ValidationException;
import gaetanomiscio.U5_W1_D4.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void saveItem(Item newItem) {
        if (newItem.getName().length() < 2)
            throw new ValidationException("Il nome non può essere più corto di 2 caratteri!");
        itemRepository.save(newItem);
        log.info(("l'item " + newItem.getName() + " è stato salvato correttamente!"));
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(long itemId) {
        return itemRepository.findById(itemId).orElseThrow(() -> new NotFoundException(itemId));
    }

    public void saveMany(List<Item> newUItem) {
        for (Item item : newUItem) {
            try {
                this.saveItem(item);
            } catch (ValidationException ex) {
                log.error(ex.getMessage());
            }
        }
    }

}

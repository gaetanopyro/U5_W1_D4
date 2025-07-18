package gaetanomiscio.U5_W1_D4.repositories;

import gaetanomiscio.U5_W1_D4.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}



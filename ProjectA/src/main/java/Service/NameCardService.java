package Service;

import Domain.NameCard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface NameCardService {
    void addNameCard(NameCard nameCard);
    void deleteAllNameCards();
    @Transactional(readOnly = true)
    List<NameCard> getNameCards(String name);
}

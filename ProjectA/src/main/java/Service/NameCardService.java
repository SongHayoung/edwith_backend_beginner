package Service;

import Domain.NameCard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface NameCardService {
    void addNameCard(String name, String phone, String Company);
    void deleteAllNameCards();
    @Transactional(readOnly = true)
    List<NameCard> getNameCards(String name);
    List<String> getNameCardsAsString(String name);
}

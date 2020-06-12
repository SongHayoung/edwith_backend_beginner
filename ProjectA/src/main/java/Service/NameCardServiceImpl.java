package Service;

import Dao.NameCardDao;
import Domain.NameCard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class NameCardServiceImpl implements NameCardService{
    private NameCardDao nameCardDao;

    public void setNameCardDao(NameCardDao nameCardDao) { this.nameCardDao = nameCardDao; }

    public void addNameCard(NameCard nameCard){ nameCardDao.addNameCard(nameCard); }

    public void deleteAllNameCards() { nameCardDao.deleteAllNameCards(); }

    public List<NameCard> getNameCards(String name) { return nameCardDao.getNameCards(name); }
}

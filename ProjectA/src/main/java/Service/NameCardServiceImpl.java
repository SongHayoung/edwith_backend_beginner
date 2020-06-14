package Service;

import Dao.NameCardDao;
import Domain.NameCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("nameCardService")
public class NameCardServiceImpl implements NameCardService{
    @Autowired private NameCardDao nameCardDao;

    public void setNameCardDao(NameCardDao nameCardDao) { this.nameCardDao = nameCardDao; }

    public void addNameCard(String name, String phone, String company){ nameCardDao.addNameCard(new NameCard(name, phone, company)); }

    public void deleteAllNameCards() { nameCardDao.deleteAllNameCards(); }

    public List<NameCard> getNameCards(String name) { return nameCardDao.getNameCards(name); }

    public List<String> getNameCardsAsString(String name) {
        List<NameCard> nameCardList = getNameCards(name);
        List<String> nameCardListAsString = new ArrayList<String>();

        for(NameCard nameCard : nameCardList)
            nameCardListAsString.add(getNameCardFormat(nameCard));
        return nameCardListAsString;
    }

    private String getNameCardFormat(NameCard nameCard) {
        return  "BussinessCard{name='" + nameCard.getName() + "', phone='" + nameCard.getPhone() +
                "', companyName='" + nameCard.getCompany() + "', createDate=" +nameCard.getDate() + "}\n";
    }
}

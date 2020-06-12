package Dao;

import Domain.NameCard;

import java.util.List;

public interface NameCardDao {
    void addNameCard(NameCard nameCard);
    void deleteAllNameCards();
    List<NameCard> getNameCards(String name);
}

package NameCardTest;

import Domain.NameCard;
import Service.NameCardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Config/applicationContext.xml")
public class NameCardServiceTest {
    @Autowired NameCardService nameCardService;
    @Autowired PlatformTransactionManager transactionManager;
    List<NameCard> nameCards;

    @Before
    public void setUp(){
        nameCards = Arrays.asList(
                new NameCard("사용자1", "010-0000-0000", "백수"),
                new NameCard("사용자2", "010-1234-1234", "개백수"),
                new NameCard("카이도우", "010-5678-5678", "백수의왕")
        );
    }

    @Test
    public void addAndget() throws SQLException {
        nameCardService.deleteAllNameCards();

        nameCardService.addNameCard(nameCards.get(0));
        nameCardService.addNameCard(nameCards.get(1));
        nameCardService.addNameCard(nameCards.get(2));

        NameCard nameCardsget1 = nameCardService.getNameCards(nameCards.get(0).getName()).get(0);
        checkSameCard(nameCardsget1,nameCards.get(0));

        NameCard nameCardsget2 = nameCardService.getNameCards(nameCards.get(1).getName()).get(0);
        checkSameCard(nameCardsget2,nameCards.get(1));

        NameCard nameCardsget3 = nameCardService.getNameCards(nameCards.get(2).getName()).get(0);
        checkSameCard(nameCardsget3,nameCards.get(2));
    }

    @Test
    public void getList() throws SQLException{
        nameCardService.deleteAllNameCards();

        nameCardService.addNameCard(nameCards.get(0));
        nameCardService.addNameCard(nameCards.get(1));

        List<NameCard> nameCardgetlist = nameCardService.getNameCards(nameCards.get(0).getName().substring(0,2));
        assertThat(nameCardgetlist.size(), is(2));
        checkSameCard(nameCards.get(0),nameCardgetlist.get(0));
        checkSameCard(nameCards.get(1),nameCardgetlist.get(1));
    }

    private void checkSameCard(NameCard nameCard1, NameCard nameCard2){
        assertThat(nameCard1.getName(), is(nameCard2.getName()));
        assertThat(nameCard1.getPhone(), is(nameCard2.getPhone()));
        assertThat(nameCard1.getCompany(), is(nameCard2.getCompany()));
        assertThat(nameCard1.getDate(), is(nameCard2.getDate()));
    }
}

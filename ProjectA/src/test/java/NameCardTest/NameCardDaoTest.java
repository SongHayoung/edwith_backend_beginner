package NameCardTest;

import Dao.NameCardDao;
import Domain.NameCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Config/applicationContext.xml")
public class NameCardDaoTest {
    @Autowired ApplicationContext context;
    @Autowired DataSource dataSource;
    private NameCardDao nameCardDao;
    private NameCard nameCard1;
    private NameCard nameCard2;
    private NameCard nameCard3;

    @Before
    public void setUp(){
        this.nameCardDao = context.getBean("nameCardDao", NameCardDao.class);
        this.nameCard1 = new NameCard("사용자1", "010-0000-0000", "백수");
        this.nameCard2 = new NameCard("사용자2", "010-1234-1234", "개백수");
        this.nameCard3 = new NameCard("카이도우", "010-5678-5678", "백수의왕");
    }

    @Test
    public void addAndget() throws SQLException {
        nameCardDao.deleteAllNameCards();

        nameCardDao.addNameCard(nameCard1);
        nameCardDao.addNameCard(nameCard2);
        nameCardDao.addNameCard(nameCard3);

        NameCard nameCardget1 = nameCardDao.getNameCards(nameCard1.getName()).get(0);
        checkSameCard(nameCard1,nameCardget1);

        NameCard nameCardget2 = nameCardDao.getNameCards(nameCard2.getName()).get(0);
        checkSameCard(nameCard2,nameCardget2);

        NameCard nameCardget3 = nameCardDao.getNameCards(nameCard3.getName()).get(0);
        checkSameCard(nameCard3,nameCard3);
    }

    @Test
    public void getList() throws SQLException{
        nameCardDao.deleteAllNameCards();

        nameCardDao.addNameCard(nameCard1);
        nameCardDao.addNameCard(nameCard2);

        List<NameCard> nameCardgetlist = nameCardDao.getNameCards(nameCard1.getName().substring(0,2));
        assertThat(nameCardgetlist.size(), is(2));
        checkSameCard(nameCard1,nameCardgetlist.get(0));
        checkSameCard(nameCard2,nameCardgetlist.get(1));
    }

    private void checkSameCard(NameCard nameCard1, NameCard nameCard2){
        assertThat(nameCard1.getName(), is(nameCard2.getName()));
        assertThat(nameCard1.getPhone(), is(nameCard2.getPhone()));
        assertThat(nameCard1.getCompany(), is(nameCard2.getCompany()));
        assertThat(nameCard1.getDate(), is(nameCard2.getDate()));
    }
}

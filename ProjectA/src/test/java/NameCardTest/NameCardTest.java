package NameCardTest;

import Domain.NameCard;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NameCardTest {
    private NameCard nameCard;
    @Before
    public void setUp(){
        nameCard = new NameCard("송하영", "010-0000-0000", "백수");
    }

    @Test
    public void getInfo(){
        assertThat(nameCard.getName(),is(nameCard.getName()));
        assertThat(nameCard.getPhone(),is(nameCard.getPhone()));
        assertThat(nameCard.getCompany(),is(nameCard.getCompany()));
        assertThat(nameCard.getDate(),is(nameCard.getDate()));
    }
}

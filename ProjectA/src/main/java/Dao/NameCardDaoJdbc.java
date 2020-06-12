package Dao;

import Domain.NameCard;
import SqlService.SqlService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NameCardDaoJdbc implements NameCardDao{
    private SqlService sqlService;
    private JdbcTemplate jdbcTemplate;
    private RowMapper<NameCard> nameCardRowMapper =
            new RowMapper<NameCard>() {
                public NameCard mapRow(ResultSet rs, int rowNum) throws SQLException {
                    NameCard nameCard = new NameCard();
                    nameCard.setName(rs.getString("name"));
                    nameCard.setCompany(rs.getString("company"));
                    nameCard.setPhone(rs.getString("phone"));
                    nameCard.setDate(rs.getString("date"));
                    return nameCard;
                }
            };

    public void setDataSource(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }
    public void setSqlService(SqlService sqlService) { this.sqlService = sqlService; }

    public void addNameCard(NameCard nameCard){
        this.jdbcTemplate.update(this.sqlService.getSql("namecardAdd"),
                nameCard.getName(), nameCard.getPhone(), nameCard.getCompany(), nameCard.getDate());
    }

    public void deleteAllNameCards(){
        this.jdbcTemplate.update(this.sqlService.getSql("namecardDeleteAll"));
    }

    public List<NameCard> getNameCards(String name){
        return this.jdbcTemplate.query(this.sqlService.getSql("namecardGet"), new Object[] {name + "%"}, this.nameCardRowMapper);
    }
}

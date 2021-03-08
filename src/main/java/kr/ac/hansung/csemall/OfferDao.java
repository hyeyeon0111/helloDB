package kr.ac.hansung.csemall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("offerDao")
public class OfferDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// Read: query and return the number of objects
	public int getRowCount() {

		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// Read: query and return a single object
	public Offer getOffer(String name) { // 이름이 유일하다고 가정

		String sqlStatement = "select * from offers where name=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}

		});

	}

	// Read: query and return multiple objects
	public List<Offer> getOffers() {

		String sqlStatement = "select * from offers";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}

		});

	}
	
	// Create
	public boolean insert(Offer offer) {
		
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		
		String sqlStatement = "insert into offers (name, email, text) values(?,?,?)";
		
		// update: return record count
		return (jdbcTemplate.update(sqlStatement, new Object[] {name, email, text}) == 1);
	}
	
	// Update
	public boolean update(Offer offer) {
		
		int id = offer.getId();
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		
		String sqlStatement = "update offers set name=?, email=?, text=? where id=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {name, email, text, id}) == 1);
	}
	
	// Delete
	public boolean delete(int id) {
		
		String sqlStatement = "delete from offers where id=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
	}

}

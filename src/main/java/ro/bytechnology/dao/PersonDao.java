package ro.bytechnology.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.bytechnology.db.Person;

@Repository
public class PersonDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addPerson(Person person){
        jdbcTemplate.update("INSERT INTO PERSON VALUES(NULL,?,?)",person.getName(),person.getAge());
    }
}

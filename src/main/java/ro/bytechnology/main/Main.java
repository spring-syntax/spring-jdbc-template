package ro.bytechnology.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.bytechnology.service.PersonService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("configuration.xml");

        DataSource dataSource = context.getBean(DataSource.class);
        try (Connection con = dataSource.getConnection()){
            String sql = "CREATE TABLE PERSON (\n" +
                    "    ID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    Name varchar(255),\n" +
                    "    Age int,\n" +
                    ");";
            Statement stmt = con.createStatement();
            stmt.execute("DROP TABLE IF EXISTS PERSON;");
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PersonService personService = context.getBean(PersonService.class);
        personService.addPersons(3);
        System.out.println("Added 3 persons to DB!");
        personService.addPersons(4);
        System.out.println("Added 4 persons to DB!");

        context.close();

    }
}

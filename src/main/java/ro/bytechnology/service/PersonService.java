package ro.bytechnology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.bytechnology.dao.PersonDao;
import ro.bytechnology.db.Person;

import java.util.Random;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public void addPersons(int n){
        Person person;
        Random random = new Random();
        for(int i=0;i<n;i++){
            int x = random.nextInt(1000)+1;
            person=new Person("Name_"+x,x);
            personDao.addPerson(person);
        }
    }
}



import java1.dao.PersonMapper;
import java1.entity.Person;
import java1.service.PersonService;
import java1.util.CacheContextUtil;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Suncm
 * @ClassName PersonTest
 * @Date 2018/12/19 10:51
 * @Version 1.0
 */
public class PersonTest {

    @Test
    public void selectAllPerson(){
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonMapper dao = (PersonMapper) context.getBean("personMapper");
        List<Person> people = dao.selectAllPerson();
        for (Person person:people
             ) {
            System.out.println(person);
        }
    }

    @Test
    public void findAllPerson(){
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService service = (PersonService) context.getBean("personService");
        List<Person> people = service.findAllPerson();
        for (Person person:people
                ) {
            System.out.println(person);
        }*/
        PersonService personService =(PersonService) CacheContextUtil.getBean("personService");
        List<Person> people = personService.findAllPerson();
        for (Person person:people
                ) {
            System.out.println(person);
        }
    }
}

package java1.serviceImpl;

import java1.dao.PersonMapper;
import java1.entity.Person;
import java1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Suncm
 * @ClassName PersonServiceImpl
 * @Date 2018/12/19 11:26
 * @Version 1.0
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public List<Person> findAllPerson() {
        List<Person> personList = personMapper.selectAllPerson();
        return personList;
    }
}

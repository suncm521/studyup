package java1.dao;

import java1.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("personMapper")
public interface PersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    public List<Person> selectAllPerson();
}
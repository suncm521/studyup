package java1.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.tools.internal.ws.processor.model.Model;
import java1.entity.Person;
import java1.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Suncm
 * @ClassName PersonController
 * @Date 2018/12/19 11:31
 * @Version 1.0
 */
@Controller
public class PersonController {

    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Resource
    private PersonService personService;

    @RequestMapping("/getAllPerson")
    @ResponseBody
    public String getAllPerson(){
        List<Person> allPerson = personService.findAllPerson();
        return JSONArray.toJSONString(allPerson);
    }
}

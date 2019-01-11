import java1.util.CacheContextUtil;
import java1.util.CacheUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Suncm
 * @ClassName RedisTest
 * @Date 2019/1/7 13:57
 * @Version 1.0
 */
public class RedisTest {
    @Test
    public void test1(){
        boolean b = CacheUtil.setString("123", "redis");//向redis里存字符串 key-value
        System.out.println(b);//true成功，
        System.out.println(CacheUtil.getString("123"));//从radis里取数据 key
    }
}
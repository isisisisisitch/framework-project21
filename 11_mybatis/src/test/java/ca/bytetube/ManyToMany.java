package ca.bytetube;

import ca.bytetube.bean.BankCard;
import ca.bytetube.bean.Job;
import ca.bytetube.bean.Person;
import ca.bytetube.util.Mybatises;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ManyToMany {
    @Test
    public void testPersonList() {
        SqlSession sqlSession = Mybatises.openSession();
        List<Person> list = sqlSession.selectList("person.list");
        for (Person person : list) {
            System.out.println(person);
        }

    }

    @Test
    public void testJobList() {
        SqlSession sqlSession = Mybatises.openSession();
        List<Job> list = sqlSession.selectList("job.list");
        for (Job card : list) {
            System.out.println(card);
        }

    }
}
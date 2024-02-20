package ca.bytetube;

import ca.bytetube.bean.BankCard;
import ca.bytetube.bean.IdCard;
import ca.bytetube.bean.Person;
import ca.bytetube.util.Mybatises;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class OneToMany {
    @Test
    public void testPersonList() {
        SqlSession sqlSession = Mybatises.openSession();
        List<Person> list = sqlSession.selectList("person.list");
        for (Person person : list) {
            System.out.println(person);
        }

    }

    @Test
    public void testBankCardList() {
        SqlSession sqlSession = Mybatises.openSession();
        List<BankCard> list = sqlSession.selectList("bankCard.list");
        for (BankCard card : list) {
            System.out.println(card);
        }

    }
}
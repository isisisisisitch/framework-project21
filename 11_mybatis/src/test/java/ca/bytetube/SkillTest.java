package ca.bytetube;

import ca.bytetube.bean.Skill;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillTest {

    @Test
    public void test1() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        List<Skill> list = sqlSession.selectList("skill.list");
        for (Skill skill : list) {
            System.out.println(skill);
        }

    }

    @Test
    public void test2() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();

        Skill skill = sqlSession.selectOne("skill.selectById", 1);
        System.out.println(skill);

    }

    @Test
    public void test3() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("level",500);

        List<Skill> list = sqlSession.selectList("skill.list2",map);
        for (Skill skill : list) {
            System.out.println(skill);
        }

    }

}

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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SkillTest {

    @Test
    public void test10() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession(true);
        Integer[] ids = {33,34,35,36};
        sqlSession.delete("skill.batchDelete",ids);



    }

    @Test
    public void test9() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession(true);
        List<Skill> list = new LinkedList<>();
        Skill skill1 = new Skill();
        skill1.setName("abc1");
        skill1.setLevel(10);
        list.add(skill1);
        Skill skill2 = new Skill();
        skill2.setName("abc2");
        skill2.setLevel(11);
        list.add(skill2);
        Skill skill3 = new Skill();
        skill3.setName("abc3");
        skill3.setLevel(12);
        list.add(skill3);
        Skill skill4 = new Skill();
        skill4.setName("abc4");
        skill4.setLevel(13);
        list.add(skill4);
       sqlSession.insert("batchInsert",list);


    }


    @Test
    public void test8() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        Skill skill = new Skill();
        skill.setName("%ava%");
        skill.setId(10);
        List<Skill> list = sqlSession.selectList("skill.dynamicSQL", skill);
        for (Skill s : list) {
            System.out.println(s);
        }

    }

    @Test
    public void test7() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession(true);

        sqlSession.delete("skill.delete", 25);

        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession(true);
        Skill skill = new Skill("R", 100);
        skill.setId(26);
        sqlSession.update("skill.update", skill);

        //sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void test5() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession(true);
        Skill skill = new Skill("test2", 200);

        sqlSession.insert("skill.insert", skill);

        System.out.println(skill);

        //sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void test4() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        Skill skill = new Skill("%ava%", 200);

        List<Skill> list = sqlSession.selectList("skill.list3", skill);
        for (Skill s : list) {
            System.out.println(s);
        }

    }

    @Test
    public void test3() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("level", 500);

        List<Skill> list = sqlSession.selectList("skill.list2", map);
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
    public void test1() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        List<Skill> list = sqlSession.selectList("skill.list");
        for (Skill skill : list) {
            System.out.println(skill);
        }

    }

}

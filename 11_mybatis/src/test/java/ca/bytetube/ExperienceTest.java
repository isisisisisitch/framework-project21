package ca.bytetube;

import ca.bytetube.bean.Experience;
import ca.bytetube.bean.Skill;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExperienceTest {

    @Test
    public void test1() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        List<Experience> list = sqlSession.selectList("experience.list");
        for (Experience skill : list) {
            System.out.println(skill);
        }

    }


}

package ca.bytetube.util;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class StringsTest {


    @Test
    public void underlineCased() {
        Assert.assertTrue(Strings.underlineCased("MyFirstLove").equals("my_first_love"));
        Assert.assertTrue(Strings.underlineCased("myFirstLove").equals("my_first_love"));
    }
}

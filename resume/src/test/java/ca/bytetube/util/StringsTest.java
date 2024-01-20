package ca.bytetube.util;


import org.junit.Assert;
import org.junit.Test;

public class StringsTest {


    @Test
    public void underlineCased() {
        Assert.assertTrue(Strings.underlineCased("MyFirstLove").equals("my_first_love"));
        Assert.assertTrue(Strings.underlineCased("myFirstLove").equals("my_first_love"));
    }
}

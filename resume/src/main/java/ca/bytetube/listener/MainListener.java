package ca.bytetube.listener;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class MainListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // null参数表示允许值为null
        DateConverter dateConverter = new DateConverter(null);
        dateConverter.setPatterns(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"});
        ConvertUtils.register(dateConverter, Date.class);

        // 调试
//        Beans.debug = true;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

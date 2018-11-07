package cn.yyt.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

import java.util.Properties;


@Configuration //表示这个类是用来配置的
public class PageHelperConfig {

    @Bean   //表示启动这个拦截器
    public PageHelper pageHelper() {
        PageHelper page = new PageHelper();
        Properties p = new Properties();
        //offsetAsPageNum:设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用.
        p.setProperty("offsetAsPageNum","true");
        //rowBoundsWithCount:设置为true时，使用RowBounds分页会进行count查询.
        p.setProperty("rowBoundsWithCount","true");
        //reasonable：启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页。
        p.setProperty("reasonable","true");
        page.setProperties(p);
        return page;
    }
}

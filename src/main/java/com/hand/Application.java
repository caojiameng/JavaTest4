package com.hand;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.infra.mapper.FilmMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import sun.nio.ch.FileLockImpl;

/**
 * Hello world!
 *
 */
public class Application
{
    public static void main( String[] args )  {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        FilmMapper filmMapper = context.getBean(FilmMapper.class);
        FilmService filmService = (FilmService) context.getBean("filmService");
        System.out.println("Context Start");
        String title = System.getenv("TITLE");
        String description = System.getenv("DESCRIPTION");
        Integer languageId = Integer.valueOf(System.getenv("LANGUAGE_ID"));
/*        String title = "Film one";
        String description = "nothing new";
        Integer languageId = 1;*/


        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguageId(languageId);

        System.out.println("Film Title:");
        System.out.println(title);
        System.out.println("Film Description:");
        System.out.println(description);
        System.out.println("Film LanguageId:");
        System.out.println(languageId);



        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        DataSourceTransactionManager txManager = (DataSourceTransactionManager) context.getBean("transactionManager");
        // 事务异常回滚
        TransactionStatus status = txManager.getTransaction(def);
        try {
            filmService.insertFilm(film);
            throw new Exception("测试一下异常");
        }
        catch (Exception ex) {
            txManager.rollback(status);
            ex.printStackTrace();
        }

        // 事务正常处理
        TransactionStatus status2 = txManager.getTransaction(def);
        try {
            filmService.insertFilm(film);
        }
        catch (Exception ex) {
            txManager.rollback(status2);
            ex.printStackTrace();
        }
        txManager.commit(status2);
        System.out.println("Context stop");

        //System.out.println(System.getenv("MYSQL_IP"));
    }
}

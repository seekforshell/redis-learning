package a.b.c;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("a.b.c.orm.dao")
public class SaleMain {
    public static void main(String[] args) {
        SpringApplication.run(SaleMain.class, args);
    }
}

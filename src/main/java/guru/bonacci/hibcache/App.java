package guru.bonacci.hibcache;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

       
    @Bean
    CommandLineRunner initialize(FooRepo repo) {
        return args -> {
            Stream.of("John", "Robert", "Nataly", "Helen", "Mary").forEach(bar -> {
                log.info("inserted with id " + repo.save(new Foo(bar)).getId());
            });
            
            Foo foo = new Foo("bbbbar");
            repo.save(foo);
            log.info("has id " + foo.getId());

            log.info("should not print query");
            log.info(""+repo.findById(foo.getId()).get());
            log.info("did not print query");

            log.info("should print query");
            repo.findById(10l);
            log.info("printed query");
        };
    }
    
    
}

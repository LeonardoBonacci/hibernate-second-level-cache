package guru.bonacci.hibcache;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    
    
    @Bean
    CommandLineRunner initialize(FooRepo repo) {
        return args -> {
            Stream.of("John", "Robert", "Nataly", "Helen", "Mary").forEach(bar -> {
                repo.save(new Foo(bar));
            });
            repo.findAll().forEach(System.out::println);
            
            
            
            Foo foo = new Foo();
            repo.save(foo);
            System.out.println(foo.getId());

            // does not print query
            System.out.println(repo.findById(foo.getId()).get());
            System.out.println(repo.findById(foo.getId()).get());

            // does print query
            repo.findById(10l);

        };
    }
    
    
}

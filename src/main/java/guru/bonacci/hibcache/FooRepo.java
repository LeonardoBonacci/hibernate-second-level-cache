package guru.bonacci.hibcache;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepo extends JpaRepository<Foo, Long> {
}

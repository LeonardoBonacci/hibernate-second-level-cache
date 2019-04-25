package guru.bonacci.hibcache;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "foos", path = "foos")
public interface FooRepo extends JpaRepository<Foo, Long> {
	
	List<Foo> findByBar(@Param("bar") String bar);
}

package guru.bonacci.hibcache;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Foo {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public Foo(final String name) {
        this.name = name;
    }
}

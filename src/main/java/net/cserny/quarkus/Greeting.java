package net.cserny.quarkus;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.NotFoundException;

@Entity
public class Greeting extends PanacheEntity {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    public String name;
    public String prefix;
    public String postfix;

    public static Greeting findByName(String name) {
        Greeting greeting = find("name", name).firstResult();
        if (greeting == null) {
            throw new NotFoundException("Greeting with name '" + name + "' not found");
        }
        return greeting;
    }
}

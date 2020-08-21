package net.cserny.quarkus;

import io.netty.util.internal.StringUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
class GreetingService {

    String greeting(String name) {
        Greeting greeting = Greeting.findByName(name);
        String prefix = "Hello";
        if (!StringUtil.isNullOrEmpty(greeting.prefix)) {
            prefix = greeting.prefix;
        }
        return prefix + " " + greeting.name;
    }

    @Transactional
    void save(Greeting greeting) {
        if (greeting == null) {
            return;
        }
        greeting.persist();
    }
}

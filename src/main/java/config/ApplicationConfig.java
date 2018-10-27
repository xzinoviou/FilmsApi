package config;

import service.UserServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzinoviou
 * 27/10/2018
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {

        @Override
        public Set<Class<?>> getClasses() {
            final Set<Class<?>> classes = new HashSet<>();
            classes.add(UserServiceImpl.class);
            return classes;
        }

}


package ru.unit.techno.arris.log.action.test.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"ru.unit.techno.ariss.log.action.lib.entity"})
@EnableJpaRepositories(basePackages = {"ru.unit.techno.ariss.log.action.lib.repository"})
@SpringBootApplication
public class LoaderClass {
    public static void main(String[] args) {
        SpringApplication.run(LoaderClass.class, args);
    }
}
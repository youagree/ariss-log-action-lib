package ru.unit.techno.arris.log.action.test.module.init;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;
import ru.unit.techno.ariss.log.action.lib.repository.EventRepository;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class StartDataLoader implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        eventRepository.deleteAll();

        Resource resource = new ClassPathResource("init-data.sql");
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(resource);
        populator.setSqlScriptEncoding("UTF-8");
        populator.execute(Objects.requireNonNull(jdbcTemplate.getDataSource()));
    }
}

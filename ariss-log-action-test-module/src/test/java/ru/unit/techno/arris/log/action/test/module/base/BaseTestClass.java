
package ru.unit.techno.arris.log.action.test.module.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.unit.techno.ariss.log.action.lib.repository.EventRepository;
import ru.unit.techno.ariss.log.action.lib.service.ActionService;

@Slf4j
@IntegrationTest
public class BaseTestClass {

    @Autowired
    protected TestUtils testUtils;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected EventRepository eventRepository;

    @Autowired
    protected ActionService actionService;

    private static final String DB_NAME = "unit_techno";

    private static final PostgreSQLContainer postgresDB = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName(DB_NAME)
            .withUsername("postgres")
            .withPassword("postgres")
            .withExposedPorts(5432)
            .withClasspathResourceMapping("init.sql", "/docker-entrypoint-initdb.d/init.sql", BindMode.READ_ONLY);

    static {
        postgresDB.start();
    }

    @AfterEach
    public void destroy() {
        //todo
    }
}
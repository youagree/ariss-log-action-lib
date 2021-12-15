
package ru.unit.techno.arris.log.action.test.module.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
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
    public static String DB_URL = null;

    private static final PostgreSQLContainer postgresDB = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName(DB_NAME)
            .withUsername("postgres")
            .withPassword("postgres")
            .withClasspathResourceMapping("init.sql", "/docker-entrypoint-initdb.d/init.sql", BindMode.READ_ONLY);

    static {
        postgresDB.start();
        DB_URL = String.format("jdbc:postgresql://%s:%d/unit_techno?currentSchema=log_action_test",
                postgresDB.getContainerIpAddress(),
                postgresDB.getFirstMappedPort());
    }

    @DynamicPropertySource
    static void dynamicSource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> DB_URL);
    }

    @After
    public void destroy() {
        eventRepository.deleteAll();
    }
}
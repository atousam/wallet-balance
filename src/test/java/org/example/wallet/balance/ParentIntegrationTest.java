package org.example.wallet.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@Testcontainers
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=none"})
public class ParentIntegrationTest {
    @LocalServerPort
    protected Integer port;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Container
    @ServiceConnection
    protected static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0-debian");

}

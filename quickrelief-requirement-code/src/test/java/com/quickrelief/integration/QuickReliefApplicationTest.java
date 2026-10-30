package com.quickrelief.integration;

import com.quickrelief.QuickReliefApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = QuickReliefApplication.class)
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
class QuickReliefApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void schemaShouldCreateBothRequiredTables() {

        Integer supplies = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES " +
                        "WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'supplies'",
                Integer.class
        );

        Integer requests = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES " +
                        "WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'requests'",
                Integer.class
        );

        assertThat(supplies).isEqualTo(1);
        assertThat(requests).isEqualTo(1);
    }
}

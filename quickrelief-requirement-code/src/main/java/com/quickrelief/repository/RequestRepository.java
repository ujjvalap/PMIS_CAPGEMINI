package com.quickrelief.repository;

import com.quickrelief.model.SupplyRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class RequestRepository {

    private final JdbcTemplate jdbcTemplate;

    public RequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SupplyRequest insert(
            String itemName,
            int quantity,
            String requestedBy) {

        String sql = """
            INSERT INTO requests (item_name, quantity, status, requested_by)
            VALUES (?, ?, ?, ?)
            """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, itemName);
            statement.setInt(2, quantity);
            statement.setString(3, "APPROVED");
            statement.setString(4, requestedBy);
            return statement;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key == null) {
            throw new IllegalStateException("Could not retrieve the created request ID");
        }

        return new SupplyRequest(
            key.longValue(), itemName, quantity, "APPROVED", requestedBy);
    }
}

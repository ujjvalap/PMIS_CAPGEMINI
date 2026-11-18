package com.quickrelief.repository;

import com.quickrelief.model.Supply;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SupplyRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Supply> supplyRowMapper = (rs, rowNum) ->
        new Supply(
            rs.getLong("id"),
            rs.getString("item_name"),
            rs.getInt("quantity")
        );

    public SupplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Supply> findAll() {
        String sql = """
            SELECT id, item_name, quantity
            FROM supplies
            ORDER BY item_name
            """;
        return jdbcTemplate.query(sql, supplyRowMapper);
    }

    public Optional<Supply> findByItemName(String itemName) {
        String sql = """
            SELECT id, item_name, quantity
            FROM supplies
            WHERE item_name = ?
            """;

        return jdbcTemplate.query(sql, supplyRowMapper, itemName)
            .stream()
            .findFirst();
    }

    public int insert(String itemName, int quantity) {
        String sql = """
            INSERT INTO supplies (item_name, quantity)
            VALUES (?, ?)
            """;
        return jdbcTemplate.update(sql, itemName, quantity);
    }

    public int restock(long id, int quantity) {
        String sql = """
            UPDATE supplies
            SET quantity = quantity + ?
            WHERE id = ?
            """;
        return jdbcTemplate.update(sql, quantity, id);
    }

    public int deductIfAvailable(String itemName, int quantity) {
        // The condition is checked and stock is deducted by one atomic SQL statement.
        String sql = """
            UPDATE supplies
            SET quantity = quantity - ?
            WHERE item_name = ?
              AND quantity >= ?
            """;
        return jdbcTemplate.update(sql, quantity, itemName, quantity);
    }
}

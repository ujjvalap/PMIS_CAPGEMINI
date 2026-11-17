# QuickRelief — Campus Emergency Supply Tracker

This project follows the supplied challenge requirements:
- Java 17+ and Spring Boot 3.x
- Maven
- `JdbcTemplate` with explicit SQL (no JPA/Hibernate)
- Two tables: `supplies` and `requests`
- `POST /api/supplies`
- `GET /api/supplies`
- `POST /api/requests`
- Transactional inventory validation and deduction
- Custom `RowMapper`
- Validation, consistent API errors, unit test and integration test

## Run

Prerequisites: JDK 17+ and Maven 3.9+.

```bash
mvn clean test
mvn spring-boot:run
```

The project uses H2 in-memory by default. Its data is reset when the application stops.

## API examples

Create inventory:

```http
POST http://localhost:8080/api/supplies
Content-Type: application/json

{"itemName":"First Aid Kit","quantity":50}
```

Restock the same item by calling the same endpoint again with the item name and quantity to add.

Read inventory:

```http
GET http://localhost:8080/api/supplies
```

Allocate stock:

```http
POST http://localhost:8080/api/requests
Content-Type: application/json

{"itemName":"First Aid Kit","quantity":3,"requestedBy":"Campus Medical Team"}
```

If stock is insufficient, the API returns `409 Conflict`. Invalid request data returns `400 Bad Request`.

## Notes

The allocation service uses a conditional SQL update and `@Transactional`. This prevents overselling for competing updates on the database and rolls back the deduction if request insertion fails.

This implementation intentionally focuses on the supplied two-hour challenge. It does not add microservices, authentication, or rate limiting because those are not required in the uploaded specification. Before public production deployment, add authentication/authorization, distributed rate limiting, database migrations, idempotency for retried allocations, and more concurrency/rollback tests. For concurrent first-time restocks, the unique constraint protects against duplicate item rows; a production implementation should use a database-specific atomic upsert or retry strategy.

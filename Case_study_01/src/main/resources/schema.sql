
CREATE TABLE IF NOT EXISTS supplies (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        item_name VARCHAR(100) NOT NULL UNIQUE,
    quantity INT NOT NULL DEFAULT 0,
    CONSTRAINT chk_supplies_quantity CHECK (quantity >= 0)
    );

CREATE TABLE IF NOT EXISTS requests (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        item_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    requested_by VARCHAR(100) NOT NULL,
    CONSTRAINT chk_requests_quantity CHECK (quantity > 0)
    );

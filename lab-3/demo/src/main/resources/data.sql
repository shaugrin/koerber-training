CREATE TABLE IF NOT EXISTS account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    balance DOUBLE
);

INSERT INTO account (name, balance) VALUES ('John Doe', 5000.0);
INSERT INTO account (name, balance) VALUES ('Jane Smith', 3000.0);
INSERT INTO account (name, balance) VALUES ('Alice Johnson', 7000.0);
INSERT INTO account (name, balance) VALUES ('Bob Williams', 4000.0);
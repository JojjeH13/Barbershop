CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    mail VARCHAR(64) NOT NULL,
    phone INT NOT NULL
);

INSERT INTO customer (name, mail, phone) VALUES
('Anna Andersson', 'anna.andersson@test.se', 701234567),
('Erik Svensson', 'erik.svensson@test.se', 708765432),
('Maria Karlsson', 'maria.karlsson@test.se', 703456789),
('Johan Nilsson', 'johan.nilsson@test.se', 709876543);

CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    price VARCHAR(32) NOT NULL,
    duration INT NOT NULL
);

//Exempel för att ändra tabeller
ALTER TABLE product
MODIFY id INT NOT NULL AUTO_INCREMENT;

INSERT INTO product(name, price, duration) VALUES
('Hair', 300, 30),
('Beard', 200, 15),
('Hair + Beard', 500, 45);

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(32) NOT NULL
);

INSERT INTO employee(name) VALUES
('Gustavo'),
('Adam'),
('Morgan');

INSERT INTO booking (
    customer_id,
    employee_id,
    product_id,
    booking_date,
    booking_time,
    status
) VALUES
(1, 1, 1, '2026-03-01', '10:00:00', 'BOKAD'),
(2, 1, 2, '2026-03-01', '11:00:00', 'BOKAD'),
(3, 2, 1, '2026-03-01', '13:30:00', 'AVBOKAD'),
(1, 3, 3, '2026-03-02', '09:00:00', 'KLAR'),
(2, 2, 2, '2026-03-02', '15:00:00', 'BOKAD');
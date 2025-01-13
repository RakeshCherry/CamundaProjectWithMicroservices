CREATE TABLE IF NOT EXISTS `orders` (
    `id` long AUTO_INCREMENT PRIMARY KEY,
    `item_id` long NOT NULL,
    `no_of_items` int NOT NULL,
    `customer_name` VARCHAR(255) NOT NULL,
    `customer_type` VARCHAR(255) NOT NULL,
    `mobile_number` VARCHAR(255) NOT NULL,
    `pincode` int NOT NULL
);

CREATE TABLE IF NOT EXISTS `inventory` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `item_name` VARCHAR(255) NOT NULL,
    `item_type` VARCHAR(255) NOT NULL,
    `price_per_unit` double NOT NULL,
    `inventory_balance` int NOT NULL
);

INSERT INTO inventory (item_name, item_type, price_per_unit, inventory_balance) VALUES
('Smartphone', 'Electronics', 35000.0, 500),
('Microwave Oven', 'Electronics', 15000.0, 120),
('Chair', 'Other', 2500.0, 700),
('Headphones', 'Electronics', 8000.0, 300),
('Notebook', 'Other', 50.0, 2000),
('Television', 'Electronics', 45000.0, 90),
('Water Bottle', 'Other', 300.0, 1000),
('Tablet', 'Electronics', 25000.0, 200),
('Lamp', 'Other', 1200.0, 400),
('Washing Machine', 'Electronics', 60000.0, 50);

INSERT INTO `orders` (`item_name`, `no_of_items`, `customer_name`, `customer_type`, `mobile_number`, `pincode`)
VALUES
    ('Smartphone', 3, 'John Doe', 'Regular', '1234567890', 560001),
    ('Microwave Oven', 2, 'Jane Smith', 'Premium', '9876543210', 560002),
    ('Chair', 10, 'Alice Johnson', 'Regular', '1122334455', 560003),
    ('Headphones', 4, 'Bob Brown', 'Regular', '6677889900', 560004),
    ('Notebook', 50, 'Charlie White', 'Premium', '9988776655', 560005),
    ('Television', 1, 'David Black', 'Regular', '4455667788', 560006),
    ('Water Bottle', 20, 'Eve Green', 'Premium', '5566778899', 560007),
    ('Tablet', 5, 'Frank Blue', 'Regular', '3344556677', 560008),
    ('Lamp', 8, 'Grace Purple', 'Premium', '2233445566', 560009),
    ('Washing Machine', 1, 'Hank Orange', 'Regular', '7788990011', 560010);
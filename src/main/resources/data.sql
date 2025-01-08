CREATE TABLE IF NOT EXISTS `orders` (
    `id` long AUTO_INCREMENT PRIMARY KEY,
    `item` VARCHAR(255) NOT NULL,
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

CREATE TABLE IF NOT EXISTS `customer_details` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `customer_name` VARCHAR(255) NOT NULL,
    `customer_type` VARCHAR(255) NOT NULL,
    `mobile_number` VARCHAR(255) NOT NULL,
    `pincode` int NOT NULL
)

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

INSERT INTO orders (item, no_of_items, customer_name, customer_type, mobile_number, pincode) VALUES
('Smartphone', 1, 'John', 'Retail', '1234567890', 12345),
('Microwave Oven', 1, 'Jane', 'Wholesale', '9876543210', 54321),
('Chair', 1, 'Mark', 'Retail', '1234567890', 12345),
('Headphones', 1, 'Emily', 'Wholesale', '9876543210', 54321),
('Notebook', 1, 'Michael', 'Retail', '1234567890', 12345),
('Television', 1, 'Sophia', 'Wholesale', '9876543210', 54321),
('Water Bottle', 1, 'William', 'Retail', '1234567890', 12345),
('Tablet', 1, 'Olivia', 'Wholesale', '9876543210', 54321),
('Lamp', 1, 'James', 'Retail', '1234567890', 12345),
('Washing Machine', 1, 'Emma', 'Wholesale', '9876543210', 54321);
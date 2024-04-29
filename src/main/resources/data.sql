INSERT INTO roles (name) VALUES
    ('ROLE_USER'),
    ('ROLE_MODERATOR'),
    ('ROLE_ADMIN');
INSERT INTO users (email, password, username) VALUES
                                                                                 ('owner1@example.com', '$2a$10$/YDSu.aDyNLByzP82kYfk.w4tBoAerSPzLfLnNgcJ0N/SxRW4y7Vm', 'owner1'),
                                                                                 ('owner2@example.com', '$2a$10$68j5sJp9ZzocRPbXF/dN1uqxfzAEAh5nJ6iVPMdVdwlwgNsbaWOwS', 'owner2');


INSERT INTO user_roles (user_id, role_id) VALUES
                                                                                 ('1','1'),
                                                                                 ('2','1');


INSERT INTO restaurant_owners (address, email, first_name, last_name, phone) VALUES
                                                                                 ('Owner Address 1', 'owner1@example.com', 'Owner First Name 1', 'Owner Last Name 1', '1234567890'),
                                                                                 ('Owner Address 2', 'owner2@example.com', 'Owner First Name 2', 'Owner Last Name 2', '9876543210');


INSERT INTO restaurants (email, image, location, name, opening_hours, phone,  status, owner_id) VALUES
                                                                                            ('restaurant1@example.com', '1.jpg','Location 1', 'Restaurant 1', '9:00 AM - 10:00 PM', '1112223333',  'Open', 1),
                                                                                            ('restaurant2@example.com', '2.jpg','Location 2', 'Restaurant 2', '8:00 AM - 9:00 PM', '4445556666', 'Closed', 2);
INSERT INTO servers (address, email, first_name, last_name, phone, restaurant_id) VALUES
                                                                                      ('Server Address 1', 'server1@example.com', 'Server First Name 1', 'Server Last Name 1', '1112223333', 1),
                                                                                      ('Server Address 2', 'server2@example.com', 'Server First Name 2', 'Server Last Name 2', '4445556666', 2);
INSERT INTO categories (description, name, restaurant_id) VALUES
                                                              ('Category Description 1', 'Category 1', 1),
                                                              ('Category Description 2', 'Category 2', 2);
INSERT INTO products (description, is_available, name, price, category_id) VALUES
                                                                                            ('Product Description 1', 1, 'Product 1', 10.99, 1),
                                                                                            ('Product Description 2', 1, 'Product 2', 8.99, 2);
INSERT INTO clients (address, email, first_name, last_name, loyalty_points, phone, registration_date) VALUES
                                                                                                          ('Client Address 1', 'client1@example.com', 'Client First Name 1', 'Client Last Name 1', 100, '1112223333', '2024-04-25'),
                                                                                                          ('Client Address 2', 'client2@example.com', 'Client First Name 2', 'Client Last Name 2', 50, '4445556666', '2024-04-25');
INSERT INTO offer (offer_type, description, title, valid_from, valid_until,  price, discount_percentage, restaurant_id, product_id)
VALUES ('bxgy', 'Buy 2 Get 1 Free on selected items', 'Special BXGY Offer', '2024-04-25', '2024-05-25', 0, 0, 1, 1);

INSERT INTO bx_gy_products_to_buy (quantity_buy, bx_gy_id, product_product_id) VALUES
                                                                                   (2, 1, 1), -- Buy 2 of Product 1 in BXGY offer 1
                                                                                   (3, 1, 2); -- Buy 3 of Product 2 in BXGY offer 1

INSERT INTO bx_gy_products_to_get (quantity_get, bx_gy_id, product_product_id) VALUES
                                                                                   (1, 1, 1), -- Get 1 of Product 1 in BXGY offer 1
                                                                                   (1, 1, 2); -- Get 1 of Product 2 in BXGY offer 1

INSERT INTO offer_orders (added_points, order_date, total_price, is_Pay, client_id, offer_id, server_id)
VALUES (20, '2024-04-25', 20.99, true, 1, 1, 1);

INSERT INTO rewards (is_redeemed, points_to_redeem, client_id, restaurant_id)
VALUES (0, 100, 1, 1),
       (0, 200, 2, 2);

INSERT INTO reward_product (reward_id, product_id)
VALUES (1, 1),
       (2, 2);

INSERT INTO item_orders (added_points, order_date, total_price, is_Pay, client_id, server_id)
VALUES (20, '2024-04-25', 50.99, false, 1, 1),
       (10, '2024-04-25', 30.99, false,  2, 2);


INSERT INTO items (quality, sub_total, item_order_id, product_id)
VALUES (2, 21.98, 1, 1),
       (3, 29.97, 1, 2);

INSERT INTO items (quality, sub_total, item_order_id, product_id)
VALUES (1, 10.99, 2, 2);

INSERT INTO offer (offer_type, description, title, valid_from, valid_until, discount_percentage, restaurant_id, product_id)
VALUES ('Discount', '10% off on selected products', 'Spring Sale', '2024-04-25', '2024-05-25', 10, 1, 1);

INSERT INTO offer (offer_type, description, title, valid_from, valid_until,price , restaurant_id)
VALUES ('Discount', '10% off on selected products', 'Spring Sale', '2024-04-25', '2024-05-25', 100.50, 1);

INSERT INTO offer_orders (added_points, order_date, total_price, is_Pay, client_id, offer_id, server_id)
VALUES (20, '2024-04-25', 20.99, true, 1, 3, 1);

INSERT INTO custom_product (custom_id, product_id) VALUES ('1','1');

--INSERT INTO client_restaurants (client_id, restaurant_id) VALUES  ('1','1');

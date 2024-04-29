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


INSERT INTO owners (email, name, phone, restaurant_id) VALUES
                                                                                 ('owner1@example.com', 'Owner First Name 1', '0258796314', null),
                                                                                 ('owner2@example.com', 'Owner First Name 2', '0123456789', null);



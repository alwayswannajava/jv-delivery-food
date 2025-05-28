INSERT INTO menu (id, name)
VALUES (nextval('seq_menu_id'), 'Main Menu');

INSERT INTO products (id, product_reference, name, description, price, type, menu_id)
VALUES (nextval('seq_product_id'), gen_random_uuid(), 'Pizza "Margherita"',
        'Classic pizza with tomato sauce, mozzarella, and basil', 180.00, 'FOOD',
        (SELECT id FROM menu WHERE name = 'Main Menu')),
       (nextval('seq_product_id'), gen_random_uuid(), 'Ukrainian Borscht',
        'Traditional borscht with meat, served with sour cream', 95.00, 'FOOD',
        (SELECT id FROM menu WHERE name = 'Main Menu')),
       (nextval('seq_product_id'), gen_random_uuid(), 'French Fries', 'Crispy French fries with salt', 70.00, 'FOOD',
        (SELECT id FROM menu WHERE name = 'Main Menu')),
       (nextval('seq_product_id'), gen_random_uuid(), 'Coca-Cola 0.5L', 'Carbonated beverage', 45.00, 'DRINK',
        (SELECT id FROM menu WHERE name = 'Main Menu'));
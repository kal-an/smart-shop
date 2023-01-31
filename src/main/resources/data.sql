insert into categories (name) values ('electronics');
insert into categories (name) values ('cloth');

insert into products (title, price) values ('tv', 1000);
insert into products (title, price) values ('phone', 300);
insert into products (title, price) values ('shoes', 30);

insert into users (name, login, email, password) values ('andrey', 'user1', 'user1@email.com', '••••');
insert into users (name, login, email, password) values ('petr', 'user2', 'user2@email.com', '••••');
insert into users (name, login, email, password) values ('john', 'user3', 'user3@email.com', '••••');

insert into orders (cart_number, user_id, status) values ('1234-5678', 1, 'NEW');
insert into orders (cart_number, user_id, status) values ('1234-5678', 1, 'COMPLETE');
insert into orders (cart_number, user_id, status) values ('1234-5678', 2, 'CANCELED');

insert into products_categories (category_id, product_id) values (1, 1);
insert into products_categories (category_id, product_id) values (1, 2);
insert into products_categories (category_id, product_id) values (2, 3);

insert into products_orders (order_id, product_id) values (1, 1);
insert into products_orders (order_id, product_id) values (1, 3);
insert into products_orders (order_id, product_id) values (2, 2);
insert into products_orders (order_id, product_id) values (3, 2);


insert into kind (name) values ('beef');
insert into kind (name) values ('pork');
insert into kind (name) values ('chicken');
insert into kind (name) values ('seafoods');
insert into kind (name) values ('vegetable');
insert into kind (name) values ('soups');
insert into kind (name) values ('appetizers');
insert into kind (name) values ('chowmen');
insert into kind (name) values ('friedrice');

insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('black pepper beef', 'Short description', 'blackpepperbeef.jpg', 12.99, 1.0, 1, 0, 1, 1);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('orange beef', 'Short description', 'orangebeef.jpg', 12.99, 0.8, 0, 0, 1, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('string bean beef', 'Short description', 'stringbeanbeef.jpg', 11.99, 1.0, 0, 0, 1, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('vegetable beef', 'Short description', 'vegetablebeef.jpg', 15.99, 1.0, 1, 0, 1, 0);

insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('hunan pork', 'Short description', 'hunanpork.jpg', 9.99, 1.0, 1, 0, 2, 2);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('mooshu pork', 'Short description', 'mooshupork.jpg', 8.99, 1.0, 1, 0, 2, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('red cooked pork', 'Short description', 'redcookedpork.jpg', 10.99, 0.85, 0, 0, 2, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('shredded pork', 'Short description', 'shreddedpork.jpg', 9.99, 1.0, 1, 0, 2, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('szechuan pork', 'Short description', 'szechuanpork.jpg', 9.99, 1.0, 0, 0, 2, 3);

insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('hunan chicken', 'Short description', 'hunanchicken.jpg', 8.99, 1.0, 1, 0, 3, 3);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('moo shu chicken', 'Short description', 'mooshuchicken.jpg', 7.99, 0.9, 1, 0, 3, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('orange chicken', 'Short description', 'orangechicken.jpg', 7.99, 1.0, 0, 0, 3, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('sesame chicken', 'Short description', 'sesamechicken.jpg', 9.99, 1.0, 0, 0, 3, 0);

insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('aromatic shrimp', 'Short description', 'aromaticshrimp.jpg', 15.99, 1.0, 1, 0, 4, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('cashewnuts shrimp', 'Short description', 'cashewnutsshrimp.jpg', 16.99, 0.7, 1, 0, 4, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('kungpao shrimp', 'Short description', 'kungpaoshrimp.jpg', 14.99, 1.0, 0, 0, 4, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('salty spicy shrimp', 'Short description', 'saltyspicyshrimp.jpg', 14.99, 1.0, 1, 0, 4, 0);
insert into dish (name, description, pic, price, discount, isChefRmd, isDelete, kind_id, spicyDegree) values ('spicy garlic scallop', 'Short description', 'spicygarlicscallop.jpg', 17.99, 1.0, 1, 0, 4, 0);


insert into usercredentials (username, password, enabled) values ('Lin@123.com', '$2a$10$CwfywdhOo4lQ62IA3Es5heixxkw2g8zH6oeHL2JqaxqRPdiG7mdyy', true);
insert into usercredentials (username, password, enabled) values ('root@123.com', '$2a$10$CwfywdhOo4lQ62IA3Es5heixxkw2g8zH6oeHL2JqaxqRPdiG7mdyy', true);

alter table usercredentials modify password varchar(60);
insert into authority(name) values ('ROLE_USER');
insert into authority(name) values ('ROLE_ADMIN');

insert into user_authority (user_id, authority_id) values ('1', '1');
insert into user_authority (user_id, authority_id) values ('2', '2');
insert into user_authority (user_id, authority_id) values ('2', '1');

insert into customer (address, email, firstName, lastName, phone, pic, rewards, userCredential_id) values ('Imperials road', 'Lin@123.com', 'Lin', 'Cong', '(240)-330-9794', 'Lin.jpg', 100.50, 1);

insert into comment (content, commentDate, customer_id, dish_id) values ('That was delicious.', '2016-10-12', 1, 2);
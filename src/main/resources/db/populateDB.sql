DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- password
INSERT INTO users (name, email, password)
VALUES ('User', 'user@gmail.com', 'password');
-- admin
INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'password');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 100000);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 100001);

INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-06 09:00:00', 'завтрак', 500, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-06 13:00:00', 'обед', 1000, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-07 00:00:00', '567', 600, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-07 13:00:00', 'еще обед', 1300, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-06 14:00:00', 'еда админа', 2000, 100001);

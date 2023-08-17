
CREATE USER IF NOT EXISTS 'myspringboot'@'spring-app' IDENTIFIED BY '3219';
GRANT ALL PRIVILEGES ON myfirstdb.* TO 'myspringboot'@'spring-app';
FLUSH PRIVILEGES;
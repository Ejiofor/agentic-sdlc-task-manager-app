create database tasks;

use tasks;


CREATE TABLE taskdata (
    id int NOT NULL AUTO_INCREMENT,
    status ENUM('TODO', 'IN_PROGRESS', 'DONE'),
    title varchar(100) NOT NULL,
    description varchar(500) NOT NULL,
    dueDate TIMESTAMP,
    PRIMARY KEY (id)
);




insert into taskdata  values(1, 'TODO', 'iron', 'iron press the clothes', '2018-07-09 19:34:24');
insert into taskdata  values(2, 'IN_PROGRESS', 'wash', 'wash the clothes warm water', '2018-06-19 19:34:24');
insert into taskdata  values(3, 'DONE', 'dry', 'dry the clothes slowly', '2018-07-26 19:34:24');


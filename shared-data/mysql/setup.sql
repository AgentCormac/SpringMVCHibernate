CREATE DATABASE IF NOT EXISTS mhdemo;
USE mhdemo;

CREATE TABLE IF NOT EXISTS person (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL DEFAULT '',
  surname varchar(20) NOT NULL DEFAULT '',
  country varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO person (id, name, surname, country) VALUES
	(1, 'Mark','Higginbottom', 'England'),
	(2, 'David','Jones', 'Wales'),
	(3, 'Andrew','McDonald', 'Scotland'),
	(4, 'Patrick','Donally', 'Ireland'),
	(5, 'Joe','Bloggs', 'England'); 
	
CREATE TABLE IF NOT EXISTS eventLog (
  id varchar(24) NOT NULL,
  event varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

GRANT ALL PRIVILEGES ON mhdemo.* To 'dockertest'@'%';
FLUSH PRIVILEGES;

commit;

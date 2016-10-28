DROP TABLE Fridge IF EXISTS;

CREATE TABLE Fridge (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);
CREATE TABLE task (
    id VARCHAR(36) PRIMARY KEY,
    text VARCHAR(100),
    done BIT
);

INSERT INTO task VALUES('f19f048c-475c-431b-98d8-5dde51822496', 'Implement create method', 1);
INSERT INTO task VALUES('71bf4bc3-7f33-4a32-9a9a-0c18cfec52b6', 'Implement reaad method', 0);
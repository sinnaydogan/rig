-- DROP SCHEMA rig;

CREATE SCHEMA rig AUTHORIZATION riguser;

-- DROP SEQUENCE rig.seq_book;

CREATE SEQUENCE rig.seq_book
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE rig.seq_book OWNER TO riguser;
GRANT ALL ON SEQUENCE rig.seq_book TO riguser;

-- DROP SEQUENCE rig.seq_customer;

CREATE SEQUENCE rig.seq_customer
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE rig.seq_customer OWNER TO riguser;
GRANT ALL ON SEQUENCE rig.seq_customer TO riguser;

-- DROP SEQUENCE rig.seq_order;

CREATE SEQUENCE rig.seq_order
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE rig.seq_order OWNER TO riguser;
GRANT ALL ON SEQUENCE rig.seq_order TO riguser;
-- rig.book definition

-- Drop table

-- DROP TABLE rig.book;

CREATE TABLE rig.book (
                          id int8 NOT NULL,
                          author varchar(100) NULL,
                          "name" varchar(100) NULL,
                          price numeric(19, 2) NULL,
                          stock int8 NULL,
                          "type" varchar(100) NULL,
                          CONSTRAINT book_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE rig.book OWNER TO riguser;
GRANT ALL ON TABLE rig.book TO riguser;


-- rig.customer definition

-- Drop table

-- DROP TABLE rig.customer;

CREATE TABLE rig.customer (
                              id int8 NOT NULL,
                              email varchar(100) NULL,
                              firstname varchar(100) NULL,
                              lastname varchar(100) NULL,
                              "password" varchar(100) NULL,
                              "role" varchar(100) NULL,
                              CONSTRAINT customer_pkey PRIMARY KEY (id),
                              CONSTRAINT uk_dwk6cx0afu8bs9o4t536v1j5v UNIQUE (email)
);

-- Permissions

ALTER TABLE rig.customer OWNER TO riguser;
GRANT ALL ON TABLE rig.customer TO riguser;


-- rig."order" definition

-- Drop table

-- DROP TABLE rig."order";

CREATE TABLE rig."order" (
                             id int8 NOT NULL,
                             order_date timestamp NULL,
                             total_price numeric(19, 2) NULL,
                             customer_id int8 NULL,
                             CONSTRAINT order_pkey PRIMARY KEY (id),
                             CONSTRAINT fkb8tboo4d95mh8gavvovwbb7vg FOREIGN KEY (customer_id) REFERENCES rig.customer(id)
);

-- Permissions

ALTER TABLE rig."order" OWNER TO riguser;
GRANT ALL ON TABLE rig."order" TO riguser;


-- rig.order_booklist definition

-- Drop table

-- DROP TABLE rig.order_booklist;

CREATE TABLE rig.order_booklist (
                                    order_id int8 NOT NULL,
                                    booklist_id int8 NOT NULL,
                                    CONSTRAINT fkjwqw10h2qgqtbckq2ola6nekt FOREIGN KEY (booklist_id) REFERENCES rig.book(id),
                                    CONSTRAINT fkmokgc6sfr96wor345iuc84ttg FOREIGN KEY (order_id) REFERENCES rig."order"(id)
);

-- Permissions

ALTER TABLE rig.order_booklist OWNER TO riguser;
GRANT ALL ON TABLE rig.order_booklist TO riguser;




-- Permissions

GRANT ALL ON SCHEMA rig TO riguser;

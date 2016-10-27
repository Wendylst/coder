CREATE TABLE business_client
(
	bs_no                NUMBER(5) ,
	bs_email             VARCHAR2(100) NOT NULL ,
	bs_password          VARCHAR2(30) NOT NULL ,	
	business_name        VARCHAR2(50) NULL ,
	business_phone       VARCHAR2(30) NULL ,
	representative       VARCHAR2(30) NULL ,
	cr_no                NUMBER(5) NULL ,
	manager_name         VARCHAR2(30) NULL ,
	manager_phone        VARCHAR2(20) NULL ,
	manager_email        VARCHAR2(100) NULL ,
	CONSTRAINT  XPK업체회원 PRIMARY KEY (bs_no) 
);
CREATE SEQUENCE bs_no_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE; 

(
	client_no            NUMBER(5)   ,
	email                VARCHAR2(50) NOT NULL ,
	password             VARCHAR2(30) NOT NULL ,
	name                 VARCHAR2(20) NULL ,
	phone                VARCHAR2(20) NULL ,
	CONSTRAINT  XPK일반회원 PRIMARY KEY (client_no)
);
CREATE SEQUENCE client_no_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE TABLE order_info
(
	order_no              NUMBER(5)  ,
	order_name           VARCHAR2(30) NULL ,
	order_price          NUMBER(10) NULL ,
	order_size           VARCHAR2(10) NULL ,
	order_option         VARCHAR2(10) NULL ,
	quantity             NUMBER(5) NULL ,
	ordre_date           DATE NULL ,
	order_point          NUMBER(10) NULL ,
	client_no            NUMBER(5) NOT NULL,
	CONSTRAINT XPK주문정보 PRIMARY KEY (order_no)
);
CREATE SEQUENCE order_no_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;



CREATE TABLE menu
(
	menu_no              NUMBER(5) not null ,
	menu_name            VARCHAR2(20) NULL ,
	menu_price           NUMBER(10) NULL ,
	menu_option          VARCHAR2(20) NULL ,
	menu_size                 VARCHAR2(20) NULL ,
	menu_point           NUMBER(10) NULL ,
	shop_no              NUMBER(5) NOT NULL ,
	menu_img             VARCHAR2(200) NULL,
	CONSTRAINT  XPK메뉴 PRIMARY KEY (menu_no)
);
CREATE SEQUENCE menu_no_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE TABLE cart
(
	client_no            NUMBER(5)  ,
	menu_no              NUMBER(5) NOT NULL ,
	cart_no              NUMBER(5) NOT NULL ,
	cart_quantity        NUMBER(5) NULL ,
	CONSTRAINT  XPK일반회원_메뉴 PRIMARY KEY (cart_no)
);
CREATE SEQUENCE cart_no_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;


CREATE TABLE shop
(
	shop_no              NUMBER(5)  ,
	shop_name            VARCHAR2(30) NULL ,
	shop_address         VARCHAR2(100) NULL ,
	operation_hour       VARCHAR2(20) NULL ,
	shop_phone           VARCHAR2(20) NULL ,
	title                VARCHAR2(200) NULL ,
	approval_chk         VARCHAR2(10) NULL ,
	bs_no                NUMBER(5) NOT NULL ,
	shop_img             VARCHAR2(200) NULL,
	CONSTRAINT  XPK매장_테이블 PRIMARY KEY (shop_no)
);

--alter table shop modify(operation_hour varchar2(20))

CREATE SEQUENCE shop_no_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;


CREATE TABLE bookmark
(
	client_no            NUMBER(5) ,
	shop_no              NUMBER(5) NOT NULL ,
	bookmark_no          NUMBER(5) NOT NULL,
	CONSTRAINT  XPK일반회원_매장_테이블 PRIMARY KEY (bookmark_no) 
);
CREATE SEQUENCE bookmark_no_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

ALTER TABLE order_info
	ADD (CONSTRAINT R_1 FOREIGN KEY (client_no) REFERENCES client (client_no));

ALTER TABLE menu
	ADD (CONSTRAINT R_5 FOREIGN KEY (shop_no) REFERENCES shop (shop_no));

ALTER TABLE cart
	ADD (CONSTRAINT R_3 FOREIGN KEY (client_no) REFERENCES client (client_no));

ALTER TABLE cart
	ADD (CONSTRAINT R_4 FOREIGN KEY (menu_no) REFERENCES menu (menu_no));

ALTER TABLE shop
	ADD (CONSTRAINT R_9 FOREIGN KEY (bs_no) REFERENCES business_client (bs_no));

ALTER TABLE bookmark
	ADD (CONSTRAINT R_7 FOREIGN KEY (client_no) REFERENCES client (client_no));

ALTER TABLE bookmark
	ADD (CONSTRAINT R_8 FOREIGN KEY (shop_no) REFERENCES shop (shop_no));
	
insert into client values(client_no_seq.nextval,'admin@gmail.com','1234','admin','01012341234');
delete client where email ='admin@gmail.com'


 

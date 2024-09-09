-- sales_order
CREATE TABLE IF NOT EXISTS sales_order
(
    order_no      varchar(25)    not null primary key comment '주문번호',
    created_at    datetime       not null default current_timestamp comment '주문일자',
    seller        varchar(25)    not null comment '판매자',
    status        varchar(15)    not null comment '주문 상태',
    item_id       int(11)        not null comment '상품_id',
    sale_quantity decimal(11, 2) not null comment '판매 수량 (단위: g)',
    amount        int(11)        not null comment '총 판매 금액'
) comment 'sales_order' charset = utf8;

-- purchase_order
CREATE TABLE IF NOT EXISTS purchase_order
(
    order_no                varchar(25)    not null primary key comment '주문번호',
    created_at              datetime       not null default current_timestamp comment '주문일자',
    buyer                   varchar(25)    not null comment '구매자',
    status                  varchar(15)    not null comment '주문 상태',
    item_id                 int(11)        not null comment '상품_id',
    sale_quantity           decimal(11, 2) not null comment '구매 수량 (단위: g)',
    amount                  int(11)        not null comment '총 주문 금액',
    receiver_zipcode        varchar(10)    not null comment '수령자 우편번호',
    receiver_address        varchar(255)   not null comment '수령자 주소',
    receiver_detail_address varchar(255)   not null comment '수령자 상세 주소'
) comment 'purchase_order' charset = utf8;

-- items
create table items
(
    id   int(11) auto_increment primary key comment '상품_id',
    type varchar(64) not null comment '품목'
) comment 'items' charset = utf8;

-- price
create table prices
(
    id         int(11) auto_increment primary key comment '가격_id',
    created_at datetime not null default current_timestamp comment '생성일자',
    item_id    int(11)  not null comment '상품_id',
    sale_price int(11)  not null comment '단위(g)당 판매가격',
    buy_price  int(11)  not null comment '단위(g)당 구매가격'
) comment 'prices' charset = utf8;

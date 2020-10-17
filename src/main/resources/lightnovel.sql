DROP TABLE moontea.book;

--  Book TABLE  --
CREATE TABLE book (
    ISBN varchar(20) NOT NULL,
    BOOK_NAME varchar(50) NOT NULL,
    AUTHOR varchar(20),
    Publish varchar(20),
    CONSTRAINT ISBN_BOOKBOOKPK PRIMARY KEY (ISBN)
    );


INSERT INTO book VALUES('978-4-7973-7280-9','在地下城尋求邂逅是否搞錯了什麼','大森藤野','SB Creative');
INSERT INTO book VALUES('978-4-8291-3787-1','不起眼女主角培育法','丸戶史明','富士見書房');
INSERT INTO book VALUES('978-4-04-867517-8','加速世界','川原礫','ASCII Media Works');
INSERT INTO book VALUES('978-4-04-867760-8','刀劍神域','川原礫','ASCII Media Works');
INSERT INTO book VALUES('978-4-09-451262-5','果然我的青春戀愛喜劇搞錯了','渡航','小學館');
INSERT INTO book VALUES('978-4-7575-4856-5','龍王的工作','白鳥士郎','SB Creative');
INSERT INTO book VALUES('978-4-7973-6690-7','農林','白鳥士郎','SOFTBANK Creative');
INSERT INTO book VALUES('978-4-04-067657-9','歡迎來到實力至上主義的教室','衣笠彰梧','KADOKAWA');





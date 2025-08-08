--[ 계정생성 ] 
-- System 계정에서 실행
-- 2. 계정생성(mybatis_ict05) 및 테이블생성
--******************* 일반 계정 생성 =>[시스템계정(System)에서 작업 ***********
--- 1. 계정생성
-- create user <계정이름> identified by <계정암호> default tablespace users;
   create user mybatis_ict05 identified by tiger default tablespace users;
-- 2. 사용자 권한 부여
   grant connect, resource to mybatis_ict05;
   grant create view to mybatis_ict05;
   
--  grant connect, resource,create view to mybatis_ict05;   
-- 3. 락 해제
-- alter user <계정이름> account unlock;
    alter user mybatis_ict05 account unlock;

-- 실행결과   
--User mybatis_ict05(가) 생성되었습니다.
--Grant을(를) 성공했습니다.
--User mybatis_ict05(가) 변경되었습니다.
-----------------------------------------------------------------------------------------------------------------------------


-- mybatis_ict05 계정에서 작업
-- mvc_user_tbl : mvc_address_tbl => 1 : 1
-- mvc_user_tbl : mvc_board_tbl => 1 : N

--1) mvc_user_tbl 생성
DROP TABLE mvc_user_tbl CASCADE CONSTRAINTS;
CREATE TABLE mvc_user_tbl(
	user_id 	NUMBER(2) PRIMARY KEY,
	user_name   VARCHAR2(30),
	reg_date    DATE
);

INSERT INTO mvc_user_tbl(user_id, user_name, reg_date)
 VALUES(1, 'john', sysdate);

INSERT INTO mvc_user_tbl(user_id, user_name, reg_date)
 VALUES(2, 'terry', sysdate);

COMMIT;


SELECT * FROM mvc_user_tbl;



-- 2) mvc_address_tbl 생성
DROP TABLE mvc_address_tbl CASCADE CONSTRAINTS;
CREATE TABLE mvc_address_tbl(
	user_id 	 NUMBER(2),
	user_address VARCHAR2(50),
	CONSTRAINT mvc_address_tbl_user_id_fk FOREIGN KEY(user_id) REFERENCES mvc_user_tbl(user_id)
);

INSERT INTO mvc_address_tbl(user_id, user_address)
 VALUES(1, '서울시 금천구 가산동');

INSERT INTO mvc_address_tbl(user_id, user_address)
 VALUES(2, '서울시 강남구 대치동');

COMMIT;


SELECT * FROM mvc_address_tbl;



-- 3) mvc_board_tbl 생성
DROP TABLE mvc_board_tbl CASCADE CONSTRAINTS;
CREATE TABLE mvc_board_tbl(
	board_num    NUMBER(3) PRIMARY KEY,
	board_title  VARCHAR2(50),
	board_content VARCHAR2(100),
	user_id 	 NUMBER(2),
	CONSTRAINT mvc_board_tbl_user_id_fk FOREIGN KEY(user_id) REFERENCES mvc_user_tbl(user_id)
);

INSERT INTO mvc_board_tbl(board_num, board_title, board_content, user_id)
 VALUES(100, '자바', '반복문', 1);

INSERT INTO mvc_board_tbl(board_num, board_title, board_content, user_id)
 VALUES(101, 'JSP', 'mvc 기본', 1);
 
INSERT INTO mvc_board_tbl(board_num, board_title, board_content, user_id)
 VALUES(102, '스프링', 'mybatis 기본', 1);
 
INSERT INTO mvc_board_tbl(board_num, board_title, board_content, user_id)
 VALUES(103, 'JSP 응용', 'mvc 활용', 2);
 
INSERT INTO mvc_board_tbl(board_num, board_title, board_content, user_id)
 VALUES(104, '스프링', 'mybatis 활용', 2);

INSERT INTO mvc_board_tbl(board_num, board_title, board_content, user_id)
 VALUES(105, '플젝', '성취감', 2);
 
COMMIT;

SELECT * FROM mvc_board_tbl;

----------------------------------------------------------------------------------
SELECT u.user_id, 
       u.user_name, 
       u.reg_date,  
       a.user_address
  FROM mvc_user_tbl u
     , mvc_address_tbl a
 WHERE u.user_id = a.user_id
 ORDER BY u.user_id ASC;

SELECT board_num boardNum
     , board_title boardTitle
     , board_content boardContent
  FROM mvc_board_tbl
 WHERE user_id = 2;
 
UPDATE  mvc_board_tbl
  SET   board_title='스프링부트'
      , board_content='스프링부트 활용'
 where board_num = 102;
 COMMIT;
 ROLLBACK;
 
-- user, board 
 SELECT u.user_id, 
       u.user_name, 
       u.reg_date,  
       b.board_num,
       b.board_title,
       b.board_content
  FROM mvc_user_tbl u
     , mvc_board_tbl b
 WHERE u.user_id = b.user_id
 ORDER BY u.user_id ASC;

SELECT u.user_id, 
       u.user_name, 
       u.reg_date,  
       b.board_num,
       b.board_title,
       b.board_content
  FROM mvc_user_tbl u
     , mvc_board_tbl b
 WHERE u.user_id = b.user_id
   AND u.user_name = 'john' 
   AND b.board_content LIKE '%반복문%'
 ORDER BY u.user_id ASC;



-- scott_05 계정에서 작업
 -------------- Ajax mvc_search_tbl 테이블 ------------------
 
DROP TABLE mvc_search_tbl CASCADE CONSTRAINTS;
CREATE TABLE mvc_search_tbl(
    keyword     VARCHAR2(250) NOT NULL  -- 검색어
);
SELECT * FROM mvc_search_tbl;
INSERT INTO mvc_search_tbl(keyword)
 VALUES('JAVA');
 
INSERT INTO mvc_search_tbl(keyword)
 VALUES('JAVA의 정석');
 
INSERT INTO mvc_search_tbl(keyword)
 VALUES('JAVA 프로그래밍 입문');
 
INSERT INTO mvc_search_tbl(keyword)
 VALUES('JSP');

INSERT INTO mvc_search_tbl(keyword)
 VALUES('JSP 프로그래밍');
 
INSERT INTO mvc_search_tbl(keyword)
 VALUES('스프링');
 
INSERT INTO mvc_search_tbl(keyword)
 VALUES('스프링부트');
 
INSERT INTO mvc_search_tbl(keyword)
 VALUES('python');
 
INSERT INTO mvc_search_tbl(keyword)
 VALUES('알기쉬운 python');

INSERT INTO mvc_search_tbl(keyword)
 VALUES('python을 이용한 데이터시각화'); 
COMMIT; 



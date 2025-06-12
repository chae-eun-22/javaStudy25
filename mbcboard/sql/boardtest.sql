-------------------------------------------------------------------
-- member 테이블 부모로 생성

create table member (
mno number(5) not null,
name nvarchar2(5) not null,
id nvarchar2(10) not null unique, -- board 테이블의 bwriter와 fk로 관계 설정하려고 함(타입 일치)
pw nvarchar2(10) not null,
regidate date default sysdate not null
)


-- 시퀀스 객체는 이미 1개가 있으니 board_seq를 같이 사용하겠다.
drop table member -- member 테이블 삭제용


-- 부모 더미데이터 입력
insert into member (mno, name, id, pw)
values (board_seq.nextval, '김기원', 'kkw', '1234')
insert into member (mno, name, id, pw)
values (board_seq.nextval, '박채은', 'ppp', '1234')
insert into member (mno, name, id, pw)
values (board_seq.nextval, '양지민', 'www', '1234')
insert into member (mno, name, id, pw)
values (board_seq.nextval, '홍경훈', 'hhh', '1234')
insert into member (mno, name, id, pw)
values (board_seq.nextval, '이현우', 'eee', '1234')

select * from member -- 확인용


-----------------------------------------------------------------------------
-- member의 자식 board 외래키 생성 필수

drop table board -- 기존에 board 테이블 삭제
drop sequence board_seq -- 자동번호 생성 제거

create table board(
	bno number(5) primary key,
	btitle nvarchar2(30) not null,
	bcontent nvarchar2(1000) not null,
	bwriter nvarchar2(10) not null,
	bdate date not null
)

create sequence board_seq increment by 1 start with 1 nocycle nocache

alter table board add constraint board_member_fk foreign key (bwriter) references member(id)
-- board 테이블은 member의 자식 테이블로 member에 id와 board에 bwriter를 관계 설정(외래키)
-- ORA-02267: column type incompatible with referenced column type -> pk와 fk를 붙여야 함
-- pk와 fk를 확인하고 연결 -> 자식 테이블에 더미데이터를 삭제하고 실행 해보자.
-- board에 더미데이터를 넣어보니 
-- RA-02291: integrity constraint (BOARDTEST.BOARD_MEMBER_FK) violated - parent key not found
-- 부모 테이블에 김기원이라는 값이 없다. -> board에 김기원을 id인 kkw로 변경

delete from board -- 조건없이 delete를 실행하면 모든 데이터가 삭제됨 -> 외래키를 다시 지정해보자

insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '덥네용~', '무더운데 등교하시느라 고생하셨습니다.', 'kkw', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '안녕하세요~', '무더운데 등교하시느라 고생하셨습니다.', 'ppp', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '감사합니다~', '무더운데 등교하시느라 고생하셨습니다.', 'www', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '수고하셨네요~', '무더운데 등교하시느라 고생하셨습니다.', 'hhh', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '화이팅하세요~', '무더운데 등교하시느라 고생하셨습니다.', 'eee', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '반갑습니다~', '무더운데 등교하시느라 고생하셨습니다.', 'kkw', sysdate)

select * from board
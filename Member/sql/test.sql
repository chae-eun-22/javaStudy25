----------------------------------------------------------------
-------- member ���̺� �θ�� ����

create table member (
mno number(5) not null,
name nvarchar2(5) not null,
id nvarchar2(10) not null unique, -- board ���̺��� bwriter�� fk�� ���� ����(unique ����ؼ� �ߺ� ���̵� ���� �Ұ�)
pw nvarchar2(10) not null,
regidate date default sysdate not null
)



---- ������ ��ü�� �̹� 1���� ������ board_seq�� ���� ����ϰڴ�.
drop table member -- member ���̺� ������


---- �θ� ���̵����� �Է�
insert into member (mno, name, id, pw)
values (board_seq.nextval, '��ä��', 'pce', '1234')
insert into member (mno, name, id, pw)
values (board_seq.nextval, '������', 'jjj', '1234')
insert into member (mno, name, id, pw)
values (board_seq.nextval, '������', 'eee', '1234')
insert into member (mno, name, id, pw)
values (board_seq.nextval, 'ȫ����', 'hhh', '1234')
insert into member (mno, name, id, pw)
values (board_seq.nextval, '����', 'kkw', '1234')

select * from member -- Ȯ�ο�


------------------------------------------------------------------------
---- member�� �ڽ� board �ܷ�Ű ���� �ʼ�

create sequence board_seq increment by 1 start with 1 nocycle nocache

alter table board add constraint board_member_fk foreign key (bwriter) references member(id)
-- board ���̺��� member�� �ڽ� ���̺�� member�� id�� board�� bwriter�� ���� ����(�ܷ�Ű)
-- ORA-02267: column type incompatible with referenced column type -> pk�� fk�� �ٿ��� ��
-- pk�� fk�� Ȯ���ϰ� ���� -> �ڽ� ���̺� ���̵����͸� �����ϰ� �����غ���
-- board�� ���̵����͸� �־��
-- RA-02291: integrity constraint (BOARDTEST.BOARD_MEMBER_FK) violated - parent key not found
-- �θ� ���̺� ��ä���̶�� ���� ����. -> board�� ��ä���� id�� pce�� ����

create table board(
bno number(5) primary key,
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null,
bdate date not null
)

insert into board (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '�ȳ��ϼ���', '���躸���� �����߾��', 'pce', sysdate)
insert into board (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '�ݰ����ϴ�', '���躸���� �����߾��', 'jjj', sysdate)
insert into board (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '�����մϴ�', '���躸���� �����߾��', 'eee', sysdate)
insert into board (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '�����ϼ̽��ϴ�', '���躸���� �����߾��', 'hhh', sysdate)
insert into board (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, 'ȭ�����ϼ���', '���躸���� �����߾��', 'kkw', sysdate)

select * from board


delete from board -- ���Ǿ��� delete�� �����ϸ� ��� �����Ͱ� ������ -> �ܷ�Ű�� �ٽ� ����


drop table board -- ������ board ���̺� ����
drop sequence board_seq -- �ڵ� ��ȣ ���� ����

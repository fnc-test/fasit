CREATE TABLE RESOURCE_SECRETS_AUD
  (
    RESOURCE_TABLE_ENTID NUMBER(19,0) ,
    SECRET_KEY           VARCHAR2(255 BYTE) ,
    SECRETS_ENTID        NUMBER(19,0),
    rev             NUMBER(19) NOT NULL,
    revtype         NUMBER(19)
    );
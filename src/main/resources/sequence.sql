CREATE TABLE IF NOT EXISTS MYSEQUENCE(
    SEQ_NAME VARCHAR(100),
    SEQ_VALUE NUMERIC(10,0),
    PRIMARY KEY (SEQ_NAME)
    );

INSERT INTO MYSEQUENCE(SEQ_NAME, SEQ_VALUE) values ('SEQ1', 0);
INSERT INTO MYSEQUENCE(SEQ_NAME, SEQ_VALUE) values ('SEQ2', 0);
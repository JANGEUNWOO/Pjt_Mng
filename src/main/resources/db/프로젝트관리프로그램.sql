
CREATE TABLE emp_mng
(
	emp_id               VARCHAR2() NOT NULL ,
	emp_nm               VARCHAR2() NULL ,
	manmonth             VARCHAR2() NULL ,
	start_date           VARCHAR2() NULL ,
	end_date             VARCHAR2() NULL ,
	pj_id                VARCHAR2() NOT NULL ,
	pmname               VARCHAR2() NULL 
);



CREATE UNIQUE INDEX XPK노무비 ON emp_mng
(emp_id   ASC,pj_id   ASC);



ALTER TABLE emp_mng
	ADD CONSTRAINT  XPK노무비 PRIMARY KEY (emp_id,pj_id);



CREATE TABLE pj_cost
(
	cost_id              VARCHAR2(8) NOT NULL ,
	cost_days            VARCHAR2(8) NULL ,
	cost_category        VARCHAR2(2) NULL ,
	cost_branch          VARCHAR2(6) NULL ,
	cost_price           VARCHAR2(10) NULL ,
	cost_etc             VARCHAR2(20) NULL ,
	pj_id                VARCHAR2(8) NOT NULL 
);



CREATE UNIQUE INDEX XPK재료비경비 ON pj_cost
(cost_id   ASC,pj_id   ASC);



ALTER TABLE pj_cost
	ADD CONSTRAINT  XPK재료비경비 PRIMARY KEY (cost_id,pj_id);



CREATE TABLE pj_inout
(
	pj_inout_id          VARCHAR2(8) NOT NULL ,
	inout_category       VARCHAR2(2) NULL ,
	inout_days           VARCHAR2(8) NULL ,
	inout_cust_nm        VARCHAR2(12) NULL ,
	inout_price          VARCHAR2(10) NULL ,
	inout_etc            VARCHAR2(20) NULL ,
	pj_id                VARCHAR2(8) NOT NULL 
);



CREATE UNIQUE INDEX XPK프로젝트_매일_매출 ON pj_inout
(pj_inout_id   ASC,pj_id   ASC);



ALTER TABLE pj_inout
	ADD CONSTRAINT  XPK프로젝트_매일_매출 PRIMARY KEY (pj_inout_id,pj_id);



CREATE TABLE pj_mng
(
	pj_id                CHAR(18) NOT NULL ,
	pj_nm                CHAR(18) NULL ,
	manager              CHAR(18) NULL ,
	plan_start_date      CHAR(18) NULL ,
	plan_end_date        CHAR(18) NULL ,
	real_start_date      CHAR(18) NULL ,
	real_end_date        CHAR(18) NULL ,
	down_pay             CHAR(18) NULL ,
	cust_nm              CHAR(18) NULL ,
	cust_status          VARCHAR2() NULL 
);



CREATE UNIQUE INDEX XPK프로젝트관리 ON pj_mng
(pj_id   ASC);



ALTER TABLE pj_mng
	ADD CONSTRAINT  XPK프로젝트관리 PRIMARY KEY (pj_id);



ALTER TABLE emp_mng
	ADD (CONSTRAINT R_10 FOREIGN KEY (pj_id) REFERENCES pj_mng (pj_id));



ALTER TABLE pj_cost
	ADD (CONSTRAINT R_7 FOREIGN KEY (pj_id) REFERENCES pj_mng (pj_id));



ALTER TABLE pj_inout
	ADD (CONSTRAINT R_9 FOREIGN KEY (pj_id) REFERENCES pj_mng (pj_id));



CREATE  TRIGGER tI_emp_mng BEFORE INSERT ON emp_mng for each row
-- ERwin Builtin Trigger
-- INSERT trigger on emp_mng 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin Trigger */
    /* pj_mng  emp_mng on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000decf", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="emp_mng"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="pj_id" */
    SELECT count(*) INTO NUMROWS
      FROM pj_mng
      WHERE
        /* %JoinFKPK(:%New,pj_mng," = "," AND") */
        :new.pj_id = pj_mng.pj_id;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert emp_mng because pj_mng does not exist.'
      );
    END IF;


-- ERwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_emp_mng AFTER UPDATE ON emp_mng for each row
-- ERwin Builtin Trigger
-- UPDATE trigger on emp_mng 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin Trigger */
  /* pj_mng  emp_mng on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000dd4f", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="emp_mng"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="pj_id" */
  SELECT count(*) INTO NUMROWS
    FROM pj_mng
    WHERE
      /* %JoinFKPK(:%New,pj_mng," = "," AND") */
      :new.pj_id = pj_mng.pj_id;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update emp_mng because pj_mng does not exist.'
    );
  END IF;


-- ERwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_pj_cost BEFORE INSERT ON pj_cost for each row
-- ERwin Builtin Trigger
-- INSERT trigger on pj_cost 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin Trigger */
    /* pj_mng  pj_cost on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000e6d0", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="pj_cost"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="pj_id" */
    SELECT count(*) INTO NUMROWS
      FROM pj_mng
      WHERE
        /* %JoinFKPK(:%New,pj_mng," = "," AND") */
        :new.pj_id = pj_mng.pj_id;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert pj_cost because pj_mng does not exist.'
      );
    END IF;


-- ERwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_pj_cost AFTER UPDATE ON pj_cost for each row
-- ERwin Builtin Trigger
-- UPDATE trigger on pj_cost 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin Trigger */
  /* pj_mng  pj_cost on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000e858", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="pj_cost"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="pj_id" */
  SELECT count(*) INTO NUMROWS
    FROM pj_mng
    WHERE
      /* %JoinFKPK(:%New,pj_mng," = "," AND") */
      :new.pj_id = pj_mng.pj_id;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update pj_cost because pj_mng does not exist.'
    );
  END IF;


-- ERwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_pj_inout BEFORE INSERT ON pj_inout for each row
-- ERwin Builtin Trigger
-- INSERT trigger on pj_inout 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin Trigger */
    /* pj_mng  pj_inout on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000dde0", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="pj_inout"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="pj_id" */
    SELECT count(*) INTO NUMROWS
      FROM pj_mng
      WHERE
        /* %JoinFKPK(:%New,pj_mng," = "," AND") */
        :new.pj_id = pj_mng.pj_id;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert pj_inout because pj_mng does not exist.'
      );
    END IF;


-- ERwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_pj_inout AFTER UPDATE ON pj_inout for each row
-- ERwin Builtin Trigger
-- UPDATE trigger on pj_inout 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin Trigger */
  /* pj_mng  pj_inout on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000dff7", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="pj_inout"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="pj_id" */
  SELECT count(*) INTO NUMROWS
    FROM pj_mng
    WHERE
      /* %JoinFKPK(:%New,pj_mng," = "," AND") */
      :new.pj_id = pj_mng.pj_id;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update pj_inout because pj_mng does not exist.'
    );
  END IF;


-- ERwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_pj_mng AFTER DELETE ON pj_mng for each row
-- ERwin Builtin Trigger
-- DELETE trigger on pj_mng 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin Trigger */
    /* pj_mng  pj_cost on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00029275", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="pj_cost"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="pj_id" */
    SELECT count(*) INTO NUMROWS
      FROM pj_cost
      WHERE
        /*  %JoinFKPK(pj_cost,:%Old," = "," AND") */
        pj_cost.pj_id = :old.pj_id;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete pj_mng because pj_cost exists.'
      );
    END IF;

    /* ERwin Builtin Trigger */
    /* pj_mng  pj_inout on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="pj_inout"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="pj_id" */
    SELECT count(*) INTO NUMROWS
      FROM pj_inout
      WHERE
        /*  %JoinFKPK(pj_inout,:%Old," = "," AND") */
        pj_inout.pj_id = :old.pj_id;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete pj_mng because pj_inout exists.'
      );
    END IF;

    /* ERwin Builtin Trigger */
    /* pj_mng  emp_mng on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="emp_mng"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="pj_id" */
    SELECT count(*) INTO NUMROWS
      FROM emp_mng
      WHERE
        /*  %JoinFKPK(emp_mng,:%Old," = "," AND") */
        emp_mng.pj_id = :old.pj_id;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete pj_mng because emp_mng exists.'
      );
    END IF;


-- ERwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_pj_mng AFTER UPDATE ON pj_mng for each row
-- ERwin Builtin Trigger
-- UPDATE trigger on pj_mng 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin Trigger */
  /* pj_mng  pj_cost on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="0002fedf", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="pj_cost"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="pj_id" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.pj_id <> :new.pj_id
  THEN
    SELECT count(*) INTO NUMROWS
      FROM pj_cost
      WHERE
        /*  %JoinFKPK(pj_cost,:%Old," = "," AND") */
        pj_cost.pj_id = :old.pj_id;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update pj_mng because pj_cost exists.'
      );
    END IF;
  END IF;

  /* ERwin Builtin Trigger */
  /* pj_mng  pj_inout on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="pj_inout"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="pj_id" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.pj_id <> :new.pj_id
  THEN
    SELECT count(*) INTO NUMROWS
      FROM pj_inout
      WHERE
        /*  %JoinFKPK(pj_inout,:%Old," = "," AND") */
        pj_inout.pj_id = :old.pj_id;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update pj_mng because pj_inout exists.'
      );
    END IF;
  END IF;

  /* ERwin Builtin Trigger */
  /* pj_mng  emp_mng on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="pj_mng"
    CHILD_OWNER="", CHILD_TABLE="emp_mng"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="pj_id" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.pj_id <> :new.pj_id
  THEN
    SELECT count(*) INTO NUMROWS
      FROM emp_mng
      WHERE
        /*  %JoinFKPK(emp_mng,:%Old," = "," AND") */
        emp_mng.pj_id = :old.pj_id;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update pj_mng because emp_mng exists.'
      );
    END IF;
  END IF;


-- ERwin Builtin Trigger
END;
/


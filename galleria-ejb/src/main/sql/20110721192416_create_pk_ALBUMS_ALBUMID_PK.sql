ALTER TABLE ALBUMS ADD CONSTRAINT ALBUMS_ALBUMID_PK PRIMARY KEY (ALBUMID);

--//@UNDO

ALTER TABLE ALBUMS DROP CONSTRAINT ALBUMS_ALBUMID_PK;
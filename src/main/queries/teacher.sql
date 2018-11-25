-- Table: public.teacher

-- DROP TABLE public.teacher;

CREATE TABLE public.teacher
(
  id_teacher integer NOT NULL DEFAULT nextval('teacher_id_teacher_seq'::regclass),
  id_account integer NOT NULL DEFAULT nextval('teacher_id_account_seq'::regclass),
  CONSTRAINT teacher_pkey PRIMARY KEY (id_teacher),
  CONSTRAINT teacher_id_account_fkey FOREIGN KEY (id_account)
      REFERENCES public.account (id_account) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.teacher
  OWNER TO queststore;

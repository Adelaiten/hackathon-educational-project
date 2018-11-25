-- Table: public.student

-- DROP TABLE public.student;

CREATE TABLE public.student
(
  id_student integer NOT NULL DEFAULT nextval('student_id_student_seq'::regclass),
  id_account integer NOT NULL DEFAULT nextval('student_id_account_seq'::regclass),
  id_class integer NOT NULL DEFAULT nextval('student_id_class_seq'::regclass),
  CONSTRAINT student_pkey PRIMARY KEY (id_student),
  CONSTRAINT student_id_account_fkey FOREIGN KEY (id_account)
      REFERENCES public.account (id_account) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT student_id_class_fkey FOREIGN KEY (id_class)
      REFERENCES public.class (id_class) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.student
  OWNER TO queststore;

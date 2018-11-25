-- Table: public.team_member

-- DROP TABLE public.team_member;

CREATE TABLE public.team_member
(
  id_team_member integer NOT NULL DEFAULT nextval('team_member_id_team_member_seq'::regclass),
  id_student integer NOT NULL DEFAULT nextval('team_member_id_student_seq'::regclass),
  CONSTRAINT team_member_pkey PRIMARY KEY (id_team_member),
  CONSTRAINT team_member_id_student_fkey FOREIGN KEY (id_student)
      REFERENCES public.student (id_student) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.team_member
  OWNER TO queststore;

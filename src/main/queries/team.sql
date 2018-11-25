-- Table: public.team

-- DROP TABLE public.team;

CREATE TABLE public.team
(
  id_student_group integer NOT NULL DEFAULT nextval('team_id_student_group_seq'::regclass),
  name character varying,
  id_quest integer NOT NULL DEFAULT nextval('team_id_quest_seq'::regclass),
  CONSTRAINT team_pkey PRIMARY KEY (id_student_group),
  CONSTRAINT team_id_quest_fkey FOREIGN KEY (id_quest)
      REFERENCES public.quest (id_quest) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.team
  OWNER TO queststore;

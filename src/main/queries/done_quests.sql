-- Table: public.done_quests

-- DROP TABLE public.done_quests;

CREATE TABLE public.done_quests
(
  id_done_quest integer NOT NULL DEFAULT nextval('done_quests_id_done_quest_seq'::regclass),
  id_quest integer NOT NULL DEFAULT nextval('done_quests_id_quest_seq'::regclass),
  id_student integer NOT NULL DEFAULT nextval('done_quests_id_student_seq'::regclass),
  CONSTRAINT done_quests_pkey PRIMARY KEY (id_done_quest),
  CONSTRAINT done_quests_id_quest_fkey FOREIGN KEY (id_quest)
      REFERENCES public.quest (id_quest) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT done_quests_id_student_fkey FOREIGN KEY (id_student)
      REFERENCES public.student (id_student) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.done_quests
  OWNER TO queststore;

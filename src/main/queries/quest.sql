-- Table: public.quest

-- DROP TABLE public.quest;

CREATE TABLE public.quest
(
  id_quest integer NOT NULL DEFAULT nextval('quest_id_quest_seq'::regclass),
  name character varying,
  description character varying,
  amount double precision,
  quest_type character varying,
  CONSTRAINT quest_pkey PRIMARY KEY (id_quest)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.quest
  OWNER TO queststore;

-- Table: public.reward

-- DROP TABLE public.reward;

CREATE TABLE public.reward
(
  id_reward integer NOT NULL DEFAULT nextval('reward_id_reward_seq'::regclass),
  name character varying,
  description character varying,
  prince double precision,
  CONSTRAINT reward_pkey PRIMARY KEY (id_reward)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.reward
  OWNER TO queststore;

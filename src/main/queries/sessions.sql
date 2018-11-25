-- Table: public.sessions

-- DROP TABLE public.sessions;

CREATE TABLE public.sessions
(
  id_session integer NOT NULL DEFAULT nextval('sessions_id_session_seq'::regclass),
  session_id character varying,
  id_account integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.sessions
  OWNER TO queststore;

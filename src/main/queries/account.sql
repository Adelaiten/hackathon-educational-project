-- Table: public.account

-- DROP TABLE public.account;

CREATE TABLE public.account
(
  id_account integer NOT NULL DEFAULT nextval('account_id_account_seq'::regclass),
  username character varying,
  passwd_hash character varying,
  salt character varying,
  name character varying,
  surname character varying,
  email character varying,
  role character varying,
  exp integer,
  coins integer,
  CONSTRAINT account_pkey PRIMARY KEY (id_account)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.account
  OWNER TO queststore;

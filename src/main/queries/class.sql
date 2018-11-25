-- Table: public.class

-- DROP TABLE public.class;

CREATE TABLE public.class
(
  id_class integer NOT NULL DEFAULT nextval('class_id_class_seq'::regclass),
  name character varying,
  CONSTRAINT class_pkey PRIMARY KEY (id_class)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.class
  OWNER TO queststore;

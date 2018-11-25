--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.10
-- Dumped by pg_dump version 9.6.10

-- Started on 2018-11-25 10:14:29 CET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12393)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2293 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16878)
-- Name: account; Type: TABLE; Schema: public; Owner: queststore
--

CREATE TABLE public.account (
    id_account integer NOT NULL,
    username character varying,
    passwd_hash character varying,
    salt character varying,
    name character varying,
    surname character varying,
    email character varying,
    role character varying,
    exp integer,
    coins integer
);


ALTER TABLE public.account OWNER TO queststore;

--
-- TOC entry 185 (class 1259 OID 16876)
-- Name: account_id_account_seq; Type: SEQUENCE; Schema: public; Owner: queststore
--

CREATE SEQUENCE public.account_id_account_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_id_account_seq OWNER TO queststore;

--
-- TOC entry 2294 (class 0 OID 0)
-- Dependencies: 185
-- Name: account_id_account_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: queststore
--

ALTER SEQUENCE public.account_id_account_seq OWNED BY public.account.id_account;


--
-- TOC entry 190 (class 1259 OID 16900)
-- Name: class; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.class (
    id_class integer NOT NULL,
    name character varying
);


ALTER TABLE public.class OWNER TO queststore;

--
-- TOC entry 189 (class 1259 OID 16898)
-- Name: class_id_class_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.class_id_class_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.class_id_class_seq OWNER TO queststore;

--
-- TOC entry 2295 (class 0 OID 0)
-- Dependencies: 189
-- Name: class_id_class_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.class_id_class_seq OWNED BY public.class.id_class;


--
-- TOC entry 201 (class 1259 OID 16974)
-- Name: done_quests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.done_quests (
    id_done_quest integer NOT NULL,
    id_quest integer NOT NULL,
    id_student integer NOT NULL
);


ALTER TABLE public.done_quests OWNER TO queststore;

--
-- TOC entry 198 (class 1259 OID 16968)
-- Name: done_quests_id_done_quest_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.done_quests_id_done_quest_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.done_quests_id_done_quest_seq OWNER TO queststore;

--
-- TOC entry 2296 (class 0 OID 0)
-- Dependencies: 198
-- Name: done_quests_id_done_quest_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.done_quests_id_done_quest_seq OWNED BY public.done_quests.id_done_quest;


--
-- TOC entry 199 (class 1259 OID 16970)
-- Name: done_quests_id_quest_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.done_quests_id_quest_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.done_quests_id_quest_seq OWNER TO queststore;

--
-- TOC entry 2297 (class 0 OID 0)
-- Dependencies: 199
-- Name: done_quests_id_quest_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.done_quests_id_quest_seq OWNED BY public.done_quests.id_quest;


--
-- TOC entry 200 (class 1259 OID 16972)
-- Name: done_quests_id_student_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.done_quests_id_student_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.done_quests_id_student_seq OWNER TO queststore;

--
-- TOC entry 2298 (class 0 OID 0)
-- Dependencies: 200
-- Name: done_quests_id_student_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.done_quests_id_student_seq OWNED BY public.done_quests.id_student;


--
-- TOC entry 188 (class 1259 OID 16889)
-- Name: quest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quest (
    id_quest integer NOT NULL,
    name character varying,
    description character varying,
    amount double precision,
    quest_type character varying
);


ALTER TABLE public.quest OWNER TO queststore;

--
-- TOC entry 187 (class 1259 OID 16887)
-- Name: quest_id_quest_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.quest_id_quest_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.quest_id_quest_seq OWNER TO queststore;

--
-- TOC entry 2299 (class 0 OID 0)
-- Dependencies: 187
-- Name: quest_id_quest_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.quest_id_quest_seq OWNED BY public.quest.id_quest;


--
-- TOC entry 209 (class 1259 OID 17029)
-- Name: reward; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reward (
    id_reward integer NOT NULL,
    name character varying,
    description character varying,
    prince double precision
);


ALTER TABLE public.reward OWNER TO queststore;

--
-- TOC entry 208 (class 1259 OID 17027)
-- Name: reward_id_reward_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reward_id_reward_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reward_id_reward_seq OWNER TO queststore;

--
-- TOC entry 2300 (class 0 OID 0)
-- Dependencies: 208
-- Name: reward_id_reward_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reward_id_reward_seq OWNED BY public.reward.id_reward;


--
-- TOC entry 215 (class 1259 OID 17083)
-- Name: sessions; Type: TABLE; Schema: public; Owner: queststore
--

CREATE TABLE public.sessions (
    id_session integer NOT NULL,
    session_id character varying,
    id_account integer
);


ALTER TABLE public.sessions OWNER TO queststore;

--
-- TOC entry 214 (class 1259 OID 17081)
-- Name: sessions_id_session_seq; Type: SEQUENCE; Schema: public; Owner: queststore
--

CREATE SEQUENCE public.sessions_id_session_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sessions_id_session_seq OWNER TO queststore;

--
-- TOC entry 2301 (class 0 OID 0)
-- Dependencies: 214
-- Name: sessions_id_session_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: queststore
--

ALTER SEQUENCE public.sessions_id_session_seq OWNED BY public.sessions.id_session;


--
-- TOC entry 197 (class 1259 OID 16950)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    id_student integer NOT NULL,
    id_account integer NOT NULL,
    id_class integer NOT NULL
);


ALTER TABLE public.student OWNER TO queststore;

--
-- TOC entry 195 (class 1259 OID 16946)
-- Name: student_id_account_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_id_account_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_id_account_seq OWNER TO queststore;

--
-- TOC entry 2302 (class 0 OID 0)
-- Dependencies: 195
-- Name: student_id_account_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_id_account_seq OWNED BY public.student.id_account;


--
-- TOC entry 196 (class 1259 OID 16948)
-- Name: student_id_class_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_id_class_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_id_class_seq OWNER TO queststore;

--
-- TOC entry 2303 (class 0 OID 0)
-- Dependencies: 196
-- Name: student_id_class_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_id_class_seq OWNED BY public.student.id_class;


--
-- TOC entry 194 (class 1259 OID 16944)
-- Name: student_id_student_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_id_student_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_id_student_seq OWNER TO queststore;

--
-- TOC entry 2304 (class 0 OID 0)
-- Dependencies: 194
-- Name: student_id_student_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_id_student_seq OWNED BY public.student.id_student;


--
-- TOC entry 213 (class 1259 OID 17044)
-- Name: student_reward; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student_reward (
    id_student_reward integer NOT NULL,
    id_student integer NOT NULL,
    id_reward integer NOT NULL
);


ALTER TABLE public.student_reward OWNER TO queststore;

--
-- TOC entry 212 (class 1259 OID 17042)
-- Name: student_reward_id_reward_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_reward_id_reward_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_reward_id_reward_seq OWNER TO queststore;

--
-- TOC entry 2305 (class 0 OID 0)
-- Dependencies: 212
-- Name: student_reward_id_reward_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_reward_id_reward_seq OWNED BY public.student_reward.id_reward;


--
-- TOC entry 210 (class 1259 OID 17038)
-- Name: student_reward_id_student_reward_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_reward_id_student_reward_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_reward_id_student_reward_seq OWNER TO queststore;

--
-- TOC entry 2306 (class 0 OID 0)
-- Dependencies: 210
-- Name: student_reward_id_student_reward_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_reward_id_student_reward_seq OWNED BY public.student_reward.id_student_reward;


--
-- TOC entry 211 (class 1259 OID 17040)
-- Name: student_reward_id_student_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_reward_id_student_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_reward_id_student_seq OWNER TO queststore;

--
-- TOC entry 2307 (class 0 OID 0)
-- Dependencies: 211
-- Name: student_reward_id_student_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_reward_id_student_seq OWNED BY public.student_reward.id_student;


--
-- TOC entry 193 (class 1259 OID 16913)
-- Name: teacher; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teacher (
    id_teacher integer NOT NULL,
    id_account integer NOT NULL
);


ALTER TABLE public.teacher OWNER TO queststore;

--
-- TOC entry 192 (class 1259 OID 16911)
-- Name: teacher_id_account_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.teacher_id_account_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.teacher_id_account_seq OWNER TO queststore;

--
-- TOC entry 2308 (class 0 OID 0)
-- Dependencies: 192
-- Name: teacher_id_account_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.teacher_id_account_seq OWNED BY public.teacher.id_account;


--
-- TOC entry 191 (class 1259 OID 16909)
-- Name: teacher_id_teacher_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.teacher_id_teacher_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.teacher_id_teacher_seq OWNER TO queststore;

--
-- TOC entry 2309 (class 0 OID 0)
-- Dependencies: 191
-- Name: teacher_id_teacher_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.teacher_id_teacher_seq OWNED BY public.teacher.id_teacher;


--
-- TOC entry 204 (class 1259 OID 16996)
-- Name: team; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.team (
    id_student_group integer NOT NULL,
    name character varying,
    id_quest integer NOT NULL
);


ALTER TABLE public.team OWNER TO queststore;

--
-- TOC entry 203 (class 1259 OID 16994)
-- Name: team_id_quest_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.team_id_quest_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.team_id_quest_seq OWNER TO queststore;

--
-- TOC entry 2310 (class 0 OID 0)
-- Dependencies: 203
-- Name: team_id_quest_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.team_id_quest_seq OWNED BY public.team.id_quest;


--
-- TOC entry 202 (class 1259 OID 16992)
-- Name: team_id_student_group_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.team_id_student_group_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.team_id_student_group_seq OWNER TO queststore;

--
-- TOC entry 2311 (class 0 OID 0)
-- Dependencies: 202
-- Name: team_id_student_group_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.team_id_student_group_seq OWNED BY public.team.id_student_group;


--
-- TOC entry 207 (class 1259 OID 17015)
-- Name: team_member; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.team_member (
    id_team_member integer NOT NULL,
    id_student integer NOT NULL
);


ALTER TABLE public.team_member OWNER TO queststore;

--
-- TOC entry 206 (class 1259 OID 17013)
-- Name: team_member_id_student_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.team_member_id_student_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.team_member_id_student_seq OWNER TO queststore;

--
-- TOC entry 2312 (class 0 OID 0)
-- Dependencies: 206
-- Name: team_member_id_student_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.team_member_id_student_seq OWNED BY public.team_member.id_student;


--
-- TOC entry 205 (class 1259 OID 17011)
-- Name: team_member_id_team_member_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.team_member_id_team_member_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.team_member_id_team_member_seq OWNER TO queststore;

--
-- TOC entry 2313 (class 0 OID 0)
-- Dependencies: 205
-- Name: team_member_id_team_member_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.team_member_id_team_member_seq OWNED BY public.team_member.id_team_member;


--
-- TOC entry 2089 (class 2604 OID 16881)
-- Name: account id_account; Type: DEFAULT; Schema: public; Owner: queststore
--

ALTER TABLE ONLY public.account ALTER COLUMN id_account SET DEFAULT nextval('public.account_id_account_seq'::regclass);


--
-- TOC entry 2091 (class 2604 OID 16903)
-- Name: class id_class; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.class ALTER COLUMN id_class SET DEFAULT nextval('public.class_id_class_seq'::regclass);


--
-- TOC entry 2097 (class 2604 OID 16977)
-- Name: done_quests id_done_quest; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.done_quests ALTER COLUMN id_done_quest SET DEFAULT nextval('public.done_quests_id_done_quest_seq'::regclass);


--
-- TOC entry 2098 (class 2604 OID 16978)
-- Name: done_quests id_quest; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.done_quests ALTER COLUMN id_quest SET DEFAULT nextval('public.done_quests_id_quest_seq'::regclass);


--
-- TOC entry 2099 (class 2604 OID 16979)
-- Name: done_quests id_student; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.done_quests ALTER COLUMN id_student SET DEFAULT nextval('public.done_quests_id_student_seq'::regclass);


--
-- TOC entry 2090 (class 2604 OID 16892)
-- Name: quest id_quest; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quest ALTER COLUMN id_quest SET DEFAULT nextval('public.quest_id_quest_seq'::regclass);


--
-- TOC entry 2104 (class 2604 OID 17032)
-- Name: reward id_reward; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reward ALTER COLUMN id_reward SET DEFAULT nextval('public.reward_id_reward_seq'::regclass);


--
-- TOC entry 2108 (class 2604 OID 17086)
-- Name: sessions id_session; Type: DEFAULT; Schema: public; Owner: queststore
--

ALTER TABLE ONLY public.sessions ALTER COLUMN id_session SET DEFAULT nextval('public.sessions_id_session_seq'::regclass);


--
-- TOC entry 2094 (class 2604 OID 16953)
-- Name: student id_student; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student ALTER COLUMN id_student SET DEFAULT nextval('public.student_id_student_seq'::regclass);


--
-- TOC entry 2095 (class 2604 OID 16954)
-- Name: student id_account; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student ALTER COLUMN id_account SET DEFAULT nextval('public.student_id_account_seq'::regclass);


--
-- TOC entry 2096 (class 2604 OID 16955)
-- Name: student id_class; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student ALTER COLUMN id_class SET DEFAULT nextval('public.student_id_class_seq'::regclass);


--
-- TOC entry 2105 (class 2604 OID 17047)
-- Name: student_reward id_student_reward; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_reward ALTER COLUMN id_student_reward SET DEFAULT nextval('public.student_reward_id_student_reward_seq'::regclass);


--
-- TOC entry 2106 (class 2604 OID 17048)
-- Name: student_reward id_student; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_reward ALTER COLUMN id_student SET DEFAULT nextval('public.student_reward_id_student_seq'::regclass);


--
-- TOC entry 2107 (class 2604 OID 17049)
-- Name: student_reward id_reward; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_reward ALTER COLUMN id_reward SET DEFAULT nextval('public.student_reward_id_reward_seq'::regclass);


--
-- TOC entry 2092 (class 2604 OID 16916)
-- Name: teacher id_teacher; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher ALTER COLUMN id_teacher SET DEFAULT nextval('public.teacher_id_teacher_seq'::regclass);


--
-- TOC entry 2093 (class 2604 OID 16917)
-- Name: teacher id_account; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher ALTER COLUMN id_account SET DEFAULT nextval('public.teacher_id_account_seq'::regclass);


--
-- TOC entry 2100 (class 2604 OID 16999)
-- Name: team id_student_group; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team ALTER COLUMN id_student_group SET DEFAULT nextval('public.team_id_student_group_seq'::regclass);


--
-- TOC entry 2101 (class 2604 OID 17000)
-- Name: team id_quest; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team ALTER COLUMN id_quest SET DEFAULT nextval('public.team_id_quest_seq'::regclass);


--
-- TOC entry 2102 (class 2604 OID 17018)
-- Name: team_member id_team_member; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team_member ALTER COLUMN id_team_member SET DEFAULT nextval('public.team_member_id_team_member_seq'::regclass);


--
-- TOC entry 2103 (class 2604 OID 17019)
-- Name: team_member id_student; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team_member ALTER COLUMN id_student SET DEFAULT nextval('public.team_member_id_student_seq'::regclass);


--
-- TOC entry 2256 (class 0 OID 16878)
-- Dependencies: 186
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: queststore
--

COPY public.account (id_account, username, passwd_hash, salt, name, surname, email, role, exp, coins) FROM stdin;
1	admin	admin	salt	name	surname	admin@gmail.com	TEACHER	99	10
\.


--
-- TOC entry 2314 (class 0 OID 0)
-- Dependencies: 185
-- Name: account_id_account_seq; Type: SEQUENCE SET; Schema: public; Owner: queststore
--

SELECT pg_catalog.setval('public.account_id_account_seq', 1, true);


--
-- TOC entry 2260 (class 0 OID 16900)
-- Dependencies: 190
-- Data for Name: class; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.class (id_class, name) FROM stdin;
\.


--
-- TOC entry 2315 (class 0 OID 0)
-- Dependencies: 189
-- Name: class_id_class_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.class_id_class_seq', 1, false);


--
-- TOC entry 2271 (class 0 OID 16974)
-- Dependencies: 201
-- Data for Name: done_quests; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.done_quests (id_done_quest, id_quest, id_student) FROM stdin;
\.


--
-- TOC entry 2316 (class 0 OID 0)
-- Dependencies: 198
-- Name: done_quests_id_done_quest_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.done_quests_id_done_quest_seq', 1, false);


--
-- TOC entry 2317 (class 0 OID 0)
-- Dependencies: 199
-- Name: done_quests_id_quest_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.done_quests_id_quest_seq', 1, false);


--
-- TOC entry 2318 (class 0 OID 0)
-- Dependencies: 200
-- Name: done_quests_id_student_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.done_quests_id_student_seq', 1, false);


--
-- TOC entry 2258 (class 0 OID 16889)
-- Dependencies: 188
-- Data for Name: quest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.quest (id_quest, name, description, amount, quest_type) FROM stdin;
\.


--
-- TOC entry 2319 (class 0 OID 0)
-- Dependencies: 187
-- Name: quest_id_quest_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.quest_id_quest_seq', 1, false);


--
-- TOC entry 2279 (class 0 OID 17029)
-- Dependencies: 209
-- Data for Name: reward; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reward (id_reward, name, description, prince) FROM stdin;
\.


--
-- TOC entry 2320 (class 0 OID 0)
-- Dependencies: 208
-- Name: reward_id_reward_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reward_id_reward_seq', 1, false);


--
-- TOC entry 2285 (class 0 OID 17083)
-- Dependencies: 215
-- Data for Name: sessions; Type: TABLE DATA; Schema: public; Owner: queststore
--

COPY public.sessions (id_session, session_id, id_account) FROM stdin;
1	8e302f9b-03e4-4b33-be95-b83a275f4f8a	1
2	47fae576-aba8-4f74-bcf3-65ada14cf557	1
3	6b9d82b5-ec74-48e7-9317-c48dbd08778f	1
4	8e302f9b-03e4-4b33-be95-b83a275f4f8a	1
5	4b360620-0dd0-42fc-90e3-42e9585985e5	1
6	40a399d3-7349-477a-950a-51e310c3898c	1
7	a8e9475d-f55b-4203-b512-b2d3dc185c69	1
8	cdaa1424-0a94-4700-80e2-a818a3c66a4d	1
9	a23e6566-316c-44d3-9e1f-17d543f62126	1
10	5ab956f3-485d-4f93-a3a0-7692bad2d62f	1
11	f9c33139-0675-45df-8e3b-eb7faaf083b0	1
12	075ae755-8455-4b9e-a292-5e7482eedb72	1
13	82a12dbd-9fdd-475f-a51d-60db1adaa21a	1
\.


--
-- TOC entry 2321 (class 0 OID 0)
-- Dependencies: 214
-- Name: sessions_id_session_seq; Type: SEQUENCE SET; Schema: public; Owner: queststore
--

SELECT pg_catalog.setval('public.sessions_id_session_seq', 13, true);


--
-- TOC entry 2267 (class 0 OID 16950)
-- Dependencies: 197
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student (id_student, id_account, id_class) FROM stdin;
\.


--
-- TOC entry 2322 (class 0 OID 0)
-- Dependencies: 195
-- Name: student_id_account_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_id_account_seq', 1, false);


--
-- TOC entry 2323 (class 0 OID 0)
-- Dependencies: 196
-- Name: student_id_class_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_id_class_seq', 1, false);


--
-- TOC entry 2324 (class 0 OID 0)
-- Dependencies: 194
-- Name: student_id_student_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_id_student_seq', 1, false);


--
-- TOC entry 2283 (class 0 OID 17044)
-- Dependencies: 213
-- Data for Name: student_reward; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student_reward (id_student_reward, id_student, id_reward) FROM stdin;
\.


--
-- TOC entry 2325 (class 0 OID 0)
-- Dependencies: 212
-- Name: student_reward_id_reward_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_reward_id_reward_seq', 1, false);


--
-- TOC entry 2326 (class 0 OID 0)
-- Dependencies: 210
-- Name: student_reward_id_student_reward_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_reward_id_student_reward_seq', 1, false);


--
-- TOC entry 2327 (class 0 OID 0)
-- Dependencies: 211
-- Name: student_reward_id_student_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_reward_id_student_seq', 1, false);


--
-- TOC entry 2263 (class 0 OID 16913)
-- Dependencies: 193
-- Data for Name: teacher; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teacher (id_teacher, id_account) FROM stdin;
\.


--
-- TOC entry 2328 (class 0 OID 0)
-- Dependencies: 192
-- Name: teacher_id_account_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teacher_id_account_seq', 1, false);


--
-- TOC entry 2329 (class 0 OID 0)
-- Dependencies: 191
-- Name: teacher_id_teacher_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teacher_id_teacher_seq', 1, false);


--
-- TOC entry 2274 (class 0 OID 16996)
-- Dependencies: 204
-- Data for Name: team; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.team (id_student_group, name, id_quest) FROM stdin;
\.


--
-- TOC entry 2330 (class 0 OID 0)
-- Dependencies: 203
-- Name: team_id_quest_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.team_id_quest_seq', 1, false);


--
-- TOC entry 2331 (class 0 OID 0)
-- Dependencies: 202
-- Name: team_id_student_group_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.team_id_student_group_seq', 1, false);


--
-- TOC entry 2277 (class 0 OID 17015)
-- Dependencies: 207
-- Data for Name: team_member; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.team_member (id_team_member, id_student) FROM stdin;
\.


--
-- TOC entry 2332 (class 0 OID 0)
-- Dependencies: 206
-- Name: team_member_id_student_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.team_member_id_student_seq', 1, false);


--
-- TOC entry 2333 (class 0 OID 0)
-- Dependencies: 205
-- Name: team_member_id_team_member_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.team_member_id_team_member_seq', 1, false);


--
-- TOC entry 2110 (class 2606 OID 16886)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: queststore
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id_account);


--
-- TOC entry 2114 (class 2606 OID 16908)
-- Name: class class_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.class
    ADD CONSTRAINT class_pkey PRIMARY KEY (id_class);


--
-- TOC entry 2120 (class 2606 OID 16981)
-- Name: done_quests done_quests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.done_quests
    ADD CONSTRAINT done_quests_pkey PRIMARY KEY (id_done_quest);


--
-- TOC entry 2112 (class 2606 OID 16897)
-- Name: quest quest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quest
    ADD CONSTRAINT quest_pkey PRIMARY KEY (id_quest);


--
-- TOC entry 2126 (class 2606 OID 17037)
-- Name: reward reward_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reward
    ADD CONSTRAINT reward_pkey PRIMARY KEY (id_reward);


--
-- TOC entry 2118 (class 2606 OID 16957)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id_student);


--
-- TOC entry 2128 (class 2606 OID 17051)
-- Name: student_reward student_reward_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_reward
    ADD CONSTRAINT student_reward_pkey PRIMARY KEY (id_student_reward);


--
-- TOC entry 2116 (class 2606 OID 16919)
-- Name: teacher teacher_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_pkey PRIMARY KEY (id_teacher);


--
-- TOC entry 2124 (class 2606 OID 17021)
-- Name: team_member team_member_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team_member
    ADD CONSTRAINT team_member_pkey PRIMARY KEY (id_team_member);


--
-- TOC entry 2122 (class 2606 OID 17005)
-- Name: team team_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team
    ADD CONSTRAINT team_pkey PRIMARY KEY (id_student_group);


--
-- TOC entry 2132 (class 2606 OID 16982)
-- Name: done_quests done_quests_id_quest_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.done_quests
    ADD CONSTRAINT done_quests_id_quest_fkey FOREIGN KEY (id_quest) REFERENCES public.quest(id_quest);


--
-- TOC entry 2133 (class 2606 OID 16987)
-- Name: done_quests done_quests_id_student_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.done_quests
    ADD CONSTRAINT done_quests_id_student_fkey FOREIGN KEY (id_student) REFERENCES public.student(id_student);


--
-- TOC entry 2130 (class 2606 OID 16958)
-- Name: student student_id_account_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_id_account_fkey FOREIGN KEY (id_account) REFERENCES public.account(id_account);


--
-- TOC entry 2131 (class 2606 OID 16963)
-- Name: student student_id_class_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_id_class_fkey FOREIGN KEY (id_class) REFERENCES public.class(id_class);


--
-- TOC entry 2137 (class 2606 OID 17057)
-- Name: student_reward student_reward_id_reward_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_reward
    ADD CONSTRAINT student_reward_id_reward_fkey FOREIGN KEY (id_reward) REFERENCES public.reward(id_reward);


--
-- TOC entry 2136 (class 2606 OID 17052)
-- Name: student_reward student_reward_id_student_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_reward
    ADD CONSTRAINT student_reward_id_student_fkey FOREIGN KEY (id_student) REFERENCES public.student(id_student);


--
-- TOC entry 2129 (class 2606 OID 16920)
-- Name: teacher teacher_id_account_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_id_account_fkey FOREIGN KEY (id_account) REFERENCES public.account(id_account);


--
-- TOC entry 2134 (class 2606 OID 17006)
-- Name: team team_id_quest_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team
    ADD CONSTRAINT team_id_quest_fkey FOREIGN KEY (id_quest) REFERENCES public.quest(id_quest);


--
-- TOC entry 2135 (class 2606 OID 17022)
-- Name: team_member team_member_id_student_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team_member
    ADD CONSTRAINT team_member_id_student_fkey FOREIGN KEY (id_student) REFERENCES public.student(id_student);


-- Completed on 2018-11-25 10:14:29 CET

--
-- PostgreSQL database dump complete
--


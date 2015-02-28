--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cpu; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cpu (
    id_cpu integer NOT NULL,
    company text NOT NULL,
    model text NOT NULL,
    quantity integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.cpu OWNER TO postgres;

--
-- Name: cpu_id_cpu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cpu_id_cpu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cpu_id_cpu_seq OWNER TO postgres;

--
-- Name: cpu_id_cpu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cpu_id_cpu_seq OWNED BY cpu.id_cpu;


--
-- Name: hdd; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE hdd (
    id_hdd integer NOT NULL,
    company text NOT NULL,
    model text NOT NULL,
    quantity integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.hdd OWNER TO postgres;

--
-- Name: hdd_id_hdd_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hdd_id_hdd_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hdd_id_hdd_seq OWNER TO postgres;

--
-- Name: hdd_id_hdd_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE hdd_id_hdd_seq OWNED BY hdd.id_hdd;


--
-- Name: mainboard; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mainboard (
    id_mb integer NOT NULL,
    company text NOT NULL,
    model text NOT NULL,
    quantity integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.mainboard OWNER TO postgres;

--
-- Name: mainboard_id_mb_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE mainboard_id_mb_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mainboard_id_mb_seq OWNER TO postgres;

--
-- Name: mainboard_id_mb_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE mainboard_id_mb_seq OWNED BY mainboard.id_mb;


--
-- Name: monitor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE monitor (
    id_mon integer NOT NULL,
    company text NOT NULL,
    model text NOT NULL,
    quantity integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.monitor OWNER TO postgres;

--
-- Name: monitor_id_mon_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE monitor_id_mon_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.monitor_id_mon_seq OWNER TO postgres;

--
-- Name: monitor_id_mon_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE monitor_id_mon_seq OWNED BY monitor.id_mon;


--
-- Name: ram; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ram (
    id_ram integer NOT NULL,
    company text NOT NULL,
    model text NOT NULL,
    quantity integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.ram OWNER TO postgres;

--
-- Name: ram_id_ram_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ram_id_ram_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ram_id_ram_seq OWNER TO postgres;

--
-- Name: ram_id_ram_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ram_id_ram_seq OWNED BY ram.id_ram;


--
-- Name: sold_cpu; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sold_cpu (
    id_sold_cpu integer NOT NULL,
    id_cpu integer,
    date date
);


ALTER TABLE public.sold_cpu OWNER TO postgres;

--
-- Name: sold_cpu_id_sold_cpu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sold_cpu_id_sold_cpu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sold_cpu_id_sold_cpu_seq OWNER TO postgres;

--
-- Name: sold_cpu_id_sold_cpu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sold_cpu_id_sold_cpu_seq OWNED BY sold_cpu.id_sold_cpu;


--
-- Name: sold_hdd; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sold_hdd (
    id_sold_hdd integer NOT NULL,
    id_hdd integer,
    date date
);


ALTER TABLE public.sold_hdd OWNER TO postgres;

--
-- Name: sold_hdd_id_sold_hdd_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sold_hdd_id_sold_hdd_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sold_hdd_id_sold_hdd_seq OWNER TO postgres;

--
-- Name: sold_hdd_id_sold_hdd_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sold_hdd_id_sold_hdd_seq OWNED BY sold_hdd.id_sold_hdd;


--
-- Name: sold_mainboard; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sold_mainboard (
    id_sold_mb integer NOT NULL,
    id_mb integer,
    date date
);


ALTER TABLE public.sold_mainboard OWNER TO postgres;

--
-- Name: sold_mainboard_id_sold_mb_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sold_mainboard_id_sold_mb_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sold_mainboard_id_sold_mb_seq OWNER TO postgres;

--
-- Name: sold_mainboard_id_sold_mb_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sold_mainboard_id_sold_mb_seq OWNED BY sold_mainboard.id_sold_mb;


--
-- Name: sold_monitor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sold_monitor (
    id_sold_mon integer NOT NULL,
    id_mon integer,
    date date
);


ALTER TABLE public.sold_monitor OWNER TO postgres;

--
-- Name: sold_monitor_id_sold_mon_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sold_monitor_id_sold_mon_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sold_monitor_id_sold_mon_seq OWNER TO postgres;

--
-- Name: sold_monitor_id_sold_mon_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sold_monitor_id_sold_mon_seq OWNED BY sold_monitor.id_sold_mon;


--
-- Name: sold_ram; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sold_ram (
    id_sold_ram integer NOT NULL,
    id_ram integer,
    date date
);


ALTER TABLE public.sold_ram OWNER TO postgres;

--
-- Name: sold_ram_id_sold_ram_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sold_ram_id_sold_ram_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sold_ram_id_sold_ram_seq OWNER TO postgres;

--
-- Name: sold_ram_id_sold_ram_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sold_ram_id_sold_ram_seq OWNED BY sold_ram.id_sold_ram;


--
-- Name: id_cpu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cpu ALTER COLUMN id_cpu SET DEFAULT nextval('cpu_id_cpu_seq'::regclass);


--
-- Name: id_hdd; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hdd ALTER COLUMN id_hdd SET DEFAULT nextval('hdd_id_hdd_seq'::regclass);


--
-- Name: id_mb; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mainboard ALTER COLUMN id_mb SET DEFAULT nextval('mainboard_id_mb_seq'::regclass);


--
-- Name: id_mon; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY monitor ALTER COLUMN id_mon SET DEFAULT nextval('monitor_id_mon_seq'::regclass);


--
-- Name: id_ram; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ram ALTER COLUMN id_ram SET DEFAULT nextval('ram_id_ram_seq'::regclass);


--
-- Name: id_sold_cpu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_cpu ALTER COLUMN id_sold_cpu SET DEFAULT nextval('sold_cpu_id_sold_cpu_seq'::regclass);


--
-- Name: id_sold_hdd; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_hdd ALTER COLUMN id_sold_hdd SET DEFAULT nextval('sold_hdd_id_sold_hdd_seq'::regclass);


--
-- Name: id_sold_mb; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_mainboard ALTER COLUMN id_sold_mb SET DEFAULT nextval('sold_mainboard_id_sold_mb_seq'::regclass);


--
-- Name: id_sold_mon; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_monitor ALTER COLUMN id_sold_mon SET DEFAULT nextval('sold_monitor_id_sold_mon_seq'::regclass);


--
-- Name: id_sold_ram; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_ram ALTER COLUMN id_sold_ram SET DEFAULT nextval('sold_ram_id_sold_ram_seq'::regclass);


--
-- Data for Name: cpu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cpu (id_cpu, company, model, quantity, price) FROM stdin;
1	Intel	core3	5	50000
2	Intel	core5	3	45000
3	Intel	core7	2	65000
4	Intel	pentium	1	25000
5	Intel	pentium4	2	35000
\.


--
-- Name: cpu_id_cpu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cpu_id_cpu_seq', 5, true);


--
-- Data for Name: hdd; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY hdd (id_hdd, company, model, quantity, price) FROM stdin;
1	seagate	ST1000	2	35000
2	seagate	ST2000	3	55000
3	Toshiba	DT1000	5	45000
4	Toshiba	DH00	1	45000
\.


--
-- Name: hdd_id_hdd_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hdd_id_hdd_seq', 4, true);


--
-- Data for Name: mainboard; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY mainboard (id_mb, company, model, quantity, price) FROM stdin;
1	Asus	H81M	1	45000
2	Asus	Z97K	2	34000
3	Asrock	H61M	2	39000
4	MSI	970A	1	49000
5	Gigabyte	B85M	5	42000
\.


--
-- Name: mainboard_id_mb_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('mainboard_id_mb_seq', 5, true);


--
-- Data for Name: monitor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY monitor (id_mon, company, model, quantity, price) FROM stdin;
1	LG	22EA	3	42000
2	LG	22MP	2	32000
3	AOK	E22	2	22000
4	Dell	S22	1	42000
5	Dell	P24	4	45000
\.


--
-- Name: monitor_id_mon_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('monitor_id_mon_seq', 5, true);


--
-- Data for Name: ram; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ram (id_ram, company, model, quantity, price) FROM stdin;
1	Kinston	DDR2_2gb	4	15000
2	Kinston	KHX_DDR3_8gb	4	1000
3	Crucial	DDR3_2gb	4	24000
4	GoodRam	DDR_1gb	1	24000
5	GoodRam	DDR_2_1gb	2	28000
\.


--
-- Name: ram_id_ram_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ram_id_ram_seq', 5, true);


--
-- Data for Name: sold_cpu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sold_cpu (id_sold_cpu, id_cpu, date) FROM stdin;
1	2	2015-02-20
2	3	2015-02-22
\.


--
-- Name: sold_cpu_id_sold_cpu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sold_cpu_id_sold_cpu_seq', 2, true);


--
-- Data for Name: sold_hdd; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sold_hdd (id_sold_hdd, id_hdd, date) FROM stdin;
1	2	2015-02-17
2	4	2015-02-07
\.


--
-- Name: sold_hdd_id_sold_hdd_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sold_hdd_id_sold_hdd_seq', 2, true);


--
-- Data for Name: sold_mainboard; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sold_mainboard (id_sold_mb, id_mb, date) FROM stdin;
1	5	2015-02-18
2	1	2015-02-11
\.


--
-- Name: sold_mainboard_id_sold_mb_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sold_mainboard_id_sold_mb_seq', 2, true);


--
-- Data for Name: sold_monitor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sold_monitor (id_sold_mon, id_mon, date) FROM stdin;
1	4	2015-02-07
2	5	2015-02-08
\.


--
-- Name: sold_monitor_id_sold_mon_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sold_monitor_id_sold_mon_seq', 2, true);


--
-- Data for Name: sold_ram; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sold_ram (id_sold_ram, id_ram, date) FROM stdin;
1	3	2015-02-22
2	2	2015-02-27
\.


--
-- Name: sold_ram_id_sold_ram_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sold_ram_id_sold_ram_seq', 2, true);


--
-- Name: cpu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cpu
    ADD CONSTRAINT cpu_pkey PRIMARY KEY (id_cpu);


--
-- Name: hdd_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hdd
    ADD CONSTRAINT hdd_pkey PRIMARY KEY (id_hdd);


--
-- Name: mainboard_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mainboard
    ADD CONSTRAINT mainboard_pkey PRIMARY KEY (id_mb);


--
-- Name: monitor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY monitor
    ADD CONSTRAINT monitor_pkey PRIMARY KEY (id_mon);


--
-- Name: ram_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ram
    ADD CONSTRAINT ram_pkey PRIMARY KEY (id_ram);


--
-- Name: sold_cpu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sold_cpu
    ADD CONSTRAINT sold_cpu_pkey PRIMARY KEY (id_sold_cpu);


--
-- Name: sold_hdd_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sold_hdd
    ADD CONSTRAINT sold_hdd_pkey PRIMARY KEY (id_sold_hdd);


--
-- Name: sold_mainboard_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sold_mainboard
    ADD CONSTRAINT sold_mainboard_pkey PRIMARY KEY (id_sold_mb);


--
-- Name: sold_monitor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sold_monitor
    ADD CONSTRAINT sold_monitor_pkey PRIMARY KEY (id_sold_mon);


--
-- Name: sold_ram_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sold_ram
    ADD CONSTRAINT sold_ram_pkey PRIMARY KEY (id_sold_ram);


--
-- Name: sold_cpu_id_cpu_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_cpu
    ADD CONSTRAINT sold_cpu_id_cpu_fkey FOREIGN KEY (id_cpu) REFERENCES cpu(id_cpu);


--
-- Name: sold_hdd_id_hdd_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_hdd
    ADD CONSTRAINT sold_hdd_id_hdd_fkey FOREIGN KEY (id_hdd) REFERENCES hdd(id_hdd);


--
-- Name: sold_mainboard_id_mb_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_mainboard
    ADD CONSTRAINT sold_mainboard_id_mb_fkey FOREIGN KEY (id_mb) REFERENCES mainboard(id_mb);


--
-- Name: sold_monitor_id_mon_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_monitor
    ADD CONSTRAINT sold_monitor_id_mon_fkey FOREIGN KEY (id_mon) REFERENCES monitor(id_mon);


--
-- Name: sold_ram_id_ram_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_ram
    ADD CONSTRAINT sold_ram_id_ram_fkey FOREIGN KEY (id_ram) REFERENCES ram(id_ram);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--


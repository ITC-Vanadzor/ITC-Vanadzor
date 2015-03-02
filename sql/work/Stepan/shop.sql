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
-- Name: cost_monitor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cost_monitor (
    id_cost_mon integer NOT NULL,
    id_mon integer,
    date date
);


ALTER TABLE public.cost_monitor OWNER TO postgres;

--
-- Name: main_board; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE main_board (
    id_mb integer NOT NULL,
    company text NOT NULL,
    model text NOT NULL,
    count integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.main_board OWNER TO postgres;

--
-- Name: monitor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE monitor (
    id_mon integer NOT NULL,
    company text NOT NULL,
    model text NOT NULL,
    number integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.monitor OWNER TO postgres;

--
-- Name: ram; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ram (
    id_ram integer NOT NULL,
    company text NOT NULL,
    model text NOT NULL,
    count integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.ram OWNER TO postgres;

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
-- Name: sold_mb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sold_mb (
    id_sold ram NOT NULL,
    id_mb integer,
    date date
);


ALTER TABLE public.sold_mb OWNER TO postgres;

--
-- Name: sold_ram; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sold_ram (
    id_sold ram NOT NULL,
    id_ram integer,
    date date
);


ALTER TABLE public.sold_ram OWNER TO postgres;

--
-- Data for Name: cost_monitor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cost_monitor (id_cost_mon, id_mon, date) FROM stdin;
1	1	2015-02-11
\.


--
-- Data for Name: main_board; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY main_board (id_mb, company, model, count, price) FROM stdin;
1	Philips	TXK	5	5000
2	LG	TYYXK	2	8000
\.


--
-- Data for Name: monitor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY monitor (id_mon, company, model, number, price) FROM stdin;
1	Asus	JTG	2	2000
2	LG	KKK	2	3000
\.


--
-- Data for Name: ram; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ram (id_ram, company, model, count, price) FROM stdin;
1	LG	TTG	3	3000
2	Asus	JTG	2	2000
\.


--
-- Data for Name: sold_mainboard; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sold_mainboard (id_sold_mb, id_mb, date) FROM stdin;
\.


--
-- Data for Name: sold_mb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sold_mb (id_sold, id_mb, date) FROM stdin;
\.


--
-- Data for Name: sold_ram; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sold_ram (id_sold, id_ram, date) FROM stdin;
\.


--
-- Name: cost_monitor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cost_monitor
    ADD CONSTRAINT cost_monitor_pkey PRIMARY KEY (id_cost_mon);


--
-- Name: main_board_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY main_board
    ADD CONSTRAINT main_board_pkey PRIMARY KEY (id_mb);


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
-- Name: sold_mainboard_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sold_mainboard
    ADD CONSTRAINT sold_mainboard_pkey PRIMARY KEY (id_sold_mb);


--
-- Name: sold_mb_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sold_mb
    ADD CONSTRAINT sold_mb_pkey PRIMARY KEY (id_sold);


--
-- Name: sold_ram_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sold_ram
    ADD CONSTRAINT sold_ram_pkey PRIMARY KEY (id_sold);


--
-- Name: cost_monitor_id_mon_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cost_monitor
    ADD CONSTRAINT cost_monitor_id_mon_fkey FOREIGN KEY (id_mon) REFERENCES monitor(id_mon);


--
-- Name: sold_mainboard_id_mb_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_mainboard
    ADD CONSTRAINT sold_mainboard_id_mb_fkey FOREIGN KEY (id_mb) REFERENCES main_board(id_mb);


--
-- Name: sold_mb_id_mb_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sold_mb
    ADD CONSTRAINT sold_mb_id_mb_fkey FOREIGN KEY (id_mb) REFERENCES main_board(id_mb);


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


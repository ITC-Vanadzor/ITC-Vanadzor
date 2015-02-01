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
-- Name: myschema; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA myschema;


ALTER SCHEMA myschema OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = myschema, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: name; Type: TABLE; Schema: myschema; Owner: postgres; Tablespace: 
--

CREATE TABLE name (
    id integer NOT NULL,
    surname character varying NOT NULL,
    age integer
);


ALTER TABLE myschema.name OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- Name: main; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE main (
    id integer NOT NULL,
    name text NOT NULL,
    lastmane text NOT NULL,
    email text NOT NULL,
    password text NOT NULL
);


ALTER TABLE public.main OWNER TO postgres;

--
-- Name: main2; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE main2 (
    id integer NOT NULL,
    name text NOT NULL,
    lastmane text NOT NULL,
    email text NOT NULL,
    password text NOT NULL
);


ALTER TABLE public.main2 OWNER TO postgres;

--
-- Name: name; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE name (
    id integer NOT NULL,
    name text NOT NULL,
    age integer NOT NULL,
    address character(50)
);


ALTER TABLE public.name OWNER TO postgres;

--
-- Name: password; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE password (
    id integer NOT NULL,
    name text NOT NULL,
    lenght integer NOT NULL
);


ALTER TABLE public.password OWNER TO postgres;

SET search_path = myschema, pg_catalog;

--
-- Data for Name: name; Type: TABLE DATA; Schema: myschema; Owner: postgres
--

COPY name (id, surname, age) FROM stdin;
\.


SET search_path = public, pg_catalog;

--
-- Data for Name: main; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY main (id, name, lastmane, email, password) FROM stdin;
1	Stepan	Chaparyan	schaparian@yahoo.com	bobo
2	Sarqis	Qocharyan	sarqis@yahoo.com	jhh
3	Vahan	Levonyan	vahans@yahoo.com	levvahan
4	Marine	Unknown	marishok@yahoo.com	marishkn
5	Movses	Khachatryan	movses@yahoo.com	moskhach
6	Hrach	unknown	hrach@yahoo.com	hrachch
7	Gor	Julhakyan	gorjul@yahoo.com	julhak
9	Eduard	Hakobyan	hakerd@yahoo.com	eduhakr
8	Karen	Qochinyan	karqochart@yahoo.com	karkhochart
10	Mane	Hambardzumyan	mane_h@yahoo.com	mane_hpas
\.


--
-- Data for Name: main2; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY main2 (id, name, lastmane, email, password) FROM stdin;
\.


--
-- Data for Name: name; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY name (id, name, age, address) FROM stdin;
\.


--
-- Data for Name: password; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY password (id, name, lenght) FROM stdin;
\.


SET search_path = myschema, pg_catalog;

--
-- Name: name_pkey; Type: CONSTRAINT; Schema: myschema; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY name
    ADD CONSTRAINT name_pkey PRIMARY KEY (id);


SET search_path = public, pg_catalog;

--
-- Name: main2_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY main2
    ADD CONSTRAINT main2_pkey PRIMARY KEY (id);


--
-- Name: main_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY main
    ADD CONSTRAINT main_pkey PRIMARY KEY (id);


--
-- Name: name_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY name
    ADD CONSTRAINT name_pkey PRIMARY KEY (id);


--
-- Name: password_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY password
    ADD CONSTRAINT password_pkey PRIMARY KEY (id);


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


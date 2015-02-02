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
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: reg_password; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE reg_password (
    user_id integer NOT NULL,
    pswd_id integer NOT NULL,
    date date,
    password character varying(25)
);


ALTER TABLE public.reg_password OWNER TO postgres;

--
-- Name: reg_password_pswd_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE reg_password_pswd_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reg_password_pswd_id_seq OWNER TO postgres;

--
-- Name: reg_password_pswd_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE reg_password_pswd_id_seq OWNED BY reg_password.pswd_id;


--
-- Name: reg_password_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE reg_password_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reg_password_user_id_seq OWNER TO postgres;

--
-- Name: reg_password_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE reg_password_user_id_seq OWNED BY reg_password.user_id;


--
-- Name: registration; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE registration (
    user_id integer NOT NULL,
    fname character varying(50),
    lname character varying(25) NOT NULL,
    email character varying(25)
);


ALTER TABLE public.registration OWNER TO postgres;

--
-- Name: registration_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE registration_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.registration_user_id_seq OWNER TO postgres;

--
-- Name: registration_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE registration_user_id_seq OWNED BY registration.user_id;


--
-- Name: weather; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE weather (
    city character varying(80),
    temp_lo integer,
    temp_hi integer,
    prcp real,
    date date
);


ALTER TABLE public.weather OWNER TO postgres;

--
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reg_password ALTER COLUMN user_id SET DEFAULT nextval('reg_password_user_id_seq'::regclass);


--
-- Name: pswd_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reg_password ALTER COLUMN pswd_id SET DEFAULT nextval('reg_password_pswd_id_seq'::regclass);


--
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY registration ALTER COLUMN user_id SET DEFAULT nextval('registration_user_id_seq'::regclass);


--
-- Data for Name: reg_password; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY reg_password (user_id, pswd_id, date, password) FROM stdin;
\.


--
-- Name: reg_password_pswd_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('reg_password_pswd_id_seq', 1, false);


--
-- Name: reg_password_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('reg_password_user_id_seq', 1, false);


--
-- Data for Name: registration; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY registration (user_id, fname, lname, email) FROM stdin;
\.


--
-- Name: registration_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('registration_user_id_seq', 1, false);


--
-- Data for Name: weather; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY weather (city, temp_lo, temp_hi, prcp, date) FROM stdin;
\.


--
-- Name: reg_password_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY reg_password
    ADD CONSTRAINT reg_password_pkey PRIMARY KEY (user_id);


--
-- Name: registration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY registration
    ADD CONSTRAINT registration_pkey PRIMARY KEY (user_id);


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


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
-- Name: user_information; Type: TABLE; Schema: public; Owner: gor; Tablespace: 
--

CREATE TABLE user_information (
    user_id integer NOT NULL,
    birt_date date,
    age integer,
    gender character varying(10)
);


ALTER TABLE user_information OWNER TO gor;

--
-- Name: user_information_user_id_seq; Type: SEQUENCE; Schema: public; Owner: gor
--

CREATE SEQUENCE user_information_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_information_user_id_seq OWNER TO gor;

--
-- Name: user_information_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: gor
--

ALTER SEQUENCE user_information_user_id_seq OWNED BY user_information.user_id;


--
-- Name: user_password; Type: TABLE; Schema: public; Owner: gor; Tablespace: 
--

CREATE TABLE user_password (
    user_id integer NOT NULL,
    password character varying(50)
);


ALTER TABLE user_password OWNER TO gor;

--
-- Name: user_password_user_id_seq; Type: SEQUENCE; Schema: public; Owner: gor
--

CREATE SEQUENCE user_password_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_password_user_id_seq OWNER TO gor;

--
-- Name: user_password_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: gor
--

ALTER SEQUENCE user_password_user_id_seq OWNED BY user_password.user_id;


--
-- Name: user_personal; Type: TABLE; Schema: public; Owner: gor; Tablespace: 
--

CREATE TABLE user_personal (
    user_id integer NOT NULL,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    email character varying(50) NOT NULL
);


ALTER TABLE user_personal OWNER TO gor;

--
-- Name: user_personal_equip_id_seq; Type: SEQUENCE; Schema: public; Owner: gor
--

CREATE SEQUENCE user_personal_equip_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_personal_equip_id_seq OWNER TO gor;

--
-- Name: user_personal_equip_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: gor
--

ALTER SEQUENCE user_personal_equip_id_seq OWNED BY user_personal.user_id;


--
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: gor
--

ALTER TABLE ONLY user_information ALTER COLUMN user_id SET DEFAULT nextval('user_information_user_id_seq'::regclass);


--
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: gor
--

ALTER TABLE ONLY user_password ALTER COLUMN user_id SET DEFAULT nextval('user_password_user_id_seq'::regclass);


--
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: gor
--

ALTER TABLE ONLY user_personal ALTER COLUMN user_id SET DEFAULT nextval('user_personal_equip_id_seq'::regclass);


--
-- Data for Name: user_information; Type: TABLE DATA; Schema: public; Owner: gor
--

COPY user_information (user_id, birt_date, age, gender) FROM stdin;
\.


--
-- Name: user_information_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: gor
--

SELECT pg_catalog.setval('user_information_user_id_seq', 1, false);


--
-- Data for Name: user_password; Type: TABLE DATA; Schema: public; Owner: gor
--

COPY user_password (user_id, password) FROM stdin;
\.


--
-- Name: user_password_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: gor
--

SELECT pg_catalog.setval('user_password_user_id_seq', 1, false);


--
-- Data for Name: user_personal; Type: TABLE DATA; Schema: public; Owner: gor
--

COPY user_personal (user_id, name, surname, email) FROM stdin;
1	anu	azganun	email@emai.email
2			
3			
4			
5			
6			
7			
8			
9			
37	Petros	Petrosyan	poxos@gmail.com
38	Petros	Petrosyan	poxos@gmail.com
\.


--
-- Name: user_personal_equip_id_seq; Type: SEQUENCE SET; Schema: public; Owner: gor
--

SELECT pg_catalog.setval('user_personal_equip_id_seq', 38, true);


--
-- Name: user_information_pkey; Type: CONSTRAINT; Schema: public; Owner: gor; Tablespace: 
--

ALTER TABLE ONLY user_information
    ADD CONSTRAINT user_information_pkey PRIMARY KEY (user_id);


--
-- Name: user_password_pkey; Type: CONSTRAINT; Schema: public; Owner: gor; Tablespace: 
--

ALTER TABLE ONLY user_password
    ADD CONSTRAINT user_password_pkey PRIMARY KEY (user_id);


--
-- Name: user_personal_pkey; Type: CONSTRAINT; Schema: public; Owner: gor; Tablespace: 
--

ALTER TABLE ONLY user_personal
    ADD CONSTRAINT user_personal_pkey PRIMARY KEY (user_id);


--
-- Name: user_information_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: gor
--

ALTER TABLE ONLY user_information
    ADD CONSTRAINT user_information_user_id_fkey FOREIGN KEY (user_id) REFERENCES user_personal(user_id);


--
-- Name: user_password_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: gor
--

ALTER TABLE ONLY user_password
    ADD CONSTRAINT user_password_user_id_fkey FOREIGN KEY (user_id) REFERENCES user_personal(user_id);


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


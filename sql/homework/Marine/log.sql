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

--
-- Name: gender; Type: TYPE; Schema: public; Owner: maya
--

CREATE TYPE gender AS ENUM (
    'male',
    'female'
);


ALTER TYPE public.gender OWNER TO maya;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: gender_age; Type: TABLE; Schema: public; Owner: maya; Tablespace: 
--

CREATE TABLE gender_age (
    id integer NOT NULL,
    age integer,
    gender gender,
    users integer
);


ALTER TABLE public.gender_age OWNER TO maya;

--
-- Name: gender_age_id_seq; Type: SEQUENCE; Schema: public; Owner: maya
--

CREATE SEQUENCE gender_age_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gender_age_id_seq OWNER TO maya;

--
-- Name: gender_age_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: maya
--

ALTER SEQUENCE gender_age_id_seq OWNED BY gender_age.id;


--
-- Name: passwd; Type: TABLE; Schema: public; Owner: maya; Tablespace: 
--

CREATE TABLE passwd (
    id_pass integer NOT NULL,
    users integer,
    passwd character(20) NOT NULL
);


ALTER TABLE public.passwd OWNER TO maya;

--
-- Name: passwd_id_pass_seq; Type: SEQUENCE; Schema: public; Owner: maya
--

CREATE SEQUENCE passwd_id_pass_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.passwd_id_pass_seq OWNER TO maya;

--
-- Name: passwd_id_pass_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: maya
--

ALTER SEQUENCE passwd_id_pass_seq OWNED BY passwd.id_pass;


--
-- Name: users; Type: TABLE; Schema: public; Owner: maya; Tablespace: 
--

CREATE TABLE users (
    id_user integer NOT NULL,
    name character(15) NOT NULL,
    lname character(15) NOT NULL,
    email character(25) NOT NULL
);


ALTER TABLE public.users OWNER TO maya;

--
-- Name: users_id_user_seq; Type: SEQUENCE; Schema: public; Owner: maya
--

CREATE SEQUENCE users_id_user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_user_seq OWNER TO maya;

--
-- Name: users_id_user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: maya
--

ALTER SEQUENCE users_id_user_seq OWNED BY users.id_user;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: maya
--

ALTER TABLE ONLY gender_age ALTER COLUMN id SET DEFAULT nextval('gender_age_id_seq'::regclass);


--
-- Name: id_pass; Type: DEFAULT; Schema: public; Owner: maya
--

ALTER TABLE ONLY passwd ALTER COLUMN id_pass SET DEFAULT nextval('passwd_id_pass_seq'::regclass);


--
-- Name: id_user; Type: DEFAULT; Schema: public; Owner: maya
--

ALTER TABLE ONLY users ALTER COLUMN id_user SET DEFAULT nextval('users_id_user_seq'::regclass);


--
-- Data for Name: gender_age; Type: TABLE DATA; Schema: public; Owner: maya
--

COPY gender_age (id, age, gender, users) FROM stdin;
\.


--
-- Name: gender_age_id_seq; Type: SEQUENCE SET; Schema: public; Owner: maya
--

SELECT pg_catalog.setval('gender_age_id_seq', 1, false);


--
-- Data for Name: passwd; Type: TABLE DATA; Schema: public; Owner: maya
--

COPY passwd (id_pass, users, passwd) FROM stdin;
\.


--
-- Name: passwd_id_pass_seq; Type: SEQUENCE SET; Schema: public; Owner: maya
--

SELECT pg_catalog.setval('passwd_id_pass_seq', 1, false);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: maya
--

COPY users (id_user, name, lname, email) FROM stdin;
1	Marine         	Grigoryan      	marishok2890@mail.ru     
2	Movses         	Khachatryan    	xmovses12@mail.ru        
3	Eduard         	Hakobyan       	edtennis@yandex.com      
\.


--
-- Name: users_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: maya
--

SELECT pg_catalog.setval('users_id_user_seq', 3, true);


--
-- Name: gender_age_pkey; Type: CONSTRAINT; Schema: public; Owner: maya; Tablespace: 
--

ALTER TABLE ONLY gender_age
    ADD CONSTRAINT gender_age_pkey PRIMARY KEY (id);


--
-- Name: passwd_pkey; Type: CONSTRAINT; Schema: public; Owner: maya; Tablespace: 
--

ALTER TABLE ONLY passwd
    ADD CONSTRAINT passwd_pkey PRIMARY KEY (id_pass);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: maya; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_user);


--
-- Name: gender_age_users_fkey; Type: FK CONSTRAINT; Schema: public; Owner: maya
--

ALTER TABLE ONLY gender_age
    ADD CONSTRAINT gender_age_users_fkey FOREIGN KEY (users) REFERENCES users(id_user);


--
-- Name: passwd_users_fkey; Type: FK CONSTRAINT; Schema: public; Owner: maya
--

ALTER TABLE ONLY passwd
    ADD CONSTRAINT passwd_users_fkey FOREIGN KEY (users) REFERENCES users(id_user);


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


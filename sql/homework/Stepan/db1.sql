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
-- Name: clients; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE clients (
    id integer NOT NULL,
    name text NOT NULL,
    lastname text NOT NULL,
    illness text NOT NULL
);


ALTER TABLE public.clients OWNER TO postgres;

--
-- Name: doctors; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE doctors (
    id integer NOT NULL,
    name text NOT NULL,
    lastname text NOT NULL,
    prof text NOT NULL
);


ALTER TABLE public.doctors OWNER TO postgres;

--
-- Name: main; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE main (
    id integer NOT NULL,
    id_doctors integer NOT NULL,
    id_clients integer NOT NULL
);


ALTER TABLE public.main OWNER TO postgres;

--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clients (id, name, lastname, illness) FROM stdin;
1	Serine	Petrosyan	fever
2	Karine	Papanyan	headache
3	Valod	Karinyan	stomachache
4	Seroj	Saqanyan	tootache
\.


--
-- Data for Name: doctors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY doctors (id, name, lastname, prof) FROM stdin;
1	Aren	Norekyan	dentist
2	Karen	Simonyan	dentist
3	Armen	Galoyan	urolog
4	Mariam	Simonya	ginekolog
5	Mariam	Petrosyan	travmatolog
\.


--
-- Data for Name: main; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY main (id, id_doctors, id_clients) FROM stdin;
1	2	3
2	2	4
3	3	4
\.


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: doctors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (id);


--
-- Name: main_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY main
    ADD CONSTRAINT main_pkey PRIMARY KEY (id);


--
-- Name: main_id_clients_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY main
    ADD CONSTRAINT main_id_clients_fkey FOREIGN KEY (id_clients) REFERENCES clients(id);


--
-- Name: main_id_doctors_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY main
    ADD CONSTRAINT main_id_doctors_fkey FOREIGN KEY (id_doctors) REFERENCES doctors(id);


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


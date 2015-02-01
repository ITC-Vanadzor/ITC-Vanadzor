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
-- Name: hardware; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE hardware (
    id integer NOT NULL,
    mainboard text NOT NULL,
    ram integer NOT NULL,
    cpu text NOT NULL,
    hdd text NOT NULL,
    monitor integer NOT NULL,
    ups text
);


ALTER TABLE public.hardware OWNER TO postgres;

--
-- Data for Name: hardware; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY hardware (id, mainboard, ram, cpu, hdd, monitor, ups) FROM stdin;
4	Asus	2	i3	500gb	19	foxcorn
3	fox	4	i5	1000gb	21	AXC
2	MSI	8	i7	2000gb	23	KHG
1	Asrock	16	G33220	4000gb	25	kjgG
\.


--
-- Name: hardware_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hardware
    ADD CONSTRAINT hardware_pkey PRIMARY KEY (id);


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


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
-- Name: accessories; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE accessories (
    id integer,
    monitor text NOT NULL,
    cd_rom text NOT NULL,
    keyboard text NOT NULL,
    ups text NOT NULL
);


ALTER TABLE public.accessories OWNER TO postgres;

--
-- Name: computer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE computer (
    id integer,
    mainboard text NOT NULL,
    ram integer NOT NULL,
    cpu text NOT NULL,
    hdd integer NOT NULL
);


ALTER TABLE public.computer OWNER TO postgres;

--
-- Name: owner; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE owner (
    id integer NOT NULL,
    name text NOT NULL,
    surname text NOT NULL,
    project text
);


ALTER TABLE public.owner OWNER TO postgres;

--
-- Data for Name: accessories; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY accessories (id, monitor, cd_rom, keyboard, ups) FROM stdin;
1	Philips_22	LG	Genius_KB	APC_250
2	Philips_19	Asus	Genius_KB	APC_350
3	LG_19	Asus	Genius_KB	no
4	LG_21	Liteon	Genius_KB	no
5	LG_21	Samsung	Genius_KB	no
5	Samsung_22	Samsung	Genius_KB	no
6	Samsung_22	Liteon	Genius_KB	no
7	Samsung_20	Pioneer	Genius_KB	no
8	Toshiba_20	Pioneer	Genius_KB	no
9	Toshiba_20	Pioneer	Genius_KB	PowerCorn
10	Philips_20	LG	Genius_KB	no
\.


--
-- Data for Name: computer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY computer (id, mainboard, ram, cpu, hdd) FROM stdin;
1	Asus	4	i3	500
2	Asrock	4	AMD FX-4100	1000
3	MSI	3	AMD FX-8320	500
4	Gigabyte	2	i5	2000
5	Asus	8	i7	2000
5	Asrock	4	Intel pentium	1000
6	MSI	4	Intel pentium	1000
7	MSI	4	Intel pentium	500
8	Asus	2	AMD FX-4100	500
9	Asus	4	AMD FX-4100	1000
10	Asus	4	AMD FX-4100	1000
\.


--
-- Data for Name: owner; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY owner (id, name, surname, project) FROM stdin;
1	Stepan	Chaparyan	Manager
2	Areg	Gareginyan	Disney
3	Anjela	Andreasyan	Disney
4	Mane	Hambardzumyan	Disney
5	Nane	Hambardzumyan	Disney
6	Ani	Papyan	Disney
7	Hasmik	Naslyan	Disney
8	Hasmik	Dabaghyan	Disney
9	Arus	Hakobyan	Dacuda
10	Gayane	Nerkararyan	Dacuda
\.


--
-- Name: owner_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY owner
    ADD CONSTRAINT owner_pkey PRIMARY KEY (id);


--
-- Name: accessories_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY accessories
    ADD CONSTRAINT accessories_id_fkey FOREIGN KEY (id) REFERENCES owner(id);


--
-- Name: computer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY computer
    ADD CONSTRAINT computer_id_fkey FOREIGN KEY (id) REFERENCES owner(id);


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


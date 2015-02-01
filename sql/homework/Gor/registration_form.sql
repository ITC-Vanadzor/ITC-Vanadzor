--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- Data for Name: user_personal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_personal (user_id, name, surname, email) FROM stdin;
\.


--
-- Data for Name: user_information; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_information (user_id, birt_date, age, gender) FROM stdin;
\.


--
-- Name: user_information_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_information_user_id_seq', 1, false);


--
-- Data for Name: user_password; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_password (user_id, password) FROM stdin;
\.


--
-- Name: user_password_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_password_user_id_seq', 1, false);


--
-- Name: user_personal_equip_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_personal_equip_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--


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
-- Name: status; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE status AS ENUM (
    'yes',
    'no'
);


ALTER TYPE public.status OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: delivery; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE delivery (
    id integer NOT NULL,
    login_id smallint NOT NULL,
    place_id smallint NOT NULL,
    date date NOT NULL
);


ALTER TABLE public.delivery OWNER TO postgres;

--
-- Name: delivery_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE delivery_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.delivery_id_seq OWNER TO postgres;

--
-- Name: delivery_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE delivery_id_seq OWNED BY delivery.id;


--
-- Name: login; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE login (
    id integer NOT NULL,
    email character varying(20) NOT NULL,
    password character varying(20) NOT NULL,
    username character varying(20)
);


ALTER TABLE public.login OWNER TO postgres;

--
-- Name: login_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE login_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.login_id_seq OWNER TO postgres;

--
-- Name: login_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE login_id_seq OWNED BY login.id;


--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE orders (
    id integer NOT NULL,
    login_id smallint NOT NULL,
    unique_product_id smallint NOT NULL,
    count integer NOT NULL,
    date timestamp without time zone NOT NULL,
    status status NOT NULL,
    CONSTRAINT orders_count_check CHECK ((count > 0))
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_id_seq OWNER TO postgres;

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE orders_id_seq OWNED BY orders.id;


--
-- Name: place; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE place (
    id integer NOT NULL,
    place_name character varying(20) NOT NULL
);


ALTER TABLE public.place OWNER TO postgres;

--
-- Name: place_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE place_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.place_id_seq OWNER TO postgres;

--
-- Name: place_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE place_id_seq OWNED BY place.id;


--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE products (
    id integer NOT NULL,
    products_name character varying(30)
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE products_id_seq OWNED BY products.id;


--
-- Name: productsbyplaces; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE productsbyplaces (
    id integer NOT NULL,
    place_id smallint NOT NULL,
    products_id smallint NOT NULL
);


ALTER TABLE public.productsbyplaces OWNER TO postgres;

--
-- Name: productsbyplaces_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE productsbyplaces_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.productsbyplaces_id_seq OWNER TO postgres;

--
-- Name: productsbyplaces_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE productsbyplaces_id_seq OWNED BY productsbyplaces.id;


--
-- Name: session; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE session (
    session_id integer NOT NULL,
    login_id integer NOT NULL
);


ALTER TABLE public.session OWNER TO postgres;

--
-- Name: session_session_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE session_session_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.session_session_id_seq OWNER TO postgres;

--
-- Name: session_session_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE session_session_id_seq OWNED BY session.session_id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY delivery ALTER COLUMN id SET DEFAULT nextval('delivery_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY login ALTER COLUMN id SET DEFAULT nextval('login_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders ALTER COLUMN id SET DEFAULT nextval('orders_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY place ALTER COLUMN id SET DEFAULT nextval('place_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products ALTER COLUMN id SET DEFAULT nextval('products_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY productsbyplaces ALTER COLUMN id SET DEFAULT nextval('productsbyplaces_id_seq'::regclass);


--
-- Name: session_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY session ALTER COLUMN session_id SET DEFAULT nextval('session_session_id_seq'::regclass);


--
-- Data for Name: delivery; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY delivery (id, login_id, place_id, date) FROM stdin;
1	5	1	2015-03-12
2	2	2	2015-03-04
3	8	1	2015-01-28
4	2	2	2015-03-04
5	8	1	2015-02-12
6	7	2	2015-03-15
7	7	1	2015-01-18
10	4	6	2015-04-01
11	3	5	2015-04-01
12	2	3	2015-04-03
13	6	4	2015-04-03
14	2	2	2015-04-03
15	5	1	2015-04-03
\.


--
-- Name: delivery_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('delivery_id_seq', 15, true);


--
-- Data for Name: login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY login (id, email, password, username) FROM stdin;
2	vahan@itc.com	vahan	Vahan
3	karen@itc.com	karen	Karen
1	marine@itc.com	marine	Marine
4	hrach@itc.com	hrach	Hrach
5	movses@itc.com	movses	Movses
7	stepan@itc.com	stepan	Stepan
6	sargis@itc.com	sargis	Sargis
8	eduard@itc.com	eduard	Eduard
\.


--
-- Name: login_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('login_id_seq', 8, true);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY orders (id, login_id, unique_product_id, count, date, status) FROM stdin;
13	1	2	5	2015-03-13 00:00:00	no
14	8	2	14	2014-03-13 00:00:00	no
15	7	1	4	2014-03-13 00:00:00	no
16	7	2	4	2014-03-13 00:00:00	yes
26	5	6	5	2015-03-01 00:00:00	yes
30	3	6	5	2015-04-01 00:00:00	yes
32	3	5	5	2015-04-01 00:00:00	yes
33	3	5	3	2015-04-01 00:00:00	yes
34	6	5	3	2015-04-01 00:00:00	yes
35	6	6	5	2015-04-01 00:00:00	yes
36	6	6	5	2015-04-01 00:00:00	yes
37	3	2	5	2015-04-01 00:00:00	yes
39	3	5	5	2015-04-01 00:00:00	yes
43	6	5	3	2015-04-03 00:00:00	yes
44	1	1	5	2015-04-03 00:00:00	yes
45	3	1	1	2015-04-03 00:00:00	yes
46	6	6	1	2015-04-03 00:00:00	yes
\.


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('orders_id_seq', 46, true);


--
-- Data for Name: place; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY place (id, place_name) FROM stdin;
1	Tashir
2	Smile
3	Lav Tex
4	Hamov Patar
5	Tutto Pizza
6	Bistro
\.


--
-- Name: place_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('place_id_seq', 6, true);


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY products (id, products_name) FROM stdin;
1	pizza
2	qyabab
3	ttvaser
5	xrovac
6	shaurma
7	lahmajo
8	fri
9	sendvich
10	coca-cola
11	fanta
12	sprite
13	tan
14	jermuk
4	katlet
15	dzuk ishxan
16	dzuk siga
17	dzuk asetrina
18	tan aparani
19	hac qari
20	hac hrazdan
21	hac buxanka
22	lavash
23	lavash aparani
24	katlet kievski
\.


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('products_id_seq', 24, true);


--
-- Data for Name: productsbyplaces; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY productsbyplaces (id, place_id, products_id) FROM stdin;
1	1	1
2	2	3
5	2	4
6	1	3
\.


--
-- Name: productsbyplaces_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('productsbyplaces_id_seq', 6, true);


--
-- Data for Name: session; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY session (session_id, login_id) FROM stdin;
2	3
25	5
38	8
40	7
41	6
\.


--
-- Name: session_session_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('session_session_id_seq', 43, true);


--
-- Name: delivery_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY delivery
    ADD CONSTRAINT delivery_pkey PRIMARY KEY (id);


--
-- Name: login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id);


--
-- Name: orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: place_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY place
    ADD CONSTRAINT place_pkey PRIMARY KEY (id);


--
-- Name: products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: productsbyplaces_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY productsbyplaces
    ADD CONSTRAINT productsbyplaces_pkey PRIMARY KEY (id);


--
-- Name: session_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY session
    ADD CONSTRAINT session_pkey PRIMARY KEY (session_id);


--
-- Name: delivery_login_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY delivery
    ADD CONSTRAINT delivery_login_id_fkey FOREIGN KEY (login_id) REFERENCES login(id);


--
-- Name: delivery_place_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY delivery
    ADD CONSTRAINT delivery_place_id_fkey FOREIGN KEY (place_id) REFERENCES place(id);


--
-- Name: orders_login_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_login_id_fkey FOREIGN KEY (login_id) REFERENCES login(id);


--
-- Name: orders_unique_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_unique_product_id_fkey FOREIGN KEY (unique_product_id) REFERENCES productsbyplaces(id);


--
-- Name: productsbyplaces_place_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY productsbyplaces
    ADD CONSTRAINT productsbyplaces_place_id_fkey FOREIGN KEY (place_id) REFERENCES place(id);


--
-- Name: productsbyplaces_products_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY productsbyplaces
    ADD CONSTRAINT productsbyplaces_products_id_fkey FOREIGN KEY (products_id) REFERENCES products(id);


--
-- Name: session_login_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY session
    ADD CONSTRAINT session_login_id_fkey FOREIGN KEY (login_id) REFERENCES login(id);


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


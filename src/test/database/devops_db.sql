--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

-- Started on 2024-03-30 10:27:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 210 (class 1259 OID 24578)
-- Name: pelicula; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pelicula (
    id bigint NOT NULL,
    descripcion character varying(255),
    fecha character varying(255),
    genero character varying(255),
    nombre character varying(255),
    valor integer
);


ALTER TABLE public.pelicula OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24577)
-- Name: pelicula_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pelicula_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pelicula_id_seq OWNER TO postgres;

--
-- TOC entry 3332 (class 0 OID 0)
-- Dependencies: 209
-- Name: pelicula_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pelicula_id_seq OWNED BY public.pelicula.id;


--
-- TOC entry 211 (class 1259 OID 24586)
-- Name: pelicula_tienda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pelicula_tienda (
    id_tienda bigint NOT NULL,
    id bigint NOT NULL
);


ALTER TABLE public.pelicula_tienda OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 24592)
-- Name: tienda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tienda (
    id_tienda bigint NOT NULL,
    cantidad_pelicula integer,
    ciudad character varying(255),
    direccion character varying(255),
    nombre_tienda character varying(255),
    numero_empleados integer
);


ALTER TABLE public.tienda OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 24591)
-- Name: tienda_id_tienda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tienda_id_tienda_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tienda_id_tienda_seq OWNER TO postgres;

--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 212
-- Name: tienda_id_tienda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tienda_id_tienda_seq OWNED BY public.tienda.id_tienda;


--
-- TOC entry 3173 (class 2604 OID 24581)
-- Name: pelicula id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula ALTER COLUMN id SET DEFAULT nextval('public.pelicula_id_seq'::regclass);


--
-- TOC entry 3174 (class 2604 OID 24595)
-- Name: tienda id_tienda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tienda ALTER COLUMN id_tienda SET DEFAULT nextval('public.tienda_id_tienda_seq'::regclass);


--
-- TOC entry 3323 (class 0 OID 24578)
-- Dependencies: 210
-- Data for Name: pelicula; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pelicula (id, descripcion, fecha, genero, nombre, valor) VALUES (1, 'Pelicula de robots', '2019', 'Ciencia ficcion', 'Transformers', 160);
INSERT INTO public.pelicula (id, descripcion, fecha, genero, nombre, valor) VALUES (2, 'Pelicula suspenso', '2019', 'Terror', 'it', 60);
INSERT INTO public.pelicula (id, descripcion, fecha, genero, nombre, valor) VALUES (3, 'Pelicula Espanto', '2009', 'Terror', 'Conjuro', 90);
INSERT INTO public.pelicula (id, descripcion, fecha, genero, nombre, valor) VALUES (4, 'Pelicula de solados en nigeria', '2000', 'Accion', 'Lagrimas del sol', 190);


--
-- TOC entry 3324 (class 0 OID 24586)
-- Dependencies: 211
-- Data for Name: pelicula_tienda; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (2, 1);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (3, 1);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (4, 1);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (5, 3);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (5, 1);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (5, 2);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (5, 4);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (3, 4);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (6, 2);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (6, 4);
INSERT INTO public.pelicula_tienda (id_tienda, id) VALUES (6, 3);


--
-- TOC entry 3326 (class 0 OID 24592)
-- Dependencies: 213
-- Data for Name: tienda; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tienda (id_tienda, cantidad_pelicula, ciudad, direccion, nombre_tienda, numero_empleados) VALUES (2, NULL, 'HUila', 'Cr 12 # 22-19', 'La loma', 4);
INSERT INTO public.tienda (id_tienda, cantidad_pelicula, ciudad, direccion, nombre_tienda, numero_empleados) VALUES (3, NULL, 'Medellin', 'Cr 98 # 11-21', 'Todito', 7);
INSERT INTO public.tienda (id_tienda, cantidad_pelicula, ciudad, direccion, nombre_tienda, numero_empleados) VALUES (5, NULL, 'Cali', 'Cr 32 # 22-21', 'El esquqinazo', 3);
INSERT INTO public.tienda (id_tienda, cantidad_pelicula, ciudad, direccion, nombre_tienda, numero_empleados) VALUES (4, 9, 'Cali', 'Cr 32 # 22-21', 'El esquqinazo', 3);
INSERT INTO public.tienda (id_tienda, cantidad_pelicula, ciudad, direccion, nombre_tienda, numero_empleados) VALUES (6, 2, 'popayan', 'Cr 12 # 212-21', 'El viafara', 3);


--
-- TOC entry 3334 (class 0 OID 0)
-- Dependencies: 209
-- Name: pelicula_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pelicula_id_seq', 4, true);


--
-- TOC entry 3335 (class 0 OID 0)
-- Dependencies: 212
-- Name: tienda_id_tienda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tienda_id_tienda_seq', 6, true);


--
-- TOC entry 3176 (class 2606 OID 24585)
-- Name: pelicula pelicula_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula
    ADD CONSTRAINT pelicula_pkey PRIMARY KEY (id);


--
-- TOC entry 3178 (class 2606 OID 24590)
-- Name: pelicula_tienda pelicula_tienda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula_tienda
    ADD CONSTRAINT pelicula_tienda_pkey PRIMARY KEY (id_tienda, id);


--
-- TOC entry 3180 (class 2606 OID 24599)
-- Name: tienda tienda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tienda
    ADD CONSTRAINT tienda_pkey PRIMARY KEY (id_tienda);


--
-- TOC entry 3182 (class 2606 OID 24605)
-- Name: pelicula_tienda fkpcxodeju2eo5bdgdmvunyueir; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula_tienda
    ADD CONSTRAINT fkpcxodeju2eo5bdgdmvunyueir FOREIGN KEY (id_tienda) REFERENCES public.tienda(id_tienda);


--
-- TOC entry 3181 (class 2606 OID 24600)
-- Name: pelicula_tienda fktlshwi0qekc59fv59a88ugkr0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula_tienda
    ADD CONSTRAINT fktlshwi0qekc59fv59a88ugkr0 FOREIGN KEY (id) REFERENCES public.pelicula(id);


-- Completed on 2024-03-30 10:27:28

--
-- PostgreSQL database dump complete
--


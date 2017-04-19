--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

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
-- Name: numbers; Type: TABLE; Schema: public; Owner: JamesHartanto
--

CREATE TABLE numbers (
    id integer NOT NULL,
    date date NOT NULL,
    value integer NOT NULL
);


ALTER TABLE numbers OWNER TO "JamesHartanto";

--
-- Name: stocks; Type: TABLE; Schema: public; Owner: JamesHartanto
--

CREATE TABLE stocks (
    id integer NOT NULL,
    name character varying(30) NOT NULL,
    symbol character varying(5) NOT NULL
);


ALTER TABLE stocks OWNER TO "JamesHartanto";

--
-- Name: stocks_id_seq; Type: SEQUENCE; Schema: public; Owner: JamesHartanto
--

CREATE SEQUENCE stocks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stocks_id_seq OWNER TO "JamesHartanto";

--
-- Name: stocks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: JamesHartanto
--

ALTER SEQUENCE stocks_id_seq OWNED BY stocks.id;


--
-- Name: stocks id; Type: DEFAULT; Schema: public; Owner: JamesHartanto
--

ALTER TABLE ONLY stocks ALTER COLUMN id SET DEFAULT nextval('stocks_id_seq'::regclass);


--
-- Data for Name: numbers; Type: TABLE DATA; Schema: public; Owner: JamesHartanto
--

COPY numbers (id, date, value) FROM stdin;
\.


--
-- Data for Name: stocks; Type: TABLE DATA; Schema: public; Owner: JamesHartanto
--

COPY stocks (id, name, symbol) FROM stdin;
\.


--
-- Name: stocks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: JamesHartanto
--

SELECT pg_catalog.setval('stocks_id_seq', 1, false);


--
-- Name: numbers numbers_pkey; Type: CONSTRAINT; Schema: public; Owner: JamesHartanto
--

ALTER TABLE ONLY numbers
    ADD CONSTRAINT numbers_pkey PRIMARY KEY (id);


--
-- Name: stocks stocks_pkey; Type: CONSTRAINT; Schema: public; Owner: JamesHartanto
--

ALTER TABLE ONLY stocks
    ADD CONSTRAINT stocks_pkey PRIMARY KEY (id);


--
-- Name: stocks_id_uindex; Type: INDEX; Schema: public; Owner: JamesHartanto
--

CREATE UNIQUE INDEX stocks_id_uindex ON stocks USING btree (id);


--
-- Name: stocks_name_uindex; Type: INDEX; Schema: public; Owner: JamesHartanto
--

CREATE UNIQUE INDEX stocks_name_uindex ON stocks USING btree (name);


--
-- Name: stocks_symbol_uindex; Type: INDEX; Schema: public; Owner: JamesHartanto
--

CREATE UNIQUE INDEX stocks_symbol_uindex ON stocks USING btree (symbol);


--
-- Name: numbers numbers_stocks_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: JamesHartanto
--

ALTER TABLE ONLY numbers
    ADD CONSTRAINT numbers_stocks_id_fk FOREIGN KEY (id) REFERENCES stocks(id);


--
-- PostgreSQL database dump complete
--


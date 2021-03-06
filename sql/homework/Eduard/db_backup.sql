PGDMP     
                    s            reg_form    9.3.6    9.3.5     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           1262    16398    reg_form    DATABASE     z   CREATE DATABASE reg_form WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
    DROP DATABASE reg_form;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    5            �           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    5            �            3079    11789    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    174            �            1259    16399    user_ids    SEQUENCE     j   CREATE SEQUENCE user_ids
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.user_ids;
       public       postgres    false    5            �            1259    16424    not_required    TABLE     �   CREATE TABLE not_required (
    n_r_id integer DEFAULT nextval('user_ids'::regclass) NOT NULL,
    id integer,
    day character(64),
    month character(64),
    year character(64),
    age character(64),
    gender character(64)
);
     DROP TABLE public.not_required;
       public         postgres    false    170    5            �            1259    16413 	   passwords    TABLE     �   CREATE TABLE passwords (
    pass_id integer DEFAULT nextval('user_ids'::regclass) NOT NULL,
    id integer,
    password character(64)
);
    DROP TABLE public.passwords;
       public         postgres    false    170    5            �            1259    16407    users    TABLE     �   CREATE TABLE users (
    id integer DEFAULT nextval('user_ids'::regclass) NOT NULL,
    name character(64),
    last_name character(64),
    email character(64)
);
    DROP TABLE public.users;
       public         postgres    false    170    5            �          0    16424    not_required 
   TABLE DATA               J   COPY not_required (n_r_id, id, day, month, year, age, gender) FROM stdin;
    public       postgres    false    173   �       �          0    16413 	   passwords 
   TABLE DATA               3   COPY passwords (pass_id, id, password) FROM stdin;
    public       postgres    false    172   �       �           0    0    user_ids    SEQUENCE SET     0   SELECT pg_catalog.setval('user_ids', 1, false);
            public       postgres    false    170            �          0    16407    users 
   TABLE DATA               4   COPY users (id, name, last_name, email) FROM stdin;
    public       postgres    false    171   �       U           2606    16429    not_required_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY not_required
    ADD CONSTRAINT not_required_pkey PRIMARY KEY (n_r_id);
 H   ALTER TABLE ONLY public.not_required DROP CONSTRAINT not_required_pkey;
       public         postgres    false    173    173            S           2606    16418    passwords_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY passwords
    ADD CONSTRAINT passwords_pkey PRIMARY KEY (pass_id);
 B   ALTER TABLE ONLY public.passwords DROP CONSTRAINT passwords_pkey;
       public         postgres    false    172    172            Q           2606    16412 
   users_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    171    171            W           2606    16430    not_required_id_fkey    FK CONSTRAINT     m   ALTER TABLE ONLY not_required
    ADD CONSTRAINT not_required_id_fkey FOREIGN KEY (id) REFERENCES users(id);
 K   ALTER TABLE ONLY public.not_required DROP CONSTRAINT not_required_id_fkey;
       public       postgres    false    173    1873    171            V           2606    16419    passwords_id_fkey    FK CONSTRAINT     g   ALTER TABLE ONLY passwords
    ADD CONSTRAINT passwords_id_fkey FOREIGN KEY (id) REFERENCES users(id);
 E   ALTER TABLE ONLY public.passwords DROP CONSTRAINT passwords_id_fkey;
       public       postgres    false    1873    171    172            �      x������ � �      �      x������ � �      �      x������ � �     
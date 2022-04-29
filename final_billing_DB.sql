PGDMP             
            z           billing_project    14.2    14.2 4    /           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            0           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            1           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            2           1262    16394    billing_project    DATABASE     t   CREATE DATABASE billing_project WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United Kingdom.1252';
    DROP DATABASE billing_project;
                postgres    false                        2615    16395    bscs    SCHEMA        CREATE SCHEMA bscs;
    DROP SCHEMA bscs;
                postgres    false                        2615    16396    rtx    SCHEMA        CREATE SCHEMA rtx;
    DROP SCHEMA rtx;
                postgres    false            3           0    0 
   SCHEMA rtx    COMMENT     3   COMMENT ON SCHEMA rtx IS 'standard public schema';
                   postgres    false    7            �            1259    16437 
   Rateplanes    TABLE     �  CREATE TABLE bscs."Rateplanes" (
    rateplane_id integer NOT NULL,
    commercial_name character varying NOT NULL,
    voice_service integer NOT NULL,
    cross_voice_service integer,
    data_service integer NOT NULL,
    sms_service integer NOT NULL,
    roaming_service integer,
    extra_mins integer NOT NULL,
    extra_sms integer NOT NULL,
    extra_data integer NOT NULL,
    extra_roaming integer NOT NULL,
    fee integer NOT NULL
);
    DROP TABLE bscs."Rateplanes";
       bscs         heap    postgres    false    5            �            1259    16440    Service_Package    TABLE     }   CREATE TABLE bscs."Service_Package" (
    service_id integer NOT NULL,
    quota bigint,
    "service_Type" text NOT NULL
);
 #   DROP TABLE bscs."Service_Package";
       bscs         heap    postgres    false    5            �            1259    16397    contract    TABLE     �   CREATE TABLE bscs.contract (
    contract_id integer NOT NULL,
    msisdn character varying(11) NOT NULL,
    rateplane_id integer NOT NULL,
    national_userid integer NOT NULL
);
    DROP TABLE bscs.contract;
       bscs         heap    postgres    false    5            �            1259    16400    users    TABLE     �   CREATE TABLE bscs.users (
    national_id integer NOT NULL,
    "User_name" character varying NOT NULL,
    age integer NOT NULL,
    address character varying,
    "e-mail" character varying[]
);
    DROP TABLE bscs.users;
       bscs         heap    postgres    false    5            �            1259    16409 
   Rateplanes    TABLE     �  CREATE TABLE rtx."Rateplanes" (
    id integer NOT NULL,
    commercial_name character varying NOT NULL,
    voice_service integer NOT NULL,
    cross_voice_service integer,
    data_service integer NOT NULL,
    sms_service integer NOT NULL,
    roaming_service integer,
    extra_mins integer NOT NULL,
    extra_sms integer NOT NULL,
    extra_data integer NOT NULL,
    extra_roaming integer NOT NULL,
    fee integer NOT NULL
);
    DROP TABLE rtx."Rateplanes";
       rtx         heap    postgres    false    7            �            1259    16405 	   cdrs_info    TABLE     X  CREATE TABLE rtx.cdrs_info (
    cdr_id integer NOT NULL,
    tx_msisdn character varying(11) NOT NULL,
    rx_msisdn character varying(11) NOT NULL,
    "time-stamp" timestamp without time zone NOT NULL,
    durations integer NOT NULL,
    rates integer NOT NULL,
    servicepackages_id integer NOT NULL,
    rateplanes_id integer NOT NULL
);
    DROP TABLE rtx.cdrs_info;
       rtx         heap    postgres    false    7            �            1259    16408    consumption_id_seq    SEQUENCE     �   CREATE SEQUENCE rtx.consumption_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE rtx.consumption_id_seq;
       rtx          postgres    false    7    213            4           0    0    consumption_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE rtx.consumption_id_seq OWNED BY rtx.cdrs_info.cdr_id;
          rtx          postgres    false    214            �            1259    16446    Service_package    TABLE     �   CREATE TABLE rtx."Service_package" (
    service_id integer DEFAULT nextval('rtx.consumption_id_seq'::regclass) NOT NULL,
    quota bigint NOT NULL,
    "service_Type" text NOT NULL
);
 "   DROP TABLE rtx."Service_package";
       rtx         heap    postgres    false    214    7            �            1259    16414    rateplanes_id_seq    SEQUENCE     �   CREATE SEQUENCE rtx.rateplanes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE rtx.rateplanes_id_seq;
       rtx          postgres    false    7    215            5           0    0    rateplanes_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE rtx.rateplanes_id_seq OWNED BY rtx."Rateplanes".id;
          rtx          postgres    false    216            x           2604    16416    Rateplanes id    DEFAULT     j   ALTER TABLE ONLY rtx."Rateplanes" ALTER COLUMN id SET DEFAULT nextval('rtx.rateplanes_id_seq'::regclass);
 ;   ALTER TABLE rtx."Rateplanes" ALTER COLUMN id DROP DEFAULT;
       rtx          postgres    false    216    215            w           2604    16415    cdrs_info cdr_id    DEFAULT     l   ALTER TABLE ONLY rtx.cdrs_info ALTER COLUMN cdr_id SET DEFAULT nextval('rtx.consumption_id_seq'::regclass);
 <   ALTER TABLE rtx.cdrs_info ALTER COLUMN cdr_id DROP DEFAULT;
       rtx          postgres    false    214    213            *          0    16437 
   Rateplanes 
   TABLE DATA           �   COPY bscs."Rateplanes" (rateplane_id, commercial_name, voice_service, cross_voice_service, data_service, sms_service, roaming_service, extra_mins, extra_sms, extra_data, extra_roaming, fee) FROM stdin;
    bscs          postgres    false    217   �@       +          0    16440    Service_Package 
   TABLE DATA           L   COPY bscs."Service_Package" (service_id, quota, "service_Type") FROM stdin;
    bscs          postgres    false    218   A       $          0    16397    contract 
   TABLE DATA           T   COPY bscs.contract (contract_id, msisdn, rateplane_id, national_userid) FROM stdin;
    bscs          postgres    false    211   (A       %          0    16400    users 
   TABLE DATA           O   COPY bscs.users (national_id, "User_name", age, address, "e-mail") FROM stdin;
    bscs          postgres    false    212   EA       (          0    16409 
   Rateplanes 
   TABLE DATA           �   COPY rtx."Rateplanes" (id, commercial_name, voice_service, cross_voice_service, data_service, sms_service, roaming_service, extra_mins, extra_sms, extra_data, extra_roaming, fee) FROM stdin;
    rtx          postgres    false    215   bA       ,          0    16446    Service_package 
   TABLE DATA           K   COPY rtx."Service_package" (service_id, quota, "service_Type") FROM stdin;
    rtx          postgres    false    219   A       &          0    16405 	   cdrs_info 
   TABLE DATA           �   COPY rtx.cdrs_info (cdr_id, tx_msisdn, rx_msisdn, "time-stamp", durations, rates, servicepackages_id, rateplanes_id) FROM stdin;
    rtx          postgres    false    213   �A       6           0    0    consumption_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('rtx.consumption_id_seq', 1, false);
          rtx          postgres    false    214            7           0    0    rateplanes_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('rtx.rateplanes_id_seq', 1, false);
          rtx          postgres    false    216            �           2606    16467    Rateplanes Rateplane_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY bscs."Rateplanes"
    ADD CONSTRAINT "Rateplane_pkey" PRIMARY KEY (rateplane_id);
 E   ALTER TABLE ONLY bscs."Rateplanes" DROP CONSTRAINT "Rateplane_pkey";
       bscs            postgres    false    217            �           2606    16469 $   Service_Package Service_Package_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY bscs."Service_Package"
    ADD CONSTRAINT "Service_Package_pkey" PRIMARY KEY (service_id);
 P   ALTER TABLE ONLY bscs."Service_Package" DROP CONSTRAINT "Service_Package_pkey";
       bscs            postgres    false    218            {           2606    16418    contract contract_msisdn_key 
   CONSTRAINT     W   ALTER TABLE ONLY bscs.contract
    ADD CONSTRAINT contract_msisdn_key UNIQUE (msisdn);
 D   ALTER TABLE ONLY bscs.contract DROP CONSTRAINT contract_msisdn_key;
       bscs            postgres    false    211            }           2606    16420    contract contract_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY bscs.contract
    ADD CONSTRAINT contract_pkey PRIMARY KEY (contract_id);
 >   ALTER TABLE ONLY bscs.contract DROP CONSTRAINT contract_pkey;
       bscs            postgres    false    211                       2606    16422    users users_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY bscs.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (national_id);
 8   ALTER TABLE ONLY bscs.users DROP CONSTRAINT users_pkey;
       bscs            postgres    false    212            �           2606    16465 $   Service_package Service_package_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY rtx."Service_package"
    ADD CONSTRAINT "Service_package_pkey" PRIMARY KEY (service_id);
 O   ALTER TABLE ONLY rtx."Service_package" DROP CONSTRAINT "Service_package_pkey";
       rtx            postgres    false    219            �           2606    16424    cdrs_info consumption_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY rtx.cdrs_info
    ADD CONSTRAINT consumption_pkey PRIMARY KEY (cdr_id);
 A   ALTER TABLE ONLY rtx.cdrs_info DROP CONSTRAINT consumption_pkey;
       rtx            postgres    false    213            �           2606    16426    Rateplanes rateplanes_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY rtx."Rateplanes"
    ADD CONSTRAINT rateplanes_pkey PRIMARY KEY (id);
 C   ALTER TABLE ONLY rtx."Rateplanes" DROP CONSTRAINT rateplanes_pkey;
       rtx            postgres    false    215            �           2606    16427 #   contract contract_rateplane_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY bscs.contract
    ADD CONSTRAINT contract_rateplane_id_fkey FOREIGN KEY (rateplane_id) REFERENCES rtx."Rateplanes"(id);
 K   ALTER TABLE ONLY bscs.contract DROP CONSTRAINT contract_rateplane_id_fkey;
       bscs          postgres    false    215    211    3203            �           2606    16525    contract fk_rateplaneid    FK CONSTRAINT     �   ALTER TABLE ONLY bscs.contract
    ADD CONSTRAINT fk_rateplaneid FOREIGN KEY (rateplane_id) REFERENCES bscs."Rateplanes"(rateplane_id);
 ?   ALTER TABLE ONLY bscs.contract DROP CONSTRAINT fk_rateplaneid;
       bscs          postgres    false    217    211    3205            �           2606    16520    contract fk_userid    FK CONSTRAINT     ~   ALTER TABLE ONLY bscs.contract
    ADD CONSTRAINT fk_userid FOREIGN KEY (national_userid) REFERENCES bscs.users(national_id);
 :   ALTER TABLE ONLY bscs.contract DROP CONSTRAINT fk_userid;
       bscs          postgres    false    211    212    3199            �           2606    16475    Rateplanes sp_fk_crossvoice    FK CONSTRAINT     �   ALTER TABLE ONLY bscs."Rateplanes"
    ADD CONSTRAINT sp_fk_crossvoice FOREIGN KEY (cross_voice_service) REFERENCES bscs."Service_Package"(service_id);
 E   ALTER TABLE ONLY bscs."Rateplanes" DROP CONSTRAINT sp_fk_crossvoice;
       bscs          postgres    false    217    218    3207            �           2606    16490    Rateplanes sp_fk_da    FK CONSTRAINT     �   ALTER TABLE ONLY bscs."Rateplanes"
    ADD CONSTRAINT sp_fk_da FOREIGN KEY (data_service) REFERENCES bscs."Service_Package"(service_id);
 =   ALTER TABLE ONLY bscs."Rateplanes" DROP CONSTRAINT sp_fk_da;
       bscs          postgres    false    3207    217    218            �           2606    16485    Rateplanes sp_fk_roaming    FK CONSTRAINT     �   ALTER TABLE ONLY bscs."Rateplanes"
    ADD CONSTRAINT sp_fk_roaming FOREIGN KEY (roaming_service) REFERENCES bscs."Service_Package"(service_id);
 B   ALTER TABLE ONLY bscs."Rateplanes" DROP CONSTRAINT sp_fk_roaming;
       bscs          postgres    false    217    3207    218            �           2606    16480    Rateplanes sp_fk_sms    FK CONSTRAINT     �   ALTER TABLE ONLY bscs."Rateplanes"
    ADD CONSTRAINT sp_fk_sms FOREIGN KEY (sms_service) REFERENCES bscs."Service_Package"(service_id);
 >   ALTER TABLE ONLY bscs."Rateplanes" DROP CONSTRAINT sp_fk_sms;
       bscs          postgres    false    218    3207    217            �           2606    16470    Rateplanes sp_fk_voice    FK CONSTRAINT     �   ALTER TABLE ONLY bscs."Rateplanes"
    ADD CONSTRAINT sp_fk_voice FOREIGN KEY (voice_service) REFERENCES bscs."Service_Package"(service_id);
 @   ALTER TABLE ONLY bscs."Rateplanes" DROP CONSTRAINT sp_fk_voice;
       bscs          postgres    false    3207    217    218            �           2606    16530    cdrs_info fk_rateplaneid    FK CONSTRAINT     ~   ALTER TABLE ONLY rtx.cdrs_info
    ADD CONSTRAINT fk_rateplaneid FOREIGN KEY (rateplanes_id) REFERENCES rtx."Rateplanes"(id);
 ?   ALTER TABLE ONLY rtx.cdrs_info DROP CONSTRAINT fk_rateplaneid;
       rtx          postgres    false    213    3203    215            �           2606    16535    cdrs_info fk_sp    FK CONSTRAINT     �   ALTER TABLE ONLY rtx.cdrs_info
    ADD CONSTRAINT fk_sp FOREIGN KEY (servicepackages_id) REFERENCES rtx."Service_package"(service_id);
 6   ALTER TABLE ONLY rtx.cdrs_info DROP CONSTRAINT fk_sp;
       rtx          postgres    false    219    3209    213            �           2606    16515    Rateplanes sp_fk_crossvoice    FK CONSTRAINT     �   ALTER TABLE ONLY rtx."Rateplanes"
    ADD CONSTRAINT sp_fk_crossvoice FOREIGN KEY (cross_voice_service) REFERENCES rtx."Service_package"(service_id);
 D   ALTER TABLE ONLY rtx."Rateplanes" DROP CONSTRAINT sp_fk_crossvoice;
       rtx          postgres    false    219    3209    215            �           2606    16495    Rateplanes sp_fk_data    FK CONSTRAINT     �   ALTER TABLE ONLY rtx."Rateplanes"
    ADD CONSTRAINT sp_fk_data FOREIGN KEY (data_service) REFERENCES rtx."Service_package"(service_id);
 >   ALTER TABLE ONLY rtx."Rateplanes" DROP CONSTRAINT sp_fk_data;
       rtx          postgres    false    215    3209    219            �           2606    16505    Rateplanes sp_fk_roaming    FK CONSTRAINT     �   ALTER TABLE ONLY rtx."Rateplanes"
    ADD CONSTRAINT sp_fk_roaming FOREIGN KEY (roaming_service) REFERENCES rtx."Service_package"(service_id);
 A   ALTER TABLE ONLY rtx."Rateplanes" DROP CONSTRAINT sp_fk_roaming;
       rtx          postgres    false    3209    219    215            �           2606    16500    Rateplanes sp_fk_sms    FK CONSTRAINT     �   ALTER TABLE ONLY rtx."Rateplanes"
    ADD CONSTRAINT sp_fk_sms FOREIGN KEY (sms_service) REFERENCES rtx."Service_package"(service_id);
 =   ALTER TABLE ONLY rtx."Rateplanes" DROP CONSTRAINT sp_fk_sms;
       rtx          postgres    false    219    3209    215            �           2606    16510    Rateplanes sp_fk_voice    FK CONSTRAINT     �   ALTER TABLE ONLY rtx."Rateplanes"
    ADD CONSTRAINT sp_fk_voice FOREIGN KEY (voice_service) REFERENCES rtx."Service_package"(service_id);
 ?   ALTER TABLE ONLY rtx."Rateplanes" DROP CONSTRAINT sp_fk_voice;
       rtx          postgres    false    3209    219    215            *      x������ � �      +      x������ � �      $      x������ � �      %      x������ � �      (      x������ � �      ,      x������ � �      &      x������ � �     
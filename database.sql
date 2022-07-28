PGDMP                         z           instaclass_db_2    14.4    14.4 �    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17887    instaclass_db_2    DATABASE     k   CREATE DATABASE instaclass_db_2 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE instaclass_db_2;
                postgres    false                        2615    17888    schema_classe    SCHEMA        CREATE SCHEMA schema_classe;
    DROP SCHEMA schema_classe;
                postgres    false            �           0    0    SCHEMA schema_classe    COMMENT     =   COMMENT ON SCHEMA schema_classe IS 'standard public schema';
                   postgres    false    6                        2615    17889    schema_istituto    SCHEMA        CREATE SCHEMA schema_istituto;
    DROP SCHEMA schema_istituto;
                postgres    false            �            1259    17890 	   calendari    TABLE     �   CREATE TABLE schema_classe.calendari (
    id_calendario integer NOT NULL,
    data_evento date NOT NULL,
    nome_evento character varying(255) NOT NULL,
    fk_classe integer NOT NULL
);
 $   DROP TABLE schema_classe.calendari;
       schema_classe         heap    postgres    false    6            �            1259    17893    calendari_id_calendario_seq    SEQUENCE     �   CREATE SEQUENCE schema_classe.calendari_id_calendario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE schema_classe.calendari_id_calendario_seq;
       schema_classe          postgres    false    6    211            �           0    0    calendari_id_calendario_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE schema_classe.calendari_id_calendario_seq OWNED BY schema_classe.calendari.id_calendario;
          schema_classe          postgres    false    212            �            1259    17894    classi    TABLE     �   CREATE TABLE schema_classe.classi (
    id_classe integer NOT NULL,
    nome_classe character varying(100) NOT NULL,
    fk_istituto integer NOT NULL
);
 !   DROP TABLE schema_classe.classi;
       schema_classe         heap    postgres    false    6            �            1259    18098    classi_docenti    TABLE     �   CREATE TABLE schema_classe.classi_docenti (
    id_classe_docente integer NOT NULL,
    docente_fk integer,
    classe_fk integer
);
 )   DROP TABLE schema_classe.classi_docenti;
       schema_classe         heap    postgres    false    6            �            1259    18097 $   classi_docenti_id_classe_docente_seq    SEQUENCE     �   CREATE SEQUENCE schema_classe.classi_docenti_id_classe_docente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 B   DROP SEQUENCE schema_classe.classi_docenti_id_classe_docente_seq;
       schema_classe          postgres    false    240    6            �           0    0 $   classi_docenti_id_classe_docente_seq    SEQUENCE OWNED BY     {   ALTER SEQUENCE schema_classe.classi_docenti_id_classe_docente_seq OWNED BY schema_classe.classi_docenti.id_classe_docente;
          schema_classe          postgres    false    239            �            1259    17897    classi_id_classe_seq    SEQUENCE     �   CREATE SEQUENCE schema_classe.classi_id_classe_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE schema_classe.classi_id_classe_seq;
       schema_classe          postgres    false    6    213            �           0    0    classi_id_classe_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE schema_classe.classi_id_classe_seq OWNED BY schema_classe.classi.id_classe;
          schema_classe          postgres    false    214            �            1259    18086    classi_studenti    TABLE     �   CREATE TABLE schema_classe.classi_studenti (
    id_classe_studente integer NOT NULL,
    studente_fk integer,
    classe_fk integer
);
 *   DROP TABLE schema_classe.classi_studenti;
       schema_classe         heap    postgres    false    6            �            1259    18085 &   classi_studenti_id_classe_studente_seq    SEQUENCE     �   CREATE SEQUENCE schema_classe.classi_studenti_id_classe_studente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 D   DROP SEQUENCE schema_classe.classi_studenti_id_classe_studente_seq;
       schema_classe          postgres    false    6    238            �           0    0 &   classi_studenti_id_classe_studente_seq    SEQUENCE OWNED BY        ALTER SEQUENCE schema_classe.classi_studenti_id_classe_studente_seq OWNED BY schema_classe.classi_studenti.id_classe_studente;
          schema_classe          postgres    false    237            �            1259    17898    compiti    TABLE     �   CREATE TABLE schema_classe.compiti (
    id_compito integer NOT NULL,
    data_consegna date NOT NULL,
    descrizione character varying(255) NOT NULL,
    fk_classe integer NOT NULL
);
 "   DROP TABLE schema_classe.compiti;
       schema_classe         heap    postgres    false    6            �            1259    17901    compiti_id_compito_seq    SEQUENCE     �   CREATE SEQUENCE schema_classe.compiti_id_compito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE schema_classe.compiti_id_compito_seq;
       schema_classe          postgres    false    6    215            �           0    0    compiti_id_compito_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE schema_classe.compiti_id_compito_seq OWNED BY schema_classe.compiti.id_compito;
          schema_classe          postgres    false    216            �            1259    17902    comunicazioni    TABLE     �   CREATE TABLE schema_classe.comunicazioni (
    id_comunicazione integer NOT NULL,
    data_comunicazione date NOT NULL,
    nome_comunicazione character varying(255) NOT NULL,
    descrizione_comunicazione text,
    fk_classe integer NOT NULL
);
 (   DROP TABLE schema_classe.comunicazioni;
       schema_classe         heap    postgres    false    6            �            1259    17907 "   comunicazioni_id_comunicazione_seq    SEQUENCE     �   CREATE SEQUENCE schema_classe.comunicazioni_id_comunicazione_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 @   DROP SEQUENCE schema_classe.comunicazioni_id_comunicazione_seq;
       schema_classe          postgres    false    6    217            �           0    0 "   comunicazioni_id_comunicazione_seq    SEQUENCE OWNED BY     w   ALTER SEQUENCE schema_classe.comunicazioni_id_comunicazione_seq OWNED BY schema_classe.comunicazioni.id_comunicazione;
          schema_classe          postgres    false    218            �            1259    17908    note    TABLE     �   CREATE TABLE schema_classe.note (
    id_nota integer NOT NULL,
    data_nota date NOT NULL,
    descrizione_nota text NOT NULL,
    cf_studente character varying(16),
    fk_classe integer NOT NULL
);
    DROP TABLE schema_classe.note;
       schema_classe         heap    postgres    false    6            �            1259    17913    note_id_nota_seq    SEQUENCE     �   CREATE SEQUENCE schema_classe.note_id_nota_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE schema_classe.note_id_nota_seq;
       schema_classe          postgres    false    219    6            �           0    0    note_id_nota_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE schema_classe.note_id_nota_seq OWNED BY schema_classe.note.id_nota;
          schema_classe          postgres    false    220            �            1259    17922    docenti    TABLE       CREATE TABLE schema_istituto.docenti (
    id_docente integer NOT NULL,
    codice_fiscale character(16) NOT NULL,
    nome_docente character varying(100) NOT NULL,
    cognome_docente character varying(100) NOT NULL,
    password_docente character varying(100) NOT NULL
);
 $   DROP TABLE schema_istituto.docenti;
       schema_istituto         heap    postgres    false    5            �            1259    17925    docenti_id_docente_seq    SEQUENCE     �   CREATE SEQUENCE schema_istituto.docenti_id_docente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE schema_istituto.docenti_id_docente_seq;
       schema_istituto          postgres    false    5    221            �           0    0    docenti_id_docente_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE schema_istituto.docenti_id_docente_seq OWNED BY schema_istituto.docenti.id_docente;
          schema_istituto          postgres    false    222            �            1259    17926    docenti_istituti    TABLE     u   CREATE TABLE schema_istituto.docenti_istituti (
    istituto_fk integer NOT NULL,
    docente_fk integer NOT NULL
);
 -   DROP TABLE schema_istituto.docenti_istituti;
       schema_istituto         heap    postgres    false    5            �            1259    17929    docenti_materie    TABLE     s   CREATE TABLE schema_istituto.docenti_materie (
    docente_fk integer NOT NULL,
    materia_fk integer NOT NULL
);
 ,   DROP TABLE schema_istituto.docenti_materie;
       schema_istituto         heap    postgres    false    5            �            1259    17932    istituti    TABLE     �   CREATE TABLE schema_istituto.istituti (
    id_istituto integer NOT NULL,
    nome_istituto character varying(100) NOT NULL,
    password_istituto character varying(50) NOT NULL
);
 %   DROP TABLE schema_istituto.istituti;
       schema_istituto         heap    postgres    false    5            �            1259    17935    istituti_materie    TABLE     u   CREATE TABLE schema_istituto.istituti_materie (
    istituto_fk integer NOT NULL,
    materia_fk integer NOT NULL
);
 -   DROP TABLE schema_istituto.istituti_materie;
       schema_istituto         heap    postgres    false    5            �            1259    17939    istituti_studenti    TABLE     w   CREATE TABLE schema_istituto.istituti_studenti (
    istituto_fk integer NOT NULL,
    studente_fk integer NOT NULL
);
 .   DROP TABLE schema_istituto.istituti_studenti;
       schema_istituto         heap    postgres    false    5            �            1259    17938    istituto_id_istituto_seq    SEQUENCE     �   CREATE SEQUENCE schema_istituto.istituto_id_istituto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE schema_istituto.istituto_id_istituto_seq;
       schema_istituto          postgres    false    5    225            �           0    0    istituto_id_istituto_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE schema_istituto.istituto_id_istituto_seq OWNED BY schema_istituto.istituti.id_istituto;
          schema_istituto          postgres    false    227            �            1259    17942    materie    TABLE     |   CREATE TABLE schema_istituto.materie (
    id_materia integer NOT NULL,
    nome_materia character varying(100) NOT NULL
);
 $   DROP TABLE schema_istituto.materie;
       schema_istituto         heap    postgres    false    5            �            1259    17945    materie_id_materia_seq    SEQUENCE     �   CREATE SEQUENCE schema_istituto.materie_id_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE schema_istituto.materie_id_materia_seq;
       schema_istituto          postgres    false    229    5            �           0    0    materie_id_materia_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE schema_istituto.materie_id_materia_seq OWNED BY schema_istituto.materie.id_materia;
          schema_istituto          postgres    false    230            �            1259    17946    presenze    TABLE     �   CREATE TABLE schema_istituto.presenze (
    id_presenza integer NOT NULL,
    data_giorno date NOT NULL,
    presente boolean NOT NULL,
    fk_studente integer NOT NULL
);
 %   DROP TABLE schema_istituto.presenze;
       schema_istituto         heap    postgres    false    5            �            1259    17949    presenze_id_presenza_seq    SEQUENCE     �   CREATE SEQUENCE schema_istituto.presenze_id_presenza_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE schema_istituto.presenze_id_presenza_seq;
       schema_istituto          postgres    false    231    5            �           0    0    presenze_id_presenza_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE schema_istituto.presenze_id_presenza_seq OWNED BY schema_istituto.presenze.id_presenza;
          schema_istituto          postgres    false    232            �            1259    17950    studenti    TABLE       CREATE TABLE schema_istituto.studenti (
    id_studente integer NOT NULL,
    codice_fiscale character(16) NOT NULL,
    nome_studente character varying(100) NOT NULL,
    cognome_studente character varying(100) NOT NULL,
    password_studente character varying(100) NOT NULL
);
 %   DROP TABLE schema_istituto.studenti;
       schema_istituto         heap    postgres    false    5            �            1259    17953    studenti_id_studente_seq    SEQUENCE     �   CREATE SEQUENCE schema_istituto.studenti_id_studente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE schema_istituto.studenti_id_studente_seq;
       schema_istituto          postgres    false    5    233            �           0    0    studenti_id_studente_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE schema_istituto.studenti_id_studente_seq OWNED BY schema_istituto.studenti.id_studente;
          schema_istituto          postgres    false    234            �            1259    17954    voti    TABLE     �   CREATE TABLE schema_istituto.voti (
    id_voto integer NOT NULL,
    punteggio integer NOT NULL,
    fk_studente integer NOT NULL,
    fk_materia integer NOT NULL
);
 !   DROP TABLE schema_istituto.voti;
       schema_istituto         heap    postgres    false    5            �            1259    17957    voti_id_voto_seq    SEQUENCE     �   CREATE SEQUENCE schema_istituto.voti_id_voto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE schema_istituto.voti_id_voto_seq;
       schema_istituto          postgres    false    5    235            �           0    0    voti_id_voto_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE schema_istituto.voti_id_voto_seq OWNED BY schema_istituto.voti.id_voto;
          schema_istituto          postgres    false    236            �           2604    17958    calendari id_calendario    DEFAULT     �   ALTER TABLE ONLY schema_classe.calendari ALTER COLUMN id_calendario SET DEFAULT nextval('schema_classe.calendari_id_calendario_seq'::regclass);
 M   ALTER TABLE schema_classe.calendari ALTER COLUMN id_calendario DROP DEFAULT;
       schema_classe          postgres    false    212    211            �           2604    17959    classi id_classe    DEFAULT     �   ALTER TABLE ONLY schema_classe.classi ALTER COLUMN id_classe SET DEFAULT nextval('schema_classe.classi_id_classe_seq'::regclass);
 F   ALTER TABLE schema_classe.classi ALTER COLUMN id_classe DROP DEFAULT;
       schema_classe          postgres    false    214    213            �           2604    18101     classi_docenti id_classe_docente    DEFAULT     �   ALTER TABLE ONLY schema_classe.classi_docenti ALTER COLUMN id_classe_docente SET DEFAULT nextval('schema_classe.classi_docenti_id_classe_docente_seq'::regclass);
 V   ALTER TABLE schema_classe.classi_docenti ALTER COLUMN id_classe_docente DROP DEFAULT;
       schema_classe          postgres    false    239    240    240            �           2604    18089 "   classi_studenti id_classe_studente    DEFAULT     �   ALTER TABLE ONLY schema_classe.classi_studenti ALTER COLUMN id_classe_studente SET DEFAULT nextval('schema_classe.classi_studenti_id_classe_studente_seq'::regclass);
 X   ALTER TABLE schema_classe.classi_studenti ALTER COLUMN id_classe_studente DROP DEFAULT;
       schema_classe          postgres    false    237    238    238            �           2604    17960    compiti id_compito    DEFAULT     �   ALTER TABLE ONLY schema_classe.compiti ALTER COLUMN id_compito SET DEFAULT nextval('schema_classe.compiti_id_compito_seq'::regclass);
 H   ALTER TABLE schema_classe.compiti ALTER COLUMN id_compito DROP DEFAULT;
       schema_classe          postgres    false    216    215            �           2604    17961    comunicazioni id_comunicazione    DEFAULT     �   ALTER TABLE ONLY schema_classe.comunicazioni ALTER COLUMN id_comunicazione SET DEFAULT nextval('schema_classe.comunicazioni_id_comunicazione_seq'::regclass);
 T   ALTER TABLE schema_classe.comunicazioni ALTER COLUMN id_comunicazione DROP DEFAULT;
       schema_classe          postgres    false    218    217            �           2604    17962    note id_nota    DEFAULT     z   ALTER TABLE ONLY schema_classe.note ALTER COLUMN id_nota SET DEFAULT nextval('schema_classe.note_id_nota_seq'::regclass);
 B   ALTER TABLE schema_classe.note ALTER COLUMN id_nota DROP DEFAULT;
       schema_classe          postgres    false    220    219            �           2604    17965    docenti id_docente    DEFAULT     �   ALTER TABLE ONLY schema_istituto.docenti ALTER COLUMN id_docente SET DEFAULT nextval('schema_istituto.docenti_id_docente_seq'::regclass);
 J   ALTER TABLE schema_istituto.docenti ALTER COLUMN id_docente DROP DEFAULT;
       schema_istituto          postgres    false    222    221            �           2604    17966    istituti id_istituto    DEFAULT     �   ALTER TABLE ONLY schema_istituto.istituti ALTER COLUMN id_istituto SET DEFAULT nextval('schema_istituto.istituto_id_istituto_seq'::regclass);
 L   ALTER TABLE schema_istituto.istituti ALTER COLUMN id_istituto DROP DEFAULT;
       schema_istituto          postgres    false    227    225            �           2604    17967    materie id_materia    DEFAULT     �   ALTER TABLE ONLY schema_istituto.materie ALTER COLUMN id_materia SET DEFAULT nextval('schema_istituto.materie_id_materia_seq'::regclass);
 J   ALTER TABLE schema_istituto.materie ALTER COLUMN id_materia DROP DEFAULT;
       schema_istituto          postgres    false    230    229            �           2604    17968    presenze id_presenza    DEFAULT     �   ALTER TABLE ONLY schema_istituto.presenze ALTER COLUMN id_presenza SET DEFAULT nextval('schema_istituto.presenze_id_presenza_seq'::regclass);
 L   ALTER TABLE schema_istituto.presenze ALTER COLUMN id_presenza DROP DEFAULT;
       schema_istituto          postgres    false    232    231            �           2604    17969    studenti id_studente    DEFAULT     �   ALTER TABLE ONLY schema_istituto.studenti ALTER COLUMN id_studente SET DEFAULT nextval('schema_istituto.studenti_id_studente_seq'::regclass);
 L   ALTER TABLE schema_istituto.studenti ALTER COLUMN id_studente DROP DEFAULT;
       schema_istituto          postgres    false    234    233            �           2604    17970    voti id_voto    DEFAULT     ~   ALTER TABLE ONLY schema_istituto.voti ALTER COLUMN id_voto SET DEFAULT nextval('schema_istituto.voti_id_voto_seq'::regclass);
 D   ALTER TABLE schema_istituto.voti ALTER COLUMN id_voto DROP DEFAULT;
       schema_istituto          postgres    false    236    235            y          0    17890 	   calendari 
   TABLE DATA           ^   COPY schema_classe.calendari (id_calendario, data_evento, nome_evento, fk_classe) FROM stdin;
    schema_classe          postgres    false    211   ��       {          0    17894    classi 
   TABLE DATA           L   COPY schema_classe.classi (id_classe, nome_classe, fk_istituto) FROM stdin;
    schema_classe          postgres    false    213   צ       �          0    18098    classi_docenti 
   TABLE DATA           Y   COPY schema_classe.classi_docenti (id_classe_docente, docente_fk, classe_fk) FROM stdin;
    schema_classe          postgres    false    240   ��       �          0    18086    classi_studenti 
   TABLE DATA           \   COPY schema_classe.classi_studenti (id_classe_studente, studente_fk, classe_fk) FROM stdin;
    schema_classe          postgres    false    238   �       }          0    17898    compiti 
   TABLE DATA           [   COPY schema_classe.compiti (id_compito, data_consegna, descrizione, fk_classe) FROM stdin;
    schema_classe          postgres    false    215   8�                 0    17902    comunicazioni 
   TABLE DATA           �   COPY schema_classe.comunicazioni (id_comunicazione, data_comunicazione, nome_comunicazione, descrizione_comunicazione, fk_classe) FROM stdin;
    schema_classe          postgres    false    217   U�       �          0    17908    note 
   TABLE DATA           c   COPY schema_classe.note (id_nota, data_nota, descrizione_nota, cf_studente, fk_classe) FROM stdin;
    schema_classe          postgres    false    219   r�       �          0    17922    docenti 
   TABLE DATA           w   COPY schema_istituto.docenti (id_docente, codice_fiscale, nome_docente, cognome_docente, password_docente) FROM stdin;
    schema_istituto          postgres    false    221   ��       �          0    17926    docenti_istituti 
   TABLE DATA           L   COPY schema_istituto.docenti_istituti (istituto_fk, docente_fk) FROM stdin;
    schema_istituto          postgres    false    223   ��       �          0    17929    docenti_materie 
   TABLE DATA           J   COPY schema_istituto.docenti_materie (docente_fk, materia_fk) FROM stdin;
    schema_istituto          postgres    false    224   ɧ       �          0    17932    istituti 
   TABLE DATA           Z   COPY schema_istituto.istituti (id_istituto, nome_istituto, password_istituto) FROM stdin;
    schema_istituto          postgres    false    225   �       �          0    17935    istituti_materie 
   TABLE DATA           L   COPY schema_istituto.istituti_materie (istituto_fk, materia_fk) FROM stdin;
    schema_istituto          postgres    false    226   �       �          0    17939    istituti_studenti 
   TABLE DATA           N   COPY schema_istituto.istituti_studenti (istituto_fk, studente_fk) FROM stdin;
    schema_istituto          postgres    false    228    �       �          0    17942    materie 
   TABLE DATA           D   COPY schema_istituto.materie (id_materia, nome_materia) FROM stdin;
    schema_istituto          postgres    false    229   =�       �          0    17946    presenze 
   TABLE DATA           \   COPY schema_istituto.presenze (id_presenza, data_giorno, presente, fk_studente) FROM stdin;
    schema_istituto          postgres    false    231   Z�       �          0    17950    studenti 
   TABLE DATA           |   COPY schema_istituto.studenti (id_studente, codice_fiscale, nome_studente, cognome_studente, password_studente) FROM stdin;
    schema_istituto          postgres    false    233   w�       �          0    17954    voti 
   TABLE DATA           T   COPY schema_istituto.voti (id_voto, punteggio, fk_studente, fk_materia) FROM stdin;
    schema_istituto          postgres    false    235   ��       �           0    0    calendari_id_calendario_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('schema_classe.calendari_id_calendario_seq', 1, false);
          schema_classe          postgres    false    212            �           0    0 $   classi_docenti_id_classe_docente_seq    SEQUENCE SET     Z   SELECT pg_catalog.setval('schema_classe.classi_docenti_id_classe_docente_seq', 1, false);
          schema_classe          postgres    false    239            �           0    0    classi_id_classe_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('schema_classe.classi_id_classe_seq', 1, true);
          schema_classe          postgres    false    214            �           0    0 &   classi_studenti_id_classe_studente_seq    SEQUENCE SET     \   SELECT pg_catalog.setval('schema_classe.classi_studenti_id_classe_studente_seq', 1, false);
          schema_classe          postgres    false    237            �           0    0    compiti_id_compito_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('schema_classe.compiti_id_compito_seq', 1, false);
          schema_classe          postgres    false    216            �           0    0 "   comunicazioni_id_comunicazione_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('schema_classe.comunicazioni_id_comunicazione_seq', 1, false);
          schema_classe          postgres    false    218            �           0    0    note_id_nota_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('schema_classe.note_id_nota_seq', 1, false);
          schema_classe          postgres    false    220            �           0    0    docenti_id_docente_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('schema_istituto.docenti_id_docente_seq', 1, false);
          schema_istituto          postgres    false    222            �           0    0    istituto_id_istituto_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('schema_istituto.istituto_id_istituto_seq', 1, false);
          schema_istituto          postgres    false    227            �           0    0    materie_id_materia_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('schema_istituto.materie_id_materia_seq', 1, false);
          schema_istituto          postgres    false    230            �           0    0    presenze_id_presenza_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('schema_istituto.presenze_id_presenza_seq', 1, false);
          schema_istituto          postgres    false    232            �           0    0    studenti_id_studente_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('schema_istituto.studenti_id_studente_seq', 1, false);
          schema_istituto          postgres    false    234            �           0    0    voti_id_voto_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('schema_istituto.voti_id_voto_seq', 1, false);
          schema_istituto          postgres    false    236            �           2606    17972    calendari calendari_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY schema_classe.calendari
    ADD CONSTRAINT calendari_pkey PRIMARY KEY (id_calendario);
 I   ALTER TABLE ONLY schema_classe.calendari DROP CONSTRAINT calendari_pkey;
       schema_classe            postgres    false    211            �           2606    18103 "   classi_docenti classi_docenti_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY schema_classe.classi_docenti
    ADD CONSTRAINT classi_docenti_pkey PRIMARY KEY (id_classe_docente);
 S   ALTER TABLE ONLY schema_classe.classi_docenti DROP CONSTRAINT classi_docenti_pkey;
       schema_classe            postgres    false    240            �           2606    17974    classi classi_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY schema_classe.classi
    ADD CONSTRAINT classi_pkey PRIMARY KEY (id_classe);
 C   ALTER TABLE ONLY schema_classe.classi DROP CONSTRAINT classi_pkey;
       schema_classe            postgres    false    213            �           2606    18091 $   classi_studenti classi_studenti_pkey 
   CONSTRAINT     y   ALTER TABLE ONLY schema_classe.classi_studenti
    ADD CONSTRAINT classi_studenti_pkey PRIMARY KEY (id_classe_studente);
 U   ALTER TABLE ONLY schema_classe.classi_studenti DROP CONSTRAINT classi_studenti_pkey;
       schema_classe            postgres    false    238            �           2606    17976    compiti compiti_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY schema_classe.compiti
    ADD CONSTRAINT compiti_pkey PRIMARY KEY (id_compito);
 E   ALTER TABLE ONLY schema_classe.compiti DROP CONSTRAINT compiti_pkey;
       schema_classe            postgres    false    215            �           2606    17978     comunicazioni comunicazioni_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY schema_classe.comunicazioni
    ADD CONSTRAINT comunicazioni_pkey PRIMARY KEY (id_comunicazione);
 Q   ALTER TABLE ONLY schema_classe.comunicazioni DROP CONSTRAINT comunicazioni_pkey;
       schema_classe            postgres    false    217            �           2606    17980    note note_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY schema_classe.note
    ADD CONSTRAINT note_pkey PRIMARY KEY (id_nota);
 ?   ALTER TABLE ONLY schema_classe.note DROP CONSTRAINT note_pkey;
       schema_classe            postgres    false    219            �           2606    17986 "   docenti docenti_codice_fiscale_key 
   CONSTRAINT     p   ALTER TABLE ONLY schema_istituto.docenti
    ADD CONSTRAINT docenti_codice_fiscale_key UNIQUE (codice_fiscale);
 U   ALTER TABLE ONLY schema_istituto.docenti DROP CONSTRAINT docenti_codice_fiscale_key;
       schema_istituto            postgres    false    221            �           2606    17988 &   docenti_istituti docenti_istituti_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.docenti_istituti
    ADD CONSTRAINT docenti_istituti_pkey PRIMARY KEY (istituto_fk, docente_fk);
 Y   ALTER TABLE ONLY schema_istituto.docenti_istituti DROP CONSTRAINT docenti_istituti_pkey;
       schema_istituto            postgres    false    223    223            �           2606    17990 $   docenti_materie docenti_materie_pkey 
   CONSTRAINT        ALTER TABLE ONLY schema_istituto.docenti_materie
    ADD CONSTRAINT docenti_materie_pkey PRIMARY KEY (docente_fk, materia_fk);
 W   ALTER TABLE ONLY schema_istituto.docenti_materie DROP CONSTRAINT docenti_materie_pkey;
       schema_istituto            postgres    false    224    224            �           2606    17992    docenti docenti_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY schema_istituto.docenti
    ADD CONSTRAINT docenti_pkey PRIMARY KEY (id_docente);
 G   ALTER TABLE ONLY schema_istituto.docenti DROP CONSTRAINT docenti_pkey;
       schema_istituto            postgres    false    221            �           2606    17994 &   istituti_materie istituti_materie_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.istituti_materie
    ADD CONSTRAINT istituti_materie_pkey PRIMARY KEY (istituto_fk, materia_fk);
 Y   ALTER TABLE ONLY schema_istituto.istituti_materie DROP CONSTRAINT istituti_materie_pkey;
       schema_istituto            postgres    false    226    226            �           2606    17996    istituti istituto_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY schema_istituto.istituti
    ADD CONSTRAINT istituto_pkey PRIMARY KEY (id_istituto);
 I   ALTER TABLE ONLY schema_istituto.istituti DROP CONSTRAINT istituto_pkey;
       schema_istituto            postgres    false    225            �           2606    17998 (   istituti_studenti istituto_studenti_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.istituti_studenti
    ADD CONSTRAINT istituto_studenti_pkey PRIMARY KEY (istituto_fk, studente_fk);
 [   ALTER TABLE ONLY schema_istituto.istituti_studenti DROP CONSTRAINT istituto_studenti_pkey;
       schema_istituto            postgres    false    228    228            �           2606    18000    materie materie_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY schema_istituto.materie
    ADD CONSTRAINT materie_pkey PRIMARY KEY (id_materia);
 G   ALTER TABLE ONLY schema_istituto.materie DROP CONSTRAINT materie_pkey;
       schema_istituto            postgres    false    229            �           2606    18002    presenze presenze_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY schema_istituto.presenze
    ADD CONSTRAINT presenze_pkey PRIMARY KEY (id_presenza);
 I   ALTER TABLE ONLY schema_istituto.presenze DROP CONSTRAINT presenze_pkey;
       schema_istituto            postgres    false    231            �           2606    18004 $   studenti studenti_codice_fiscale_key 
   CONSTRAINT     r   ALTER TABLE ONLY schema_istituto.studenti
    ADD CONSTRAINT studenti_codice_fiscale_key UNIQUE (codice_fiscale);
 W   ALTER TABLE ONLY schema_istituto.studenti DROP CONSTRAINT studenti_codice_fiscale_key;
       schema_istituto            postgres    false    233            �           2606    18006    studenti studenti_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY schema_istituto.studenti
    ADD CONSTRAINT studenti_pkey PRIMARY KEY (id_studente);
 I   ALTER TABLE ONLY schema_istituto.studenti DROP CONSTRAINT studenti_pkey;
       schema_istituto            postgres    false    233            �           2606    18008    voti voti_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY schema_istituto.voti
    ADD CONSTRAINT voti_pkey PRIMARY KEY (id_voto);
 A   ALTER TABLE ONLY schema_istituto.voti DROP CONSTRAINT voti_pkey;
       schema_istituto            postgres    false    235            �           2606    18009    compiti classe_fk    FK CONSTRAINT     �   ALTER TABLE ONLY schema_classe.compiti
    ADD CONSTRAINT classe_fk FOREIGN KEY (fk_classe) REFERENCES schema_classe.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY schema_classe.compiti DROP CONSTRAINT classe_fk;
       schema_classe          postgres    false    213    3258    215            �           2606    18014    calendari classe_fk    FK CONSTRAINT     �   ALTER TABLE ONLY schema_classe.calendari
    ADD CONSTRAINT classe_fk FOREIGN KEY (fk_classe) REFERENCES schema_classe.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY schema_classe.calendari DROP CONSTRAINT classe_fk;
       schema_classe          postgres    false    211    213    3258            �           2606    18019    comunicazioni classe_fk    FK CONSTRAINT     �   ALTER TABLE ONLY schema_classe.comunicazioni
    ADD CONSTRAINT classe_fk FOREIGN KEY (fk_classe) REFERENCES schema_classe.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 H   ALTER TABLE ONLY schema_classe.comunicazioni DROP CONSTRAINT classe_fk;
       schema_classe          postgres    false    213    3258    217            �           2606    18024    note classe_fk    FK CONSTRAINT     �   ALTER TABLE ONLY schema_classe.note
    ADD CONSTRAINT classe_fk FOREIGN KEY (fk_classe) REFERENCES schema_classe.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 ?   ALTER TABLE ONLY schema_classe.note DROP CONSTRAINT classe_fk;
       schema_classe          postgres    false    213    3258    219            �           2606    18092    classi_studenti fk_classe    FK CONSTRAINT     �   ALTER TABLE ONLY schema_classe.classi_studenti
    ADD CONSTRAINT fk_classe FOREIGN KEY (classe_fk) REFERENCES schema_classe.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 J   ALTER TABLE ONLY schema_classe.classi_studenti DROP CONSTRAINT fk_classe;
       schema_classe          postgres    false    3258    213    238            �           2606    18104    classi_docenti fk_classe    FK CONSTRAINT     �   ALTER TABLE ONLY schema_classe.classi_docenti
    ADD CONSTRAINT fk_classe FOREIGN KEY (classe_fk) REFERENCES schema_classe.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 I   ALTER TABLE ONLY schema_classe.classi_docenti DROP CONSTRAINT fk_classe;
       schema_classe          postgres    false    3258    213    240            �           2606    18029    docenti_istituti fk_docente    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.docenti_istituti
    ADD CONSTRAINT fk_docente FOREIGN KEY (docente_fk) REFERENCES schema_istituto.docenti(id_docente) ON UPDATE CASCADE ON DELETE CASCADE;
 N   ALTER TABLE ONLY schema_istituto.docenti_istituti DROP CONSTRAINT fk_docente;
       schema_istituto          postgres    false    221    3268    223            �           2606    18034    docenti_materie fk_docente    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.docenti_materie
    ADD CONSTRAINT fk_docente FOREIGN KEY (docente_fk) REFERENCES schema_istituto.docenti(id_docente) ON UPDATE CASCADE ON DELETE CASCADE;
 M   ALTER TABLE ONLY schema_istituto.docenti_materie DROP CONSTRAINT fk_docente;
       schema_istituto          postgres    false    221    3268    224            �           2606    18039    istituti_materie fk_istituto    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.istituti_materie
    ADD CONSTRAINT fk_istituto FOREIGN KEY (istituto_fk) REFERENCES schema_istituto.istituti(id_istituto) ON UPDATE CASCADE ON DELETE CASCADE;
 O   ALTER TABLE ONLY schema_istituto.istituti_materie DROP CONSTRAINT fk_istituto;
       schema_istituto          postgres    false    226    3274    225            �           2606    18044    istituti_studenti fk_istituto    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.istituti_studenti
    ADD CONSTRAINT fk_istituto FOREIGN KEY (istituto_fk) REFERENCES schema_istituto.istituti(id_istituto) ON UPDATE CASCADE ON DELETE CASCADE;
 P   ALTER TABLE ONLY schema_istituto.istituti_studenti DROP CONSTRAINT fk_istituto;
       schema_istituto          postgres    false    228    3274    225            �           2606    18049    docenti_istituti fk_istituto    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.docenti_istituti
    ADD CONSTRAINT fk_istituto FOREIGN KEY (istituto_fk) REFERENCES schema_istituto.istituti(id_istituto) ON UPDATE CASCADE ON DELETE CASCADE;
 O   ALTER TABLE ONLY schema_istituto.docenti_istituti DROP CONSTRAINT fk_istituto;
       schema_istituto          postgres    false    223    3274    225            �           2606    18054    istituti_materie fk_materia    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.istituti_materie
    ADD CONSTRAINT fk_materia FOREIGN KEY (materia_fk) REFERENCES schema_istituto.materie(id_materia) ON UPDATE CASCADE ON DELETE CASCADE;
 N   ALTER TABLE ONLY schema_istituto.istituti_materie DROP CONSTRAINT fk_materia;
       schema_istituto          postgres    false    226    3280    229            �           2606    18059    docenti_materie fk_materia    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.docenti_materie
    ADD CONSTRAINT fk_materia FOREIGN KEY (materia_fk) REFERENCES schema_istituto.materie(id_materia) ON UPDATE CASCADE ON DELETE CASCADE;
 M   ALTER TABLE ONLY schema_istituto.docenti_materie DROP CONSTRAINT fk_materia;
       schema_istituto          postgres    false    224    229    3280            �           2606    18064    istituti_studenti fk_studente    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.istituti_studenti
    ADD CONSTRAINT fk_studente FOREIGN KEY (studente_fk) REFERENCES schema_istituto.studenti(id_studente) ON UPDATE CASCADE ON DELETE CASCADE;
 P   ALTER TABLE ONLY schema_istituto.istituti_studenti DROP CONSTRAINT fk_studente;
       schema_istituto          postgres    false    228    233    3286            �           2606    18069    voti materia_fk    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.voti
    ADD CONSTRAINT materia_fk FOREIGN KEY (fk_materia) REFERENCES schema_istituto.materie(id_materia) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY schema_istituto.voti DROP CONSTRAINT materia_fk;
       schema_istituto          postgres    false    229    235    3280            �           2606    18074    voti studente_fk    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.voti
    ADD CONSTRAINT studente_fk FOREIGN KEY (fk_studente) REFERENCES schema_istituto.studenti(id_studente) ON UPDATE CASCADE ON DELETE CASCADE;
 C   ALTER TABLE ONLY schema_istituto.voti DROP CONSTRAINT studente_fk;
       schema_istituto          postgres    false    235    3286    233            �           2606    18079    presenze utente_fk    FK CONSTRAINT     �   ALTER TABLE ONLY schema_istituto.presenze
    ADD CONSTRAINT utente_fk FOREIGN KEY (fk_studente) REFERENCES schema_istituto.studenti(id_studente) ON UPDATE CASCADE ON DELETE CASCADE;
 E   ALTER TABLE ONLY schema_istituto.presenze DROP CONSTRAINT utente_fk;
       schema_istituto          postgres    false    3286    233    231            y      x������ � �      {      x�3�,(��M�4����� =@      �      x������ � �      �      x������ � �      }      x������ � �            x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     
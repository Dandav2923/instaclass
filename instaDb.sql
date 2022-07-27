PGDMP     '        
            z           instaclass_database    14.4    14.4 x    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16426    instaclass_database    DATABASE     o   CREATE DATABASE instaclass_database WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
 #   DROP DATABASE instaclass_database;
                postgres    false            �            1259    16596 	   calendari    TABLE     �   CREATE TABLE public.calendari (
    id_calendario integer NOT NULL,
    data_evento date,
    nome_evento character varying(255),
    fk_classe integer NOT NULL
);
    DROP TABLE public.calendari;
       public         heap    postgres    false            �            1259    16595    calendario_id_calendario_seq    SEQUENCE     �   CREATE SEQUENCE public.calendario_id_calendario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.calendario_id_calendario_seq;
       public          postgres    false    231            �           0    0    calendario_id_calendario_seq    SEQUENCE OWNED BY     \   ALTER SEQUENCE public.calendario_id_calendario_seq OWNED BY public.calendari.id_calendario;
          public          postgres    false    230            �            1259    16427    classi    TABLE     �   CREATE TABLE public.classi (
    id_classe integer NOT NULL,
    nome_classe character varying(100) NOT NULL,
    fk_istituto integer NOT NULL
);
    DROP TABLE public.classi;
       public         heap    postgres    false            �            1259    16430    classe_id_classe_seq    SEQUENCE     �   CREATE SEQUENCE public.classe_id_classe_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.classe_id_classe_seq;
       public          postgres    false    209            �           0    0    classe_id_classe_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.classe_id_classe_seq OWNED BY public.classi.id_classe;
          public          postgres    false    210            �            1259    16568    classi_docenti    TABLE     h   CREATE TABLE public.classi_docenti (
    classe_fk integer NOT NULL,
    docente_fk integer NOT NULL
);
 "   DROP TABLE public.classi_docenti;
       public         heap    postgres    false            �            1259    16431    classi_studenti    TABLE     j   CREATE TABLE public.classi_studenti (
    classe_fk integer NOT NULL,
    studente_fk integer NOT NULL
);
 #   DROP TABLE public.classi_studenti;
       public         heap    postgres    false            �            1259    16584    compiti    TABLE     �   CREATE TABLE public.compiti (
    id_compito integer NOT NULL,
    data_consegna date,
    descrizione character varying(255),
    fk_classe integer NOT NULL
);
    DROP TABLE public.compiti;
       public         heap    postgres    false            �            1259    16583    compiti_id_compito_seq    SEQUENCE     �   CREATE SEQUENCE public.compiti_id_compito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.compiti_id_compito_seq;
       public          postgres    false    229            �           0    0    compiti_id_compito_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.compiti_id_compito_seq OWNED BY public.compiti.id_compito;
          public          postgres    false    228            �            1259    16608    comunicazioni    TABLE     �   CREATE TABLE public.comunicazioni (
    id_comunicazione integer NOT NULL,
    data_comunicazione date,
    nome_comunicazione character varying(255),
    fk_classe integer NOT NULL
);
 !   DROP TABLE public.comunicazioni;
       public         heap    postgres    false            �            1259    16607 "   comunicazioni_id_comunicazione_seq    SEQUENCE     �   CREATE SEQUENCE public.comunicazioni_id_comunicazione_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.comunicazioni_id_comunicazione_seq;
       public          postgres    false    233            �           0    0 "   comunicazioni_id_comunicazione_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.comunicazioni_id_comunicazione_seq OWNED BY public.comunicazioni.id_comunicazione;
          public          postgres    false    232            �            1259    16434    docenti    TABLE     �   CREATE TABLE public.docenti (
    id_docente integer NOT NULL,
    cf character(16) NOT NULL,
    nome_docente character varying(100) NOT NULL,
    cognome character varying(100) NOT NULL,
    password character varying(100) NOT NULL
);
    DROP TABLE public.docenti;
       public         heap    postgres    false            �            1259    16437    docenti_id_docente_seq    SEQUENCE     �   CREATE SEQUENCE public.docenti_id_docente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.docenti_id_docente_seq;
       public          postgres    false    212            �           0    0    docenti_id_docente_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.docenti_id_docente_seq OWNED BY public.docenti.id_docente;
          public          postgres    false    213            �            1259    16553    docenti_istituti    TABLE     l   CREATE TABLE public.docenti_istituti (
    istituto_fk integer NOT NULL,
    docente_fk integer NOT NULL
);
 $   DROP TABLE public.docenti_istituti;
       public         heap    postgres    false            �            1259    16631    docenti_materie    TABLE     j   CREATE TABLE public.docenti_materie (
    materia_fk integer NOT NULL,
    docente_fk integer NOT NULL
);
 #   DROP TABLE public.docenti_materie;
       public         heap    postgres    false            �            1259    16438    istituti    TABLE     �   CREATE TABLE public.istituti (
    id_istituto integer NOT NULL,
    nome_istituto character varying(100) NOT NULL,
    password character varying(100) NOT NULL
);
    DROP TABLE public.istituti;
       public         heap    postgres    false            �            1259    16442    istituti_materie    TABLE     l   CREATE TABLE public.istituti_materie (
    istituto_fk integer NOT NULL,
    materia_fk integer NOT NULL
);
 $   DROP TABLE public.istituti_materie;
       public         heap    postgres    false            �            1259    16445    istituti_studenti    TABLE     n   CREATE TABLE public.istituti_studenti (
    istituto_fk integer NOT NULL,
    studente_fk integer NOT NULL
);
 %   DROP TABLE public.istituti_studenti;
       public         heap    postgres    false            �            1259    16441    istituto_id_istituto_seq    SEQUENCE     �   CREATE SEQUENCE public.istituto_id_istituto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.istituto_id_istituto_seq;
       public          postgres    false    214            �           0    0    istituto_id_istituto_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.istituto_id_istituto_seq OWNED BY public.istituti.id_istituto;
          public          postgres    false    215            �            1259    16448    materie    TABLE     k   CREATE TABLE public.materie (
    id_materia integer NOT NULL,
    nome character varying(100) NOT NULL
);
    DROP TABLE public.materie;
       public         heap    postgres    false            �            1259    16451    materia_id_materia_seq    SEQUENCE     �   CREATE SEQUENCE public.materia_id_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.materia_id_materia_seq;
       public          postgres    false    218            �           0    0    materia_id_materia_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.materia_id_materia_seq OWNED BY public.materie.id_materia;
          public          postgres    false    219            �            1259    16620    note    TABLE     �   CREATE TABLE public.note (
    id_nota integer NOT NULL,
    data_nota date,
    descrizione_nota character varying(255),
    cf_studente character varying(16),
    fk_classe integer NOT NULL
);
    DROP TABLE public.note;
       public         heap    postgres    false            �            1259    16619    note_id_nota_seq    SEQUENCE     �   CREATE SEQUENCE public.note_id_nota_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.note_id_nota_seq;
       public          postgres    false    235            �           0    0    note_id_nota_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.note_id_nota_seq OWNED BY public.note.id_nota;
          public          postgres    false    234            �            1259    16452    presenze    TABLE     �   CREATE TABLE public.presenze (
    id_presenza integer NOT NULL,
    data_giorno date NOT NULL,
    presente boolean NOT NULL,
    fk_studente integer NOT NULL
);
    DROP TABLE public.presenze;
       public         heap    postgres    false            �            1259    16455    presenze_id_presenza_seq    SEQUENCE     �   CREATE SEQUENCE public.presenze_id_presenza_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.presenze_id_presenza_seq;
       public          postgres    false    220            �           0    0    presenze_id_presenza_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.presenze_id_presenza_seq OWNED BY public.presenze.id_presenza;
          public          postgres    false    221            �            1259    16456    studenti    TABLE     �   CREATE TABLE public.studenti (
    id_studente integer NOT NULL,
    nome_studente character varying(100) NOT NULL,
    cognome_studente character varying(100) NOT NULL,
    cf character(16) NOT NULL,
    password character varying(100) NOT NULL
);
    DROP TABLE public.studenti;
       public         heap    postgres    false            �            1259    16459    studenti_id_studente_seq    SEQUENCE     �   CREATE SEQUENCE public.studenti_id_studente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.studenti_id_studente_seq;
       public          postgres    false    222            �           0    0    studenti_id_studente_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.studenti_id_studente_seq OWNED BY public.studenti.id_studente;
          public          postgres    false    223            �            1259    16460    voti    TABLE     �   CREATE TABLE public.voti (
    id_voto integer NOT NULL,
    punteggio integer NOT NULL,
    fk_studente integer NOT NULL,
    fk_materia integer NOT NULL
);
    DROP TABLE public.voti;
       public         heap    postgres    false            �            1259    16463    voti_id_voto_seq    SEQUENCE     �   CREATE SEQUENCE public.voti_id_voto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.voti_id_voto_seq;
       public          postgres    false    224            �           0    0    voti_id_voto_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.voti_id_voto_seq OWNED BY public.voti.id_voto;
          public          postgres    false    225            �           2604    16599    calendari id_calendario    DEFAULT     �   ALTER TABLE ONLY public.calendari ALTER COLUMN id_calendario SET DEFAULT nextval('public.calendario_id_calendario_seq'::regclass);
 F   ALTER TABLE public.calendari ALTER COLUMN id_calendario DROP DEFAULT;
       public          postgres    false    230    231    231            �           2604    16464    classi id_classe    DEFAULT     t   ALTER TABLE ONLY public.classi ALTER COLUMN id_classe SET DEFAULT nextval('public.classe_id_classe_seq'::regclass);
 ?   ALTER TABLE public.classi ALTER COLUMN id_classe DROP DEFAULT;
       public          postgres    false    210    209            �           2604    16587    compiti id_compito    DEFAULT     x   ALTER TABLE ONLY public.compiti ALTER COLUMN id_compito SET DEFAULT nextval('public.compiti_id_compito_seq'::regclass);
 A   ALTER TABLE public.compiti ALTER COLUMN id_compito DROP DEFAULT;
       public          postgres    false    228    229    229            �           2604    16611    comunicazioni id_comunicazione    DEFAULT     �   ALTER TABLE ONLY public.comunicazioni ALTER COLUMN id_comunicazione SET DEFAULT nextval('public.comunicazioni_id_comunicazione_seq'::regclass);
 M   ALTER TABLE public.comunicazioni ALTER COLUMN id_comunicazione DROP DEFAULT;
       public          postgres    false    232    233    233            �           2604    16465    docenti id_docente    DEFAULT     x   ALTER TABLE ONLY public.docenti ALTER COLUMN id_docente SET DEFAULT nextval('public.docenti_id_docente_seq'::regclass);
 A   ALTER TABLE public.docenti ALTER COLUMN id_docente DROP DEFAULT;
       public          postgres    false    213    212            �           2604    16466    istituti id_istituto    DEFAULT     |   ALTER TABLE ONLY public.istituti ALTER COLUMN id_istituto SET DEFAULT nextval('public.istituto_id_istituto_seq'::regclass);
 C   ALTER TABLE public.istituti ALTER COLUMN id_istituto DROP DEFAULT;
       public          postgres    false    215    214            �           2604    16467    materie id_materia    DEFAULT     x   ALTER TABLE ONLY public.materie ALTER COLUMN id_materia SET DEFAULT nextval('public.materia_id_materia_seq'::regclass);
 A   ALTER TABLE public.materie ALTER COLUMN id_materia DROP DEFAULT;
       public          postgres    false    219    218            �           2604    16623    note id_nota    DEFAULT     l   ALTER TABLE ONLY public.note ALTER COLUMN id_nota SET DEFAULT nextval('public.note_id_nota_seq'::regclass);
 ;   ALTER TABLE public.note ALTER COLUMN id_nota DROP DEFAULT;
       public          postgres    false    235    234    235            �           2604    16468    presenze id_presenza    DEFAULT     |   ALTER TABLE ONLY public.presenze ALTER COLUMN id_presenza SET DEFAULT nextval('public.presenze_id_presenza_seq'::regclass);
 C   ALTER TABLE public.presenze ALTER COLUMN id_presenza DROP DEFAULT;
       public          postgres    false    221    220            �           2604    16469    studenti id_studente    DEFAULT     |   ALTER TABLE ONLY public.studenti ALTER COLUMN id_studente SET DEFAULT nextval('public.studenti_id_studente_seq'::regclass);
 C   ALTER TABLE public.studenti ALTER COLUMN id_studente DROP DEFAULT;
       public          postgres    false    223    222            �           2604    16470    voti id_voto    DEFAULT     l   ALTER TABLE ONLY public.voti ALTER COLUMN id_voto SET DEFAULT nextval('public.voti_id_voto_seq'::regclass);
 ;   ALTER TABLE public.voti ALTER COLUMN id_voto DROP DEFAULT;
       public          postgres    false    225    224            �          0    16596 	   calendari 
   TABLE DATA           W   COPY public.calendari (id_calendario, data_evento, nome_evento, fk_classe) FROM stdin;
    public          postgres    false    231   <�       t          0    16427    classi 
   TABLE DATA           E   COPY public.classi (id_classe, nome_classe, fk_istituto) FROM stdin;
    public          postgres    false    209   �       �          0    16568    classi_docenti 
   TABLE DATA           ?   COPY public.classi_docenti (classe_fk, docente_fk) FROM stdin;
    public          postgres    false    227          v          0    16431    classi_studenti 
   TABLE DATA           A   COPY public.classi_studenti (classe_fk, studente_fk) FROM stdin;
    public          postgres    false    211   �       �          0    16584    compiti 
   TABLE DATA           T   COPY public.compiti (id_compito, data_consegna, descrizione, fk_classe) FROM stdin;
    public          postgres    false    229   �       �          0    16608    comunicazioni 
   TABLE DATA           l   COPY public.comunicazioni (id_comunicazione, data_comunicazione, nome_comunicazione, fk_classe) FROM stdin;
    public          postgres    false    233   o�       w          0    16434    docenti 
   TABLE DATA           R   COPY public.docenti (id_docente, cf, nome_docente, cognome, password) FROM stdin;
    public          postgres    false    212   ��       �          0    16553    docenti_istituti 
   TABLE DATA           C   COPY public.docenti_istituti (istituto_fk, docente_fk) FROM stdin;
    public          postgres    false    226   �       �          0    16631    docenti_materie 
   TABLE DATA           A   COPY public.docenti_materie (materia_fk, docente_fk) FROM stdin;
    public          postgres    false    236   0�       y          0    16438    istituti 
   TABLE DATA           H   COPY public.istituti (id_istituto, nome_istituto, password) FROM stdin;
    public          postgres    false    214   S�       {          0    16442    istituti_materie 
   TABLE DATA           C   COPY public.istituti_materie (istituto_fk, materia_fk) FROM stdin;
    public          postgres    false    216   ��       |          0    16445    istituti_studenti 
   TABLE DATA           E   COPY public.istituti_studenti (istituto_fk, studente_fk) FROM stdin;
    public          postgres    false    217   ��       }          0    16448    materie 
   TABLE DATA           3   COPY public.materie (id_materia, nome) FROM stdin;
    public          postgres    false    218   �       �          0    16620    note 
   TABLE DATA           \   COPY public.note (id_nota, data_nota, descrizione_nota, cf_studente, fk_classe) FROM stdin;
    public          postgres    false    235   #�                 0    16452    presenze 
   TABLE DATA           S   COPY public.presenze (id_presenza, data_giorno, presente, fk_studente) FROM stdin;
    public          postgres    false    220   ��       �          0    16456    studenti 
   TABLE DATA           ^   COPY public.studenti (id_studente, nome_studente, cognome_studente, cf, password) FROM stdin;
    public          postgres    false    222   ��       �          0    16460    voti 
   TABLE DATA           K   COPY public.voti (id_voto, punteggio, fk_studente, fk_materia) FROM stdin;
    public          postgres    false    224   �       �           0    0    calendario_id_calendario_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.calendario_id_calendario_seq', 2, true);
          public          postgres    false    230            �           0    0    classe_id_classe_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.classe_id_classe_seq', 4, true);
          public          postgres    false    210            �           0    0    compiti_id_compito_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.compiti_id_compito_seq', 2, true);
          public          postgres    false    228            �           0    0 "   comunicazioni_id_comunicazione_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.comunicazioni_id_comunicazione_seq', 2, true);
          public          postgres    false    232            �           0    0    docenti_id_docente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.docenti_id_docente_seq', 2, true);
          public          postgres    false    213            �           0    0    istituto_id_istituto_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.istituto_id_istituto_seq', 2, true);
          public          postgres    false    215            �           0    0    materia_id_materia_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.materia_id_materia_seq', 3, true);
          public          postgres    false    219            �           0    0    note_id_nota_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.note_id_nota_seq', 3, true);
          public          postgres    false    234            �           0    0    presenze_id_presenza_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.presenze_id_presenza_seq', 4, true);
          public          postgres    false    221            �           0    0    studenti_id_studente_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.studenti_id_studente_seq', 4, true);
          public          postgres    false    223            �           0    0    voti_id_voto_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.voti_id_voto_seq', 2, true);
          public          postgres    false    225            �           2606    16601    calendari calendario_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.calendari
    ADD CONSTRAINT calendario_pkey PRIMARY KEY (id_calendario);
 C   ALTER TABLE ONLY public.calendari DROP CONSTRAINT calendario_pkey;
       public            postgres    false    231            �           2606    16572 "   classi_docenti classe_docente_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY public.classi_docenti
    ADD CONSTRAINT classe_docente_pkey PRIMARY KEY (classe_fk, docente_fk);
 L   ALTER TABLE ONLY public.classi_docenti DROP CONSTRAINT classe_docente_pkey;
       public            postgres    false    227    227            �           2606    16472    classi classe_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.classi
    ADD CONSTRAINT classe_pkey PRIMARY KEY (id_classe);
 <   ALTER TABLE ONLY public.classi DROP CONSTRAINT classe_pkey;
       public            postgres    false    209            �           2606    16474 $   classi_studenti classe_studente_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.classi_studenti
    ADD CONSTRAINT classe_studente_pkey PRIMARY KEY (classe_fk, studente_fk);
 N   ALTER TABLE ONLY public.classi_studenti DROP CONSTRAINT classe_studente_pkey;
       public            postgres    false    211    211            �           2606    16589    compiti compiti_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.compiti
    ADD CONSTRAINT compiti_pkey PRIMARY KEY (id_compito);
 >   ALTER TABLE ONLY public.compiti DROP CONSTRAINT compiti_pkey;
       public            postgres    false    229            �           2606    16613     comunicazioni comunicazioni_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.comunicazioni
    ADD CONSTRAINT comunicazioni_pkey PRIMARY KEY (id_comunicazione);
 J   ALTER TABLE ONLY public.comunicazioni DROP CONSTRAINT comunicazioni_pkey;
       public            postgres    false    233            �           2606    16557 &   docenti_istituti docenti_istituto_pkey 
   CONSTRAINT     y   ALTER TABLE ONLY public.docenti_istituti
    ADD CONSTRAINT docenti_istituto_pkey PRIMARY KEY (istituto_fk, docente_fk);
 P   ALTER TABLE ONLY public.docenti_istituti DROP CONSTRAINT docenti_istituto_pkey;
       public            postgres    false    226    226            �           2606    16635 $   docenti_materie docenti_materia_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.docenti_materie
    ADD CONSTRAINT docenti_materia_pkey PRIMARY KEY (materia_fk, docente_fk);
 N   ALTER TABLE ONLY public.docenti_materie DROP CONSTRAINT docenti_materia_pkey;
       public            postgres    false    236    236            �           2606    16476    docenti docenti_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.docenti
    ADD CONSTRAINT docenti_pkey PRIMARY KEY (id_docente);
 >   ALTER TABLE ONLY public.docenti DROP CONSTRAINT docenti_pkey;
       public            postgres    false    212            �           2606    16478 &   istituti_materie istituto_materia_pkey 
   CONSTRAINT     y   ALTER TABLE ONLY public.istituti_materie
    ADD CONSTRAINT istituto_materia_pkey PRIMARY KEY (istituto_fk, materia_fk);
 P   ALTER TABLE ONLY public.istituti_materie DROP CONSTRAINT istituto_materia_pkey;
       public            postgres    false    216    216            �           2606    16480 #   istituti istituto_nome_istituto_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.istituti
    ADD CONSTRAINT istituto_nome_istituto_key UNIQUE (nome_istituto);
 M   ALTER TABLE ONLY public.istituti DROP CONSTRAINT istituto_nome_istituto_key;
       public            postgres    false    214            �           2606    16482    istituti istituto_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.istituti
    ADD CONSTRAINT istituto_pkey PRIMARY KEY (id_istituto);
 @   ALTER TABLE ONLY public.istituti DROP CONSTRAINT istituto_pkey;
       public            postgres    false    214            �           2606    16484 (   istituti_studenti istituto_studenti_pkey 
   CONSTRAINT     |   ALTER TABLE ONLY public.istituti_studenti
    ADD CONSTRAINT istituto_studenti_pkey PRIMARY KEY (istituto_fk, studente_fk);
 R   ALTER TABLE ONLY public.istituti_studenti DROP CONSTRAINT istituto_studenti_pkey;
       public            postgres    false    217    217            �           2606    16486    materie materia_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.materie
    ADD CONSTRAINT materia_pkey PRIMARY KEY (id_materia);
 >   ALTER TABLE ONLY public.materie DROP CONSTRAINT materia_pkey;
       public            postgres    false    218            �           2606    16625    note note_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_pkey PRIMARY KEY (id_nota);
 8   ALTER TABLE ONLY public.note DROP CONSTRAINT note_pkey;
       public            postgres    false    235            �           2606    16488    presenze presenze_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.presenze
    ADD CONSTRAINT presenze_pkey PRIMARY KEY (id_presenza);
 @   ALTER TABLE ONLY public.presenze DROP CONSTRAINT presenze_pkey;
       public            postgres    false    220            �           2606    16490    studenti studenti_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.studenti
    ADD CONSTRAINT studenti_pkey PRIMARY KEY (id_studente);
 @   ALTER TABLE ONLY public.studenti DROP CONSTRAINT studenti_pkey;
       public            postgres    false    222            �           2606    16492    voti voti_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.voti
    ADD CONSTRAINT voti_pkey PRIMARY KEY (id_voto);
 8   ALTER TABLE ONLY public.voti DROP CONSTRAINT voti_pkey;
       public            postgres    false    224            �           2606    16590    compiti classe_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.compiti
    ADD CONSTRAINT classe_fk FOREIGN KEY (fk_classe) REFERENCES public.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 ;   ALTER TABLE ONLY public.compiti DROP CONSTRAINT classe_fk;
       public          postgres    false    209    229    3250            �           2606    16602    calendari classe_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.calendari
    ADD CONSTRAINT classe_fk FOREIGN KEY (fk_classe) REFERENCES public.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.calendari DROP CONSTRAINT classe_fk;
       public          postgres    false    209    3250    231            �           2606    16614    comunicazioni classe_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.comunicazioni
    ADD CONSTRAINT classe_fk FOREIGN KEY (fk_classe) REFERENCES public.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 A   ALTER TABLE ONLY public.comunicazioni DROP CONSTRAINT classe_fk;
       public          postgres    false    3250    233    209            �           2606    16626    note classe_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.note
    ADD CONSTRAINT classe_fk FOREIGN KEY (fk_classe) REFERENCES public.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 8   ALTER TABLE ONLY public.note DROP CONSTRAINT classe_fk;
       public          postgres    false    235    209    3250            �           2606    16493    classi_studenti fk_classe    FK CONSTRAINT     �   ALTER TABLE ONLY public.classi_studenti
    ADD CONSTRAINT fk_classe FOREIGN KEY (classe_fk) REFERENCES public.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 C   ALTER TABLE ONLY public.classi_studenti DROP CONSTRAINT fk_classe;
       public          postgres    false    209    3250    211            �           2606    16573    classi_docenti fk_classe    FK CONSTRAINT     �   ALTER TABLE ONLY public.classi_docenti
    ADD CONSTRAINT fk_classe FOREIGN KEY (classe_fk) REFERENCES public.classi(id_classe) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.classi_docenti DROP CONSTRAINT fk_classe;
       public          postgres    false    3250    209    227            �           2606    16563    docenti_istituti fk_docente    FK CONSTRAINT     �   ALTER TABLE ONLY public.docenti_istituti
    ADD CONSTRAINT fk_docente FOREIGN KEY (docente_fk) REFERENCES public.docenti(id_docente) ON UPDATE CASCADE ON DELETE CASCADE;
 E   ALTER TABLE ONLY public.docenti_istituti DROP CONSTRAINT fk_docente;
       public          postgres    false    226    3254    212            �           2606    16578    classi_docenti fk_docente    FK CONSTRAINT     �   ALTER TABLE ONLY public.classi_docenti
    ADD CONSTRAINT fk_docente FOREIGN KEY (docente_fk) REFERENCES public.docenti(id_docente) ON UPDATE CASCADE ON DELETE CASCADE;
 C   ALTER TABLE ONLY public.classi_docenti DROP CONSTRAINT fk_docente;
       public          postgres    false    227    212    3254            �           2606    16641    docenti_materie fk_docente    FK CONSTRAINT     �   ALTER TABLE ONLY public.docenti_materie
    ADD CONSTRAINT fk_docente FOREIGN KEY (docente_fk) REFERENCES public.docenti(id_docente) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.docenti_materie DROP CONSTRAINT fk_docente;
       public          postgres    false    212    3254    236            �           2606    16498    istituti_studenti fk_istituto    FK CONSTRAINT     �   ALTER TABLE ONLY public.istituti_studenti
    ADD CONSTRAINT fk_istituto FOREIGN KEY (istituto_fk) REFERENCES public.istituti(id_istituto) ON UPDATE CASCADE ON DELETE CASCADE;
 G   ALTER TABLE ONLY public.istituti_studenti DROP CONSTRAINT fk_istituto;
       public          postgres    false    3258    217    214            �           2606    16503    istituti_materie fk_istituto    FK CONSTRAINT     �   ALTER TABLE ONLY public.istituti_materie
    ADD CONSTRAINT fk_istituto FOREIGN KEY (istituto_fk) REFERENCES public.istituti(id_istituto) ON UPDATE CASCADE ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.istituti_materie DROP CONSTRAINT fk_istituto;
       public          postgres    false    3258    216    214            �           2606    16558    docenti_istituti fk_istituto    FK CONSTRAINT     �   ALTER TABLE ONLY public.docenti_istituti
    ADD CONSTRAINT fk_istituto FOREIGN KEY (istituto_fk) REFERENCES public.istituti(id_istituto) ON UPDATE CASCADE ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.docenti_istituti DROP CONSTRAINT fk_istituto;
       public          postgres    false    226    214    3258            �           2606    16508    istituti_materie fk_materia    FK CONSTRAINT     �   ALTER TABLE ONLY public.istituti_materie
    ADD CONSTRAINT fk_materia FOREIGN KEY (materia_fk) REFERENCES public.materie(id_materia) ON UPDATE CASCADE ON DELETE CASCADE;
 E   ALTER TABLE ONLY public.istituti_materie DROP CONSTRAINT fk_materia;
       public          postgres    false    218    216    3264            �           2606    16636    docenti_materie fk_materia    FK CONSTRAINT     �   ALTER TABLE ONLY public.docenti_materie
    ADD CONSTRAINT fk_materia FOREIGN KEY (materia_fk) REFERENCES public.materie(id_materia) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.docenti_materie DROP CONSTRAINT fk_materia;
       public          postgres    false    3264    236    218            �           2606    16513    istituti_studenti fk_studente    FK CONSTRAINT     �   ALTER TABLE ONLY public.istituti_studenti
    ADD CONSTRAINT fk_studente FOREIGN KEY (studente_fk) REFERENCES public.studenti(id_studente) ON UPDATE CASCADE ON DELETE CASCADE;
 G   ALTER TABLE ONLY public.istituti_studenti DROP CONSTRAINT fk_studente;
       public          postgres    false    217    3268    222            �           2606    16518    classi_studenti fk_studente    FK CONSTRAINT     �   ALTER TABLE ONLY public.classi_studenti
    ADD CONSTRAINT fk_studente FOREIGN KEY (studente_fk) REFERENCES public.studenti(id_studente) ON UPDATE CASCADE ON DELETE CASCADE;
 E   ALTER TABLE ONLY public.classi_studenti DROP CONSTRAINT fk_studente;
       public          postgres    false    222    3268    211            �           2606    16523    classi istituto_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.classi
    ADD CONSTRAINT istituto_fk FOREIGN KEY (fk_istituto) REFERENCES public.istituti(id_istituto) ON UPDATE CASCADE ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.classi DROP CONSTRAINT istituto_fk;
       public          postgres    false    3258    209    214            �           2606    16528    voti materia_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.voti
    ADD CONSTRAINT materia_fk FOREIGN KEY (fk_materia) REFERENCES public.materie(id_materia) ON UPDATE CASCADE ON DELETE CASCADE;
 9   ALTER TABLE ONLY public.voti DROP CONSTRAINT materia_fk;
       public          postgres    false    224    3264    218            �           2606    16533    voti studente_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.voti
    ADD CONSTRAINT studente_fk FOREIGN KEY (fk_studente) REFERENCES public.studenti(id_studente) ON UPDATE CASCADE ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.voti DROP CONSTRAINT studente_fk;
       public          postgres    false    222    3268    224            �           2606    16538    presenze utente_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.presenze
    ADD CONSTRAINT utente_fk FOREIGN KEY (fk_studente) REFERENCES public.studenti(id_studente) ON UPDATE CASCADE ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.presenze DROP CONSTRAINT utente_fk;
       public          postgres    false    222    220    3268            �   3   x�3�4202�5!N�̒DNC.#������1�cqqjnRNj"�W� �
�      t   3   x�3�(��M�4�2�NM��KI�4�2�I-���p�&��c���� 2(�      �      x�3�4�2bcN#. ����� u�      v      x�3�4�2b#Nc.C ����� �      �   I   x�3�4202�50�54�t+�)��W(�/*IT��QHN�K�4�2����52��M,*�M,I���DNC�=... �o&      �   2   x�3�4202�50�52�t,+�,��4�2B��r:g%��$�%b���� /0�      w   J   x�3�4426153��4,,O-*���M,JN����K�I-�D(�2�(��p�'E�9��J����qqq ��      �      x�3�4�2�4����� ��      �      x�3�4�2�=... ��      y   1   x�3�,��)I�4426153�2�L���IM��L+O�,-/�,����� ��      {      x�3�4�2�4bC.# m�c���� 'g�      |      x�3�4�2cc�=... v      }   .   x�3��M,I�M,�LN�2��,I��L���2�.�/�L����� �      �   Y   x�3�4202�54�52�t+�)�����4�2�H���r�%�%���+�&���ML��-,
�S�J*���ƀ'XULĜ=... ��>         "   x�3�4202�5!�Nc.d�4N�=... ��g      �   P   x�3�tI��L�I���t�����4426153��4(,O-*�Dp�p���e�s�'����UerXZ����b(����� �      �      x�3�4�4�4�2�4�4�4����� ��     
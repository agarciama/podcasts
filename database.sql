
-- Eliminar secuencias (para limpieza)
DROP SEQUENCE IF EXISTS seq_creador;
DROP SEQUENCE IF EXISTS seq_podcast;

-- Eliminar tablas (para limpieza)
DROP TABLE IF EXISTS podcast CASCADE;
DROP TABLE IF EXISTS creador CASCADE;

-- Crear tabla de creador
CREATE TABLE CREADOR (
                         ID VARCHAR(10),
                         NOMBRE VARCHAR(100),
                         EMAIL VARCHAR(100),
                         BIO VARCHAR(500),

                         CONSTRAINT "PK_CREADOR"           PRIMARY KEY (ID),
                         CONSTRAINT "NN_CREADOR.NOMBRE"    CHECK (NOMBRE IS NOT NULL),
                         CONSTRAINT "NN_CREADOR.EMAIL"     CHECK (EMAIL IS NOT NULL)
);

-- Crear tabla de podcast
CREATE TABLE PODCAST (
                         ID VARCHAR(10),
                         ID_CREADOR VARCHAR(10),
                         TITULO VARCHAR(200),
                         DESCRIPCION VARCHAR(1000),
                         FECHA_INICIO DATE,
                         IMAGEN VARCHAR(500),

                         CONSTRAINT "PK_PODCAST"               PRIMARY KEY (ID),
                         CONSTRAINT "FK_PODCAST_CREADOR"       FOREIGN KEY (ID_CREADOR) REFERENCES creador(ID) ON DELETE CASCADE,
                         CONSTRAINT "NN_PODCAST.ID_CREADOR"    CHECK (ID_CREADOR IS NOT NULL),
                         CONSTRAINT "NN_PODCAST.TITULO"        CHECK (TITULO IS NOT NULL),
                         CONSTRAINT "NN_PODCAST.DESCRIPCION"   CHECK (DESCRIPCION IS NOT NULL),
                         CONSTRAINT "NN_PODCAST.FECHA_INICIO"  CHECK (FECHA_INICIO IS NOT NULL),
                         CONSTRAINT "NN_PODCAST.IMAGEN"        CHECK (IMAGEN IS NOT NULL)
);


-- Crear secuencias
CREATE SEQUENCE seq_creador   MINVALUE 1 MAXVALUE 999999998 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_podcast   MINVALUE 1 MAXVALUE 999999998 START WITH 1 INCREMENT BY 1;

-- Formato de fecha: día-mes-año
SET datestyle = 'ISO, DMY';


-- Datos de ejemplo: Creadores
INSERT INTO CREADOR (ID, nombre, email, bio) VALUES
(('CR' || nextval('seq_creador')), 'Laura García', 'laura.garcia@example.com', 'Podcaster de tecnología y ciencia.'),
(('CR' || nextval('seq_creador')), 'Pedro Martínez', 'pedro.martinez@example.com', 'Especialista en entrevistas de negocios.'),
(('CR' || nextval('seq_creador')), 'Jordi Wild', 'contact@jordiwild.com', 'YouTuber, psicólogo y podcaster, creador de The Wild Project.'),
(('CR' || nextval('seq_creador')), 'Pedro Buerbaum', 'contact@pedrobuerbaum.com', 'Emprendedor y presentador del podcast WORLDCA$T.');


-- Datos de ejemplo: Podcasts
INSERT INTO PODCAST (ID, ID_CREADOR, titulo, descripcion, FECHA_INICIO, imagen) VALUES
(('PC' || nextval('seq_podcast')), 'CR1', 'Tech Talks', 'Conversaciones sobre las últimas tendencias tecnológicas.', '2023-05-10', 'https://example.com/images/techtalks.jpg'),
(('PC' || nextval('seq_podcast')), 'CR2', 'Negocios Hoy', 'Análisis de noticias y entrevistas empresariales.', '2022-11-01', 'https://example.com/images/negocioshoy.jpg'),
(('PC' || nextval('seq_podcast')), 'CR3', 'The Wild Project', 'Podcast de entrevistas y debates presentado por Jordi Wild, con invitados de diversos campos.', '2020-01-01', 'https://podcasts.apple.com/es/podcast/the-wild-project/id1501968107/image'),
(('PC' || nextval('seq_podcast')), 'CR4', 'WORLDCA$T', 'Podcast semanal de conversaciones sin guiones presentado por Pedro Buerbaum.', '2021-06-17', 'https://open.spotify.com/show/5hiPtlvSfLe4S9S5S9RCwG/image');

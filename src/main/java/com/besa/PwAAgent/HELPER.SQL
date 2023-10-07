-----------------------FUNDAMENTALES----------------------------
-- ACTIVIDAD_PWA: --
INSERT INTO
    ACTIVIDAD_PWA  (id, nombre, tipo, duracion)
VALUES
    (0, 'MUSICOTERAPIA', 'Entretenimiento', 60);

INSERT INTO
    ACTIVIDAD_PWA  (id, nombre, tipo, duracion)
VALUES
    (1, 'CUENTERIA', 'Entretenimiento', 60);

-- ANTECEDENTE: --
INSERT INTO
    antecedente (id, etiqueta, valor)
VALUES
    (1, 'antecedente_prueba', 1);

-- CUIDADOR: --
INSERT INTO
    cuidador (
        nombre_usuario,
        contrasena,
        nombre,
        correo,
        celular
    )
VALUES
    (
        'juan_cuidador',
        'jpablo98',
        'Juan Pablo',
        'jamorocho98@gmail.com',
        '3007682470'
    );

-- ESTADOCIVIL: --
INSERT INTO
    estado_civil (tipo_ec)
VALUES
    ('s' --Soltero
);

-----------------------------
INSERT INTO
    estado_civil (tipo_ec)
VALUES
    ('c' --Casado
);

-- FAMILIAR: --
INSERT INTO
    familiar (
        id,
        nombre,
        parentesco,
        interes,
        esta_vivo,
        nacimiento
    )
VALUES
    (
        10909,
        'Paulina Cantor',
        'Esposa',
        10.5,
        TRUE,
        '19960101'
    );

-- GENERO: --
INSERT INTO
    genero (genero)
VALUES
    ('Latin');

INSERT INTO
    genero (genero)
VALUES
    ('Pop');
-- JOINT: --
INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (0, 'HeadPitch', 0.333358, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (1, 'HeadYaw', 0.0173742, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (2, 'HipPitch', -0.726057, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (3, 'HipRoll', -0.00359941, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (4, 'KneePitch', -0.00905603, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (5, 'LElbowRoll', -0.110514, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (6, 'LElbowYaw', -1.71537, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (7, 'LHand', 0.6942, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (8, 'LShoulderPitch', 1.20428, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (9, 'LShoulderRoll', 0.113541, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (10, 'LWristYaw', 0.0345809, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (11, 'RElbowRoll', 0.0923345, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (12, 'RElbowYaw', 1.68466, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (13, 'RHand', 0.688049, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (14, 'RShoulderPitch', 1.20446, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (15, 'RShoulderRoll', -0.117913, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (16, 'RWristYaw', -0.0225847, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (17, 'HeadPitch', -0.22017, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (18, 'HeadYaw', 0, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (19, 'HipPitch', 0.0733038, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (20, 'HipRoll', 0, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (21, 'KneePitch', 0, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (22, 'LElbowRoll', -1.22173, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (23, 'LElbowYaw', -1.71042, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (24, 'LHand', 0.7, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (25, 'LShoulderPitch', 1.51669, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (26, 'LShoulderRoll', 0.10821, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (27, 'LWristYaw', 0.0349066, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (28, 'RElbowRoll', 1.22173, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (29, 'RElbowYaw', 1.67552, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (30, 'RHand', 0.7, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (31, 'RShoulderPitch', 1.53589, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (32, 'RShoulderRoll', -0.115192, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (33, 'RWristYaw', -0.0244346, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (34, 'LElbowRoll', -1.22173, 0.36);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (35, 'LShoulderPitch', 1.02974, 0.36);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (36, 'LShoulderPitch', 2.08567, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (37, 'LShoulderPitch', 1.02974, 1.16);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (38, 'LShoulderPitch', 2.08567, 1.56);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (39, 'RElbowRoll', 1.22173, 0.36);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (40, 'RShoulderPitch', 2.74312, 0.36);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (41, 'RShoulderPitch', 1.02974, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (42, 'RShoulderPitch', 2.74312, 1.16);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (43, 'RShoulderPitch', 1.02974, 1.56);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (44, 'LElbowRoll', -0.698132, 0.36);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (45, 'RElbowRoll', 0.698132, 0.36);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (46, 'HeadPitch', 0.174533, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (47, 'HipPitch', -0.436332, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (48, 'LShoulderPitch', 1.309, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (49, 'RShoulderPitch', 1.309, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (50, 'HeadPitch', -0.122173, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (51, 'HipPitch', 0.0349066, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (52, 'LElbowRoll', -0.959931, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (53, 'RElbowRoll', 0.959931, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (54, 'HeadPitch', 0, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (55, 'HipPitch', 0, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (56, 'LElbowRoll', -0.349066, 0.76);

INSERT INTO
    Joint (id, nombre, angulo, tiempo)
VALUES
    (57, 'RElbowRoll', 0.349066, 0.76);

-- NIVELEDUCATIVO: --
INSERT INTO
    nivel_educativo (tipo_ne)
VALUES
    ('Alta Educación');

-- REGLA: --
INSERT INTO
    regla (id, feedback, etiqueta)
VALUES
    (1, 1, 'Regla prueba');

-- ROBOT: --
INSERT INTO
    robot (id, nombre)
VALUES
    (1, 'pepper');

-- TAG: --
INSERT INTO
    tag (id, tag)
VALUES
    (1, 'tag de prueba');

-----------------------COMPOSITES----------------------------
-- EMOCION: --
INSERT INTO
    emocion (
        id,
        imagen,
        emotional_tag,
        robot_id
    )
VALUES
    (0, 'VHAPPY', 'VHAPPY', 1);

INSERT INTO
    emocion (
        id,
        imagen,
        emotional_tag,
        robot_id
    )
VALUES
    (1, 'HAPPY', 'HAPPY', 1);

INSERT INTO
    emocion (
        id,
        imagen,
        emotional_tag,
        robot_id
    )
VALUES
    (2, 'NORMAL', 'NORMAL', 1);

INSERT INTO
    emocion (
        id,
        imagen,
        emotional_tag,
        robot_id
    )
VALUES
    (3, 'SAD', 'SAD', 1);

INSERT INTO
    emocion (
        id,
        imagen,
        emotional_tag,
        robot_id
    )
VALUES
    (4, 'VSAD', 'VSAD', 1);

-- CAUSADEMENCIA: --
INSERT INTO
    causa_demencia (condicion)
VALUES
    ('alzheimer');

-- PERFILPWA: --
INSERT INTO
    perfil_pwa (
        cedula,
        nombre,
        apellido,
        fecha_nacimiento,
        pais_nacimiento,
        profesion,
        edad,
        estado_civil_tipo_ec,
        cuidador_nombre_usuario,
        nivel_educativo_tipo_ne,
        tiene_programa_ejercicio
    )
VALUES
    (
        '0',
        'Mario',
        'Suarez',
        '19400101',
        'Colombia',
        'Retirada',
        80,
        'c',
        'juan_cuidador',
        'Alta Educación',
        false
    );

-- PERFILMEDICO: --
INSERT INTO
    perfil_medico (
        perfil_pwa_cedula,
        toma_medicamentos,
        discap_auditiva,
        discap_visual,
        discap_motora,
        estado_enfermedad,
        periodo_vigila,
        fast,
        riesgo_caida,
        sppb,
        causa_demencia_condicion
    )
VALUES
    (
        '0',
        1,
        1,
        1,
        1,
        1,
        1,
        1,
        NULL,
        NULL,
        'alzheimer'
    );

INSERT INTO
    RELIGION (ID, LIBRO, NAME, ORACION)
VALUES
    (
        1,
        'LA BIBLIA',
        'CRISTIANA',
        'Padre nuestro que estás en el cielo, santificado sea tu Nombre;venga a nosotros tu Reino;hágase tu voluntad en la tierra como en el cielo.Danos hoy nuestro pan de cada día;perdona nuestras ofensas,como también nosotros perdonamos'
    );

INSERT INTO
    VERSICULO (ID, INFORMACION, TEXTO)
VALUES
    (
        1,
        'JUAN 3 16',
        'Porque de tal manera amó Dios al mundo que ha dado a su Hijo Unigénito, para que todo aquel que en él cree no se pierda, mas tenga vida eterna'
    );

INSERT INTO
    RELIGION_VERSICULOS (RELIGION_ID, VERSICULOS_ID)
VALUES
    (1, 1);

-- PERFILPREFERENCIA: --
INSERT INTO
    perfil_preferencia (
        perfil_pwa_cedula,
        nombre_preferido,
        gusto_karaoke,
        gusto_musica,
        gusto_baile,
        GUSTO_LEER,
        brillo_preferido,
        vol_preferido,
        NIVEL_RELIGIOSO,
        RELIGION_ID,
        gusto_ejercicio
    )
VALUES
    (
        '0',
        'Don Mario',
        1,
        3,
        1,
        1,
        80,
        80,
        5,
        1,
        2
    );

--ACCION--
INSERT INTO
    accion (id, nombre, emocion_id, tipo)
VALUES
    (0, 'POSTURA', 4, 'postura');

INSERT INTO
    accion (id, nombre, emocion_id, tipo)
VALUES
    (1, 'POSTURA', 0, 'postura');

INSERT INTO
    accion (id, nombre, emocion_id, tipo)
VALUES
    (2, 'caminar', 4, 'comando');

INSERT INTO
    accion (id, nombre, emocion_id, tipo)
VALUES
    (3, 'caminar', 0, 'comando');

INSERT INTO
    accion (id, nombre, emocion_id, tipo)
VALUES
    (4, 'POSTURA', 3, 'postura');

INSERT INTO
    accion (id, nombre, emocion_id, tipo)
VALUES
    (5, 'POSTURA', 1, 'postura');

INSERT INTO
    accion (id, nombre, emocion_id, tipo)
VALUES
    (6, 'POSTURA ', 2, 'postura');

-- ACCIONRUTINARIA: --
INSERT INTO
    actividad_rutinaria (
        id,
        nombre,
        duracion,
        hora,
        medico_pwa_cedula
    )
VALUES
    (
        1,
        'cuenteria',
        5,
        '20220808',
        '0'
    );

--ACCIONXJOINT--
INSERT INTO
    accion_x_joint (joint_id, accion_id)
VALUES
    (1, 1);

INSERT INTO
    ACT_X_PREFERENCIA (
        Actividad_PwA_id,
        PREFERENCIA_PWA_CEDULA,
        activa,
        gusto,
        enriq
    )
VALUES
    (0, '0', 1, 0.8, 5);

INSERT INTO
    ACT_X_PREFERENCIA (
        Actividad_PwA_id,
        PREFERENCIA_PWA_CEDULA,
        activa,
        gusto,
        enriq
    )
VALUES
    (1, '0', 1, 0.5, 2);

-- BAILE: --
INSERT INTO
    baile (id, nombre, genero)
VALUES
    (1, 'MACARENA', 'Pop');

INSERT INTO
    baile (id, nombre, genero)
VALUES
    (2, 'HAPPINESSDANCE', 'Pop');

-- CANCION: --
INSERT INTO
    Cancion (nombre, genero, url)
VALUES
    (
        'Mi cacharrito',
        'Latin',
        'http://192.168.223.33:49494/content/media/object_id/28/res_id/0/ext/file.mp4'
    );

INSERT INTO
    Cancion (nombre, genero, url)
VALUES
    (
        'Un Beso Y una Flor',
        'Pop',
        'http://192.168.223.33:49494/content/media/object_id/34/res_id/0/ext/file.mp4'
    );

INSERT INTO
    Cancion (nombre, genero, url)
VALUES
    (
        'Chiquitica',
        'Latin',
        'http://192.168.223.33:49494/content/media/object_id/25/res_id/0/ext/file.mp4'
    );

INSERT INTO
    Cancion (nombre, genero, url)
VALUES
    (
        'Mi querido viejo',
        'Pop',
        'http://192.168.223.33:49494/content/media/object_id/31/res_id/0/ext/file.mp4'
    );

-- CDR: --
INSERT INTO
    cdr (
        memoria,
        orientacion,
        juicio,
        vida_social,
        hogar,
        cuidadopersonal,
        medico_pwa_cedula
    )
VALUES
    (
        1,
        1,
        1,
        1,
        1,
        1,
        '0'
    );

INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Érase una vez una preciosa niña',1, 'Caperucita roja', ' ', ' ', 'http://10.195.22.103:49152/content/media/object_id/39/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'que siempre llevaba una capa roja con capucha para protegerse del frío',2, 'Caperucita roja', ' ', 'SHOWWARDROBE', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Por eso, todo el mundo la llamaba Caperucita Roja',3, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Caperucita vivía en una casita cerca del bosque',4, 'Caperucita roja', ' ', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Un día, la mamá de  Caperucita le dijo',5, 'Caperucita roja', ' ', ' ', 'http://10.195.22.103:49152/content/media/object_id/54/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Hija mía, tu abuelita está enferma',6, 'Caperucita roja','ABUELA_ENFERMAR_NULL', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'He preparado una cestita con tortas y un tarrito de miel para que se la lleves',7, 'Caperucita roja','CAPERUCITA_LLEVAR_REGALO', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Ya verás qué contenta se pone!',8, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Estupendo, mamá!',9, 'Caperucita roja','CAPERUCITA_EMOCIONAR_noobject', 'HAPPINESS', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Yo también tengo muchas ganas de ir a visitarla, dijo Caperucita saltando de alegría',10, 'Caperucita roja','CAPERUCITA_ALEGRARSE_noobject', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Cuando Caperucita se disponía a salir de casa',11, 'Caperucita roja', ' ', 'COMPLETECONV', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'su mamá, con gesto un poco serio, le hizo una advertencia',12, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Ten mucho cuidado, cariño. No te entretengas con nada y no hables con extraños',13, 'Caperucita roja','CAPERUCITA_ASUSTADA_noobject', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Sabes que en el bosque vive el lobo y es muy peligroso',14, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Si ves que aparece, sigue tu camino sin detenerte',15, 'Caperucita roja', ' ', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'No te preocupes, mamita, dijo la niña. Tendré en cuenta todo lo que me dices',16, 'Caperucita roja','CAPERUCITA_ASUSTADA_noobject', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Está bien, contestó la mamá, confiada. Dame un besito y no tardes en regresar',17, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Así lo haré, mamá, afirmó de nuevo Caperucita diciendo adiós con su manita mientras se alejaba',18, 'Caperucita roja', ' ', 'WALK', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Cuando llegó al bosque',19, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'la pequeña comenzó a distraerse contemplando los pajaritos y recogiendo flores',20, 'Caperucita roja','CAPERUCITA_OBSERVAR_NATURALEZA', 'EXPLORE', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'No se dio cuenta de que alguien la observaba detrás de un viejo y frondoso árbol',21, 'Caperucita roja','LOBO_OBSERVAR_CAPERUCITA', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'De repente, oyó una voz dulce y zalamera',22, 'Caperucita roja', ' ', 'HOWL', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¿A dónde vas, Caperucita?',23, 'Caperucita roja','LOBO_HABLA_CAPERUCITA', 'COMPLETECONV', 'http://10.195.22.103:49152/content/media/object_id/57/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'La niña, dando un respingo, se giró y vio que quien le hablaba era un enorme lobo',24, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Voy a casa de mi abuelita, al otro lado del bosque',25, 'Caperucita roja', ' ', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Está enferma y le llevo una deliciosa merienda y unas flores para alegrarle el día',26, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Oh, eso es estupendo!, dijo el astuto lobo, Yo también vivo por allí',27, 'Caperucita roja','LOBO_AMENAZAR_CAPERUCITA', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Te echo una carrera a ver quién llega antes',28, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Cada uno iremos por un camino diferente ¿te parece bien?',29, 'Caperucita roja', ' ', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'La inocente niña pensó que era una idea divertida y asintió con la cabeza',30, 'Caperucita roja','CAPERUCITA_APRECIAR_IDEA', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'No sabía que el lobo había elegido el camino más corto para llegar primero a su destino',31, 'Caperucita roja','LOBO_TRAICIONAR_CAPERUCITA', 'COMPLETECONV', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Cuando el animal  llegó a casa de la abuela, llamó a la puerta',32, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¿Quién es?, gritó la mujer',33, 'Caperucita roja', ' ', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Soy yo, abuelita, tu querida nieta Caperucita',34, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Ábreme la puerta, dijo el lobo imitando la voz de la niña',35, 'Caperucita roja','LOBO_ENGANAR_ABUELA', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Pasa, querida mía. La puerta está abierta, contestó la abuela',36, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'El malvado lobo entró en la casa y sin pensárselo dos veces',37, 'Caperucita roja', ' ', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'saltó sobre la cama y se comió a la anciana',38, 'Caperucita roja','LOBO_DEVORAR_ABUELA', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Después, se puso su camisón y su gorrito de dormir',39, 'Caperucita roja', ' ', 'YAWN', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'y se metió entre las sábanas esperando a que llegara la niña',40, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Al rato, se oyeron unos golpes',41, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¿Quién llama?, dijo el lobo forzando la voz como si fuera la abuelita',42, 'Caperucita roja','LOBO_ENGANAR_CAPERUCITA', 'QUESTION', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Soy yo, Caperucita. Vengo a hacerte una visita y a traerte unos ricos dulces para merendar',43, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Pasa, querida, estoy deseando abrazarte, dijo el lobo malvado relamiéndose',44, 'Caperucita roja', ' ', 'COMPLETECONV', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'La habitación estaba en penumbra',45, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Cuando se acercó a la cama, a Caperucita le pareció que su abuela estaba muy cambiada',46, 'Caperucita roja','CAPERUCITA_SOSPECHAR_noobject', ' ', 'http://10.195.22.103:49152/content/media/object_id/9/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Extrañada, le dijo: Abuelita, abuelita ¡qué ojos tan grandes tienes!',47, 'Caperucita roja','CAPERUCITA_SOSPECHAR_noobject', 'BIGEYES', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Son para verte mejor, preciosa mía, contestó el lobo, suavizando la voz',48, 'Caperucita roja','CAPERUCITA_SOSPECHAR_noobject', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Abuelita, abuelita ¡qué orejas tan grandes tienes!',49, 'Caperucita roja', ' ', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Son para oírte mejor, querida',50, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Pero abuelita, abuelita ¡qué boca tan grande tienes!',51, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Es para comerte mejor!, gritó el lobo dando un enorme salto y comiéndose a la niña de un bocado',52, 'Caperucita roja','LOBO_DEVORAR_CAPERUCITA', 'EAT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Con la barriga llena después de tanta comida, al lobo le entró sueño',53, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Salió de la casa, se tumbó en el jardín y cayó profundamente dormido',54, 'Caperucita roja','LOBO_DESCANSAR_noobject', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'El fuerte sonido de sus ronquidos llamó la atención de un cazador que pasaba por allí',55, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'El hombre se acercó y vio que el animal tenía la panza muy hinchada, demasiado para ser un lobo',56, 'Caperucita roja','HOMBRE_SORPRENDER_noobject', 'WALK', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Sospechando que pasaba algo extraño, cogió un cuchillo y le rajó la tripa',57, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Se llevó una gran sorpresa cuando vio que de ella salieron sanas y salvas la abuela y la niña!',58, 'Caperucita roja','FAMILIAR_ESCAPAR_noobject', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Después de liberarlas, el cazador cosió la barriga del lobo',59, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'y esperaron un rato a que el animal se despertará',60, 'Caperucita roja','LOBO_ENFERMAR_noobject', 'COMPLETECONV', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Cuando por fin abrió los ojos, vio como los tres le rodeaban y escuchó la profunda',61, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'y amenazante voz del cazador que le gritaba enfurecido:',62, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Lárgate, lobo malvado! ¡No te queremos en este bosque!',63, 'Caperucita roja','HOMBRE_GRITAR_LOBO', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Como vuelva a verte por aquí, no volverás a contarlo!',64, 'Caperucita roja', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'El lobo, aterrado, puso pies en polvorosa y salió despavorido',65, 'Caperucita roja','LOBO_HUIR_noobject', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Caperucita y su abuelita, con lágrimas cayendo sobre sus mejillas, se abrazaron',66, 'Caperucita roja','FAMILIA_ABRAZAR_noobject', ' ', 'http://10.195.22.103:49152/content/media/object_id/51/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'El susto había pasado y la niña había aprendido una importante lección:',67, 'Caperucita roja', ' ', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'nunca más desobedecería a su mamá ni se fiaría de extraños',68, 'Caperucita roja', ' ', ' ', ' ');

INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Había una vez tres hermanos cerditos que vivían en el bosque',1, 'Los 3 Cerditos', ' ', ' ', 'http://10.195.22.103:49152/content/media/object_id/42/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Como el malvado lobo siempre los estaba persiguiendo para comérselos dijo un día el mayor:',2, 'Los 3 Cerditos','LOBO_PERSEGUIR_CERDO', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Tenemos que hacer una casa para protegernos de lobo',3, 'Los 3 Cerditos', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Así podremos escondernos dentro de ella cada vez que el lobo aparezca por aquí',4, 'Los 3 Cerditos','CERDO_SONAR_CASA', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'A los otros dos les pareció muy buena idea',5, 'Los 3 Cerditos', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'pero no se ponían de acuerdo respecto a qué material utilizar',6, 'Los 3 Cerditos', ' ', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Al final, y para no discutir, decidieron que cada uno la hiciera de lo que quisiese',7, 'Los 3 Cerditos', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'El más pequeño optó por utilizar paja, para no tardar mucho y poder irse a jugar después',8, 'Los 3 Cerditos','CERDO_CONSTRUIR_CASA', 'BUILD', 'http://10.195.22.103:49152/content/media/object_id/45/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'El mediano prefirió construirla de madera',9, 'Los 3 Cerditos','CERDO_CONSTRUIR_CASA', ' ', 'http://10.195.22.103:49152/content/media/object_id/63/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'que era más resistente que la paja y tampoco le llevaría mucho tiempo hacerla',10, 'Los 3 Cerditos', ' ', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Pero el mayor pensó que aunque tardara más que sus hermanos',11, 'Los 3 Cerditos', ' ', ' ', 'http://10.195.22.103:49152/content/media/object_id/17/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'lo mejor era hacer una casa resistente y fuerte con ladrillos',12, 'Los 3 Cerditos', ' ', 'BUILD', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Además así podré hacer una chimenea con la que calentarme en invierno, pensó el cerdito',13, 'Los 3 Cerditos','CERDO_CONSTRUIR_CASA', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Cuando los tres acabaron sus casas se metieron cada uno en la suya',14, 'Los 3 Cerditos', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'y entonces apareció por ahí el malvado lobo',15, 'Los 3 Cerditos','LOBO_APARECER_noobject', 'FEROCIOUS', 'http://10.195.22.103:49152/content/media/object_id/60/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Se dirigió a la de paja y llamó a la puerta:',16, 'Los 3 Cerditos', ' ', 'TOCTOC', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Anda cerdito se bueno y déjame entrar',17, 'Los 3 Cerditos', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡No! ¡Eso ni pensarlo!',18, 'Los 3 Cerditos', ' ', 'FRAGCONVRIGHT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Pues soplaré y soplaré y la casita derribaré!',19, 'Los 3 Cerditos', ' ', ' ', 'http://10.195.22.103:49152/content/media/object_id/30/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Y el lobo empezó a soplar y a estornudar, la débil casa acabó viniéndose abajo',20, 'Los 3 Cerditos','LOBO_DESTRUIR_CASA', 'BLOW', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Pero el cerdito echó a correr y se refugió en la casa de su hermano mediano',21, 'Los 3 Cerditos','CERDO_REFUGIARSE_noobject', 'WALK', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'que estaba hecha de madera',22, 'Los 3 Cerditos', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Anda cerditos sed buenos y dejarme entrar',23, 'Los 3 Cerditos', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡No! ¡Eso ni pensarlo!, dijeron los dos',24, 'Los 3 Cerditos', ' ', 'COMPLETECONV', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Pues soplaré y soplaré y la casita derribaré!',25, 'Los 3 Cerditos', ' ', ' ', 'http://10.195.22.103:49152/content/media/object_id/36/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'El lobo empezó a soplar y a estornudar',26, 'Los 3 Cerditos', ' ', 'BLOW', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'aunque esta vez tuvo que hacer más esfuerzos para derribar la casa al final la madera acabó cediendo',27, 'Los 3 Cerditos','LOBO_DESTRUIR_CASA', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'y los cerditos salieron corriendo en dirección hacia la casa de su hermano mayor',28, 'Los 3 Cerditos','CERDO_REFUGIARSE_noobject', 'WALK', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'El lobo estaba cada vez más hambriento así que sopló y sopló con todas sus fuerzas',29, 'Los 3 Cerditos', ' ', 'BLOW', 'http://10.195.22.103:49152/content/media/object_id/14/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'pero esta vez no tenía nada que hacer porque la casa no se movía ni siquiera un poco',30, 'Los 3 Cerditos', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Dentro los cerditos celebraban la resistencia de la casa de su hermano',31, 'Los 3 Cerditos','CERDO_CELEBRAR_EXITO', 'CELEBRATE', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'y cantaban alegres por haberse librado del lobo:',32, 'Los 3 Cerditos', ' ', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¿Quien teme al lobo feroz? ¡No, no, no!',33, 'Los 3 Cerditos','CERDO_VITOREAR_noobject', 'QUESTION', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Fuera el lobo continuaba soplando en vano, cada vez más enfadado',34, 'Los 3 Cerditos', ' ', 'BLOW', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Hasta que decidió parar para descansar y entonces reparó en que la casa tenía una chimenea',35, 'Los 3 Cerditos', ' ', ' ', 'http://10.195.22.103:49152/content/media/object_id/27/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( '¡Ja! ¡Pensaban que de mí iban a librarse! ¡Subiré por la chimenea y me los comeré a los tres!',36, 'Los 3 Cerditos','LOBO_PERSEGUIR_CERDO', 'FRAGCONVLEFT', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Pero los cerditos le oyeron, y para darle su merecido llenaron la chimenea de leña',37, 'Los 3 Cerditos', ' ', ' ', 'http://10.195.22.103:49152/content/media/object_id/33/res_id/0');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'y pusieron al fuego un gran caldero con agua',38, 'Los 3 Cerditos', ' ', 'COMPLETECONV', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'Así cuando el lobo cayó por la chimenea el agua estaba hirviendo',39, 'Los 3 Cerditos','LOBO_QUEMAR_COLA', ' ', ' ');
INSERT INTO Frase (contenido,orden,Cuento_nombre,emotional_event,accion,url_imagen) VALUES( 'se quemó tanto que salió gritando de la casa y no volvió a comer cerditos en una larga temporada',40, 'Los 3 Cerditos','LOBO_HUIR_noobject', 'FRAGCONVRIGHT', ' ');

-- ENRIQ: --
INSERT INTO
    enriq (
        params,
        valor,
        frase_orden,
        frase_nombre,
        cancion_nombre
    )
VALUES
    (
        'Params?',
        'Valor es un string??',
        1,
        'Augh-Thor Phalsoh',
        'test song'
    );

-- EVENTINFLUENCE: --
INSERT INTO
    event_influence (
        id,
        event_name,
        event_influence,
        emotional_axis_config_id
    )
VALUES
    (
        1,
        'evento_de_prueba',
        1.0,
        1
    );

-- FAMILIARES: --
INSERT INTO
    familiares (perfil_pwa_cedula, familiar_id)
VALUES
    ('0', 10909);

-- LISTATAG: --
INSERT INTO
    lista_tag (cancion_nombre, tag_id)
VALUES
    ('test song', 1);

-- PREFERENCIAXBAILE: --
INSERT INTO
    preferencia_x_baile (
        baile_id,
        preferencia_pwa_cedula,
        gusto
    )
VALUES
    (1, '0', 2.0);

INSERT INTO
    preferencia_x_baile (
        baile_id,
        preferencia_pwa_cedula,
        gusto
    )
VALUES
    (2, '0', 2.0);


INSERT INTO
    preferencia_x_baile (
        baile_id,
        preferencia_pwa_cedula,
        gusto
    )
VALUES
    (3, '0', 2.0);

-- PREFERENCIAXCANCION: --
INSERT INTO
    preferencia_x_cancion (
        cancion_nombre,
        preferencia_pwa_cedula,
        gusto,
        reminiscencia
    )
VALUES
    ('Mi cacharrito', '0', 2.0, 1);

INSERT INTO
    preferencia_x_cancion (
        cancion_nombre,
        preferencia_pwa_cedula,
        gusto,
        reminiscencia
    )
VALUES
    ('Un Beso Y una Flor', '0', 2.0, 1);

INSERT INTO
    preferencia_x_cancion (
        cancion_nombre,
        preferencia_pwa_cedula,
        gusto,
        reminiscencia
    )
VALUES
    ('Chiquitica', '0', 2.0, 1);

INSERT INTO
    preferencia_x_cancion (
        cancion_nombre,
        preferencia_pwa_cedula,
        gusto,
        reminiscencia
    )
VALUES
    ('Mi querido viejo', '0', 2.0, 1);

INSERT INTO Genero (genero) VALUES('Literatura Infantil');
INSERT INTO Cuento (genero,Autor,nombre) VALUES( 'Literatura Infantil', 'Charles Perrault', 'Caperucita roja');
INSERT INTO Cuento (genero,Autor,nombre) VALUES( 'Literatura Infantil',  'Jon Scieszka', 'Los 3 Cerditos');

-- PREFERENCIAXCUENTA: --
INSERT INTO
    preferencia_x_cuento (
        cuento_nombre,
        preferencia_pwa_cedula,
        gusto
    )
VALUES
    ('Caperucita Roja', '0', 2.0);


INSERT INTO
    preferencia_x_cuento (
        cuento_nombre,
        preferencia_pwa_cedula,
        gusto
    )
VALUES
    ('Los 3 Cerditos', '0', 2.0);

-- REGISTROACTIVIDAD: --
INSERT INTO
    registro_actividad (
        fecha,
        perfil_pwa_cedula,
        tipo,
        estado_inicial,
        estado_final,
        actividad_pwa_id
    )
VALUES
    (
        '20220101',
        '0',
        'entretenimiento',
        'true',
        'true',
        1
    );

-- REGLAXANTECEDENTE: --
INSERT INTO
    regla_x_antecedente (regla_id, antecedente_id)
VALUES
    (1, 1);

----------------------------------- NUEVOS VALORES: --------------------------------
-- CATEGORIAENTRENAMIENTO --
INSERT INTO
    categoria_entrenamiento(tipo)
VALUES
    ('FuerzaC1');

INSERT INTO
    categoria_entrenamiento(tipo)
VALUES
    ('CardiovascularC1');

INSERT INTO
    categoria_entrenamiento (tipo)
VALUES
    ('EquilibrioC1');

INSERT INTO
    categoria_entrenamiento (tipo)
VALUES
    ('FlexibilidadC1');

INSERT INTO
    categoria_entrenamiento(tipo)
VALUES
    ('FuerzaBrazosC1');

INSERT INTO
    categoria_entrenamiento(tipo)
VALUES
    ('FuerzaPiernasC1');

-- DIA --
INSERT INTO
    dia (nombre)
VALUES
    ('LunesC1');

INSERT INTO
    dia (nombre)
VALUES
    ('MartesC1');

INSERT INTO
    dia (nombre)
VALUES
    ('MiercolesC1');

INSERT INTO
    dia (nombre)
VALUES
    ('JuevesC1');

INSERT INTO
    dia (nombre)
VALUES
    ('ViernesC1');

INSERT INTO
    dia (nombre)
VALUES
    ('SabadoC1');

INSERT INTO
    dia (nombre)
VALUES
    ('DomingoC1');

-- EJERCICIO --
----- FUERZA ------
INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    (
        'MANCUERNA',
        10.0,
        TRUE,
        'http://10.195.40.154:49152/content/media/object_id/19/res_id/0'
    );

INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    (
        'CRUZADO',
        10.0,
        TRUE,
        'http://10.195.40.154:49152/content/media/object_id/22/res_id/0'
    );

INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    ('SENTADILLA', 10.0, FALSE, NULL);

INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    ('LIGAH', 15.0, FALSE, NULL);

--INSERT INTO Ejercicio (nombre, duracion,necesita_peso, url_video) 
--VALUES ('LIGAC', 10.0,FALSE, NULL);
INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    ('GIRARTOALLA', 10.0, FALSE, NULL);

----- CARDIO ----
INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    ('WALK', 10.0, FALSE, NULL);

----- FLEXIBILIDAD ----
INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    ('ELEVACIONH', 10.0, FALSE, NULL);

INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    ('ELEVACIONV', 15.0, FALSE, NULL);

INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    ('GiRARTRONCO', 10.0, FALSE, NULL);

INSERT INTO
    Ejercicio (nombre, duracion, necesita_peso, url_video)
VALUES
    ('GIRARCABEZA', 10.0, FALSE, NULL);

select
    *
from
    Ejercicio;

--- INTENSIDAD ---
INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    ('12_Fuerza_C1', 2, 10, NULL, 5, 'FuerzaC1');

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    ('34_Fuerza_C1', 2, 12, NULL, 5, 'FuerzaC1');

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    ('56_Fuerza_C1', 3, 12, NULL, 5, 'FuerzaC1');

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    ('78_Fuerza_C1', 2, 10, NULL, 10, 'FuerzaC1');

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    ('910_Fuerza_C1', 2, 12, NULL, 10, 'FuerzaC1');

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    ('1112_Fuerza_C1', 3, 12, NULL, 10, 'FuerzaC1');

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    (
        '12_Flexibilidad_C1',
        3,
        3,
        NULL,
        NULL,
        'FlexibilidadC1'
    );

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    (
        '34_Flexibilidad_C1',
        3,
        4,
        NULL,
        NULL,
        'FlexibilidadC1'
    );

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    (
        '12_FuerzaBrazos_C1',
        3,
        3,
        NULL,
        NULL,
        'FuerzaBrazosC1'
    );

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    (
        '34_FuerzaBrazos_C1',
        3,
        4,
        NULL,
        NULL,
        'FuerzaBrazosC1'
    );

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    (
        '12_Cardiovascular_C1',
        2,
        1,
        20,
        NULL,
        'CardiovascularC1'
    );

INSERT INTO
    Intensidad (
        id,
        series,
        repeticiones,
        duracion_ejercicio,
        peso,
        categoria_entrenamiento_tipo
    )
VALUES
    (
        '34_Cardiovascular_C1',
        2,
        1,
        300,
        NULL,
        'CardiovascularC1'
    );

-- PROGRAMAEJERCICIO --
INSERT INTO
    programa_ejercicio (nombre)
VALUES
    ('C1');

-- CATEGORIAENTRENAMIENTOXPROGRAMA --
INSERT INTO
    categoria_entrenamiento_x_programa (tipo_categoria, programa_ejercicio_nombre)
VALUES
    ('FuerzaC1', 'C1');

INSERT INTO
    categoria_entrenamiento_x_programa (tipo_categoria, programa_ejercicio_nombre)
VALUES
    ('FuerzaBrazosC1', 'C1');

INSERT INTO
    categoria_entrenamiento_x_programa (tipo_categoria, programa_ejercicio_nombre)
VALUES
    ('FuerzaPiernasC1', 'C1');

INSERT INTO
    categoria_entrenamiento_x_programa (tipo_categoria, programa_ejercicio_nombre)
VALUES
    ('CardiovascularC1', 'C1');

INSERT INTO
    categoria_entrenamiento_x_programa (tipo_categoria, programa_ejercicio_nombre)
VALUES
    ('EquilibrioC1', 'C1');

INSERT INTO
    categoria_entrenamiento_x_programa (tipo_categoria, programa_ejercicio_nombre)
VALUES
    ('FlexibilidadC1', 'C1');

-- DIAXPROGRAMAEJERCICIO --
INSERT INTO
    dia_x_programa_ejercicio (
        dia_nombre,
        programa_ejercicio_nombre,
        indice_orden
    )
VALUES
    ('LunesC1', 'C1', 1);

INSERT INTO
    dia_x_programa_ejercicio (
        dia_nombre,
        programa_ejercicio_nombre,
        indice_orden
    )
VALUES
    ('MartesC1', 'C1', 2);

INSERT INTO
    dia_x_programa_ejercicio (
        dia_nombre,
        programa_ejercicio_nombre,
        indice_orden
    )
VALUES
    ('MiercolesC1', 'C1', 3);

INSERT INTO
    dia_x_programa_ejercicio (
        dia_nombre,
        programa_ejercicio_nombre,
        indice_orden
    )
VALUES
    ('JuevesC1', 'C1', 4);

INSERT INTO
    dia_x_programa_ejercicio (
        dia_nombre,
        programa_ejercicio_nombre,
        indice_orden
    )
VALUES
    ('ViernesC1', 'C1', 5);

INSERT INTO
    dia_x_programa_ejercicio (
        dia_nombre,
        programa_ejercicio_nombre,
        indice_orden
    )
VALUES
    ('SabadoC1', 'C1', 6);

INSERT INTO
    dia_x_programa_ejercicio (
        dia_nombre,
        programa_ejercicio_nombre,
        indice_orden
    )
VALUES
    ('DomingoC1', 'C1', 7);

-- DIAXCATEGORIAENTRENAMIENTO --
-- Lunes --
INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('LunesC1', 'FuerzaC1', 1, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('LunesC1', 'FlexibilidadC1', 2, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('LunesC1', 'EquilibrioC1', 3, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('LunesC1', 'CardiovascularC1', 4, false);

-- Martes --
INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('MartesC1', 'EquilibrioC1', 1, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('MartesC1', 'FlexibilidadC1', 2, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('MartesC1', 'CardiovascularC1', 3, false);

-- Miercoles --
INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('MiercolesC1', 'FuerzaC1', 1, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('MiercolesC1', 'FlexibilidadC1', 2, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('MiercolesC1', 'EquilibrioC1', 3, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('MiercolesC1', 'CardiovascularC1', 4, false);

-- Jueves --
INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('JuevesC1', 'EquilibrioC1', 1, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('JuevesC1', 'FlexibilidadC1', 2, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('JuevesC1', 'CardiovascularC1', 3, false);

-- Viernes --
INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('ViernesC1', 'FuerzaBrazosC1', 1, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('ViernesC1', 'FlexibilidadC1', 2, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('ViernesC1', 'CardiovascularC1', 3, false);

-- Sabado -- 
INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('SabadoC1', 'FuerzaPiernasC1', 1, true);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('SabadoC1', 'FlexibilidadC1', 2, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('SabadoC1', 'CardiovascularC1', 3, false);

-- Domingo --    
INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('DomingoC1', 'EquilibrioC1', 1, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('DomingoC1', 'FlexibilidadC1', 2, false);

INSERT INTO
    dia_x_categoria_entrenamiento (
        dia_nombre,
        categoria_tipo,
        indice_orden,
        opcional
    )
VALUES
    ('DomingoC1', 'CardiovascularC1', 3, false);

-- EJERCICIOXCATEGORIA --
INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('MANCUERNA', 'FuerzaC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('MANCUERNA', 'FuerzaBrazosC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('SENTADILLA', 'FuerzaC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('SENTADILLA', 'FuerzaPiernasC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('CRUZADO', 'FuerzaC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('CRUZADO', 'FuerzaBrazosC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('LIGAH', 'FuerzaC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('LIGAH', 'FuerzaBrazosC1');

--INSERT INTO ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
--VALUES('LIGAC', 'FuerzaC1');
--INSERT INTO ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
--VALUES('LIGAC', 'FuerzaBrazosC1');
INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('GIRARTOALLA', 'FuerzaC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('GIRARTOALLA', 'FuerzaBrazosC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('WALK', 'CardiovascularC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('ELEVACIONH', 'FlexibilidadC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('ELEVACIONV', 'FlexibilidadC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('GiRARTRONCO', 'FlexibilidadC1');

INSERT INTO
    ejercicio_x_categoria (ejercicio_nombre, categoria_tipo)
VALUES
    ('GIRARCABEZA', 'FlexibilidadC1');

-- FRASEINSPIRACIONAL --
-- MANCUERNA --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'MANCUERNA',
        'Sube esos brazos!',
        1.5,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        2,
        'MANCUERNA',
        'Vamos, tu puedes! Lo estas haciendo bien!',
        0,
        'sad'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        3,
        'MANCUERNA',
        'Hasta me estoy cansando yo!',
        3,
        'neutral'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        4,
        'MANCUERNA',
        'Con paciencia, subiendo esas mancuernas!',
        0,
        'angry'
    );

-- SENTADILLA --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'SENTADILLA',
        'Bajemos el cuerpo!',
        0,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (2, 'SENTADILLA', 'Con toda!', 3, 'sad');

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        3,
        'SENTADILLA',
        'Manten tu coro derecho!',
        0,
        'neutral'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (4, 'SENTADILLA', 'Nosotros podemos!', 6, 'angry');

-- CRUZADO --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'CRUZADO',
        'Cruzemos esos brazos!',
        0,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        2,
        'CRUZADO',
        'Fuerza y determinacion!',
        3,
        'sad'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (3, 'CRUZADO', 'Uff, uff! Así es!', 6, 'neutral');

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        4,
        'CRUZADO',
        'Esto es genial para los brazos!',
        0,
        'angry'
    );

-- LIGAH --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'LIGAH',
        'Agarra esa liga con fuerza!',
        0,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        2,
        'LIGAH',
        'Un gran movimiento horizontal!',
        6,
        'sad'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (3, 'LIGAH', 'Listo, y un, y dos!', 0, 'neutral');

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (4, 'LIGAH', 'Somos campeones!', 0, 'angry');

-- LIGAC --
--INSERT INTO frase_inspiracional (id, ejercicio,  contenidos, tiempo_ejecucion, pwa_emocion) 
--VALUES (1,'LIGAC', 'Agarra esa liga con fuerza!', 0, 'happy');
--INSERT INTO frase_inspiracional (id, ejercicio,  contenidos, tiempo_ejecucion, pwa_emocion) 
-- VALUES (1,'LIGAC', 'Super duper, con todo!', 1, 'sad');
--INSERT INTO frase_inspiracional (id, ejercicio,  contenidos, tiempo_ejecucion, pwa_emocion) 
-- VALUES (1,'LIGAC', 'Yo se que tu puedes!', 0, 'neutral');
--INSERT INTO frase_inspiracional (id, ejercicio,  contenidos, tiempo_ejecucion, pwa_emocion) 
-- VALUES (1,'LIGAC', 'Que bien lo haces!', 0, 'angry');
-- GIRARTOALLA --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'GIRARTOALLA',
        'Giremos esa toalla!',
        0,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        2,
        'GIRARTOALLA',
        'Te mueves como un cisne!',
        1,
        'sad'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        3,
        'GIRARTOALLA',
        'Estos movimientos son fundamentales',
        0,
        'neutral'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        4,
        'GIRARTOALLA',
        'Sigue mi paso y todo estará bien!',
        0,
        'angry'
    );

-- WALK --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'WALK',
        'Y un, y dos, y tres, y cua!',
        0,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (2, 'WALK', 'Vamos!', 1, 'sad');

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (3, 'WALK', 'Con ritmo!', 0, 'neutral');

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (4, 'WALK', 'Usa esas piernas!', 0, 'angry');

-- ELEVACIONH --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'ELEVACIONH',
        'Elevemonos horizontalmente!',
        0,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (2, 'ELEVACIONH', 'Sigueme!', 1, 'sad');

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        3,
        'ELEVACIONH',
        'Esto nos servirá a nuestra flexibilidad!',
        0,
        'neutral'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        4,
        'ELEVACIONH',
        'Que gran servicio!',
        0,
        'angry'
    );

-- ELEVACIONV --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'ELEVACIONV',
        'Elevemonos verticalmente!',
        0,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        2,
        'ELEVACIONV',
        'Lo estas haciendo del chiras!',
        1,
        'sad'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        3,
        'ELEVACIONV',
        'Lentamente se gana la carrera!',
        0,
        'neutral'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (4, 'ELEVACIONV', 'Wuhu!', 0, 'angry');

-- GiRARTRONCO --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'GiRARTRONCO',
        'Giremos ese tronco!',
        0,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        2,
        'GiRARTRONCO',
        'No como los arboles, nuestro tronco es flexible!',
        0,
        'sad'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        3,
        'GiRARTRONCO',
        'Que grandes movimientos estamos haciendo!',
        0,
        'neutral'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (4, 'GiRARTRONCO', 'Yahu!', 0, 'angry');

-- GIRARCABEZA --
INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        1,
        'GIRARCABEZA',
        'Giremos esa cabeza!',
        0,
        'happy'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        2,
        'GIRARCABEZA',
        'Mueve esa cabeza como yo! mira!',
        0,
        'sad'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (
        3,
        'GIRARCABEZA',
        'Guau, ni me siento mareado. Tu?',
        0,
        'neutral'
    );

INSERT INTO
    frase_inspiracional (
        id,
        ejercicio,
        contenidos,
        tiempo_ejecucion,
        pwa_emocion
    )
VALUES
    (4, 'GIRARCABEZA', 'Encabezante!', 0, 'angry');
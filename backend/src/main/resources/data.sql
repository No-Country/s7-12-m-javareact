-- insert users --

INSERT INTO USERS (EMAIL, PASSWORD, ROLE)
VALUES
('maria@correo.com','$2a$10$6BOKBHct.1.6NvCb2UDBuOM.w1S7SC29ggEzhYO.LlffwfxD9kjta','ADMIN'),
('pedro@correo.com','$2a$10$6BOKBHct.1.6NvCb2UDBuOM.w1S7SC29ggEzhYO.LlffwfxD9kjta','ADMIN'),
('admin@movear.com','$2a$10$6BOKBHct.1.6NvCb2UDBuOM.w1S7SC29ggEzhYO.LlffwfxD9kjta','ADMIN'),
('user@test.com','$2a$10$6BOKBHct.1.6NvCb2UDBuOM.w1S7SC29ggEzhYO.LlffwfxD9kjta','ADMIN');

-- insert locations --

INSERT INTO LOCATIONS(ID_LOCATION, NAME)
VALUES
('06014030','Juan E. Barra'),
('06063030','Napaleofú'),
('06063040','Ramos Otero');


INSERT INTO LOCATIONS(ID_LOCATION, BRANCH, NAME)
VALUES
('02000010', 1,'Ciudad Autonoma de Buenos Aires'),
('14014010',2,'Córdoba'),
('06441030',3,'La Plata'),
('10077020',4,'Rosario'),
('66028050',5,'Salta');

-- insert customers --

INSERT INTO CUSTOMERS(FULL_NAME, FK_LOCATION, FK_USER, ADDRESS, DNI, NUMBER_LICENSE, DATE_EXPIRATION)
VALUES
('Maria Contrera','02000010',1,'Control','234234234','234234234','2026-09-12'),
('Pedro Perez','14014010',2,'Otra direccion','345345345','234234234','2029-09-12'),
('Admin Admin','10077020',3,'Otra direccion','6768768','4565466','2025-09-12'),
('Test Test','06441030',4,'Otra direccion','97979','456456','2049-09-12');

-- insert categories --

INSERT INTO CATEGORIES (NAME, DEFAULT_IMAGE_URL, VOLUME, CAPACITY_LIMIT, HOURLY_PRICE)
VALUES
('Small', 'https://res.cloudinary.com/dqkkehztd/image/upload/v1681482995/images/hb3zgcqmikxo8uot9zj8.jpg', 10.0, 1000.0, 40000.00),
('Medium', 'https://res.cloudinary.com/dqkkehztd/image/upload/v1681482995/images/yzrjmjhpcievk9vpdnw7.jpg', 20.0, 2000.0, 50000.00),
('Big', 'https://res.cloudinary.com/dqkkehztd/image/upload/v1681482995/images/jgwhblosqc1ebuxdeldu.jpg', 30.0, 3000.0, 60000.00);

INSERT INTO MEDIA (url_secure,title,type_format,public_id,bytes)
VALUES
('http://res.cloudinary.com/dqkkehztd/image/upload/v1681745805/images/z8wtixnalldh84utwcoa.jpg','gmc-m','image','images/z8wtixnalldh84utwcoa',
     36078),
('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746402/images/oerounydbls3c8u640g2.jpg',
    'chevrolet-m.jpg',
    'image',
    'images/oerounydbls3c8u640g2',
    36619),
('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746451/images/xfs5juazmxsz8mmjyjwh.jpg',
    'dodge-m',
    'image',
    'images/xfs5juazmxsz8mmjyjwh',
    36328),
    ('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746492/images/logc2vgnsulz68witljc.jpg',
    'volvo-l',
    'image',
    'images/logc2vgnsulz68witljc',
    53486),
('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746511/images/fxmsdyifvtmkif6asmnu.jpg',
    'mercedez-l',
    'image',
    'images/fxmsdyifvtmkif6asmnu',
    41600
),
('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746536/images/mecsukp5wiofivbiawgl.jpg',
    'kenworth-s',
    'image',
    'images/mecsukp5wiofivbiawgl',
    51609),
    ('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746564/images/poygxwiifd0jebdpgrrm.jpg',
    'mitsubishi-s',
    'image',
    'images/poygxwiifd0jebdpgrrm',
    51921),
    ('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746586/images/hpspha1yics5pk9iu48l.jpg',
    'isuzu-s',
    'image',
    'images/hpspha1yics5pk9iu48l',
    74650),
    ('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746605/images/v4zscwelvnqw0bhwkljo.jpg',
        'ford2-s',
    'image',
    'images/v4zscwelvnqw0bhwkljo',
    53753),
('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746633/images/cipgazp1me3xsdtphaur.jpg',
    'toyota-s',
   'image',
    'images/cipgazp1me3xsdtphaur',
    61280),
('http://res.cloudinary.com/dqkkehztd/image/upload/v1681746653/images/ttrjenaoptzisxqjutva.jpg',
    'ford-s',
    'image',
    'images/ttrjenaoptzisxqjutva',
    42016);




-- insert cars --

INSERT INTO CARS (MODEL, MAKE, YEAR, AIR, GPS, PASSENGERS, PATENT, LENGTH, WIDTH, HEIGHT, FK_LOCATION, ID_CATEGORY,ID_MEDIA)
VALUES
('Small Truck', 'Ford', 2022, true, true, 2, 'ABC123', 6000, 2200, 2400, '02000010', 1,9),
('Medium Truck', 'Chevrolet', 2021, true, false, 3, 'DEF456', 8000, 2500, 2800, '14014010', 2,2),
('Big Truck', 'Volvo', 2020, true, true, 4, 'GHI789', 10000, 3000, 3200, '06441030', 3,4),
('Small Truck', 'Toyota', 2023, true, true, 2, 'JKL123', 6000, 2200, 2400, '10077020', 1,10),
('Medium Truck', 'Dodge', 2022, true, false, 3, 'MNO456', 8000, 2500, 2800, '66028050', 2,3),
('Big Truck', 'Mercedes-Benz', 2021, true, true, 4, 'PQR789', 10000, 3000, 3200, '66028050', 3,5),
('Small Truck', 'Isuzu', 2022, true, true, 2, 'STU123', 6000, 2200, 2400, '10077020', 1,8),
('Medium Truck', 'GMC', 2021, true, false, 3, 'VWX456', 8000, 2500, 2800, '06441030', 2,1),
('Big Truck', 'Kenworth', 2020, true, true, 4, 'YZA789', 10000, 3000, 3200, '02000010', 1,6),
('Small Truck', 'Mitsubishi', 2022, true, true, 2, 'BCD123', 6000, 2200, 2400, '14014010', 1,7);
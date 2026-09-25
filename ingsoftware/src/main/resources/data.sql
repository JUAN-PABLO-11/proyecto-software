-- Se ejecuta automáticamente cada vez que la app arranca (después de crear las tablas)
-- y se borra junto con las tablas al cerrar la app (ddl-auto=create-drop)

INSERT INTO books (title, author, isbn) VALUES
                                            ('Cien años de soledad', 'Gabriel García Márquez', '9780307474728'),
                                            ('El amor en los tiempos del cólera', 'Gabriel García Márquez', '9780307389732'),
                                            ('Rayuela', 'Julio Cortázar', '9788437604572'),
                                            ('El principito', 'Antoine de Saint-Exupéry', '9780156012195'),
                                            ('1984', 'George Orwell', '9780451524935');

INSERT INTO ratings (book_id, username, score) VALUES
                                                   (1, 'laura',  5),
                                                   (1, 'carlos', 4),
                                                   (1, 'maria',  5),
                                                   (2, 'laura',  3),
                                                   (2, 'juan',   4),
                                                   (3, 'carlos', 2),
                                                   (4, 'maria',  5),
                                                   (4, 'juan',   5),
                                                   (4, 'laura',  4),
                                                   (5, 'carlos', 5);

INSERT INTO reviews (book_id, username, content) VALUES
                                                     (1, 'laura',  'Una obra maestra del realismo mágico. La historia de los Buendía me atrapó de principio a fin.'),
                                                     (1, 'carlos', 'Al inicio es difícil seguir a tantos personajes con el mismo nombre, pero vale la pena.'),
                                                     (2, 'juan',   'Una historia de amor preciosa, con una prosa muy cuidada.'),
                                                     (3, 'carlos', 'Interesante propuesta narrativa, aunque me resultó confusa en varias partes.'),
                                                     (4, 'maria',  'Un libro corto pero lleno de significado. Lo releo cada año.'),
                                                     (5, 'carlos', 'Inquietante y muy actual. Te deja pensando por días.');
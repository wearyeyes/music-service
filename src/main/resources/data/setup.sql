
CREATE TABLE album (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    duration INTERVAL HOUR TO SECOND,
    created_date DATE
);

CREATE TABLE song (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    duration INTERVAL MINUTE TO SECOND,
    album INT
    FOREIGN KEY(album) REFERENCES album(id)
);

CREATE TABLE author (
    id INT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birth_date DATE
);

CREATE TABLE m2m_author_album (
    author_id INT,
    album_id INT,
    FOREIGN KEY(author_id) REFERENCES author(id),
    FOREIGN KEY(album_id) REFERENCES album(id)
);

CREATE TABLE m2m_author_song (
    author_id INT,
    song_id INT,
    FOREIGN KEY(author_id) REFERENCES author(id),
    FOREIGN KEY(song_id) REFERENCES song(id)
);
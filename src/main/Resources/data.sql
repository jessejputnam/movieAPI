-- USER TABLE
CREATE TABLE IF NOT EXISTS user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);

-- GENRES TABLE
CREATE TABLE IF NOT EXISTS genre (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

-- SPECIFIC VIDEO'S GENRE TABLE
CREATE TABLE IF NOT EXISTS video_genre (
    id INT PRIMARY KEY AUTO_INCREMENT,
    genre_id INT,

    FOREIGN KEY (genre_id) REFERENCES genre(id)
);

-- LIST TABLE
CREATE TABLE IF NOT EXISTS list (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(255),
    user_id INT,

    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- VIDEOS TABLE
CREATE TABLE IF NOT EXISTS video (
    id INT PRIMARY KEY AUTO_INCREMENT,
    api_id INT,
    img_small VARCHAR(255),
    img_large VARCHAR(255),
    title VARCHAR(255),
    overview VARCHAR(2000),
    release_date VARCHAR(10),
    vote_average FLOAT(6,4),
    user_rating FLOAT(2,1),
    popularity FLOAT(8,4),
    video_genre_id INT,
    list_id INT,

    FOREIGN KEY (video_genre_id) REFERENCES video_genre(id),
    FOREIGN KEY (list_id) REFERENCES list(id)
);

-- SEED GENRE TYPES TO GENRE TABLE
INSERT IGNORE INTO genre (id, name) VALUES (28, "Action");
INSERT IGNORE INTO genre (id, name) VALUES (10759, "Action & Adventure");
INSERT IGNORE INTO genre (id, name) VALUES (12, "Adventure");
INSERT IGNORE INTO genre (id, name) VALUES (16, "Animation");
INSERT IGNORE INTO genre (id, name) VALUES (35, "Comedy");
INSERT IGNORE INTO genre (id, name) VALUES (80, "Crime");
INSERT IGNORE INTO genre (id, name) VALUES (99, "Documentary");
INSERT IGNORE INTO genre (id, name) VALUES (18, "Drama");
INSERT IGNORE INTO genre (id, name) VALUES (10751, "Family");
INSERT IGNORE INTO genre (id, name) VALUES (14, "Fantasy");
INSERT IGNORE INTO genre (id, name) VALUES (36, "History");
INSERT IGNORE INTO genre (id, name) VALUES (27, "Horror");
INSERT IGNORE INTO genre (id, name) VALUES (10762, "Kids");
INSERT IGNORE INTO genre (id, name) VALUES (10402, 'Music');
INSERT IGNORE INTO genre (id, name) VALUES (9648, "Mystery");
INSERT IGNORE INTO genre (id, name) VALUES (10763, "News");
INSERT IGNORE INTO genre (id, name) VALUES (10764, "Reality");
INSERT IGNORE INTO genre (id, name) VALUES (10749, "Romance");
INSERT IGNORE INTO genre (id, name) VALUES (878, "Science Fiction");
INSERT IGNORE INTO genre (id, name) VALUES (10765, "Sci-Fi & Fantasy");
INSERT IGNORE INTO genre (id, name) VALUES (10766, "Soap");
INSERT IGNORE INTO genre (id, name) VALUES (10767, "Talk");
INSERT IGNORE INTO genre (id, name) VALUES (53, "Thriller");
INSERT IGNORE INTO genre (id, name) VALUES (10770, "TV Movie");
INSERT IGNORE INTO genre (id, name) VALUES (10752, "War");
INSERT IGNORE INTO genre (id, name) VALUES (10768, "War & Politics");
INSERT IGNORE INTO genre (id, name) VALUES (37, "Western");
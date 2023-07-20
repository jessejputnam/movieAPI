-- ACCOUNT TABLE
CREATE TABLE IF NOT EXISTS account (
    account_id VARCHAR(255) PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    account_password VARCHAR(255)
);

-- LIST TABLE
CREATE TABLE IF NOT EXISTS list (
    list_id INT PRIMARY KEY AUTO_INCREMENT,
    list_type VARCHAR(255),
    account_id VARCHAR(255),

    FOREIGN KEY (account_id) REFERENCES account(account_id)
);

-- VIDEOS TABLE
CREATE TABLE IF NOT EXISTS video (
    video_id VARCHAR(255) PRIMARY KEY,
    api_id INT,
    img_small VARCHAR(255),
    img_large VARCHAR(255),
    title VARCHAR(255),
    overview VARCHAR(2000),
    release_date VARCHAR(10),
    vote_average FLOAT(6,4),
    user_rating FLOAT(2,1),
    popularity FLOAT(8,4),
    list_id INT,

    FOREIGN KEY (list_id) REFERENCES list(list_id)
);

-- GENRES TABLE
CREATE TABLE IF NOT EXISTS genre (
    genre_id INT PRIMARY KEY,
    genre_name VARCHAR(255)
);

-- SPECIFIC VIDEO'S GENRE TABLE (JUNCTION TABLE)
CREATE TABLE IF NOT EXISTS video_genre (
    video_id VARCHAR(255),
    genre_id INT,

    PRIMARY KEY (video_id, genre_id),
    FOREIGN KEY (video_id) REFERENCES video(video_id),
    FOREIGN KEY (genre_id) REFERENCES genre(genre_id)
);

-- SEED GENRE TYPES TO GENRE TABLE
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (28, "Action");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10759, "Action & Adventure");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (12, "Adventure");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (16, "Animation");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (35, "Comedy");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (80, "Crime");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (99, "Documentary");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (18, "Drama");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10751, "Family");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (14, "Fantasy");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (36, "History");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (27, "Horror");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10762, "Kids");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10402, 'Music');
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (9648, "Mystery");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10763, "News");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10764, "Reality");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10749, "Romance");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (878, "Science Fiction");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10765, "Sci-Fi & Fantasy");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10766, "Soap");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10767, "Talk");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (53, "Thriller");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10770, "TV Movie");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10752, "War");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (10768, "War & Politics");
INSERT IGNORE INTO genre (genre_id, genre_name) VALUES (37, "Western");
-- Database: TEMUD

CREATE TABLE characters (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    race TEXT NOT NULL,
    class TEXT NOT NULL,
    strength INT NOT NULL,
    health INT NOT NULL,
    wisdom INT NOT NULL,
    intelligence INT NOT NULL,
    agility INT NOT NULL,
    level_up_speed INT DEFAULT 1,
    attack_bonus INT DEFAULT 0,
    fire_damage_multiplier INT DEFAULT 1
);

CREATE TABLE rooms (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL
);

CREATE TABLE monsters (
    id SERIAL PRIMARY KEY,
    room_id INT REFERENCES rooms(id),
    name TEXT NOT NULL,
    health INT NOT NULL,
    attack INT NOT NULL
);

CREATE TABLE exits (
    from_room_id INT REFERENCES rooms(id),
    to_room_id INT REFERENCES rooms(id),
    direction TEXT NOT NULL,
    PRIMARY KEY (from_room_id, to_room_id, direction)
);

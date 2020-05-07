CREATE TABLE game
(
    id bigint auto_increment primary key,
);

CREATE TABLE team
(
    id   bigint auto_increment primary key,
    name varchar(45),
);

CREATE TABLE game_has_team
(
    game_id  bigint references game (id),
    team_id  bigint references team (id),
    position varchar(45),
    valid    boolean,
    score    int
);

CREATE TABLE player
(
    id          bigint primary key,
    team_id     bigint references team (id),
    match_order int,
    name        varchar(45)
);

CREATE TABLE action
(
    id     bigint,
    result varchar(45)
);

CREATE TABLE player_has_action
(
    player_id bigint references player (id),
    action_id bigint references action (id),
    game_id   bigint references game (id),
    inning    int,
    turn      varchar(45),
    count     int
);

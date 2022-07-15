INSERT INTO status (id, name, code, created_at, updated_at) VALUES (1, 'In progress', 'IPS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO status (id, name, code, created_at, updated_at) VALUES (2, 'Completed', 'CPD', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO states (id, name, code, created_at, updated_at) VALUES (1, 'IDLE', 'IDE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO states (id, name, code, created_at, updated_at) VALUES (2, 'LOADING', 'LDG', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO states (id, name, code, created_at, updated_at) VALUES (3, 'LOADED', 'LDD', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO states (id, name, code, created_at, updated_at) VALUES (4, 'DELIVERING', 'DLG', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO states (id, name, code, created_at, updated_at) VALUES (5, 'DELIVERED', 'DLD', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO states (id, name, code, created_at, updated_at) VALUES (6, 'RETURNING', 'RTG', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO models (id, name, code, created_at, updated_at) VALUES (1, 'Lightweight', 'LWT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO models (id, name, code, created_at, updated_at) VALUES (2, 'Middleweight', 'MWT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO models (id, name, code, created_at, updated_at) VALUES (3, 'Cruiserweight', 'CWT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO models (id, name, code, created_at, updated_at) VALUES (4, 'Heavyweight', 'HWT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
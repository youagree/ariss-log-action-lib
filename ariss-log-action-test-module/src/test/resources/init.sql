CREATE SCHEMA log_action_test;

CREATE USER action_admin WITH password 'squd';

ALTER USER action_admin WITH SUPERUSER;

GRANT USAGE ON SCHEMA log_action_test TO action_admin;

ALTER SCHEMA log_action_test OWNER TO action_admin;

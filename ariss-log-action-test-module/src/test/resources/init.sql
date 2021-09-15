CREATE SCHEMA log_action_test;

CREATE USER log_admin WITH password 'squd';

ALTER USER log_admin WITH SUPERUSER;

GRANT USAGE ON SCHEMA log_action_test TO log_admin;

ALTER SCHEMA log_action_test OWNER TO log_admin;

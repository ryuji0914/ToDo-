DROP TABLE IF EXISTS todo;

CREATE TABLE todo (
	task_id SERIAL PRIMARY KEY,
	task_name VARCHAR(100) NOT NULL,
	detail TEXT,
	priority  VARCHAR(20),
	todo_status VARCHAR(20),
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP
);
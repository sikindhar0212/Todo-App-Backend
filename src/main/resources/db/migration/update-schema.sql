CREATE TABLE todo.todo
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    username      VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    target_date   datetime NULL,
    is_done       BIT(1) NULL,
    CONSTRAINT pk_todo PRIMARY KEY (id)
);
DROP TABLE IF EXISTS EditorData;

CREATE TABLE EditorContent
(
    Id         INT PRIMARY KEY,
    EditorData varchar(max) DEFAULT NULL
);

INSERT INTO EditorContent(Id, EditorData)
VALUES (0, '');

INSERT INTO EditorContent(Id, EditorData)
VALUES (1, '');
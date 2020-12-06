DROP TABLE IF EXISTS EditorData;

CREATE TABLE EditorContent (
  Id INT AUTO_INCREMENT  PRIMARY KEY,
  EditorData varchar(max) DEFAULT NULL
);

INSERT INTO EditorContent(EditorData) VALUES ( '' );
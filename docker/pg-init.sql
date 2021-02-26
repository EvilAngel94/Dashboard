CREATE TABLE Interactable (
    id int PRIMARY KEY,
    redirectionUrl VARCHAR(255),
    placeholderSrc VARCHAR(255),
    src VARCHAR(255),
    slug VARCHAR(255),
    gif VARCHAR(255),
    title VARCHAR(255)
)

-- Insert some base values in the interactable table
INSERT INTO interactable
VALUES (1, 'https://www.todoist.com', 'todo-btn.png', 'todo-btn.png', '', 'interactive/todo-interaction-btn.gif', 'Todoist'),
 (2, 'https://www.autodraw.com/', 'sketching-btn.png', 'sketching-btn.png', '', 'interactive/sketching-interaction-btn.gif', 'Sketching'),
 (3, 'https://www.gmail.com', 'pers-mail-btn.png', 'pers-mail-btn.png', '', 'interactive/pers-mail-interaction-btn.gif', 'Personal Mail'),
 (4, 'https://www.outlook.com', 'work-mail-btn.png', 'work-mail-btn.png', '', 'interactive/work-mail-interaction-btn.gif', 'Work Mail'),
 (5, 'https://drive.google.com/', 'google-drive-btn.png', 'google-drive-btn.png', '', 'interactive/google-drive-interaction-btn.gif', 'Google Drive'),
 (6, '', 'weather-forecast-btn.png', 'weather-forecast-btn.png', 'weather', 'interactive/weather-forecast-interaction-btn.gif', 'Weather Forecast')
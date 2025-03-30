-- INSERT INTO venues ( venue_id, venue_name, location)
-- VALUES
--     ('Grand Hall', 'New York'),
--     ('Sunset Arena', 'Los Angeles'),
--     ('Ocean View Stadium', 'Miami'),
--     ('Royal Theater', 'London'),
--     ('Skyline Convention Center', 'Tokyo');

INSERT INTO venues values (default, 'Grand Hall' ,'New York'

);

-- UPDATE venues SET venue_name='thavorn' , location='phom penh' WHERE venue_id=1;

INSERT INTO attendees (attendee_name, email)
VALUES
    ('Oggy', 'oggy@example.com'),
    ('Jack', 'jack@example.com'),
    ('DeeDee', 'deedee@example.com'),
    ('Marky', 'marky@example.com'),
    ('Joey', 'joey@example.com');

INSERT INTO events (event_name, event_date, venue_id)
VALUES
    ('Tech  2025', '2025-06-15', 4),
    ('Music ', '2025-07-20', 5),
    ('Startup', '2025-08-05', 6),
    ('Film ', '2025-09-12', 7);


INSERT INTO  event_attendee (event_id, attendees_id) VALUES
                                                         (19 , 3);

SELECT * FROM event_attendee sc INNER JOIN attendees a ON sc.attendees_id = a.attendee_id WHERE event_id = 19;

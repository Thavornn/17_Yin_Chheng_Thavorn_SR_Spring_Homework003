CREATE TABLE IF NOT EXISTS venues (
    venue_id SERIAL PRIMARY KEY  ,
    venue_name VARCHAR (100)  NOT NULL ,
    location VARCHAR (100) NOT NULL
);

CREATE TABLE IF NOT EXISTS attendees(

                                        attendee_id SERIAL PRIMARY KEY  ,
                                        attendee_name VARCHAR (100)  NOT NULL ,
                                        email VARCHAR (100) NOT NULL

);

CREATE TABLE IF NOT EXISTS events (
                        event_id SERIAL PRIMARY KEY,
                        event_name VARCHAR(255) NOT NULL,
                        event_date DATE NOT NULL,
                        venue_id INT,
                        FOREIGN KEY (venue_id) REFERENCES venues(venue_id) ON DELETE CASCADE
                                  ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS event_attendee(
    id SERIAL PRIMARY KEY ,
    event_id INT,
    attendees_id INT,
    FOREIGN KEY (event_id) REFERENCES  events(event_id)
                                         ON DELETE CASCADE
                                         ON UPDATE CASCADE ,
    FOREIGN KEY  (attendees_id) REFERENCES attendees(attendee_id)
                                         ON DELETE CASCADE
                                         ON UPDATE CASCADE

);
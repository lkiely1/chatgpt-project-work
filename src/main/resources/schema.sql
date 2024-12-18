-- Create Household table
CREATE TABLE household (
                           eircode VARCHAR(10) PRIMARY KEY,
                           number_of_occupants INT NOT NULL,
                           max_number_of_occupants INT NOT NULL,
                           is_owner_occupied BOOLEAN,
                           number_of_pets INT NOT NULL
);

-- Create Pet table
CREATE TABLE pet (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(100) NOT NULL,
                     animal_type VARCHAR(50) NOT NULL,
                     breed VARCHAR(100),
                     age INT,
                     eircode VARCHAR(10) NOT NULL,
                     FOREIGN KEY (eircode) REFERENCES household(eircode)
);

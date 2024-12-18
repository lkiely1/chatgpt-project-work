-- Insert sample data for Household
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, is_owner_occupied, number_of_pets)
VALUES
    ('D01AB23', 3, 4, TRUE, 2),
    ('D02CD34', 2, 3, FALSE, 1),
    ('D03EF45', 1, 2, TRUE, 0);

-- Insert sample data for Pet
INSERT INTO pet (name, animal_type, breed, age, eircode)
VALUES
    ('Rex', 'Dog', 'Labrador', 5, 'D01AB23'),
    ('Bella', 'Cat', 'Siamese', 3, 'D01AB23'),
    ('Charlie', 'Dog', 'Beagle', 2, 'D02CD34');

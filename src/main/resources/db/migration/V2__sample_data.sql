-- Insert sample persons
INSERT INTO person (id, given_name, family_name, gender, birth_date)
VALUES
  ('11111111-1111-1111-1111-111111111111', 'Arin', 'Kandala', 'Male', '1990-05-15'),
  ('22222222-2222-2222-2222-222222222222', 'Maya', 'Kandala', 'Female', '1992-08-20'),
  ('33333333-3333-3333-3333-333333333333', 'Rohan', 'Kandala', 'Male', '2015-03-10'),
  ('44444444-4444-4444-4444-444444444444', 'Anya', 'Kandala', 'Female', '2018-07-05');

-- Insert relationships
-- Arin and Maya are spouses
INSERT INTO relationship (id, from_person, to_person, rel_type)
VALUES
  ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '11111111-1111-1111-1111-111111111111', '22222222-2222-2222-2222-222222222222', 'spouse');

-- Arin and Maya are parents of Rohan
INSERT INTO relationship (id, from_person, to_person, rel_type)
VALUES
  ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '11111111-1111-1111-1111-111111111111', '33333333-3333-3333-3333-333333333333', 'parent'),
  ('aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaa3', '22222222-2222-2222-2222-222222222222', '33333333-3333-3333-3333-333333333333', 'parent');

-- Arin and Maya are parents of Anya
INSERT INTO relationship (id, from_person, to_person, rel_type)
VALUES
  ('aaaaaaa4-aaaa-aaaa-aaaa-aaaaaaaaaaa4', '11111111-1111-1111-1111-111111111111', '44444444-4444-4444-4444-444444444444', 'parent'),
  ('aaaaaaa5-aaaa-aaaa-aaaa-aaaaaaaaaaa5', '22222222-2222-2222-2222-222222222222', '44444444-4444-4444-4444-444444444444', 'parent');


-- Insert sample persons (id will auto-generate)
INSERT INTO person (given_name, birth_date) VALUES
  ('Arin', '1990-01-01'),
  ('Maya', '1992-05-12'),
  ('Krishna', '2015-07-20'),
  ('Radha', '2018-03-15');

-- Insert relationships by selecting IDs dynamically
-- SPOUSE Arin <-> Maya
INSERT INTO relationship (from_person, to_person, rel_type)
SELECT p1.id, p2.id, 'SPOUSE'
FROM person p1, person p2
WHERE p1.given_name = 'Arin' AND p2.given_name = 'Maya';

INSERT INTO relationship (from_person, to_person, rel_type)
SELECT p2.id, p1.id, 'SPOUSE'
FROM person p1, person p2
WHERE p1.given_name = 'Arin' AND p2.given_name = 'Maya';

-- PARENT relationships
INSERT INTO relationship (from_person, to_person, rel_type)
SELECT p1.id, c.id, 'PARENT'
FROM person p1, person c
WHERE p1.given_name = 'Arin' AND c.given_name IN ('Krishna','Radha');

INSERT INTO relationship (from_person, to_person, rel_type)
SELECT p2.id, c.id, 'PARENT'
FROM person p2, person c
WHERE p2.given_name = 'Maya' AND c.given_name IN ('Krishna','Radha');

-- SIBLING relationships
INSERT INTO relationship (from_person, to_person, rel_type)
SELECT c1.id, c2.id, 'SIBLING'
FROM person c1, person c2
WHERE c1.given_name = 'Krishna' AND c2.given_name = 'Radha';

INSERT INTO relationship (from_person, to_person, rel_type)
SELECT c2.id, c1.id, 'SIBLING'
FROM person c1, person c2
WHERE c1.given_name = 'Krishna' AND c2.given_name = 'Radha';

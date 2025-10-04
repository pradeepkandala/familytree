-- Enable UUID extension for unique IDs
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Person table
CREATE TABLE person (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    given_name TEXT NOT NULL,
    middle_name TEXT,
    family_name TEXT,
    gender TEXT,
    birth_date DATE,
    death_date DATE,
    birthplace TEXT,
    gotra TEXT,
    notes TEXT,
    created_at TIMESTAMPTZ DEFAULT now(),
    updated_at TIMESTAMPTZ DEFAULT now(),
    deleted BOOLEAN DEFAULT FALSE
);

-- Relationship table (links two persons with a type)
CREATE TABLE relationship (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    from_person UUID NOT NULL REFERENCES person(id) ON DELETE CASCADE,
    to_person UUID NOT NULL REFERENCES person(id) ON DELETE CASCADE,
    rel_type TEXT NOT NULL, -- e.g., parent, spouse, sibling
    start_date DATE,
    end_date DATE,
    created_at TIMESTAMPTZ DEFAULT now()
);

-- Indexes to speed up queries on relationships
CREATE INDEX idx_rel_from ON relationship(from_person);
CREATE INDEX idx_rel_to ON relationship(to_person);

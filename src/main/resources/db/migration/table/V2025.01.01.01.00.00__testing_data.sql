INSERT INTO farmer (id, name) VALUES
('0f6b4463-4f82-49ad-b7a3-d26ab0a4d52b', 'John Doe'),
('8c4a2782-ae49-4347-a09f-9e4c5c4b99f5', 'Jane Smith');

INSERT INTO crop_type (id, name) VALUES
('a50c94d6-1e7f-4df2-b9eb-5c1e8b1e7b53', 'Corn'),
('f2f42295-8590-4a63-b6fd-1654bba76b28', 'Potatoes'),
('3e7e2d02-982d-47d7-8220-886a4d4b22d2', 'Wheat');

INSERT INTO field (id, planting_area, farmer_id) VALUES
('d05b5c25-32d3-404a-837d-6483b37a8f52', 10.5, '0f6b4463-4f82-49ad-b7a3-d26ab0a4d52b'), -- John Doe's field
('3c5e2d71-f61b-4870-8597-3a2065aa83e5', 8.2, '8c4a2782-ae49-4347-a09f-9e4c5c4b99f5');  -- Jane Smith's field

INSERT INTO harvest (id, crop_type_id, actual_product, season, field_id) VALUES
('7b294fc4-85fd-4b8f-b8ed-3f2d9cfcb8f2', 'a50c94d6-1e7f-4df2-b9eb-5c1e8b1e7b53', 100.5, 'SUMMER', 'd05b5c25-32d3-404a-837d-6483b37a8f52'), -- Corn harvested by John Doe in Spring
('a5c424c2-50e4-4cb6-81b7-f3e209a51297', 'f2f42295-8590-4a63-b6fd-1654bba76b28', 75.2, 'WINTER', '3c5e2d71-f61b-4870-8597-3a2065aa83e5');  -- Potatoes harvested by Jane Smith in Summer

INSERT INTO plant (id, crop_type_id, expected_product, season, field_id) VALUES
('f5e8dc49-3b85-4c8f-b760-1912e45f7c4e', 'a50c94d6-1e7f-4df2-b9eb-5c1e8b1e7b53', 120.0, 'SUMMER', 'd05b5c25-32d3-404a-837d-6483b37a8f52'), -- Corn planted by John Doe in Spring
('8c4a2782-ae49-4347-a09f-9e4c5c4b99f5', 'f2f42295-8590-4a63-b6fd-1654bba76b28', 80.0, 'WINTER', '3c5e2d71-f61b-4870-8597-3a2065aa83e5');  -- Potatoes planted by Jane Smith in Summer

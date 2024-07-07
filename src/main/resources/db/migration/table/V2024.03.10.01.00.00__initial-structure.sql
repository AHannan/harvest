CREATE TABLE farmer (
    id                      VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE crop_type (
    id                      VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE field (
    id                      VARCHAR(255) PRIMARY KEY,
    planting_area DOUBLE PRECISION NOT NULL,
    farmer_id VARCHAR(255) NOT NULL,
CONSTRAINT fk_farmer_field FOREIGN KEY (farmer_id) REFERENCES farmer(id)
);

CREATE TABLE harvest (
    id                      VARCHAR(255) PRIMARY KEY,
    crop_type_id VARCHAR(255) NOT NULL,
    actual_product DOUBLE PRECISION NOT NULL,
    season VARCHAR(10) NOT NULL,
    field_id VARCHAR(255) NOT NULL,
CONSTRAINT fk_crop_type_harvest FOREIGN KEY (crop_type_id) REFERENCES crop_type(id),
CONSTRAINT fk_field_harvest FOREIGN KEY (field_id) REFERENCES field(id)
);

CREATE TABLE plant (
    id                      VARCHAR(255) PRIMARY KEY,
    crop_type_id VARCHAR(255) NOT NULL,
    expected_product DOUBLE PRECISION NOT NULL,
    season VARCHAR(10) NOT NULL,
    field_id VARCHAR(255) NOT NULL,
CONSTRAINT fk_crop_type_plant FOREIGN KEY (crop_type_id) REFERENCES crop_type(id),
CONSTRAINT fk_field_plant FOREIGN KEY (field_id) REFERENCES field(id)
);

# Harvest Spring Boot Application

## Introduction
Organization “Harvest”  wants to collect information from Farmers for every field for every season, per farm (2 API):
1. Planted:   	
   a. Planting Area (in acres).
   b. Type of crops planted.
   c. Amount of Expected product (in tons)
2. Harvested:
   a. Actual amount of harvested product.
   Organization “Harvest”  want to see reports for every season shows expected vs actual amount of product:
    1. For each farm
    2. For each Type of crops


## API Endpoints
By default, the application runs on `http://localhost:8080`.

### Submit Harvest Data

```http
POST /api/farm-controller/harvest
```
#### Request Body

```json
{
  "cropTypeId": "3e7e2d02-982d-47d7-8220-886a4d4b22d2",
  "actualProduct": 100.5,  
  "fieldId": "d05b5c25-32d3-404a-837d-6483b37a8f52",
  "season": "SPRING"
}
```

### Submit Plant Data

```http
POST /api/farm-controller/plant
```

#### Request Body

```json
{
    "cropTypeId": "f2f42295-8590-4a63-b6fd-1654bba76b28",
    "expectedProduct": 200.5,
    "fieldId": "3c5e2d71-f61b-4870-8597-3a2065aa83e5",
    "season": "SUMMER"
}
```

### Generate Farm Report
```http
GET /api/farm-controller/reports/farmer/{farmerId}
```

### Generate Crop Report
```http
GET /api/farm-controller/reports/crop/{cropTypeId}
```

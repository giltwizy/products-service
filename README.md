# PRODUCTS REST API
This service is written in Java and uses Spring Boot to provide a REST API.

### Exposed API

1. [x] Add new product
```
curl --location 'http://localhost:9000/api/v1/addProduct' \
--header 'Content-Type: application/json' \
--data '{
    "productName": "mobile phone",
    "productQuantity": 3,
    "productPrice": 600000
}'
```

2. [x] Add new products
```
curl --location 'http://localhost:9000/api/v1/addProducts' \
--header 'Content-Type: application/json' \
--data '[
{
    "productName": "Truncker",
    "productQuantity": 2,
    "productPrice": 30000
},
{
    "productName": "Nissan",
    "productQuantity": 1,
    "productPrice": 2000000
},
{
    "productName": "Hill Drinking water",
    "productQuantity": 4,
    "productPrice": 2000
}
]'
```

3. [x] Get products
```
curl --location 'http://localhost:9000/api/v1/products' \
--data ''
```

4. [x] Get product by Id
```
curl --location 'http://localhost:9000/api/v1/productById/4' \
--data ''
```

5. [x] Get product by Name
```
curl --location 'http://localhost:9000/api/v1/productByName/Truncker' \
--data ''
```

6. [x] Update a product
```
curl --location --request PUT 'http://localhost:9000/api/v1/update' \
--header 'Content-Type: application/json' \
--data '{
        "productId": 3,
        "productName": "Dasani Drinking water",
        "productPrice": 2000.0,
        "productQuantity": 4
    }'
```

7. [x] Delete a product
```
curl --location --request DELETE 'http://localhost:9000/api/v1/delete/1' \
--data ''
```

# Languages and Tools
<p> <a href="https://www.docker.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> </a> <a href="https://www.spring.io" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="java" width="40" height="40"/> </a></p>
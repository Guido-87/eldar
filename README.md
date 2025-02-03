# Endpoints disponibles:

#### Crear persona: POST /api/personas
#### Eliminar persona por ID: DELETE /api/personas/{id}
#### Crear tarjeta: POST /api/tarjetas
#### Eliminar tarjeta por ID: DELETE /api/tarjetas/{id}
#### Realizar una compra: POST /api/compras
#### Obtener detalle de una compra: GET /api/compras/{id}

# Como ejecutar la aplicación:
Dentro de la ruta del proyecto, ejecutar en una terminal:
#### mvn spring-boot:run

# Como ejecutar los tests:
Descomentar la línea #spring.profiles.active=test en application.properties

# Como ejecutar el detector de fraude:
Ejecutar el método main de la clase DetectorFraude dentro del paquete utils
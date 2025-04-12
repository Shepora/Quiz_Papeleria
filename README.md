AQUI SE VA A EXPLICAR COMO SE VAN A HACER LAS PETICIONES A POSTMAN Y COMO FUNCIONAN.

1. Ventas realizadas por un empleado con sus respectivos clientes
 Endpoint: GET /api/ventas/por-empleado/{id}
//Este Endpoint nos permite consultar todas las ventas que han sido realizadas por un empleado en especifico, asi mismo mostrando los datos del cliente y su respectiva fecha
 //EJEMPLO
 [
    {
        "cliente": "Cliente 23",
        "fecha": "2025-01-17",
        "empleado": "Empleado 95",
        "idVenta": 3
    }
]
 Consulta SQL:
 SELECT v.id_venta, e.nombre AS empleado, c.nombre AS cliente, v.fecha
 FROM venta v
 JOIN empleado e ON v.id_empleado = e.id_empleado
 JOIN cliente c ON v.id_cliente = c.id_cliente
 WHERE v.id_empleado = :idEmpleado
 //Esta consulta nos va a devolver los sugientes datos (ID de la venta, Nombre del empleado, Nombre del cliente,
Fecha de la venta)

 
 2. Ventas de un empleado por fecha
 Endpoint: GET /api/ventas/por-empleado-fecha?empleado={id}&fecha=YYYY-MM-DD
 //Este nos permite obtener todas las ventas realizadas por un empleado en una fecha especifica.
 //Ejemplo 
 [
    {
        "cliente": "Cliente 42",
        "fecha": "2025-02-20",
        "empleado": "Empleado 55",
        "idVenta": 1
    }
]
 Consulta SQL:
 SELECT v.id_venta, e.nombre AS empleado, c.nombre AS cliente, v.fecha
 FROM venta v
 JOIN empleado e ON v.id_empleado = e.id_empleado
 JOIN cliente c ON v.id_cliente = c.id_cliente
 WHERE v.id_empleado = :idEmpleado AND v.fecha = :fecha
 //Esta consulta nos va a devolver los sugientes datos (ID de la venta, Nombre del empleado, Nombre del cliente,
Fecha de la venta)
 
 3. Productos que ofrece un proveedor
 Endpoint: GET /proveedores/{id}/productos
 //Este Endpoint nos muestra todos los productos que estan asociados con un proveedor en especifico.
//Ejemplo
     {
        "nombre": "Producto 1",
        "descripcion": "Producto de ejemplo número 1",
        "id_producto": 2,
        "stock": 23,
        "precio": 17.14
    },
    {
        "nombre": "Producto 11",
        "stock": 47,
        "descripcion": "Producto de ejemplo número 11",
        "precio": 55.49,
        "id_producto": 12
    },
    {
        "stock": 41,
        "descripcion": "Producto de ejemplo número 21",
        "precio": 65.76,
        "id_producto": 22,
        "nombre": "Producto 21"
    },
 Consulta SQL:
 SELECT p.id_producto, p.nombre, p.descripcion, p.precio, p.stock
 FROM producto p
 WHERE p.id_proveedor = :idProveedor
 //Esta consulta nos va a devolver los sugientes datos (ID del producto, Nombre, Descripción
Precio, Stock disponible)
 
 4. Clientes con el detalle de venta
 Endpoint: GET /api/clientes/detalle-ventas
 //Este Endpoint nos permite consultar el detalle de todas las ventas realizadas por cada cliente,
ademas de incluir los productos comprados, su cantidad y el precio unitario.
//Ejemplo
 {
        "cliente": "Cliente 99",
        "precioUnitario": 32.84,
        "cantidad": 3,
        "producto": "Producto 63",
        "idVenta": 49
    },
    {
        "cliente": "Cliente 99",
        "precioUnitario": 91.14,
        "cantidad": 4,
        "producto": "Producto 8",
        "idVenta": 49
    },
    {
        "cliente": "Cliente 99",
        "precioUnitario": 19.11,
        "cantidad": 5,
        "producto": "Producto 53",
        "idVenta": 49
    },
 Consulta SQL:
 SELECT c.nombre AS cliente, v.id_venta, dv.cantidad, dv.precio_unitario, p.nombre AS producto
 FROM cliente c
JOIN venta v ON c.id_cliente = v.id_cliente
 JOIN detalle_venta dv ON v.id_venta = dv.id_venta
 JOIN producto p ON dv.id_producto = p.id_producto
//Esta consulta nos va a devolver los sugientes datos (Nombre del cliente, ID de la venta, Cantidad de productos comprados, 
Precio unitario de cada producto, Nombre del producto)

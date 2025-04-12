package Repository;

import Model.detalle_venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Detalle_VentaRepository extends JpaRepository<detalle_venta, Long> {

    @Query(value = "SELECT dv.id_detalle, v.id_venta, c.nombre AS cliente, p.nombre AS producto, dv.cantidad, dv.precio_unitario " +
            "FROM detalle_venta dv " +
            "JOIN venta v ON dv.id_venta = v.id_venta " +
            "JOIN cliente c ON v.id_cliente = c.id_cliente " +
            "JOIN producto p ON dv.id_producto = p.id_producto", nativeQuery = true)
    List<Object[]> findDetalleVentasConClienteYProducto();
}

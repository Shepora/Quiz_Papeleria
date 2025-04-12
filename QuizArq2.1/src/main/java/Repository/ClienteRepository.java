package Repository;

import Model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<cliente, Long> {
    @Query(value = "SELECT c.nombre AS cliente, v.id_venta, dv.cantidad, dv.precio_unitario, p.nombre AS producto " +
            "FROM cliente c " +
            "JOIN venta v ON c.id_cliente = v.id_cliente " +
            "JOIN detalle_venta dv ON v.id_venta = dv.id_venta " +
            "JOIN producto p ON dv.id_producto = p.id_producto", nativeQuery = true)
    List<Object[]> findClientesConDetalleVentaRaw();

}


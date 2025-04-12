package Repository;

import Model.empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface EmpleadoRepository extends JpaRepository<empleado, Long> {

    @Query(value = """
        SELECT v.id_venta, v.fecha, c.nombre AS cliente
        FROM venta v
        JOIN cliente c ON v.id_cliente = c.id_cliente
        WHERE v.id_empleado = :idEmpleado
    """, nativeQuery = true)
    List<Map<String, Object>> findVentasConClientesPorEmpleado(Long idEmpleado);
}
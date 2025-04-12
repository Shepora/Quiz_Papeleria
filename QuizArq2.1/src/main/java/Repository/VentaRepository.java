package Repository;

import Model.venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<venta, Long> {

    @Query(value = "SELECT v.id_venta, e.nombre AS empleado, c.nombre AS cliente, v.fecha " +
            "FROM venta v " +
            "JOIN empleado e ON v.id_empleado = e.id_empleado " +
            "JOIN cliente c ON v.id_cliente = c.id_cliente " +
            "WHERE v.id_empleado = :idEmpleado", nativeQuery = true)
    List<Object[]> findVentasByEmpleado(@Param("idEmpleado") Long idEmpleado);

    @Query(value = "SELECT v.id_venta, e.nombre AS empleado, c.nombre AS cliente, v.fecha " +
            "FROM venta v " +
            "JOIN empleado e ON v.id_empleado = e.id_empleado " +
            "JOIN cliente c ON v.id_cliente = c.id_cliente " +
            "WHERE v.id_empleado = :idEmpleado AND v.fecha = :fecha", nativeQuery = true)
    List<Object[]> findVentasPorEmpleadoYFecha(@Param("idEmpleado") Long idEmpleado,
                                               @Param("fecha") LocalDate fecha);
}

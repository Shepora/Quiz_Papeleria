package Service;

import Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Map<String, Object>> obtenerVentasPorEmpleado(Long idEmpleado) {
        List<Object[]> resultados = ventaRepository.findVentasByEmpleado(idEmpleado);
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> map = new HashMap<>();
            map.put("idVenta", fila[0]);
            map.put("empleado", fila[1]);
            map.put("cliente", fila[2]);
            map.put("fecha", fila[3]);
            lista.add(map);
        }

        return lista;
    }

    public List<Map<String, Object>> obtenerVentasPorEmpleadoYFecha(Long idEmpleado, LocalDate fecha) {
        List<Object[]> resultados = ventaRepository.findVentasPorEmpleadoYFecha(idEmpleado, fecha);
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> map = new HashMap<>();
            map.put("idVenta", fila[0]);
            map.put("empleado", fila[1]);
            map.put("cliente", fila[2]);
            map.put("fecha", fila[3]);
            lista.add(map);
        }

        return lista;
    }
}
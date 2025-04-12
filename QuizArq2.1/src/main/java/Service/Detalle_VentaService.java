package Service;

import Repository.Detalle_VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Detalle_VentaService {
    @Autowired
    private Detalle_VentaRepository detalleVentaRepository;

    public List<Map<String, Object>> obtenerDetalleVentas() {
        List<Object[]> resultados = detalleVentaRepository.findDetalleVentasConClienteYProducto();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> map = new HashMap<>();
            map.put("idDetalle", fila[0]);
            map.put("idVenta", fila[1]);
            map.put("cliente", fila[2]);
            map.put("producto", fila[3]);
            map.put("cantidad", fila[4]);
            map.put("precioUnitario", fila[5]);
            lista.add(map);
        }

        return lista;
    }
}
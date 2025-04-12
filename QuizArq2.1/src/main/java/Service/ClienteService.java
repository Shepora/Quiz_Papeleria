package Service;

import Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Map<String, Object>> obtenerClientesConDetalleDeVenta() {
        List<Object[]> resultados = clienteRepository.findClientesConDetalleVentaRaw();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> filaMap = new HashMap<>();
            filaMap.put("cliente", fila[0]);
            filaMap.put("idVenta", fila[1]);
            filaMap.put("cantidad", fila[2]);
            filaMap.put("precioUnitario", fila[3]);
            filaMap.put("producto", fila[4]);
            lista.add(filaMap);
        }

        return lista;
    }

}

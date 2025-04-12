package Controller;


import Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/detalle-ventas")
    public ResponseEntity<List<Map<String, Object>>> getClientesConDetalleVentas() {
        List<Map<String, Object>> clientes = clienteService.obtenerClientesConDetalleDeVenta();
        return ResponseEntity.ok(clientes);
    }

}

package Controller;


import Service.Detalle_VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/detalle-ventas")
public class Detalle_VentaController {

    @Autowired
    private Detalle_VentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getDetalleVentas() {
        return ResponseEntity.ok(detalleVentaService.obtenerDetalleVentas());
    }
}
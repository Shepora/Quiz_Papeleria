package Controller;

import Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping("/por-empleado/{id}")
    public ResponseEntity<List<Map<String, Object>>> getVentasPorEmpleado(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.obtenerVentasPorEmpleado(id));
    }

    @GetMapping("/por-empleado-fecha")
    public ResponseEntity<List<Map<String, Object>>> getVentasPorEmpleadoYFecha(
            @RequestParam("empleado") Long idEmpleado,
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(ventaService.obtenerVentasPorEmpleadoYFecha(idEmpleado, fecha));
    }
}
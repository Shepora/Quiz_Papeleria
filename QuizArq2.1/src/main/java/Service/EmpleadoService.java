package Service;

import Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Map<String, Object>> obtenerVentasConClientes(Long idEmpleado) {
        return empleadoRepository.findVentasConClientesPorEmpleado(idEmpleado);
    }
}
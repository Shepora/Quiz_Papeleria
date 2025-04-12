package Service;


import Repository.ProductoRepository;
import Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Map<String, Object>> obtenerProductosPorProveedor(Long idProveedor) {
        return proveedorRepository.findProductosPorProveedor(idProveedor);
    }
}


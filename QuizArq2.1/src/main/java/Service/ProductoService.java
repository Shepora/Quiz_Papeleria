package Service;

import Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Map<String, Object>> obtenerProductosPorProveedor(Long idProveedor) {
        return productoRepository.findProductosPorProveedor(idProveedor);
    }
}
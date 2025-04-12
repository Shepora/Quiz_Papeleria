package Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProveedor;

    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    @OneToMany(mappedBy = "proveedor")
    private List<producto> productos;

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<producto> getProductos() {
        return productos;
    }

    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }
}

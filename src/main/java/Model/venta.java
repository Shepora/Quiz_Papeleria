package Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private empleado empleado;

    @OneToMany(mappedBy = "venta")
    private List<detalle_venta> detalles;

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(empleado empleado) {
        this.empleado = empleado;
    }

    public List<detalle_venta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<detalle_venta> detalles) {
        this.detalles = detalles;
    }
}
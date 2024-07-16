package KubePrueba.pr.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Universidades {

    @Id	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autos_seq")
    @SequenceGenerator(name = "autos_seq", sequenceName = "autos_seq", allocationSize = 1)
	private int codigo;
	private String nombre;

    public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
}

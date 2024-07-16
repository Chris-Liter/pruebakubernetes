package KubePrueba.pr.business;

import KubePrueba.pr.dao.GestionUniversidad;
import KubePrueba.pr.modelo.Universidades;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;


@Stateless
public class UniversidadesDao {

    @Inject
    private GestionUniversidad gestionUniversidad;


    public void Guardar(Universidades uni){
        gestionUniversidad.insert(uni);
    }

    public void actualizar(Universidades uni){
        gestionUniversidad.update(uni);
    }

    public List<Universidades> Listar(){
        return gestionUniversidad.getAll();
    }

    public void Eliminar(int id){
        gestionUniversidad.remove(id);
    }
}

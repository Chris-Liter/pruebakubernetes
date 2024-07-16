package KubePrueba.pr.dao;

import java.util.List;

import KubePrueba.pr.modelo.Universidades;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Stateless
public class GestionUniversidad {

    @PersistenceContext
    private EntityManager em;

    public void insert(Universidades autos) {
        em.merge(autos);
    }

    public void update(Universidades autos) {
        em.merge(autos);
    }

    public void remove(int codigo) {
        Universidades autos = em.find(Universidades.class, codigo);
        em.remove(autos);
    }

    public Universidades read(String codigo) {
        Universidades autos = em.find(Universidades.class, codigo);
        return autos;
    }

    public List<Universidades> getAll() {
        String jpql = "SELECT c FROM Universidades c";
        Query q = em.createQuery(jpql, Universidades.class);
        return q.getResultList();
    }

    public Universidades getAutos(int cedula) {
        String jpql = "SELECT c FROM Universidades c WHERE c.codigo = :codigo";
        Query q = em.createQuery(jpql, Universidades.class);
        q.setParameter("codigo", cedula);
        List<Universidades> clientes = q.getResultList();
        if (clientes.size() > 0)
            return clientes.get(0);
        return null;
    }
}

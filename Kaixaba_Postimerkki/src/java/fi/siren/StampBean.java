/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.siren;
 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
/**
 *
 * @author Miika
 */
@Stateless
public class StampBean implements StampService {
     
    @PersistenceContext(unitName = "postimerkit")
    private EntityManager em;
 
    @Override
    public Stamp createOrUpdate(Stamp stamp) {
        return em.merge(stamp);
    }
    @Override
    public void remove(Stamp stamp) {
        em.remove(em.merge(stamp));
    }
    @Override
    public Stamp find(Object id) {
        return em.find(fi.siren.Stamp.class, id);
    }
     
    @Override
    public List<Object> getStamps() throws Exception {
        Query query = em.createQuery("Select obj from Stamp as obj");
        return query.getResultList();
    }
}
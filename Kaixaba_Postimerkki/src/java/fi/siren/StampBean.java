package fi.siren;
 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
/**
 * Enables interaction with the database.
 * @author Miika
 */
@Stateless
public class StampBean implements StampService {
     
    @PersistenceContext(unitName = "postimerkit")
    private EntityManager em;
    
    /**
     * Creates a new stamp to the database.
     * @param stamp
     * @return stamp
     */
    @Override
    public Stamp createOrUpdate(Stamp stamp) {
        return em.merge(stamp);
    }
    
    /**
     * Removes stamp from the database.
     * @param stamp 
     */
    @Override
    public void remove(Stamp stamp) {
        em.remove(em.merge(stamp));
    }
    
    /**
     * Returns stamp from the database which id is given as parameter.
     * @param id
     * @return stamp.
     */
    @Override
    public Stamp find(Object id) {
        return em.find(fi.siren.Stamp.class, id);
    }
     
    /**
     * Gets all stamps from the database.
     * @return stamps
     * @throws Exception 
     */
    @Override
    public List<Stamp> getStamps() throws Exception {
        Query query = em.createQuery("Select obj from Stamp as obj");
        return query.getResultList();
    }
}

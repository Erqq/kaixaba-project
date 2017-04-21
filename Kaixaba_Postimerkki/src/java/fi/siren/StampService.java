package fi.siren;
 
import java.util.List;
import javax.ejb.Local;
 
/**
 * Enables interaction with the database.
 * @author Miika
 */
@Local
public interface StampService {
    
   /**
     * Creates a new stamp to the database.
     * @param stamp
     * @return stamp
     */
    Stamp createOrUpdate(Stamp stamp);
    
    /**
     * Removes stamp from the database.
     * @param stamp 
     */
    void remove(Stamp stamp);
    
    /**
     * Returns stamp from the database which id is given as parameter.
     * @param id
     * @return stamp.
     */
    Stamp find(Object id);
    
    /**
     * Gets all stamps from the database.
     * @return stamps
     * @throws Exception 
     */
    List<Stamp> getStamps() throws Exception;
}

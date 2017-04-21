package fi.siren;
 
import java.util.List;
import javax.ejb.Local;
 
/**
 *
 * @author Miika
 */
@Local
public interface StampService {
    Stamp createOrUpdate(Stamp stamp);
    void remove(Stamp stamp);
    Stamp find(Object id);
    List<Stamp> getStamps() throws Exception;
}

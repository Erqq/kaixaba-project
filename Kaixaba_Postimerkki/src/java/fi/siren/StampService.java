/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

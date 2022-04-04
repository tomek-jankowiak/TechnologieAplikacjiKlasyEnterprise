package req.facade;

import java.util.List;
import javax.ejb.Local;
import req.entites.Request;

/**
 *
 * @author Tomek
 */
@Local
public interface RequestFacadeLocal {

    void create(Request request);

    void edit(Request request);

    void remove(Request request);

    Request find(Object id);

    List<Request> findAll();

    List<Request> findRange(int[] range);

    int count();
    
}

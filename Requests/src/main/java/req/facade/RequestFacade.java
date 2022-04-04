package req.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import req.entites.Request;

/**
 *
 * @author Tomek
 */
@Stateless
public class RequestFacade extends AbstractFacade<Request> implements RequestFacadeLocal {

    @PersistenceContext(unitName = "RequestsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequestFacade() {
        super(Request.class);
    }
    
}

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import src.entities.Cliente;

@Repository
@Transactional
public class ClienteDAOService {
    @PersistenceContext
    private EntityManager entityManager;

    public long insert(Cliente cliente){
        // Open transaction
        entityManager.persist(cliente);
        // Close transaction
        return cliente.idCliente;
    }
}

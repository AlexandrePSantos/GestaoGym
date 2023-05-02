import org.springframework.stereotype.Component;
import entities.Cliente;

@Component
public class ClienteDAOServiceCommandLineRunner implements CommandLineRunner{
    @Override
    public void run(String... arg0) throws Exception{
        Cliente cliente = new Cliente("Jack", 30);
    }
}
import java.util.EnumSet;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import repository.entities.Aulagrupo;
import repository.entities.Cliente;
import repository.entities.Equipamento;
import repository.entities.Exercicio;
import repository.entities.Funcionario;
import repository.entities.Linhaexercicio;
import repository.entities.Linhaparticipante;
import repository.entities.Planotreino;

public class Main {

    public static void main(String[] args) {
        // Create a persistence unit using the persistence.xml file
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

        // Create the Hibernate metadata sources based on the JPA entities
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(emf.getProperties())
                .build();
        MetadataSources metadata = new MetadataSources(registry);
        metadata.addAnnotatedClass(Exercicio.class);
        metadata.addAnnotatedClass(Equipamento.class);
        metadata.addAnnotatedClass(Planotreino.class);
        metadata.addAnnotatedClass(Funcionario.class);
        metadata.addAnnotatedClass(Cliente.class);
        metadata.addAnnotatedClass(Aulagrupo.class);
        metadata.addAnnotatedClass(Linhaexercicio.class);
        metadata.addAnnotatedClass(Linhaparticipante.class);

        // Create the schema export object and set the output to console
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setFormat(true).setDelimiter(";").setOutputFile("schema.sql");

        // Create the database schema based on the metadata sources
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata.buildMetadata());
    }

}

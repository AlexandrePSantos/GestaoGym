module com.AcessoBD {
    requires java.persistence;
    requires java.activation;
    requires org.hibernate.orm.core;
    requires org.postgresql.jdbc;

    opens com.AcessoBD.repository.entities to org.hibernate.orm.core;

    exports com.AcessoBD.DAO;
    exports com.AcessoBD.BLL;
}
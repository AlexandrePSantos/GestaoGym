module com.AcessoBD {
    requires java.persistence;
    requires java.activation;
    requires org.hibernate.orm.core;
    requires org.postgresql.jdbc;

    exports com.AcessoBD.DAO;
    exports com.AcessoBD.BLL;
}
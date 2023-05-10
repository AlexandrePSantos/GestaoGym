open module com.example.bd  {
    requires java.persistence;
    requires java.activation;
    requires java.sql;
    requires org.hibernate.orm.core;

    exports com.bd.DAL;
    exports com.bd.BLL;


}
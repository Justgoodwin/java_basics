import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CreateSessionFactory {

    public static Session createSession(String pathToConfig) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure(pathToConfig).build();

        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }
}

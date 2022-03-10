import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    static String url = "jdbc:mysql://localhost:3306/skillbox";
    static String user = "root";
    static String pass = "swordfish";


    public static void main(String[] args) {

//        DbConnection dbConnection = new DbConnection(url, user, pass);
//
//        dbConnection.getConnection();
//
//        Statement statement = dbConnection.getStatement();
//
//        final String querryString = "select course_name, COUNT(*) / "
//                + "(MAX(month(subscription_date)) - MIN(month(subscription_date)) + 1) "
//                + "AS avg from purchaselist group by course_name;";


        Session session = CreateSessionFactory.createSession("hibernate.cfg.xml");


        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, 1);

        System.out.println(course.getStudents().size());

        CreateSessionFactory.closeSession(session);


//        try {
//            ResultSet purchaselist = statement.executeQuery(querryString);
//
//            while (purchaselist.next()) {
//                String courseName = purchaselist.getString("course_name");
//                String avgValue = purchaselist.getString("avg");
//                System.out.println(courseName + " - " + avgValue);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}

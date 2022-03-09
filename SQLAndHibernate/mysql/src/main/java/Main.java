import org.hibernate.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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

        Course course = session.get(Course.class, 1);

        System.out.println("Course name:\s" + course.getName() + "\nstudents count:\s" + course.getStudentCount());

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

import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static String url = "jdbc:mysql://localhost:3306/skillbox";
    static String user = "root";
    static String pass = "swordfish";


    public static void main(String[] args) {
//        //DB connection
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

        String hql = "From " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseList = session.createQuery(hql).getResultList();
        ArrayList<Integer> idConnect = new ArrayList<>();

        for (PurchaseList purchase : purchaseList) {
            Query criteria = session.createQuery("from " + Students.class.getSimpleName()
                    + " where name = :studentName ");
            List<Students> students = criteria.setParameter("studentName", purchase.getStudentName()).getResultList();
            idConnect.add(students.get(0).getId());

            criteria = session.createQuery("from " + Course.class.getSimpleName()
                    + " where name = :courseName ");
            List<Course> courses = criteria.setParameter("courseName", purchase.getCourseName()).getResultList();
            idConnect.add(courses.get(0).getId());

            int studentIdInfo = 0;
            int courseIdInfo = 1;
            if (idConnect.size() == 2) {
                Transaction transaction = session.beginTransaction();
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                linkedPurchaseList.setLinkedPurchaseId(idConnect.get(studentIdInfo), idConnect.get(courseIdInfo));
                session.saveOrUpdate(linkedPurchaseList);
                session.flush();
                transaction.commit();
                idConnect.clear();
            }
        }
//        //Hibernate querry language
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Course> courseCriteriaQuery = criteriaBuilder.createQuery(Course.class);
//        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);
//        courseCriteriaQuery.select(courseRoot)
//                .where(criteriaBuilder.greaterThan(courseRoot.<Integer>get("price"), 100000))
//                .orderBy(criteriaBuilder.desc(courseRoot.get("price")));
//        List<Course> courseList = session.createQuery(courseCriteriaQuery).setMaxResults(5).getResultList();
//
//        for (Course course : courseList) {
//            System.out.println(course.getName() + " - " + course.getPrice());
//        }
//        Transaction transaction = session.beginTransaction();
//        Course course = session.get(Course.class, 1);
//        System.out.println(course.getStudents().size());
        CreateSessionFactory.closeSession(session);

    }
}

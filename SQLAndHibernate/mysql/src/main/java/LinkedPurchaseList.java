import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "linkedPurchaseList")
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseId linkedPurchaseId;

    public LinkedPurchaseList() {
    }

    public LinkedPurchaseList(LinkedPurchaseId linkedPurchaseId) {
        this.linkedPurchaseId = linkedPurchaseId;
    }

    public void setLinkedPurchaseId(int studentId, int courseId) {
        linkedPurchaseId = new LinkedPurchaseId(studentId,courseId);
    }

    @Embeddable
    public static class LinkedPurchaseId implements Serializable {
        @Column(name = "student_id")
        private int studentId;
        @Column(name = "course_id")
        private int courseId;

        public LinkedPurchaseId() {
        }

        public LinkedPurchaseId(int studentId, int courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LinkedPurchaseId that)) return false;
            return studentId == that.studentId && courseId == that.courseId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, courseId);
        }
    }
}

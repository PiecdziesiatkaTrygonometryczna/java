import java.util.ArrayList;

public class GradeList {
    private final ArrayList<Float> grades;

    public GradeList() {
        this.grades = new ArrayList<>();
    }

    public void addGrade(float grade) {
        grades.add(grade);
    }

    public float calculateAverage() {
        if (grades.isEmpty()) {
            return -1;
        }

        float sum = 0;
        for (float grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public float findMaxGrade() {
        if (grades.isEmpty()) {
            return -1;
        }

        float maxGrade = grades.getFirst();
        for (float grade : grades) {
            if (grade > maxGrade) {
                maxGrade = grade;
            }
        }
        return maxGrade;
    }

    public float findMinGrade() {
        if (grades.isEmpty()) {
            return -1;
        }

        float minGrade = grades.getFirst();
        for (float grade : grades) {
            if (grade < minGrade) {
                minGrade = grade;
            }
        }
        return minGrade;
    }
}

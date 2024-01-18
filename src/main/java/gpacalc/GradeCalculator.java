package gpacalc.gpaCal;

import java.util.List;

public class GradeCalculator {
    private List<Subject> subjects;     // 객체들의 리스트를 저장함

    // 클래스의 생성자. 새로운 객체를 생성할 때 호출하는 메소드
    public GradeCalculator(List<Subject> subjects) {
        this.subjects = subjects;
    }

    // 저장된 과목 리스트를 출력하는 메소드
    public void printSubjectList() {
        System.out.println("<과목 목록>");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    // GPA를 계산하는 메소드
    public double calculatedGPA() {
        double totalGradePoints = 0.0;
        int totalCredits = 0;

        for (Subject subject : subjects) {
            if (!subject.isPassFailGrade()) {
                totalGradePoints += subject.getGradeValue() * subject.getCredit();
                totalCredits += subject.getCredit();
            }
        }

        return totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
    }


    // 계산된 GPA를 출력하는 메소드.
    public void printCalculatedGpa() {
        double gpa = calculatedGPA();
        int totalCredit = 0;

        System.out.printf("<취득학점>\n%d학점\n", totalCredit);
        System.out.printf("<평점평균>\n%.2f / 4.5\n", gpa);
    }
}



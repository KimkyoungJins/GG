package gpacalc.gpaCal;

public class Subject {

    private String type;        // 과목의 유형 "전공" 또는 "교양"
    private String name;        // 과목의 이름
    private int credit;         // 학점
    private String grade;       // 성적

    //Subject 클래스 생성자
    public Subject(String type, String name, int credit, String grade) {
        this.type = type;
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    // 과목의 유형을 반환하는 메소드
    public String getType() {
        return type;
    }

    // 과목의 학점을 반환하는 메소드
    public int getCredit() {
        return credit;
    }

    // 성적을 숫자 값으로 변환하기 위함
    // enum으로 바꾼다.  -- 아직 못바꿨다.
    public double getGradeValue() {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0; // P/NP 과목은 평점 계산에서 제외
        }
    }

    // 불리언 값으로 성적이 "P" 또는 "NP"인지 확인
    public boolean isPassFailGrade() {
        return grade.equals("P") || grade.equals("NP");
    }

    //
    //@Override
    public String toString() {
        return String.format("[%s] %s,%d,%s", type, name, credit, grade);
    }
}


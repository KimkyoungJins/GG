package gpacalc.gpaCal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

// 테스트 클래스
class GradeCalculatorTest {

    private GradeCalculator gradeCalculator;
    private List<Subject> subjects;

    // 각 테스트 케이스가 실행되기 전에 실행되는 메서드를 정의한다.
    @BeforeEach
    void setUp() {

        // 테스트 하려면 초기 과목 데이터를 설정해야함
        subjects = Arrays.asList(
                new Subject("전공", "자바프로그래밍", 3, "A+"),
                new Subject("전공", "머신러닝", 3, "B+"),
                new Subject("교양", "선형대수학", 2, "A0")
        );

        // 객체를 생성한다.
        gradeCalculator = new GradeCalculator(subjects);
    }


    // 실제 GPA를 계산하는 기능을 테스트한다.
    @Test
    void testCalculatedGPA() {
        // Assuming the grade values are A+: 4.5, B+: 3.5, A0: 4.0
        double expectedGPA = ((4.5 * 3) + (3.5 * 3) + (4.0 * 2)) / 8;
        assertEquals(expectedGPA, gradeCalculator.calculatedGPA(), 0.01);
    }


    // PF 과목이 GPA 계산에 포함되지 않는지 테스트한다.
    @Test
    void testCalculatedGPAWithPassFail() {

        // PF 과목 추가한다.
        subjects = Arrays.asList(
                new Subject("전공", "자바프로그래밍", 3, "A+"),
                new Subject("전공", "머신러닝", 3, "B+"),
                new Subject("교양", "선형대수학", 2, "P")  // Pass/Fail subject
        );
        gradeCalculator = new GradeCalculator(subjects);

        // PF과목은 GPA 계산에서 제외
        double expectedGPA = ((4.5 * 3) + (3.5 * 3)) / 6;
        assertEquals(expectedGPA, gradeCalculator.calculatedGPA(), 0.01);
    }
}

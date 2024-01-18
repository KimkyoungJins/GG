package gpacalc.gpaCal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GpaCalcTest {

    // 과목 리스트를 테스트에 사용하기 위한 변수 선언
    private List<Subject> subjects;

    // 각 테스트 실행 전에 과목 리스트 초기화
    @BeforeEach
    void setUp() {
        subjects = new ArrayList<>();
    }

    // 올바른 입력을 받아서 과목이 잘 추가 되는지 테스트
    @Test
    void testAddSubjectsValidInput() {
        String input = "자바프로그래밍-3-A+, 머신러닝-3-B+";
        Scanner scanner = new Scanner(input);
        GpaCalc.addSubjects(scanner, subjects, "전공");
        assertEquals(2, subjects.size());

        // 첫 번째 입력과목 확인
        Subject firstSubject = subjects.get(0);
        assertEquals("전공", firstSubject.getType());
        assertEquals("자바프로그래밍", firstSubject.getName());
        assertEquals(3, firstSubject.getCredit());
        assertEquals("A+", firstSubject.getGrade());

        // 두 번째 입력과목 확인
        Subject secondSubject = subjects.get(1);
        assertEquals("전공", secondSubject.getType());
        assertEquals("머신러닝", secondSubject.getName());
        assertEquals(3, secondSubject.getCredit());
        assertEquals("B+", secondSubject.getGrade());
    }


    // 잘못된 입력을 받았을 때 예외가 발생하는지 테스트
    @Test
    void testAddSubjectsInvalidInput() {

        // 테스트를 위한 잘못된 입력 문자열 준비
        String input = "Invalid Input";
        Scanner scanner = new Scanner(input);

        // 예외 발생을 검증함.
        assertThrows(IllegalArgumentException.class, () -> {
            GpaCalc.addSubjects(scanner, subjects, "전공");
        });
    }
}

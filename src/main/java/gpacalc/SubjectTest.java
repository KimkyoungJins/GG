package gpacalc.gpaCal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

// 기능을 테스트 하기 위한 클래스
class SubjectTest {

    // 메서드 테스트
    @Test
    void testSubjectConstructorAndGetters() {
        Subject subject = new Subject("전공", "자바프로그래밍", 3, "A+");
        assertEquals("전공", subject.getType());
        assertEquals("Java Programming", subject.getName());    // 이름이 올바르게 설정되었는지
        assertEquals(3, subject.getCredit());                   // 학점이 올바르게 설정되었는지
        assertEquals("A+", subject.getGrade());                 // 평점이 올바르게 설정되었는지
    }


    //메서드 테스트
    @Test
    void testGetGradeValue() {
        assertEquals(4.5, new Subject("전공", "자바프로그래밍", 3, "A+").getGradeValue());
        assertEquals(4.0, new Subject("전공", "자바프로그래밍", 3, "A0").getGradeValue());
        // Add assertions for other grade values
    }

    @Test
    void testIsPassFailGrade() {

        // P/NP 과목인 경우 true를 반환하는지, 그렇지 않은 경우 false 반환하는지
        assertTrue(new Subject("교양", "Art", 2, "P").isPassFailGrade());
        assertTrue(new Subject("교양", "Art", 2, "NP").isPassFailGrade());
        assertFalse(new Subject("전공", "자바프로그래밍", 3, "A+").isPassFailGrade());
    }

    @Test
    void testToString() {

        // toString 메서드가 올바른 문자열을 반환하는지 검증한다.
        Subject subject = new Subject("전공", "자바프로그래밍", 3, "A+");
        String expectedString = "[전공] 자바프로그래밍,3,A+";
        assertEquals(expectedString, subject.toString());
    }
}

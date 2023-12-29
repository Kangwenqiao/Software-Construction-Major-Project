package ExerciseClasssTest;

import ExerciseClass.AbstractEquation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AbstractEquationTest {

    @Test
    void testEqualsAndHashCode() {
        AbstractEquation equation1 = new ConcreteEquation((short) 3, (short) 5, '+');
        AbstractEquation equation2 = new ConcreteEquation((short) 3, (short) 5, '+');
        AbstractEquation equation3 = new ConcreteEquation((short) 4, (short) 5, '+');

        // 测试相等性
        assertEquals(equation1, equation2, "equation1 应该等于 equation2");
        assertNotEquals(equation1, equation3, "equation1 不应该等于 equation3");

        // 测试哈希码
        assertEquals(equation1.hashCode(), equation2.hashCode(), "equation1 和 equation2 的哈希码应该相等");
        assertNotEquals(equation1.hashCode(), equation3.hashCode(), "equation1 和 equation3 的哈希码不应该相等");
    }

    @Test
    void testToString() {
        AbstractEquation equation = new ConcreteEquation((short) 3, (short) 5, '+');
        String expected = "3 + 5";
        assertEquals(expected, equation.toString(), "toString 方法返回的字符串应该符合预期");
    }
}

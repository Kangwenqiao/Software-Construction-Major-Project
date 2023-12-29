package ExerciseClasssTest;

import ExerciseClass.AddEquation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AddEquationTest {

    @Test
    void testConstructorAndCalculate() {
        AddEquation addEquation = new AddEquation((short) 3, (short) 5);

        // 测试构造函数是否正确设置了操作数和操作符
        assertEquals(3, addEquation.getOperand1(), "操作数1应该为3");
        assertEquals(5, addEquation.getOperand2(), "操作数2应该为5");
        assertEquals('+', addEquation.getOperator(), "操作符应该为'+'");

        // 测试calculate方法是否正确计算加法结果
        assertEquals(8, addEquation.calculate(), "3 + 5 应该等于 8");
    }

    @Test
    void testEqualsAndHashCode() {
        AddEquation equation1 = new AddEquation((short) 3, (short) 5);
        AddEquation equation2 = new AddEquation((short) 3, (short) 5);
        AddEquation equation3 = new AddEquation((short) 4, (short) 5);

        // 测试相等性
        assertEquals(equation1, equation2, "equation1 应该等于 equation2");
        assertNotEquals(equation1, equation3, "equation1 不应该等于 equation3");

        // 测试哈希码
        assertEquals(equation1.hashCode(), equation2.hashCode(), "equation1 和 equation2 的哈希码应该相等");
        assertNotEquals(equation1.hashCode(), equation3.hashCode(), "equation1 和 equation3 的哈希码不应该相等");
    }

    @Test
    void testToString() {
        AddEquation equation = new AddEquation((short) 3, (short) 5);
        String expected = "3 + 5";
        assertEquals(expected, equation.toString(), "toString 方法返回的字符串应该符合预期");
    }
}

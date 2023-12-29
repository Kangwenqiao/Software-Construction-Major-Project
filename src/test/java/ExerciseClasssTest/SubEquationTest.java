package ExerciseClasssTest;

import ExerciseClass.SubEquation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SubEquationTest {

    @Test
    void testConstructorAndCalculate() {
        // 创建减法算式对象
        SubEquation subEquation = new SubEquation((short) 5, (short) 3);

        // 测试构造函数是否正确设置了操作数和操作符
        assertEquals(5, subEquation.getOperand1(), "操作数1应该为5");
        assertEquals(3, subEquation.getOperand2(), "操作数2应该为3");
        assertEquals('-', subEquation.getOperator(), "操作符应该为'-'");

        // 测试calculate方法是否正确计算减法结果
        assertEquals(2, subEquation.calculate(), "5 - 3 应该等于 2");
    }

    @Test
    void testEqualsAndHashCode() {
        SubEquation equation1 = new SubEquation((short) 5, (short) 3);
        SubEquation equation2 = new SubEquation((short) 5, (short) 3);
        SubEquation equation3 = new SubEquation((short) 4, (short) 3);

        // 测试相等性
        assertEquals(equation1, equation2, "equation1 应该等于 equation2");
        assertEquals(equation2, equation1, "equation2 应该等于 equation1");
        assertNotEquals(equation1, equation3, "equation1 不应该等于 equation3");
        assertNotEquals(equation2, equation3, "equation2 不应该等于 equation3");

        // 测试哈希码
        assertEquals(equation1.hashCode(), equation2.hashCode(), "equation1 和 equation2 的哈希码应该相等");
        assertNotEquals(equation1.hashCode(), equation3.hashCode(), "equation1 和 equation3 的哈希码不应该相等");
    }

    @Test
    void testToString() {
        SubEquation equation = new SubEquation((short) 5, (short) 3);
        String expected = "5 - 3";
        assertEquals(expected, equation.toString(), "toString 方法返回的字符串应该符合预期");
    }
}

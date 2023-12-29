package ExerciseClasssTest;

import ExerciseClass.EquationFactory;
import ExerciseClass.IEquation;
import ExerciseClass.AddEquation;
import ExerciseClass.SubEquation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EquationFactoryTest {

    @Test
    void testGetEquationRandom() {
        // 创建 EquationFactory 对象
        EquationFactory equationFactory = new EquationFactory();

        // 生成多个随机算式并检查它们是否是 AddEquation 或 SubEquation 的实例
        for (int i = 0; i < 100; i++) {
            IEquation equation = equationFactory.getEquationRandom();
            assertTrue(equation instanceof AddEquation || equation instanceof SubEquation,
                    "生成的算式应该是 AddEquation 或 SubEquation 的实例");
        }
    }
}

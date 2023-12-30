package ExerciseClasssTest; // Author: wqKang
// Author: wqKang

import ExerciseClass.AddEquation;
import ExerciseClass.EquationFactory;
import ExerciseClass.IEquation;
import ExerciseClass.SubEquation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Author: wqKang
public class EquationFactoryTest { // Author: wqKang
    // Author: wqKang
    @Test
    // Author: wqKang
    void testGetEquationRandom() { // Author: wqKang
        // 创建 EquationFactory 对象 // Author: wqKang
        EquationFactory equationFactory = new EquationFactory(); // Author: wqKang
        // Author: wqKang
        // 生成多个随机算式并检查它们是否是 AddEquation 或 SubEquation 的实例 // Author: wqKang
        for (int i = 0; i < 100; i++) { // Author: wqKang
            IEquation equation = equationFactory.getEquationRandom(); // Author: wqKang
            assertTrue(equation instanceof AddEquation || equation instanceof SubEquation, // Author: wqKang
                    "生成的算式应该是 AddEquation 或 SubEquation 的实例"); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
} // Author: wqKang

package ExerciseClass; // Author: wqKang
// Author: wqKang

import java.util.Random;
// Author: wqKang

/**
 * // Author: wqKang
 * EquationFactory 工厂类，用于创建随机算式对象。 // Author: wqKang
 * 该类包含方法，能够随机生成加法或减法算式。 // Author: wqKang
 */ // Author: wqKang
public class EquationFactory { // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 随机返回算数式，可以是加法或减法。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 随机生成的算数式对象，实现了 IEquation 接口 // Author: wqKang
     */ // Author: wqKang
    public IEquation getEquationRandom() { // Author: wqKang
        Random random = new Random(); // Author: wqKang
        // Author: wqKang
        // 生成随机的操作数1和操作数2（范围在0到100之间） // Author: wqKang
        short operand1 = (short) random.nextInt(101); // Author: wqKang
        short operand2 = (short) random.nextInt(101); // Author: wqKang
        // Author: wqKang
        // 随机选择是加法还是减法 // Author: wqKang
        if (random.nextBoolean()) { // Author: wqKang
            // 返回加法算式对象 // Author: wqKang
            return new AddEquation(operand1, operand2); // Author: wqKang
        } else { // Author: wqKang
            // 返回减法算式对象 // Author: wqKang
            return new SubEquation(operand1, operand2); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
} // Author: wqKang

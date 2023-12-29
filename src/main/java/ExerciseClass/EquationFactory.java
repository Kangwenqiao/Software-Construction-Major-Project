package ExerciseClass;

import java.util.Random;

/**
 * EquationFactory 工厂类，用于创建随机算式对象。
 * 该类包含方法，能够随机生成加法或减法算式。
 */
public class EquationFactory {

    /**
     * 随机返回算数式，可以是加法或减法。
     *
     * @return 随机生成的算数式对象，实现了 IEquation 接口
     */
    public IEquation getEquationRandom() {
        Random random = new Random();

        // 生成随机的操作数1和操作数2（范围在0到100之间）
        short operand1 = (short) random.nextInt(101);
        short operand2 = (short) random.nextInt(101);

        // 随机选择是加法还是减法
        if (random.nextBoolean()) {
            // 返回加法算式对象
            return new AddEquation(operand1, operand2);
        } else {
            // 返回减法算式对象
            return new SubEquation(operand1, operand2);
        }
    }
}

package ExerciseClasssTest;

import ExerciseClass.AbstractEquation;

// 具体的算式类
public class ConcreteEquation extends AbstractEquation {

    /**
     * 构造函数，用于初始化算式的操作数和操作符。
     *
     * @param operand1 第一个操作数
     * @param operand2 第二个操作数
     * @param operator 操作符
     */
    public ConcreteEquation(short operand1, short operand2, char operator) {
        super(operand1, operand2, operator);
    }

    /**
     * 实现 IEquation 接口的 calculate 方法，用于计算算式的结果。
     *
     * @return 计算结果
     */
    @Override
    public int calculate() {
        switch (getOperator()) {
            case '+':
                return getOperand1() + getOperand2();
            case '-':
                return getOperand1() - getOperand2();
            case '*':
                return getOperand1() * getOperand2();
            case '/':
                if (getOperand2() != 0) {
                    return getOperand1() / getOperand2();
                } else {
                    throw new ArithmeticException("除数不能为零");
                }
            default:
                throw new UnsupportedOperationException("不支持的操作符：" + getOperator());
        }
    }
}

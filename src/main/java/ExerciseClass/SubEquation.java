package ExerciseClass;

/**
 * 减法算式类，继承自抽象算式类 AbstractEquation。
 */
public class SubEquation extends AbstractEquation {

    /**
     * 构造函数，用于初始化减法算式的操作数和操作符。
     *
     * @param operand1 第一个操作数
     * @param operand2 第二个操作数
     */
    public SubEquation(short operand1, short operand2) {
        // 调用父类构造函数，设置操作数和操作符
        super(operand1, operand2, '-');
    }

    /**
     * 计算并返回减法算式的结果。
     *
     * @return 减法算式的计算结果
     */
    @Override
    public int calculate() {
        // 返回操作数1减去操作数2的结果
        return getOperand1() - getOperand2();
    }
}
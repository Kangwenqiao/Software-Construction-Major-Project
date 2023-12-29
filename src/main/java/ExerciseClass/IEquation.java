package ExerciseClass;

/**
 * 算式接口，定义了表示数学算式的方法。
 */
public interface IEquation {

    /**
     * 获取算式的第一个操作数。
     *
     * @return 第一个操作数
     */
    short getOperand1();

    /**
     * 获取算式的第二个操作数。
     *
     * @return 第二个操作数
     */
    short getOperand2();

    /**
     * 获取算式的操作符。
     *
     * @return 操作符
     */
    char getOperator();

    /**
     * 计算并返回算式的结果。
     *
     * @return 算式的计算结果
     */
    int calculate();

    /**
     * 返回算式的字符串表示形式。
     *
     * @return 字符串表示形式
     */
    String toString();
}

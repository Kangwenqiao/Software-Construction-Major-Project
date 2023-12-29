package ExerciseClass;

import java.util.Objects;

// 算式抽象类
public abstract class AbstractEquation implements IEquation {
    private short operand1;  // 操作数1
    private short operand2;  // 操作数2
    private char operator;   // 操作符

    /**
     * 构造函数，用于初始化算式的操作数和操作符。
     *
     * @param operand1 第一个操作数
     * @param operand2 第二个操作数
     * @param operator 操作符
     */
    public AbstractEquation(short operand1, short operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    /**
     * 无参构造函数，用于创建未初始化的算式对象。
     */
    public AbstractEquation() {
    }

    /**
     * 获取操作数1。
     *
     * @return 操作数1
     */
    @Override
    public short getOperand1() {
        return operand1;
    }

    /**
     * 获取操作数2。
     *
     * @return 操作数2
     */
    @Override
    public short getOperand2() {
        return operand2;
    }

    /**
     * 获取操作符。
     *
     * @return 操作符
     */
    @Override
    public char getOperator() {
        return operator;
    }

    /**
     * 判断两个算式对象是否相等。
     *
     * @param obj 要比较的对象
     * @return 如果对象相等，返回true；否则返回false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractEquation equation = (AbstractEquation) obj;
        return operand1 == equation.operand1 && operand2 == equation.operand2 && operator == equation.operator;
    }

    /**
     * 计算并返回算式对象的哈希码。
     *
     * @return 哈希码值
     */
    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operator);
    }

    /**
     * 返回算式对象的字符串表示形式，格式为 "operand1 operator operand2"。
     *
     * @return 字符串表示形式
     */
    @Override
    public String toString() {
        return operand1 + " " + operator + " " + operand2;
    }
}

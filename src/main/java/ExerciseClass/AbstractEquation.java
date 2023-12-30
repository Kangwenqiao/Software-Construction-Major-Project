package ExerciseClass; // Author: wqKang
// Author: wqKang

import java.util.Objects;

// Author: wqKang
// 算式抽象类 // Author: wqKang
public abstract class AbstractEquation implements IEquation { // Author: wqKang
    private short operand1;  // 操作数1 // Author: wqKang
    private short operand2;  // 操作数2 // Author: wqKang
    private char operator;   // 操作符 // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 构造函数，用于初始化算式的操作数和操作符。 // Author: wqKang
     * // Author: wqKang
     *
     * @param operand1 第一个操作数 // Author: wqKang
     * @param operand2 第二个操作数 // Author: wqKang
     * @param operator 操作符 // Author: wqKang
     */ // Author: wqKang
    public AbstractEquation(short operand1, short operand2, char operator) { // Author: wqKang
        this.operand1 = operand1; // Author: wqKang
        this.operand2 = operand2; // Author: wqKang
        this.operator = operator; // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 无参构造函数，用于创建未初始化的算式对象。 // Author: wqKang
     */ // Author: wqKang
    public AbstractEquation() { // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 获取操作数1。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 操作数1 // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public short getOperand1() { // Author: wqKang
        return operand1; // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 获取操作数2。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 操作数2 // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public short getOperand2() { // Author: wqKang
        return operand2; // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 获取操作符。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 操作符 // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public char getOperator() { // Author: wqKang
        return operator; // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 判断两个算式对象是否相等。 // Author: wqKang
     * // Author: wqKang
     *
     * @param obj 要比较的对象 // Author: wqKang
     * @return 如果对象相等，返回true；否则返回false // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public boolean equals(Object obj) { // Author: wqKang
        if (this == obj) return true; // Author: wqKang
        if (obj == null || getClass() != obj.getClass()) return false; // Author: wqKang
        AbstractEquation equation = (AbstractEquation) obj; // Author: wqKang
        return operand1 == equation.operand1 && operand2 == equation.operand2 && operator == equation.operator; // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 计算并返回算式对象的哈希码。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 哈希码值 // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public int hashCode() { // Author: wqKang
        return Objects.hash(operand1, operand2, operator); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 返回算式对象的字符串表示形式，格式为 "operand1 operator operand2"。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 字符串表示形式 // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public String toString() { // Author: wqKang
        return operand1 + " " + operator + " " + operand2; // Author: wqKang
    } // Author: wqKang
} // Author: wqKang

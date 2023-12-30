package ExerciseClasssTest; // Author: wqKang

import ExerciseClass.AbstractEquation;

// Author: wqKang
// 具体的算式类 // Author: wqKang
public class ConcreteEquation extends AbstractEquation { // Author: wqKang
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
    public ConcreteEquation(short operand1, short operand2, char operator) { // Author: wqKang
        super(operand1, operand2, operator); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 实现 IEquation 接口的 calculate 方法，用于计算算式的结果。 // Author: wqKang
     * // Author: wqKang
     *
     * @return 计算结果 // Author: wqKang
     */ // Author: wqKang
    @Override // Author: wqKang
    public int calculate() { // Author: wqKang
        switch (getOperator()) { // Author: wqKang
            case '+': // Author: wqKang
                return getOperand1() + getOperand2(); // Author: wqKang
            case '-': // Author: wqKang
                return getOperand1() - getOperand2(); // Author: wqKang
            case '*': // Author: wqKang
                return getOperand1() * getOperand2(); // Author: wqKang
            case '/': // Author: wqKang
                if (getOperand2() != 0) { // Author: wqKang
                    return getOperand1() / getOperand2(); // Author: wqKang
                } else { // Author: wqKang
                    throw new ArithmeticException("除数不能为零"); // Author: wqKang
                } // Author: wqKang
            default: // Author: wqKang
                throw new UnsupportedOperationException("不支持的操作符：" + getOperator()); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
} // Author: wqKang

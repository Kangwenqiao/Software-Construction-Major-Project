package ExerciseClass; // Author: wqKang
// Author: wqKang

/**
 * // Author: wqKang
 * 算式约束接口。 // Author: wqKang
 * 定义了检查算式是否满足特定条件的方法。 // Author: wqKang
 */ // Author: wqKang
public interface EquationChecker { // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 检查给定算式是否满足约束条件。 // Author: wqKang
     * // Author: wqKang
     *
     * @param equation 要检查的算式对象，实现了 IEquation 接口 // Author: wqKang
     * @return 如果算式满足约束条件，返回 true；否则返回 false // Author: wqKang
     */ // Author: wqKang
    boolean check(IEquation equation); // Author: wqKang
} // Author: wqKang

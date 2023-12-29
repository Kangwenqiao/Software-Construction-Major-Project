package ExerciseClass;

/**
 * 算式约束接口。
 * 定义了检查算式是否满足特定条件的方法。
 */
public interface EquationChecker {

    /**
     * 检查给定算式是否满足约束条件。
     *
     * @param equation 要检查的算式对象，实现了 IEquation 接口
     * @return 如果算式满足约束条件，返回 true；否则返回 false
     */
    boolean check(IEquation equation);
}

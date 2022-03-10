package com.summer.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * SpEL 表达式测试
 *
 * @author zhanghui
 */
public class SpELTest {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
//        Expression exp = parser.parseExpression("'Hello World'.concat('!')");

        String message = (String) exp.getValue();
        System.out.println(message);
        text();
    }

    public static void text() {
        ExpressionParser parser = new SpelExpressionParser();

        // evals to "Hello World"
        String helloWorld = parser.parseExpression("'Hello World'").getValue(String.class);
        System.out.println(helloWorld);

        Double avogadrosNumber = parser.parseExpression("6.0221415E+23").getValue(Double.class);
        System.out.println(avogadrosNumber);

        // evals to 2147483647
        Integer maxValue = parser.parseExpression("0x7FFFFFFF").getValue(Integer.class);
        System.out.println(maxValue);

        Boolean trueValue = parser.parseExpression("true").getValue(Boolean.class);
        System.out.println(trueValue);

        Object nullValue = parser.parseExpression("null").getValue();
        System.out.println(nullValue);


//        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
//        context.setVariable();
//
//        // Inventions Array
//
//        // evaluates to "Induction motor"
//        String invention = parser.parseExpression("inventions[3]").getValue(
//                context, tesla, String.class);
//
//        // Members List
//
//        // evaluates to "Nikola Tesla"
//        String name = parser.parseExpression("Members[0].Name").getValue(
//                context, ieee, String.class);
//
//        // List and Array navigation
//        // evaluates to "Wireless communication"
//        String invention1 = parser.parseExpression("Members[0].Inventions[6]").getValue(
//                context, ieee, String.class);
//
//        // evals to 1856
//        int year = (Integer) parser.parseExpression("Birthdate.Year + 1900").getValue(context);
//        System.out.println(year);
//
//        String city = (String) parser.parseExpression("placeOfBirth.City").getValue(context);
//        System.out.println(city);

    }

}

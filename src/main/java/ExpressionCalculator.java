import java.util.Scanner;

public class ExpressionCalculator {
    private String[] elements;
    private int position;

    public ExpressionCalculator(String expression) {
        this.elements = expression.split(" "); //разбиваем по пробелам
        this.position = 0;
    }
//метод для плюс/минус
    protected double parse() {
        double first = multiply();

        while (position < elements.length){
            String operator = elements[position];
            if(!operator.equals("+") && !operator.equals("-")){
                break;
            } else {
                position++;
            }
            double second = multiply();
            if(operator.equals("+")){
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }
    //метод для умножения/деления
    private double multiply() {
        double first = brackets();

        while (position < elements.length){
            String operator = elements[position];
            if(!operator.equals("*") && !operator.equals("/")){
                break;
            } else {
                position++;
            }
            double second = brackets();
            if(operator.equals("*")){
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    //метод для скобок
    private double brackets(){
        String next = elements[position];
        double result;

        if(next.equals("(")){
            position++;
            result = parse();
            String closeBracket;
            if(position < elements.length) {
                closeBracket = elements[position];
            } else {
                throw new IllegalArgumentException("Не закрыты скобки!");
            }
            if(closeBracket.equals(")")) {
                position++;
                return result;
            }
            throw new IllegalArgumentException("Вместо ')' найден другой символ - " + closeBracket);
        }
        position++;
        return Double.parseDouble(next);
    }
}

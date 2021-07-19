package Calculator;

import java.util.Scanner;

public class Launch {

    public static void main(String[] args)

    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ВВедите 2 числа и знак операции между ними");
        String stroka = scanner.nextLine();
        try
        {
            MathOperation action = new MathOperation(stroka);
            IntegerFigure result = action.doOperation();
            System.out.println(result);
        }
        catch (Exception ex)
        {
            System.out.println("Произошла следующая ошибка: " + ex.getMessage());
        }
    }

}

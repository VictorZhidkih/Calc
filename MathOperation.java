package Calculator;

public class MathOperation {

    private String oper;
    private IntegerFigure n1, n2;

    public MathOperation(String operationString) throws Exception 
    {
        String[] chisla;

        if (operationString.indexOf("+") > -1)
        {
            chisla = operationString.split("\\+");
            oper = "+";
        }
        else if (operationString.indexOf("-") > -1)
        {
            chisla = operationString.split("-");
            oper = "-";
        }
        else if (operationString.indexOf("*") > -1)
        {
            chisla = operationString.split("\\*");
            oper = "*";
        }
        else if (operationString.indexOf("/") > -1)
        {
            chisla = operationString.split("/");
            oper = "/";
        }
        else
            throw new Exception("Строка не соответствует матем. операции!");

        if (chisla.length > 2)
            throw new Exception("В строке более одного знака операции " + oper + "!");

        try
        {
            n1 = new IntegerArabic(chisla[0].trim());
        }
        catch (Exception ex)
        {
            try
            {
                n1 = new IntegerRoman(chisla[0].trim());
            }
            catch (Exception ex1)
            {
                throw new Exception("1-е число не является корректным числом от 1 до 10!");
            }
        }

        try
        {
            n2 = new IntegerArabic(chisla[1].trim());
        }
        catch (Exception ex)
        {
            try
            {
                n2 = new IntegerRoman(chisla[1].trim());
            }
            catch (Exception ex1)
            {
                throw new Exception("2-е число не является корректным числом от 1 до 10!");
            }
        }
    }

    public IntegerFigure doOperation() throws Exception
    {
        IntegerFigure result;

        if (n1 instanceof IntegerArabic) // если первое чисдо - арабское
        {
            if (n2 instanceof IntegerArabic) // если второе - тоже арабское
            {
                if (oper.equals("+"))
                    result = new IntegerArabic(n1.getFigure() + n2.getFigure());
                else if (oper.equals("-"))
                    result = new IntegerArabic(n1.getFigure() - n2.getFigure());
                else if (oper.equals("*"))
                    result = new IntegerArabic(n1.getFigure() * n2.getFigure());
                else
                    result = new IntegerArabic(n1.getFigure() / n2.getFigure());
            }
            else
                throw new Exception("Одно число записано арабскими цифрами, другое - римскими!");
        }
        else // если первое число - римское
        {
            if (n2 instanceof IntegerRoman)  // если второе - тоже римское
            {
                if (oper.equals("+"))
                    result = new IntegerRoman(n1.getFigure() + n2.getFigure());
                else if (oper.equals("-"))
                    result = new IntegerRoman(n1.getFigure() - n2.getFigure());
                else if (oper.equals("*"))
                    result = new IntegerRoman(n1.getFigure() * n2.getFigure());
                else
                    result = new IntegerRoman(n1.getFigure() / n2.getFigure());
                
                if (result.getFigure() <= 0)
                    throw new Exception("Получилось " + result.getFigure() + ". Римскими цифрами записать такое нельзя");
            }
            else
                throw new Exception("Одно число записано арабскими цифрами, другое - римскими!");
        }

        return result;
    }

}

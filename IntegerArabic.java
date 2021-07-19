
package Calculator;


public class IntegerArabic extends IntegerFigure {
    
    public IntegerArabic(String s) throws Exception
    {
        figure = Integer.parseInt(s);
        if (figure < 1)
            throw new Exception("Число не от 1 до 10");
        if (figure > 10)
            throw new Exception("Число не от 1 до 10");
    }
    
    public IntegerArabic(int value)
    {
        figure = value;
    }
    
    @Override
    public String toString()
    {
        return figure.toString();
    }
    
}

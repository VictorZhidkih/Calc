
package Calculator;

public class IntegerRoman extends IntegerFigure {
    
    public IntegerRoman(String s) throws Exception
    {
        figure = makeValue(s);
    }
    
    public IntegerRoman(int value)
    {
        figure = value;
    }
    
    @Override
    public String toString()
    {
        return makeString(figure);
    }
    
    private static Integer makeValue(String s) throws Exception
    {
        switch (s)
        {
            case "I" :
                return 1;
            case "II" :
                return 2;
            case "III" :
                return 3;
            case "IV" :
                return 4;
            case "V" :
                return 5;
            case "VI" :
                return 6;
            case "VII" :
                return 7;
            case "VIII" :
                return 8;
            case "IX" :
                return 9;
            case "X" :
                return 10;
            default:
                throw new Exception();
        }
    }
    
    private static String makeString(int chis)
    {
        int digit1 = chis % 10;
        int digit2 = chis / 10;

        String result = makeStringOneRazryad(digit2, 2) + makeStringOneRazryad(digit1, 1);

        return result;
    }
    
    private static String makeStringOneRazryad(int digit, int razryad)
    {
        String s1, s2, s3;
        if (razryad == 1)
        {
            s1 = "I";
            s2 = "V";
            s3 = "X";
        }
        else // razryad == 2
        {
            s1 = "X";
            s2 = "L";
            s3 = "C";
        }
        
        String str = "";
        switch (digit)
        {
            case 1: 
            case 2: 
            case 3:
                for(int i = 1; i <= digit; ++i)
                    str += s1;
                break;
            case 4:
                str = s1 + s2;
                break;
            case 5:
                str = s2;
                break;
            case 6: case 7: case 8:
                str = s2;
                for(int i = 1; i <= digit - 5; ++i)
                    str += s1;
                break;
            case 9:
                str = s1 + s3;
                break;
            case 10:
                str = s3;
                break;
        }
        
        return str;
    }
    
}

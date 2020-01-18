import javax.swing.*;

public class Model {
    enum Operation {add, sub, mul, div, notOperation, calculate};

    private double score;
    private double operand;
    private boolean rownaSie;
    private int liczb;

    private final static String zeroString = "0";
    public final static String error = "ERR";

    private StringBuilder buforWejsciowy;
    private String doOdczytu;
    private Operation lastOperation;

    public void clear() {
        buforWejsciowy = new StringBuilder(zeroString);
        score = 0;
        operand = 0;
        liczb = 1;
        rownaSie = false;
        lastOperation = Operation.add;
        doOdczytu = zeroString;

    }

    public Model() {
        clear();
    }

    /**
     *
     * @param v liczba do przedstawienia
     * @return Łańcuch gotowy do pobrania przez kontroler, stanowi liczbe bez ułamka jesli, część całkowita jest zerowa.
     */

    private static String showValue(double v)
    {
        int intValue = (int) v;
        if (v == intValue)
            return String.valueOf(intValue);
        else
            return String.valueOf(v);
    }

    public void putZero() {

        if(rownaSie)
        {
            clear();
            rownaSie = false;
        }

        if (!buforWejsciowy.toString().equals(zeroString)) {
            buforWejsciowy.append(View.znak0);
            doOdczytu = buforWejsciowy.toString();
        }
    }

    public void putDot() {
        if(rownaSie)
        {
            clear();
            rownaSie = false;
        }

        if (buforWejsciowy.toString().indexOf(View.znakDot) == -1)
            buforWejsciowy.append(View.znakDot);
        doOdczytu = buforWejsciowy.toString();
    }

    private void clearBuff() {
        buforWejsciowy.delete(1, buforWejsciowy.length());
        buforWejsciowy.setCharAt(0, View.znak0);
    }

    /**
     * obliczenie poprzednich zapamietanych operacji
     * a + b -
     */
    private void obliczPoprzednie()
    {

        if(liczb == 1)
        {
            operand = Double.parseDouble(buforWejsciowy.toString());
            oblicz();


            System.out.println("wczytano " + operand);
            System.out.println("wynik " + score);
            liczb = 2;

        }
        else // liczb 2
        {
            if(rownaSie == false)
                operand = Double.parseDouble(buforWejsciowy.toString());
            oblicz();
            System.out.println("wynik2 " + score);
        }
        doOdczytu = showValue(score);

    }

    /**
     * Co ma sie stac, jesli zostanie wstaiony znak +, -, /, *
     * @param op jaki znak
     */
    private void putSign(Operation op)
    {
        if(!rownaSie)   obliczPoprzednie();
        lastOperation = op;
        clearBuff();
        rownaSie = false;
    }

    public void putAdd() { putSign(Operation.add); }
    public void putSub() { putSign(Operation.sub); }
    public void putMul() { putSign(Operation.mul); }
    public void putDiv() { putSign(Operation.div); }


    /**
     * wstawienie cyfr od 1 do 9 do bufowq
     * @param znak - cyfra od 1 do 9
     */
    public void putOneToNine(char znak) {
        if(rownaSie)
        {
            clear();
            rownaSie = false;
        }

        if (buforWejsciowy.toString().equals(zeroString)) {
            buforWejsciowy.setCharAt(0, znak);
            System.out.println("aaaaa");
        } else
            buforWejsciowy.append(znak);
        doOdczytu = buforWejsciowy.toString();
    }

    public String getResult() {

        return doOdczytu;
    }

    private void oblicz() {

        switch(lastOperation)
        {
            case add:
                score = score + operand;

                System.out.println("dodawanie");
                break;
            case sub:
                score = score - operand;
                break;
            case mul:
                score = score * operand;
                break;
            case div:
                score = score / operand;

        }
    }

    /**
     * operacja równa się
     */

    public void calculate() {


        if(!rownaSie) {
            operand = Double.parseDouble(buforWejsciowy.toString());
        }
        oblicz();
        if(score == Double.POSITIVE_INFINITY)
            doOdczytu = Model.error;
        else
            doOdczytu = showValue(score);
        System.out.println("sssssss" + score);
        buforWejsciowy.delete(0, buforWejsciowy.length());
        buforWejsciowy.append(doOdczytu);
        //lastOperation = Operation.calculate;
        rownaSie = true;
        
    }

}











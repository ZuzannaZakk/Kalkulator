import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener {

    private View widok;
    private Model modelCalc;


    public Controler(View widok, Model modelCalc)
    {
        this.widok = widok;
        this.modelCalc = modelCalc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton)e.getSource();
        char znak = buttonClicked.getText().charAt(0);

        switch(znak)
        {
            case View.znak0:
                modelCalc.putZero();
                break;
            case View.znak1:
            case View.znak2:
            case View.znak3:
            case View.znak4:
            case View.znak5:
            case View.znak6:
            case View.znak7:
            case View.znak8:
            case View.znak9:
                modelCalc.putOneToNine(znak);

                break;
            case View.znakDot:
                modelCalc.putDot();
                break;
            case View.znakC:
                modelCalc.clear();
                break;
            case View.znakPlus:
                modelCalc.putAdd();
                break;
            case View.znakMinus:
                modelCalc.putSub();
                break;
            case View.znakDziel:
                modelCalc.putDiv();
                break;
            case View.znakMnoz:
                modelCalc.putMul();
                break;
            case View.znakRownaSie:
                modelCalc.calculate();
                break;

        }
        widok.setView(modelCalc.getResult());

        System.out.println(znak);

    }
}

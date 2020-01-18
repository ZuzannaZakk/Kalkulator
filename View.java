import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private static final int size = 300;
    private static final int heightLabel = 40;

    public final static char znak0 = '0';
    public final static char znak1 = '1';
    public final static char znak2 = '2';
    public final static char znak3 = '3';
    public final static char znak4 = '4';
    public final static char znak5 = '5';
    public final static char znak6 = '6';
    public final static char znak7 = '7';
    public final static char znak8 = '8';
    public final static char znak9 = '9';

    public final static char znakDot = '.';
    public final static char znakC = 'C';

    public final static char znakPlus = '+';
    public final static char znakMinus = '-';
    public final static char znakDziel = '/';
    public final static char znakMnoz = '*';
    public final static char znakRownaSie = '=';

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;

    private JButton button8;
    private JButton button9;
    private JButton buttonPlus;
    private JButton buttonMinus;

    private JButton buttonDivide;
    private JButton buttonMultiply;
    private JButton buttonClear;
    private JButton buttonEqual;
    private JButton buttonDot;
    //private JTextField filed;
    private JLabel field;
    private Model calculatorModel;
    private Controler controler;

    /**
     *
     */
    public View(){
        calculatorModel = new Model();

        controler = new Controler(this, calculatorModel);

        button0 = createButton(String.valueOf(znak0));
        button1 = createButton(String.valueOf(znak1));
        button2 = createButton(String.valueOf(znak2));
        button3 = createButton(String.valueOf(znak3));

        button4 = createButton(String.valueOf(znak4));
        button5 = createButton(String.valueOf(znak5));
        button6 = createButton(String.valueOf(znak6));
        button7 = createButton(String.valueOf(znak7));

        button8 = createButton(String.valueOf(znak8));
        button9 = createButton(String.valueOf(znak9));

        buttonPlus = createButton(String.valueOf(znakPlus));
        buttonMinus = createButton(String.valueOf(znakMinus));


        buttonDivide = createButton(String.valueOf(znakDziel));
        buttonMultiply = createButton(String.valueOf(znakMnoz));
        buttonEqual = createButton(String.valueOf(znakRownaSie));
        buttonDot = createButton(String.valueOf(znakDot));

        buttonClear = createButton(String.valueOf(znakC));

        field = new JLabel(calculatorModel.getResult(), JLabel.RIGHT);
        setFontSize(30);
        field.setVerticalTextPosition(JLabel.CENTER);


        field.setPreferredSize(new Dimension(size, heightLabel));
        field.setMinimumSize(new Dimension(size, heightLabel));
        field.setMaximumSize(new Dimension(size, heightLabel));

        this.setLayout(new BorderLayout());
        this.add(field, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4,4));

        centerPanel.add(button7);
        centerPanel.add(button8);
        centerPanel.add(button9);
        centerPanel.add(buttonMultiply);

        centerPanel.add(button4);
        centerPanel.add(button5);
        centerPanel.add(button6);
        centerPanel.add(buttonMinus);

        centerPanel.add(button1);
        centerPanel.add(button2);
        centerPanel.add(button3);
        centerPanel.add(buttonPlus);

        centerPanel.add(button0);
        centerPanel.add(buttonDot);
        centerPanel.add(buttonEqual);
        centerPanel.add(buttonDivide);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(buttonClear, BorderLayout.SOUTH);

        this.setSize(size, size);
        //this.setLocationByPlatform(true);
        Toolkit kit  = Toolkit.getDefaultToolkit();
        int x = kit.getScreenSize().width/2 - this.getWidth()/2;
        int y = kit.getScreenSize().height/2 - this.getHeight()/2;
        this.setLocation(x,y);
    }
    private JButton createButton(String text){
        JButton button = new JButton(text);
        button.addActionListener(controler);
        return button;
    }

    public void setView(String result)
    {
        if(result.equals(Model.error)) {
            setFontSize(20);
            field.setText("Nie można dzielić przez zero.");
        }

        else{
            setFontSize(30);
            field.setText(result);
        }

    }

    /**
     * Funkcja zmienia rozmiar czcionki
     * @param size - rozmiar czcionki
     */
    private void setFontSize(int size)
    {
        Font font = field.getFont();
        field.setFont(new Font(font.getName(), Font.PLAIN, size));
    }


    public static void main(String []args){
        View window = new View();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

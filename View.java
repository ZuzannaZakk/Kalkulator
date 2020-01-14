import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private static final int size = 300;
    private static final int heightLabel = 40;

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
    /**
     *
     */
    public View(){
        calculatorModel = new Model();
        WriteListener w = new WriteListener(); // sluchacz do dodawania cyfr

        button0 = createButton("0", w);
        button1 = createButton("1", w);
        button2 = createButton("2", w);
        button3 = createButton("3", w);

        button4 = createButton("4", w);
        button5 = createButton("5", w);
        button6 = createButton("6", w);
        button7 = createButton("7", w);

        button8 = createButton("8", w);
        button9 = createButton("9", w);

        ActionListener addListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        };

        ActionListener subListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        };

        ActionListener divListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        };

        ActionListener mulListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        };

        ActionListener eqListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        };

        ActionListener dotListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        };

        buttonPlus = createButton("+", addListener);
        buttonMinus = createButton("-", subListener);


        buttonDivide = createButton("/", divListener);
        buttonMultiply = createButton("*", mulListener);
        buttonEqual = createButton("=", eqListener);
        buttonDot = createButton(".", dotListener);

        ActionListener clearListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatorModel.reset();
                field.setText(calculatorModel.toString());
            }
        };

        buttonClear = createButton("C", clearListener);


        //filed = new JTextField("");
        field = new JLabel(calculatorModel.toString(), JLabel.RIGHT);
        Font font = field.getFont();
        field.setFont(new Font(font.getName(), Font.PLAIN, 30));

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

        centerPanel.add(button6);
        centerPanel.add(button5);
        centerPanel.add(button4);
        centerPanel.add(buttonMinus);

        centerPanel.add(button3);
        centerPanel.add(button2);
        centerPanel.add(button1);
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
    private JButton createButton(String text, ActionListener listener){
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    class WriteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String znak = e.getActionCommand();
            //String newText = field.getText() + znak;
            //field.setText(newText);
            int cyfra = Integer.parseInt(znak);
            calculatorModel.addCyfra(cyfra);
            field.setText(calculatorModel.toString());
        }
    }



    public static void main(String []args){
        View window = new View();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

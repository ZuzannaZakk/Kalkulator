public class Model {
    private double score;
    public Model(){
        score = 0;
    }
    public void add(double operand){
        score = score + operand;
    }
    public void sub(double operand){
        score = score - operand;
    }
    public void mul(double operand){
        score = score * operand;
    }
    public void div(double operand){
        score = score / operand;
    }
    public double getScore(){
        return score;
    }
    public String toString(){
        long value = Math.round(score);
        double value2 = value;
        if(value2 == score) // calkowita
            return String.valueOf(value);
        return String.valueOf(score);
    }

    public void reset (){
        score = 0;
    }

    public void addCyfra(int cyfra){
        score = 10 * score + cyfra;
    }
}

package www.omervaizman.co.blackjackomer;

public class Player {
    int Score=0;
    int AceCounter=0;
    int CardCounter=0;
   int ML=70;

    public Player() {
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score += score;
    }

    public int getAceCounter() {
        return AceCounter;
    }

    public void setAceCounter() {
        AceCounter++;
    }

    public int getCardCounter() {
        return CardCounter;
    }

    public void setCardCounter() {
        CardCounter++;
    }
    public void ResetPlayer(){
        AceCounter=0;
        CardCounter=0;
        Score=0;
    }
    public void newScore(int score){
        Score=score;
    }

    public int getML() {
        return ML;
    }

    public void setML() {
        this.ML +=80;
    }
   public void setMLvalue(int ML){
       this.ML=ML;
    }

    public void reserML(){
        this.ML=70;
    }
}

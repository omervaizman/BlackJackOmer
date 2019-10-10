package www.omervaizman.co.blackjackomer;

public class Card {
  private int CardType;  //'H'=1,'D'=2,'C'=3,'S'=4
    private int CardValue;

    //--------------------------------------------------------------
    public Card(int cardType, int cardValue) {
        CardType = cardType;
        CardValue = cardValue;
    }
    //--------------------------------------------------------------
    public int getCardType() {
        return CardType;
    }
    //--------------------------------------------------------------
    public void setCardType(char cardType) {
        CardType = cardType;
    }
    //--------------------------------------------------------------
    public int getCardValue() {
        return CardValue;
    }
    //--------------------------------------------------------------
    public void setCardValue(int cardValue) {
        CardValue = cardValue;
    }
    //--------------------------------------------------------------
    public int getRealCardValue(){
        if (this.CardValue>10){
            return 10;
        }
            return this.CardValue;

    }
    //--------------------------------------------------------------



}

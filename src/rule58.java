import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class rule58 {

    enum Suit {CLUB, DIAMOND, HEART, SPACE}
    enum Rank {ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    public static void main(String[] args) {
        for(Iterator<Suit> i = suits.iterator(); i.hasNext();)
            for(Iterator<Rank> j = ranks.iterator(); j.hasNext();){
                i.next();
                j.next();
            }

        for(Iterator<Suit> i = suits.iterator(); i.hasNext();){
            Suit suit = i.next();
            for(Iterator<Rank> j = ranks.iterator(); j.hasNext();){
                j.next();
            }
        }

        for(Suit suit: suits)
            for(Rank rank: ranks){

            }
    }


}

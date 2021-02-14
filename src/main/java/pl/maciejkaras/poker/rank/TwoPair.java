package pl.maciejkaras.poker.rank;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.Optional;
import java.util.Set;

import static pl.maciejkaras.poker.model.PokerHand.TWO_PAIR;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.cardIndexArray;

public class TwoPair implements PokerRank {

    @Override
    public Optional<PokerHand> identify(Set<Card> cards) {
        int[] cardIndexArray = cardIndexArray(cards);
        int numberOfPair = 0;

        for (int value : cardIndexArray) {
            if (value == 2) {
                numberOfPair++;
            }
        }

        if (numberOfPair == 2) {
            return Optional.of(TWO_PAIR);
        }

        return Optional.empty();
    }
}

package pl.maciejkaras.poker.rank;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.Optional;
import java.util.Set;

import static pl.maciejkaras.poker.model.PokerHand.ONE_PAIR;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.isNumberOfKind;

public class OnePair implements PokerRank {

    @Override
    public Optional<PokerHand> identify(Set<Card> cards) {
        if (isNumberOfKind(cards, 2)) {
            return Optional.of(ONE_PAIR);
        }

        return Optional.empty();
    }
}

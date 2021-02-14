package pl.maciejkaras.poker.rank;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.Optional;
import java.util.Set;

import static pl.maciejkaras.poker.model.PokerHand.STRAIGHT;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.isStraight;

public class Straight implements PokerRank {
    @Override
    public Optional<PokerHand> identify(Set<Card> cards) {
        if (isStraight(cards)) {
            return Optional.of(STRAIGHT);
        }

        return Optional.empty();
    }
}

package pl.maciejkaras.poker.rank;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.Optional;
import java.util.Set;

import static pl.maciejkaras.poker.model.PokerHand.STRAIGHT_FLUSH;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.isFlush;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.isStraight;

public class StraightFlush implements PokerRank {

    @Override
    public Optional<PokerHand> identify(Set<Card> cards) {
        if (!isFlush(cards)) {
            return Optional.empty();
        }

        if (!isStraight(cards)) {
            return Optional.empty();
        }

        return Optional.of(STRAIGHT_FLUSH);
    }
}

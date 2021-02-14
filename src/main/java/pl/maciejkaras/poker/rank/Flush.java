package pl.maciejkaras.poker.rank;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.Optional;
import java.util.Set;

import static pl.maciejkaras.poker.model.PokerHand.FLUSH;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.isFlush;

public class Flush implements PokerRank {

    @Override
    public Optional<PokerHand> identify(Set<Card> cards) {
        if (isFlush(cards)) {
            return Optional.of(FLUSH);
        }

        return Optional.empty();
    }
}

package pl.maciejkaras.poker.rank;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.Optional;
import java.util.Set;

import static pl.maciejkaras.poker.model.PokerHand.THREE_OF_A_KIND;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.isNumberOfKind;

public class ThreeOfAKind implements PokerRank {

    @Override
    public Optional<PokerHand> identify(Set<Card> cards) {
        if (isNumberOfKind(cards, 3)) {
            return Optional.of(THREE_OF_A_KIND);
        }

        return Optional.empty();
    }
}

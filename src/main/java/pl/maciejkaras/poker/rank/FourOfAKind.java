package pl.maciejkaras.poker.rank;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.Optional;
import java.util.Set;

import static pl.maciejkaras.poker.model.PokerHand.FOUR_OF_A_KIND;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.isNumberOfKind;

public class FourOfAKind implements PokerRank {

    @Override
    public Optional<PokerHand> identify(Set<Card> cards) {
        if (isNumberOfKind(cards, 4)) {
            return Optional.of(FOUR_OF_A_KIND);
        }

        return Optional.empty();
    }
}

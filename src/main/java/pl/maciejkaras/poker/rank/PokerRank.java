package pl.maciejkaras.poker.rank;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.Optional;
import java.util.Set;

public interface PokerRank {

    Optional<PokerHand> identify(Set<Card> cards);

}

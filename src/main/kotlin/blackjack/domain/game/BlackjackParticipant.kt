package blackjack.domain.game

import blackjack.domain.betting.BettingMoney
import blackjack.domain.participant.Dealer
import blackjack.domain.participant.Player

class BlackjackParticipant private constructor(
    val dealer: Dealer,
    val players: List<Player>
) {
    companion object {
        fun of(dealer: Dealer, names: List<String>, money: (String) -> (BettingMoney)): BlackjackParticipant {
            val players = mutableListOf<Player>()
            names.forEach { name ->
                players.add(Player(name, money(name)))
            }
            return BlackjackParticipant(dealer, players)
        }
    }
}

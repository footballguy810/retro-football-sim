package io.retrofootballfuture.sim;

import java.util.*;

public class DraftSystem {
    private List<Player> draftPool;

    public DraftSystem(List<Player> pool) {
        this.draftPool = pool;
    }

    public Player draftPlayer(Team team) {
        Player best = draftPool.stream().max(Comparator.comparingInt(Player::getSkill)).orElse(null);
        if (best != null) {
            team.addPlayer(best);
            draftPool.remove(best);
        }
        return best;
    }
}
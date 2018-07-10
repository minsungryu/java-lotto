package lotto.domain;

public enum Rank {

    FAIL(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    public static final int BONUS_MATCH = 5;

    private final int match;
    private final int prize;
    private final boolean bonus;

    Rank(int match, int prize) {
        this(match, prize, false);
    }

    Rank(int match, int prize, boolean bonus) {
        this.match = match;
        this.prize = prize;
        this.bonus = bonus;
    }

    public static int prizeOf(int match) {
        return Rank.prizeOf(match, false);
    }

    public static int prizeOf(int match, boolean bonus) {
        return Rank.of(match, bonus).prize;
    }

    public static Rank of(int match) {
        return Rank.of(match, false);
    }

    public static Rank of(int match, boolean bonus) {
        if (bonus && match == FIRST.match) {
            throw new RuntimeException();
        }
        if (bonus && match == BONUS_MATCH) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.match == match) {
                return rank;
            }
        }
        return FAIL;
    }

    @Override
    public String toString() {
        if (bonus && match == BONUS_MATCH) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", match, prize);
        }
        return String.format("%d개 일치 (%d원)", match, prize);
    }

}

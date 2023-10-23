package baseball.domain;

public enum Hint {

    STRIKE("스트라이크"),
    BALL("볼"),
    ;

    private static final String NO_HINT = "낫싱";

    private final String symbol;
    private int count;

    static {
        STRIKE.count = 0;
        BALL.count = 0;
    }

    Hint(String symbol) {
        this.symbol = symbol;
    }

    public static void initialize() {
        STRIKE.count = 0;
        BALL.count = 0;
    }

    public static String getResultMessage() {
        if (isNothing()) {
            return NO_HINT;
        }

        return String.join(" ", BALL.summary(), STRIKE.summary()).trim();
    }

    public static boolean isWin() {
        return Hint.STRIKE.count == 3;
    }

    private static boolean isNothing() {
        return BALL.count == 0 && STRIKE.count == 0;
    }

    public void addCount() {
        this.count += 1;
    }

    public String summary() {
        if (isExist()) {
            return count + symbol;
        }
        return "";
    }

    private boolean isExist() {
        return count != 0;
    }
}

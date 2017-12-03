package ohtu;

public class TennisGame {

    private int player1_score = 0;
    private int player2_score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.contains("player1")) {
            player1_score += 1;
        } else {
            player2_score += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (player1_score == player2_score) {
            score = getTie(player1_score);
        } else if (player1_score >= 4 || player2_score >= 4) {
            score = getWinnerOrAdvantage();
        } else {
            score = getSituation(player1_score, player2_score);
        }
        return score;
    }

    private String getWinnerOrAdvantage() {
        int decideWinner = player1_score - player2_score;
        if (decideWinner == 1) {
            return "Advantage player1";
        } else if (decideWinner == -1) {
            return "Advantage player2";
        } else if (decideWinner >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getTie(int player1_score) {
        String score = "";
        score += getScoreName(player1_score);
        if (!score.contains("Deuce")) {
            score += "-All";
        }
        return score;
    }

    private String getSituation(int player1_score, int player2_score) {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1_score;
            } else {
                score += "-";
                tempScore = player2_score;
            }
            score += getScoreName(tempScore);
        }
        return score;
    }

    private String getScoreName(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }
}


public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";

        if (m_score1==m_score2)
        {
            score = tie(m_score1);
        }
        else if (m_score1>=4 || m_score2>=4) {
            score = scoreMoreThanFour(m_score1, m_score2);
        }
        else {
            score = scoreLessThanFour(m_score1, m_score2);
        }

        return score;
    }

    public String tie(int score) {
        switch (score) {
            case 0:
                return "Love-All";

            case 1:
                return "Fifteen-All";

            case 2:
                return "Thirty-All";

            default:
                return "Deuce";
        }
    }

    public String scoreExpected(int score) {
        switch(score) {
            case 0:
                return "Love";

            case 1:
                return "Fifteen";

            case 2:
                return "Thirty";

            case 3:
                return "Forty";

            default:
                return "";
        }
    }

    public String scoreLessThanFour(int score1, int score2) {
        String score1Expected = scoreExpected(score1);
        String score2Expected = scoreExpected(score2);

        return score1Expected +"-"+ score2Expected;
    }

    public String scoreMoreThanFour(int score1, int score2) {
        int minusResult = score1 - score2;

        if (minusResult==1) {
            return "Advantage player1";
        } else if (minusResult ==-1) {
            return "Advantage player2";
        } else if (minusResult>=2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

}

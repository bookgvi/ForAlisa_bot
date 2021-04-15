package BotSimple;

import java.util.StringTokenizer;

public class TextHandler {
    private final int howQuestion = 2;
    private final int simpleQuestion = 12;
    private final String howAnswer = "А тебе какое дело?";
    private String yes = "Ага";
    private String no = "Неть";

    public String handler(String msg) {
        String _answer = msg;
        int questionType = msg.split("Как").length;
        questionType = questionType != 2
                ? msg.contains("?")
                    ? simpleQuestion
                    : 0
                : questionType;
        System.out.printf("\n%s\n", questionType);
        switch (questionType) {
            case simpleQuestion:
                _answer = new YesNoWtf().yesOrNo();
            break;
            case howQuestion:
                _answer = howAnswer;
            break;
        }
        return _answer;
    }
}


import java.util.Random;
import java.util.Scanner;

public class QuizSystem {
    private String quizQuestion;
    private String[] quizArray, shuffledQuizArray;

    QuizSystem (String quizQuestion, String quizCorrectAnswer, String quizWrongAnswer1, String quizWrongAnswer2, String quizWrongAnswer3) {
        this.quizQuestion = quizQuestion;

        this.quizArray = new String[]{quizCorrectAnswer, quizWrongAnswer1, quizWrongAnswer2, quizWrongAnswer3};
        this.shuffledQuizArray = shuffleAnswers(this.quizArray);
    }

    public String getQuizQuestion() { return quizQuestion; }

    public String getQuizCorrectAnswer() { return quizArray[0]; }




    private String[] shuffleAnswers(String[] ArrayToShuffle) {
        Random random = new Random();
        String[] shuffledArray = ArrayToShuffle.clone();

        //Fisher-Yates shuffle Link: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
        for (int i = shuffledArray.length - 1 ; i > 0 ; i--) {
            int j = random.nextInt(i + 1);

            String temp = shuffledArray[j];
            shuffledArray[j] = shuffledArray[i];
            shuffledArray[i] = temp;
        }
        return shuffledArray;
    }

    public void startQuiz() {
        System.out.println(quizQuestion);
        for (int i = 0; i < shuffledQuizArray.length; i++) {
            System.out.println(String.format("%d. ", i + 1) + shuffledQuizArray[i]);
        }

        Scanner sc = Game.getScanner();
        System.out.println("Type the number next to an answer to pick");
        System.out.print(">");
        int choice = sc.nextInt();
        System.out.println(choice + "     :" + shuffledQuizArray[choice-1] + ":" + quizArray[0]);
        if(shuffledQuizArray[choice-1].equals(quizArray[0])){
            System.out.println("You answered the quiz correctly, and is rewarded with + 10 energy");
            Player.getPlayer().setMaxEnergy(Player.getPlayer().getMaxEnergy()+10);
        }else {
            System.out.println("You answered the quiz wrongly, you are not rewarded");
        }

        QuizRegistry.quiz.remove(0);

    }
}
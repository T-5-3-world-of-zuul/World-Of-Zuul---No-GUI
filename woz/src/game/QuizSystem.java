package src.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import src.gui.MainAppController;
public class QuizSystem {
    private String quizQuestion;
    private String[] quizArray, shuffledQuizArray;
    PlayerEnergy player = PlayerEnergy.getPlayer();
    QuizSystem (String quizQuestion, String quizCorrectAnswer, String quizWrongAnswer1, String quizWrongAnswer2, String quizWrongAnswer3) {
        this.quizQuestion = quizQuestion;

        this.quizArray = new String[]{quizCorrectAnswer, quizWrongAnswer1, quizWrongAnswer2, quizWrongAnswer3};
        this.shuffledQuizArray = shuffleAnswers(this.quizArray);
    }

    private boolean quizTaken = false;
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

    public List<Button> startQuiz() {

        System.out.println(quizQuestion);
        String outText = quizQuestion;
        Game.getRegistry().setOutput(outText);

        List<Button> btnList = new ArrayList<Button>();

        for (int i = 0; i < shuffledQuizArray.length; i++) {
            System.out.println(String.format("%d. ", i + 1) + shuffledQuizArray[i]);
            Button tempBtn = new Button(String.format("%d. ", i + 1) + shuffledQuizArray[i]);
            int finalI = i;
            tempBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(!quizTaken){
                        if (shuffledQuizArray[finalI].equals(quizArray[0])){
                            Game.getRegistry().setOutput("You answered correctly and is rewarded with +10 max energy");
                            player.setMaxEnergy(player.getMaxEnergy()+10);
                            quizTaken = true;

                        } else {
                            Game.getRegistry().setOutput("You answered wrongly");
                        }
                        MainAppController.activateAllPanes();


                    }
                }
            });
            btnList.add(tempBtn);
        }

        /*
        Scanner sc = Game.getScanner();
        System.out.println("Type the number next to an answer to pick");
        System.out.print(">");
        int choice = sc.nextInt();

        if(shuffledQuizArray[choice-1].equals(quizArray[0])){
            System.out.println("You answered the quiz correctly, and is rewarded with + 10 energy");
            player.setMaxEnergy(player.getMaxEnergy()+10);
        }else {
            System.out.println("You answered the quiz wrongly, you are not rewarded");
        }
        */
        QuizRegistry.quiz.remove(0);
        return btnList;
    }

    public boolean getQuizTaken(){
        return quizTaken;
    }
}
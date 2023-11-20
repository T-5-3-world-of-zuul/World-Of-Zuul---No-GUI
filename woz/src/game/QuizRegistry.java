package src.game;

import java.util.ArrayList;

public class QuizRegistry {

    static ArrayList<QuizSystem> quiz = new ArrayList<QuizSystem>();



    static QuizSystem round1Quiz = new QuizSystem(
            "A drought appears when?",
            "The region experiences a small amount of downpour",
            "The region experiences a large amount of downpour",
            "The region experiences cold winds",
            "The region experiences warm winds");
    static QuizSystem round2Quiz = new QuizSystem(
            "What danger does a flood present to crops?",
            "A flood may drown or trample crops",
            "During a flood not enough sunlight reaches the crops",
            "During a flood stones get flung around, ripping crops apart",
            "During a flood the water becomes unclean damaging crops");
    static QuizSystem round3Quiz = new QuizSystem(
            "How fast does desert locust multiply?",
            "They can multiply up to twenty fold every three months",
            "They can up to quadruple every three months",
            "They can multiply up to ten fold every three months",
            "They can up to double every three months");
    static QuizSystem round4Quiz = new QuizSystem(
            "Which of the following is a potential danger associated with hailstorms?",
            "A hailstorm may cause crop damage in the affected area.",
            "Hailstorms may cause flooding in the affected area.",
            "Hail can disrupt air circulation. This could raise the temperature in the area.",
            "Hail has no negative impact on agriculture.");
    static QuizSystem round5Quiz = new QuizSystem(
            "How to reduce the changes of B. fusca?",
            "Increase the number of predators and parasites to reduce the number of B.fusca larvae.",
            "Burning entire crops as a precaution.",
            "Overwater crops so that larvae suffocate to death.",
            "There is no way to control or reduce Busseola Fusca.");
    static QuizSystem round6Quiz = new QuizSystem(
            "What will happen if farm fields are not protected from larvae?",
            "Larvae can cause significant damage to crops by consuming plant material, leading to reduced growth and yield.",
            "Larvae are natural pollinators and do not pose a threat to crops.",
            "Larvae have a significant positive impact on biodiversity, which benefits the ecosystem of the region in which they live.",
            "Larvae are very useful for farm fields. There is no need to take any precautions");
    static QuizSystem round7Quiz = new QuizSystem(
            "Which f the following options ensures optimal soil nutrition and effective agriculture? ",
            "NPK fertilizers may help nutritionally enrich the soil.",
            "Increasing sunlight exposure helps to nutritionally enrich the soil.",
            "Watering the field less frequently can aid in nutrient retention.",
            "Planting more of the same crops could help the soil in retaining its nutrients.");



    public static void initQuiz(){
        quiz.add(round1Quiz);
        quiz.add(round2Quiz);
        quiz.add(round3Quiz);
        quiz.add(round4Quiz);
        quiz.add(round5Quiz);
        quiz.add(round6Quiz);
        quiz.add(round7Quiz);

    }
}

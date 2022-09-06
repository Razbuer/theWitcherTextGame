package ru.rusyaevmax.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private static volatile Game instance;
    private Map<String, Paragraph> gameWay = new HashMap<>();

    private Game(){ init();}

    public static Game getInstance() {
        if (instance == null) {
            synchronized (Game.class) {
                if (instance == null) {
                    instance = new Game();
                }
            }
        }

        return instance;
    }

    private void init() {
        Paragraph infoAboutEnemy = new Paragraph("start", "Хорошо, {playerName}. Завелось у нас тут чудище");
        putGameWay(infoAboutEnemy);

        Paragraph acceptOrder = new Paragraph("принять заказ", "В бой!");
        Paragraph refuseOrder = new Paragraph("отказаться от заказа", "Ну и сдох ведьмак от голода");
        infoAboutEnemy.getChoices().add(acceptOrder);
        infoAboutEnemy.getChoices().add(refuseOrder);
        putGameWay(acceptOrder);
        putGameWay(refuseOrder);
    }

    private void putGameWay(Paragraph paragraph) {
        gameWay.put(paragraph.getTextLink(), paragraph);
    }

    public Map<String, Paragraph> getGameWay() {
        return gameWay;
    }
}

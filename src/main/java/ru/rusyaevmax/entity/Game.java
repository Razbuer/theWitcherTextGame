package ru.rusyaevmax.entity;

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
        Paragraph infoAboutEnemy = new Paragraph("start", "- Приятно познакомиться, {playerName}. На рынке у Третогорских ворот завелась наглая бестия, домовым называется. Хотя людей чудовище не трогает, причиняет оно торговцам значительные убытки. Если поймаешь и убьёшь этого домового получишь немалую награду. <br/> - И не нужно мешкать, поскольку розничная торговля есть хребет здоровой экономики, и финансовое благополучие городских купцов в наших же интересах. <br/> - Ну что, ты нам поможешь?");
        putGameWay(infoAboutEnemy);

        Paragraph acceptOrder = new Paragraph("принять заказ", "Со слов купца ты узнаешь, что эта бестия оказывается - гнусный толстых кошак. Дело становится ещё интереснее.");
        Paragraph refuseOrder = new Paragraph("отказаться от заказа", "К сожалению ведьмаки живут только с денег с заказов, по этому город продолжила опустошать беспощадная бестия, а ведьмак умер с голоду!");
        infoAboutEnemy.getChoices().add(acceptOrder);
        infoAboutEnemy.getChoices().add(refuseOrder);
        putGameWay(acceptOrder);
        putGameWay(refuseOrder);

        Paragraph lookAround = new Paragraph("осмотреться", "Оказывается, уже многие продавцы рынка стали жертвами этого гигантского кота. Прямоходящий кот, обворовывающий торговцев? Такого ведьмак за всю карьеру ещё не видел. <br> И ведь купец не соврал, отпечатки на самом деле кошачьи, да ещё и какие огромные. Ведут они в сторону улицы.");
        acceptOrder.getChoices().add(lookAround);
        putGameWay(lookAround);

        Paragraph movingOn = new Paragraph("двигаться по следам", "Дальше следы идут вдоль стены в сторону моста. Судя по всему, он убегал из города. <br>Покинув территорию города, ты заметил последние следы, которые обрываются на краю моста. Какой вывод? Наш жулик явно спрыгнул в воду. Можете оббежать по земле или поиграть в Assassin’s Creed и совершить прыжок веры с моста в воду.");
        lookAround.getChoices().add(movingOn);
        putGameWay(movingOn);

        Paragraph jumpIntoTheWater = new Paragraph("прыгнуть в воду", "Мда, ассасин из тебя никакой, на поверхности воды были острые камни. <br>Падения ты не пережил...");
        Paragraph runAroundGround = new Paragraph("оббежать по земле", "Как и ожидалось, на берегу обнаружатся новые следы похитителя. Самое интересное, что через пару шагов отпечатки лап превратятся в следы от ботинок. Кот в сапогах? Становится все интереснее и интереснее. <br>Довольно быстро следы привели тебя ко входу в дом домового, который будет настежь открыт. Никого дома не обнаружится, поэтому придется поискать зацепки самому. <br>Возле кровати набросано много разной одежды - женской, мужской и даже детской. <br>Ты понимаешь, что имеешь дело с допплером.");
        movingOn.getChoices().add(jumpIntoTheWater);
        movingOn.getChoices().add(runAroundGround);
        putGameWay(jumpIntoTheWater);
        putGameWay(runAroundGround);

        Paragraph getOutOfHouse = new Paragraph("выйти из дома", "Выйдя из дома ты замечаешь странного стражника. <br>В этот раз допплер решил притвориться храмовым стражником. Сделал он это весьма неудачно, ведь разговор стражника с эльфом для Новиграда - это дикость, нелюдей и чародеев здесь не любят. Тем более стража.");
        runAroundGround.getChoices().add(getOutOfHouse);
        putGameWay(getOutOfHouse);

        Paragraph comeUp = new Paragraph("подойти ближе", "Подойдя ближе, допплер сразу понял в чём дело и решил уровнять силы, а именно принимает твой облик. Довольно странно, но забавно.");
        getOutOfHouse.getChoices().add(comeUp);
        putGameWay(comeUp);

        Paragraph attack = new Paragraph("вступить в драку", "Ты выхватываешь свой серебрянный меч, и наносишь удар в прыжке, но допплер как ни странно уворачивается и парирует все твои удары. Но длится это не долго, ты догадываешь использовать знак Аард, допплер падает и ты отрубаешь ему голову.<br>Битва закончена, допплер вооплотился в своё первоначальное обличие. Пора идти за наградой.");
        Paragraph speak = new Paragraph("поговорить с допплером", "После разговора с допплером, ты понимаешь, что у всех есть свои мотивы и что он безобидный. <br>Допплер приглашает тебя к себе домой, чтобы отметить новое знакомство.<br>Заказ конечно же ты не выполняешь, оставляя допплеа живым, но обзоводишься новым другом, это и есть настоящая ПОБЕДА!");
        comeUp.getChoices().add(attack);
        comeUp.getChoices().add(speak);
        putGameWay(attack);
        putGameWay(speak);

        Paragraph payment = new Paragraph("идти к купцу", "Купцу ты рассказываешь, что это бы никакой не домовой, а обычный допплер.<br>Купец щедро одаривает тебя чеканной монетой. И ты уходишь в поиске новых заказов!");
        attack.getChoices().add(payment);
        putGameWay(payment);
    }

    private void putGameWay(Paragraph paragraph) {
        gameWay.put(paragraph.getTextLink(), paragraph);
    }

    public Map<String, Paragraph> getGameWay() {
        return gameWay;
    }
}

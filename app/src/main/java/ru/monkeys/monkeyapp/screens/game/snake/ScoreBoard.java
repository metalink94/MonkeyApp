package ru.monkeys.monkeyapp.screens.game.snake;

import android.graphics.Canvas;
import android.graphics.Paint;
import ru.monkeys.monkeyapp.engine.AbstractGamePanel;
import ru.monkeys.monkeyapp.engine.actor.PositionedActor;

public class ScoreBoard extends PositionedActor {
    private int score;

    public ScoreBoard(AbstractGamePanel context) {
        super(context.getWidth() - 150, 30);
        this.score = 0;
    }

    @Override
    public void stylePaint(Paint p) {
        p.setTextSize(20);
    }

    public void earnPoints(int points) {
        score += points;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("Score: " + score, getX(), getY(), getPaint());
    }

}

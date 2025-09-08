package com.example.game;

public class SpeedBoost extends CharacterDecorator {
    private final int boost;

    public SpeedBoost(Character wrapped, int boost) {
        super(wrapped);
        this.boost = boost;
    }

    @Override
    public void move() {
        System.out.println("Zoom! Speed boosted to " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + boost;
    }
}

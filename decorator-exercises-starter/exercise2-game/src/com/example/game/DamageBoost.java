package com.example.game;

public class DamageBoost extends CharacterDecorator {
    private final int boost;

    public DamageBoost(Character wrapped, int boost) {
        super(wrapped);
        this.boost = boost;
    }

    @Override
    public void attack() {
        System.out.println("Smash! Damage boosted to " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getDamage() {
        return super.getDamage() + boost;
    }
}

package com.example.game;

public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character wrapped) {
        super(wrapped);
    }

    @Override
    public void move() {
        System.out.println("Golden aura surrounds you");
        super.move();
    }

    @Override
    public void attack() {
        System.out.println("Golden aura empowers your attack");
        super.attack();
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + 2; // small buff
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 5; // small buff
    }

    @Override
    public String getSprite() {
        return "golden_" + super.getSprite();
    }
}

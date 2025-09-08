package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String userHandle;

    public WhatsAppDecorator(Notifier wrapped, String userHandle) {
        super(wrapped);
        this.userHandle = userHandle;
    }

    @Override
    public void notify(String text) {
        System.out.println("[WhatsApp -> " + userHandle + "]: " + text);
        super.notify(text);
    }
}

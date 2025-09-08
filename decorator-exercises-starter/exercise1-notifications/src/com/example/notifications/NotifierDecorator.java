package com.example.notifications;

/**
 * Base decorator — delegates to another Notifier.
 */
public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrapped;

    public NotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void notify(String text) {
        if (wrapped != null) {
            wrapped.notify(text);
        }
    }
}

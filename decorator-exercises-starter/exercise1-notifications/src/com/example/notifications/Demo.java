package com.example.notifications;

public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline
        base.notify("Baseline email only.");

        // a) Email + SMS
        Notifier smsAndEmail = new SmsDecorator(base, "+91-99999-11111");
        smsAndEmail.notify("Build green");

        // b) Email + WhatsApp
        Notifier waAndEmail = new WhatsAppDecorator(base, "user_wa");
        waAndEmail.notify("Deployment started");

        // c) Email + Slack
        Notifier slackAndEmail = new SlackDecorator(base, "alerts");
        slackAndEmail.notify("Error logs detected");

        // d) Email + WhatsApp + Slack
        Notifier full = new SlackDecorator(
                new WhatsAppDecorator(base, "user_wa"),
                "deployments");
        full.notify("Deployment completed");
    }
}

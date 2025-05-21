package org.coreconcepts.solid_principles.ocp;

public interface NotificationService {
    public void sendOTP(String medium);
    public void sendTransactionReport(String medium);
}

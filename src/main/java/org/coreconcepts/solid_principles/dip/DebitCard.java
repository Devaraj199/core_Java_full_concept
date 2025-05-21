package org.coreconcepts.solid_principles.dip;

public class DebitCard implements BankCard {

    @Override
    public void doTransaction(long amount) {
        System.out.println("Payment using Debit card");
    }
}

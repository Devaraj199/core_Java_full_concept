package org.coreconcepts.solid_principles.dip;

public class ShoppingMall {

    private BankCard bankCard;

    public ShoppingMall(BankCard debitCard) {
        this.bankCard = debitCard;
    }

    public void doPurchaseSomething(Long amount) {
        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        BankCard bankCard= new CreditCard();
        ShoppingMall shoppingMall = new ShoppingMall(bankCard);
        shoppingMall.doPurchaseSomething(5000L);
    }
}

package ATMLLD.entites;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    Map<String, Card> cards;
    Map<String,Account> accounts;
    Map<Card,Account> cardAccountMap;
    
    public BankService(){
        this.cards = new HashMap<>();
        this.accounts = new HashMap<>();
        this.cardAccountMap = new HashMap<>();

        Account acc1 = createAccount("123-456", 300);
        Account acc2 = createAccount("789-123", 250);

        Card c1 = createCard("c1", "1234");
        Card c2 = createCard("c2", "9108");

        linkCardToAccount(c2, acc2);
        linkCardToAccount(c1, acc1);
    }

    public Account createAccount(String number, int amount){
        Account acc = new Account(number, amount);
        accounts.put(number,acc);
        return acc;
    }

    public Card createCard(String cardNumber, String pin){
        Card card = new Card(cardNumber, pin);
        cards.put(cardNumber,card);
        return card;
    }

    public void linkCardToAccount(Card card,Account acc){
        acc.getCards().put(card.getCardNumber(), card);
        cardAccountMap.put(card, acc);
    }

    public void withdraw(Card card, int amount){
        Account acc = cardAccountMap.get(card);
        if(acc.getBalance() < amount){
            System.out.println("Insufficient Balance");
            return;
        }
        acc.withdraw(amount);
    }

    public void deposit(Card card, int amount){
        Account acc = cardAccountMap.get(card);
        acc.deposit(amount);
    }

    public boolean authenticate(Card card, String pin){
        return card.getPin().equals(pin);
    }

    public int getBalance(Card card){
        return cardAccountMap.get(card).getBalance();
    }

    public Card getCard(String cardNumber){
        return cards.getOrDefault(cardNumber, null);
    }
}

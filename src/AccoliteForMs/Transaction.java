package AccoliteForMs;

import java.util.List;
import java.util.stream.Collectors;

/*
Using stream
1.Find average transaction value by orderType
2.Consider only transactions which has amount greater than 10000
 */
final class Transaction {

    private final int id;
    private final int amount;
    private final String orderType;

    public Transaction(int id, int amount, String orderType) {
        this.id = id;
        this.amount = amount;
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", orderType='" + orderType + '\'' +
                '}';
    }

    public int getAmount() {
        return amount;
    }

    public String getOrderType() {
        return orderType;
    }

    public static void main(String[] args){
        List<Transaction> transactionList = List.of(
                new Transaction(1, 100, "Online"),
                new Transaction(2, 11000, "Online"),
                new Transaction(3, 400, "Offline"),
                new Transaction(4, 500, "Offline")
                );

        //1
        transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getOrderType,Collectors.averagingInt(Transaction::getAmount)))
                .entrySet().forEach(System.out::println);

        //2
        transactionList.stream().filter(obj -> obj.getAmount() > 10000).forEach(System.out::println);

    }

}

package bankAccount;

public class Account {


    /*
        Create a static method name is deposit
        parameters are two int(int amountAccount1 , int amountToAdd)
        return type is int

        add amountToAdd to accountNumber
     */
    public static int deposit(int amountAccount1, int amountToAdd) {
        amountAccount1 += amountToAdd;

        return amountAccount1;
    }

    /*
         Create a static method name is withDraw
         parameters are two int(int amountAccount1 , int withdrawAmount)
         return type is int
         remove the withdrawAmount from the  accountAmount

     */
    public static int withDraw(int amountAccount1, int withdrawAmount) {
        amountAccount1 -= withdrawAmount;

        return amountAccount1;
    }


    /*
        Create a static method name is transferOtherUser
        Parameters are 2 objects of Users class(Users  sendingUser , Users receivingUser )and one int (transferAmount)
        Return type is String
        if the transferAmount is greater  than amountAccount1 variable of the object sendingUser
        Then return Sender is poor lol :)
       if the transferAmount is smaller than amountAccount1 variable of the object sendingUser
           ****** Remove 2 percent from the transferAmount
            remove the transferAmount from the sendingUser amountAccount1( you need to use withDraw method)
            add the transferAmount to the receivingUser  amountAccount1 (you need to use deposit method)
        Then return "Transaction is completed successfully"
        For example:
        SendingUser amountAccount1 has 1000 dollar
        receiving user amountAccount1 has 200 dollar
        transferAmount 100
        After the transaction SendingUser amountAccount1 should have 902 dollor
        After the transaction receivingUser amountAccount1 should have 298 dollor
     */
    public static String transferOtherUser(Users sendingUser, Users receivingUser, int transferAmount) {


        String msg = "";
        if (transferAmount > sendingUser.amountAccount1) {
            msg = "Sender is poor lol :)";
        }

        if (transferAmount < sendingUser.amountAccount1) {
            transferAmount -= 2 * transferAmount / 100;
            receivingUser.amountAccount1 = deposit(receivingUser.amountAccount1, transferAmount);
            sendingUser.amountAccount1 = withDraw(sendingUser.amountAccount1, transferAmount);
            msg = "Transaction is completed successfully";
        }

        return msg;
    }



    /*
       Create a static method name is transferToOwnAccount
       parameter is One Users object(you can put any name) , one int transferAmount
       return type is String
       if the transferAmount is greater than variable amountAccount1 of the object of Users
        return "You need more money dude"
       if the transferAmount is smaller than variable amountAccount1 of the object of Users
        ***Remove 2 percent from the transferAmount
          remove the transferAmount from variable amountAccount1 of the object of Users  (use withDraw method)
          add transferAmount to variable amountAccount2 of the object of Users   (use deposit method)
        return "Transaction is completed successfully"
     */

    public static String transferToOwnAccount(Users custom, int transferAmount) {
        String msg2 = "";
        if (transferAmount > custom.amountAccount1) {
            msg2 = "You need more money dude";
        }
        if (transferAmount < custom.amountAccount1) {
            transferAmount -= 1 * transferAmount / 100;
            custom.amountAccount1 = withDraw(custom.amountAccount1, transferAmount);
            custom.amountAccount2 = deposit(custom.amountAccount2, transferAmount);

            msg2 = "Transaction is completed successfully";

        }

        return msg2;
    }
}















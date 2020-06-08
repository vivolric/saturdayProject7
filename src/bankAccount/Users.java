package bankAccount;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Users {

    /*   Not typed here!!!!!!!!!!!!!!! we are not pro! YET ;)
        Create instance variables String ( name, password ,dateOfBirth, marriageStatus,  relativeName, relativeAge, isTransferedSuceesfully)
        Create int  variables (accountNumber ,amountAccount1, accountNumber2, amountAccount2)
        all public
     */
    public String name, password, dateOfBirth, marriageStatus, relativeName, relativeAge, isTransferedSuceesfully;
    public int accountNumber, amountAccount1, accountNumber2, amountAccount2;

    /*
    NOTE:
    Before the constructor create the methods which given under the constructor and than come back to create the constructor
     */
//
    /*
    Create a constructor
    Parameters are String name , password , dateOfBirth , marriageStatus
    int amountAccount1 , amountAccount2
    instance variable name equals to parameter name
    same for password
    same for amountAccount1
    same for amountAccount2
    Following also in the constructor
    variable accountNumber get the the number from the  randomNumberCreader method
    variable accountNumber2 get the the number from the  randomNumberCreader method
    variable marriageStatus equals to CheckMariageStatus method return
    variable dateOfBirth equals to checkAge method return
     */

    public Users(String name, String password, String dateOfBirth, String marriageStatus, int amountAccount1, int amountAccount2) {
        this.name = name;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.marriageStatus = CheckMariageStatus(marriageStatus);
        this.accountNumber = randomNumberCreader();
        this.amountAccount1 = amountAccount1;
        this.accountNumber2 = randomNumberCreader();
        this.amountAccount2 = amountAccount2;
    }

   /*
        Create method name is  CheckMariageStatus
        parameter is String(marriageStatus)
        return type is String
        if String marriageStatus equals married
        Ask to user (use scanner class)
        Do you want to add  your relative?
        if the user says Yes
        Ask to user
        What is your relative name?
        Ask to user
        Date of birth relative?
        Then Add the relative(Use AddRelative class ) (Hint create an object of AddRelative class)
        relativeName variable equals to AddRelative class fullName
        relativeAge variable equals to AddRelative class age
            if relativeAge equals to "0"
                then change the relativeName to "Relative should be more then 18 years old";
                then change the relativeAge to "Relative should be more then 18 years old";
                return the "Relative should be more then 18 years old";
            if the relativeAge is not equal to "0"
               return "Transaction done successfully"
        If the user say No
        then return no need to add relative.
     */

    public static String checkAge(String myDOB) {

        String msg4 = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(myDOB, formatter);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();
        int monthOfBirth = dateOfBirth.getMonthValue();
        int monthOfCurrent = currentDate.getMonthValue();
        int dayOfBirth = dateOfBirth.getDayOfMonth();
        int dayOfCurrent = currentDate.getDayOfMonth();

        if (age > 18) {

            msg4 = "You can get a credit card";

        } else if (age < 18) {

            msg4 = "You should be at least 18 years old to get a credit card.";

        } else if (age == 18) {

            if (monthOfCurrent > monthOfBirth) {

                msg4 = "You can get a credit card";

            } else if (monthOfCurrent < monthOfBirth) {

                msg4 = "You should be at least 18 years old to get a credit card.";

            } else if (monthOfCurrent == monthOfBirth) {

                if (dayOfCurrent > dayOfBirth) {

                    msg4 = "You can get a credit card";
                } else

                    msg4 = "You should be at least 18 years old to get a credit card.";

            }


        }


        return msg4;
    }

    /*
        Create a static method name is checkAge
        parameter is one String(myDOB)
        return type is String
        Compare today's date to myDOB
        if myDOB compare to today date is greater than  18 then return "You can get a credit card"
        if myDOB compare to today date is less then 18 "You should be at least 18 years old to get a credit card."
        if myDOB compare to today date equals 18 then you need to compare the months.(use nested if)
        if today's monthvalue is greater than myDOB's monthvalue return "You can get a credit card"
        if today's monthvalue is less than myDOB's monthvalue return "You should be at least 18 years old to get a credit card."
        if today's monthvalue is equal to myDOB's monthvalue , you need to compare day of the months. (use nested if)
        If today's amount of day is greater than myDOB's amount of days return "You can get a credit card"
        else return "You should be at least 18 years old to get a credit card."
        For example today date is 10/05/2020
        if myDOB is 09/05/2002
        return should be  "You can get a credit card"
        if myDOB is 11/05/2002
        return should be  "You should be at least 18 years old to get a credit card."
        Hint: Use LocalDate and Period classes,
     */

    public static int randomNumberCreader() {
        Random random = new Random();

        int randomNumber = random.nextInt(89999999) + 10000000;

        return randomNumber;
    }


    /*
        Create a randomNumberCreader method  which is returning 8 digit number
            it should be between 10000000 - 99999999
            return type is int
     */

    public String CheckMariageStatus(String marriageStatus) {

        Scanner input = new Scanner(System.in);
        String msg3 = "";


        if (marriageStatus.equalsIgnoreCase("married")) {
            System.out.println("Do you want to add add your relative?");
            String answer = input.nextLine();

            if (answer.equalsIgnoreCase("Yes")) ;
            {
                System.out.println("What is your relative name?");
                String name = input.nextLine();

                System.out.println(" Date of birth relative?");
                String date = input.nextLine();

//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//                LocalDate dateOfBirth = LocalDate.parse(date, formatter);
//                LocalDate currentDate = LocalDate.now();
//                int age = Period.between(dateOfBirth, currentDate).getYears();
//                String strAge = String.valueOf(age);
                AddRelative relative = new AddRelative(name, date);
                relativeName = relative.fullName;
                relativeAge = relative.age;
                if (relativeAge.equalsIgnoreCase("0")) {

                    relativeName = "Relative should be more then 18 years old";
                    relativeAge = "Relative should be more then 18 years old";
                    msg3 = "Relative should be more then 18 years old";

                } else if (!relative.age.equalsIgnoreCase("0")) {

                    msg3 = "Transaction done successfully";

                }
            }

            if (answer.equalsIgnoreCase("No")) {
                msg3 = "no need to add relative.";

            }

        }
        return msg3;
    }


    /*
        Create a method name is transfer
        Parameters are two Users(own, other) object
        Return type is void
        In this method
            First ask to user "Do you want to transfer between your accounts or different user" (use scanner class)
        if the answer is own
        Ask to user "Enter amount of money you want to enter"
       this amount will be your transferAmount to use for the transferToOwnAccount method that below
           instance variable isTransferedSuceesfully equals to the the method transferToOwnAccount in the Account class
        if the answer different
        Ask to user "Enter amount of money you want to enter"
        this amount will be your transferAmount to use for the transferOtherUser method that below
         instance variable isTransferedSuceesfully equals to the the method transferOtherUser in the Account class
     */

    public void transfer(Users own, Users other) {

        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to transfer between your accounts or different user");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("own")) {
            System.out.println("Enter amount of money you want to enter");
            int transferAmmount = input.nextInt();
            isTransferedSuceesfully = Account.transferToOwnAccount(own, transferAmmount);
        } else {
            System.out.println("Enter amount of money you want to enter");
            int transferAmmount = input.nextInt();
            isTransferedSuceesfully = Account.transferOtherUser(own, other, transferAmmount);

        }

    }


    /*
        Print the objects using toString method
        like
         return "\nname: " + name +
                "\npassword: " + password+
                "\ndateOfBirth: " + dateOfBirth+
                ......
     */

    @Override
    public String toString() {
        return
                "\nname= " + name +
                        "\npassword= " + password +
                        "\ndateOfBirth= " + dateOfBirth +
                        "\nmarriageStatus='" + marriageStatus +
                        "\nrelativeName='" + relativeName +
                        "\nrelativeAge='" + relativeAge +
                        "\nisTransferedSuceesfully='" + isTransferedSuceesfully +
                        "\naccountNumber=" + accountNumber +
                        "\namountAccount1=" + amountAccount1 +
                        "\naccountNumber2=" + accountNumber2 +
                        "\namountAccount2=" + amountAccount2;
    }
}
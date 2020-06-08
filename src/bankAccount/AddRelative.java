package bankAccount;

public class AddRelative {


    /*
    Create an instance variable
        String fullName , String age
     */
    String fullName;
    String age;

    /*
        Create a constructor AddRelative
            parameters String fullName and  String age
        instance variable fullName equals to parameter fullName
        If the age is greater than  and equal to 18, so the  instance variable age equals to parameter age (use relativeAgeChecker method)
        If the age is less than 18, so the instance variable age equals to "0"
     */


    public AddRelative(String fullName, String age) {
        this.fullName = fullName;

        if (relativeAgeChecker(age)) {
            this.age = age;
        } else {
            this.age = "0";
        }
        System.out.println(this.fullName);
        System.out.println(this.age);
    }

   /*
        Create a method name is relativeAgeChecker
        parameter String(relativeAge)
        return type is boolean
        if the relativeAge more and equal to 18 return true
        else false
        Note: use a Users class checkAge method(check which statement gives you the age is greater than and equal to 18)
     */

    public static boolean relativeAgeChecker(String relativeAge) {
        String convertAge = Users.checkAge(relativeAge);
        if (convertAge.equals("You can get a credit card")) {
            return true;
        } else
            return false;
    }
}



package labs;

public class BankAccountApp1
{
    public static void main(String[] args)
    {
        BankAccount1 acc1 = new BankAccount1("286174613" , 1000);
        BankAccount1 acc2 = new BankAccount1("184168134" , 1000);
        BankAccount1 acc3 = new BankAccount1("548131846" , 1000);

        acc1.setName("Mridul Kumar");
        System.out.println(acc1.getName());

        acc1.makeDeposit(500);
        acc1.makeDeposit(600);
        acc1.payBill(200);
        acc1.accrue();
        System.out.println(acc1.toString());
    }
}

class BankAccount1 implements IInterest
{
    private static int id = 1000;  // internal id unique for each person
    private String name;
    private String accountNumber; // id + random 2-digit number + first 2 digit of ssn
    private static final String routingNumber = "12345";
    private String ssn;
    private double balance;

    //Constructor
    public BankAccount1(String ssn , double initDeposit)
    {
        balance = initDeposit;
        System.out.println("New Account Created");
        this.ssn = ssn;
        id++;
        setAccountNumber();
    }

    private void setAccountNumber()
    {
        int random = (int) (Math.random() * 100);
        accountNumber = id + "" + random + ssn.substring(0,2);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void payBill(double amount)
    {
        System.out.println("Paying Bill of Rs" + amount);
        balance = balance - amount;
        showBalance();
    }

    public void makeDeposit(double amount)
    {
        System.out.println("Making deposit of Rs" + amount);
        balance = balance + amount;
        showBalance();
    }

    public void showBalance()
    {
        System.out.println("Your Balance is Rs" + balance);
    }

    @Override
    public void accrue()
    {
        balance = balance * (1 + (rate/100));
        showBalance();
    }

    @Override
    public String toString()
    {
        return ("[Name : " + name + "]\n" + "[Balance : " + balance + "]\n" + "[Account Number : " + accountNumber + "]\n" + "[Routing Number : " + routingNumber + "]\n");
    }
}
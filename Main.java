class Main {
    public static void main(String[] args) {

    }
}

class Bank {
    Person[] users;
    double balance;

    void bankloop() {
        while (true) {
            boolean cont = false;
            for (Person person : users) {
                if (person.alive) {
                    cont = true;
                    break;
                }
            }
            if (!cont) {
                System.exit(0);
            } else {
                monthly();
            }
        }
    }

    void monthly() {
        incrementAge();
        checkAge();
        checkMinimum();
        takeMoney();
    }

    void incrementAge() {
        for (Person person : users) {
            person.age += 1;
        }
    }

    void checkAge() {
        for (Person person : users) {
            if (person.age > 720) {
                person.alive = false;
            }
        }
    }
    void checkMinimum() {
        for (Person person : users) {
            for (Debit account : person.accounts){
            if (account.balance < account.minimum) {
                person.alive = false;
            }
        }
    }
    void takeMoney(){
        for (Person person : users){
            if (person.alive){
                for (Debit account : person.accounts){
                    this.balance += account.balance * account.interestRate;
                    account.balance -= account.balance * account.interestRate; 
                }
            }
        }
    }
    
}

class Person {
    int age;
    boolean alive;
    Debit[] accounts;
}

class Debit {
    double balance;
    double interestRate;
    double minimum;
}

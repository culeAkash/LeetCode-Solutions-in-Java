class Bank {
    private long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }

    private boolean isValid(int index,long money){
        return balance[index] >= money;
    }

    private void withdrawMon(int idx,long money){
        balance[idx] -= money;
    }

    private void depositMon(int idx,long money){
        balance[idx] += money;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1>balance.length || account2 > balance.length)return false;

        if(!isValid(account1-1,money))return false;

        withdrawMon(account1-1,money);
        depositMon(account2-1,money);

        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account>balance.length)return false;

        depositMon(account-1,money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account>balance.length || !isValid(account-1,money))return false;

        withdrawMon(account-1,money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
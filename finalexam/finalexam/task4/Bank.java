package finalexam.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bank implements LegalEntity {
    private String address;
    private String vatNumber;
    private List<Account> accounts;

    public Bank(String address, String vatNumber) {
        this.address = address;
        this.vatNumber = vatNumber;
        this.accounts = new ArrayList<>();
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public boolean deleteAccount(Account account) {
        return accounts.remove(account);
    }

    public List<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public void saveAccountsToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(accounts);
        }
    }

    public void loadAccountsFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            accounts = (List<Account>) ois.readObject();
        }
    }
}

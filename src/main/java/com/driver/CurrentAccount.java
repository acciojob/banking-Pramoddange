package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name, balance,5000); // Call the constructor of the parent class (BankAccount)

        // Minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if (balance < 5000) {
            throw new Exception("Insufficient Balance");
        }

        this.tradeLicenseId = tradeLicenseId;
            }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        // Check if no two consecutive characters are the same

        if (!hasConsecutiveCharacters(tradeLicenseId)) {
            return; // Valid license ID, do nothing
        }

        // Check if characters can be rearranged to create a valid license ID
        if (canRearrangeToValidId(tradeLicenseId)) {
            return; // Valid license ID, do nothing
        }

        // If the conditions are not met, throw an exception
        throw new Exception("Valid License can not be generated");
    }

    private boolean hasConsecutiveCharacters(String licenseId) {
        for (int i = 0; i < licenseId.length() - 1; i++) {
            if (licenseId.charAt(i) == licenseId.charAt(i + 1)) {
                return true; // Consecutive characters are the same
            }
        }
        return false; // No consecutive characters are the same
    }

    private boolean canRearrangeToValidId(String licenseId) {
        // Convert the licenseId to an array of characters for easier manipulation
        char[] charArray = licenseId.toCharArray();

        // Sort the array to group similar characters together
        Arrays.sort(charArray);

        // Check if the sorted array has consecutive characters
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                return true; // Consecutive characters are the same
            }
        }

        return false; // No consecutive characters are the same after sorting
    }



}

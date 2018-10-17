package com.company;

public class Main {

    public static void main(String[] args) {
	    switch (args[0]) {
            case "all": ContactDetailsService.showAllContacts(); break;
            case "add": ContactDetailsService.addNewContact(new ContactDetails(args[1], args[2], args[3])); break;
            case "search": ContactDetailsService.search(args[1]); break;
            case "delete": ContactDetailsService.delete(args[1]); break;
        }
    }
}

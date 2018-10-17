package com.company;

import java.util.List;

class ContactDetailsService {

    static void addNewContact(ContactDetails contactDetails) {
        List<ContactDetails> contacts = ContactDetailsRepo.readArray();
        contacts.add(contactDetails);
        ContactDetailsRepo.writeArray(contacts);
    }

    static void showAllContacts() {
        List<ContactDetails> contacts = ContactDetailsRepo.readArray();
        System.out.println("All contacts:");
        for(ContactDetails cd : contacts) {
            System.out.println(cd.toString());
        }
    }

    static void search(String name) {
        List<ContactDetails> contacts = ContactDetailsRepo.readArray();
        System.out.println("Search results for " + name);

        for (ContactDetails cd: contacts) {
            if (name.equals(cd.getName())) {
                System.out.println(cd.toString());
            }
        }
    }

    static void delete(String name) {
        List<ContactDetails> contacts = ContactDetailsRepo.readArray();

        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).getName()) || name.equals(contacts.get(i).getPhone())) {
                System.out.println("Removing " + contacts.get(i).toString());
                contacts.remove(i);
                i--;
            }
        }

        ContactDetailsRepo.writeArray(contacts);
    }
}

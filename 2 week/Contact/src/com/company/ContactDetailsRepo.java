package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ContactDetailsRepo {

    static void writeArray(List<ContactDetails> contacts) {
        JSONArray jsonContacts = new JSONArray();
        for (ContactDetails cd: contacts) {
            JSONObject obj = new JSONObject();
            obj.put("name", cd.getName());
            obj.put("phone", cd.getPhone());
            obj.put("email", cd.getEmail());
            jsonContacts.add(obj);
        }

        System.out.println(jsonContacts.toJSONString());

        try (FileWriter file = new FileWriter("file.json")) {
            file.write(jsonContacts.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<ContactDetails> readArray() {
        JSONParser parser = new JSONParser();
        List<ContactDetails> contacts = new ArrayList<>();

        try {
            JSONArray jsonContacts = (JSONArray)parser.parse(new FileReader("file.json"));;
            for (Object obj: jsonContacts) {
                JSONObject jsonObject = (JSONObject) obj;
                contacts.add(new ContactDetails((String)jsonObject.get("name"),
                        (String)jsonObject.get("phone"),
                        (String)jsonObject.get("email")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contacts;
    }
}

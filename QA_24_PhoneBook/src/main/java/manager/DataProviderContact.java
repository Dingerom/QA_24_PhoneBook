package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .email("stark@gmail.com")
                .phone("12365332223")
                .description("all fields")
                .build()
        });
        list.add(new Object[]{Contact.builder()
                .name("TonyReq")
                .lastName("Stark")
                .address("NY")
                .email("stark@gmail.com")
                .phone("12365333444")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Stark")
                        .address("NY")
                        .email("stark@gmail.com")
                        .phone("123")
                        .description("wrong phone")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Stark")
                        .address("NY")
                        .email("stark@gmail.com")
                        .phone("12345612345695654255")
                        .description("wrong phone")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Stark")
                        .address("NY")
                        .email("stark@gmail.com")
                        .phone("wwwwwwwwwww")
                        .description("wrong phone")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Stark")
                        .address("NY")
                        .email("stark@gmail.com")
                        .phone("")
                        .description("wrong phone")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()
            });
            line = reader.readLine();
        }

        return list.iterator();
    }


}
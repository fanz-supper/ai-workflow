package com.ai;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * @title: YamlTest
 * @description:
 * @author: zhangfan
 */
public class YamlTest {


    @Test
    public void domainList() {
        String str = """
                modules:
                  - name: Book Management
                    functionality: Manage all books in the library including adding, updating, and removing book records.
                    features:
                      - Add new books to the database
                      - Update existing book details
                      - Remove books from the system
                  - name: User Management
                    functionality: Handle information about library users including registrations and account management.
                    features:
                      - Register new users
                      - Update user information
                      - Manage user roles and permissions
                  - name: Borrowing System
                    functionality: Manage the borrowing and returning of books by users.
                    features:
                      - Track borrowed books
                      - Manage return deadlines
                      - Send reminders for overdue books
                  - name: Search and Catalog
                    functionality: Allow users to search for books and view library catalog.
                    features:
                      - Search for books by title, author, or ISBN
                      - Filter results by genre or availability
                  - name: Reporting
                    functionality: Generate reports related to book loans, user activity, and inventory.
                    features:
                      - Generate monthly borrowing statistics
                      - List popular books based on borrow frequency
                      - Assess library inventory health
                """;


        Yaml yaml = new Yaml();
        Map<String, Object> data  = yaml.load(str);

        Object o = data.get("modules");

    }
}

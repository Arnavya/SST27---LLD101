package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {

    private final NaiveCsvReader reader;
    private final ProfileService service;

    public CsvProfileImporter(NaiveCsvReader reader, ProfileService service) {
        this.reader = Objects.requireNonNull(reader);
        this.service = Objects.requireNonNull(service);
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = reader.read(csvFile);
        int success = 0;

        for (String[] row : rows) {
            if (row.length < 3) {
                System.out.println("Skipping row: not enough columns");
                continue;
            }
            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();

            if (id.isEmpty() || email.isEmpty()) {
                System.out.println("Skipping row: missing id or email");
                continue;
            }
            if (!email.contains("@")) {
                System.out.println("Skipping row: bad email " + email);
                continue;
            }

            try {
                service.createProfile(id, email, displayName);
                success++;
            } catch (Exception e) {
                System.out.println("Skipping row due to error: " + e.getMessage());
            }
        }
        return success;
    }
}

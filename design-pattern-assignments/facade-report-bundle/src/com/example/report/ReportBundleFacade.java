package com.example.report;

import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private final JsonWriter writer;
    private final Zipper zipper;
    private final AuditLog log;

    public ReportBundleFacade(JsonWriter writer, Zipper zipper, AuditLog log) {
        this.writer = Objects.requireNonNull(writer);
        this.zipper = Objects.requireNonNull(zipper);
        this.log = Objects.requireNonNull(log);
    }

    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");

        Path json = writer.write(data, outDir, baseName);
        Path zip = zipper.zip(json, outDir.resolve(baseName + ".zip"));
        log.log("exported " + zip);
        return zip;
    }
}

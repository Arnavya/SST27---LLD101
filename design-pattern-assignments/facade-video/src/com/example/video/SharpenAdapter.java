package com.example.video;

import java.util.Arrays;
import java.util.Objects;

/** Adapter around LegacySharpen to work with Frame[]. */
public class SharpenAdapter {
    private final LegacySharpen legacy;

    public SharpenAdapter(LegacySharpen legacy) {
        this.legacy = Objects.requireNonNull(legacy);
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");
        // Fake handle conversion
        String handle = "HANDLE:frames:" + frames.length;
        String newHandle = legacy.applySharpen(handle, strength);

        // For demo: just return same frames, but show adapter effect
        System.out.println("Applied sharpen via legacy: " + newHandle);
        return Arrays.copyOf(frames, frames.length);
    }
}

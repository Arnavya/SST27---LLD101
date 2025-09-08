package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filters;
    private final Encoder encoder;
    private final SharpenAdapter sharpener;

    public VideoPipelineFacade(Decoder decoder, FilterEngine filters,
                               Encoder encoder, SharpenAdapter sharpener) {
        this.decoder = Objects.requireNonNull(decoder);
        this.filters = Objects.requireNonNull(filters);
        this.encoder = Objects.requireNonNull(encoder);
        this.sharpener = Objects.requireNonNull(sharpener);
    }

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");

        Frame[] frames = decoder.decode(src);

        if (gray) {
            frames = filters.grayscale(frames);
        }
        if (scale != null) {
            frames = filters.scale(frames, scale);
        }
        if (sharpenStrength != null) {
            frames = sharpener.sharpen(frames, sharpenStrength);
        }

        return encoder.encode(frames, out);
    }
}

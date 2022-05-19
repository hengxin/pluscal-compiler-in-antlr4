package com.PlusCal.interp.tlaplus;

import com.PlusCal.parser.PlusCalParser;

import java.io.File;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public final class TlaPlusSpec {

    public static TlaPlusSpec translateFrom(PlusCalParser.AlgorithmContext ctx) {
        ToTlaplusTranslator translator = new ToTlaplusTranslator();
        translator.visitAlgorithm(ctx);
        return new TlaPlusSpec(translator);
    }

    private final ToTlaplusTranslator translator;

    private TlaPlusSpec(ToTlaplusTranslator translator) {
        this.translator = translator;
    }

    public void print() throws IOException {
        translator.writeTo(System.out);
    }

    public Appendable writeTo(Appendable out) throws IOException {
        translator.writeTo(out);
        return out;
    }

    public Path writeTo(Path path, OpenOption...options) throws IOException {
        writeTo(path, StandardCharsets.UTF_8, options);
        return path;
    }

    public Path writeTo(Path path, Charset charset, OpenOption...options) throws IOException {
        final String outputFileName = ""; // TODO
        Path outputPath = path.resolve(outputFileName);
        try (Writer writer = new OutputStreamWriter(
                Files.newOutputStream(outputPath, options), charset)) {
            if (Arrays.stream(options).anyMatch(opt -> opt == StandardOpenOption.APPEND)) {
                writer.append("\n\n");
            }
            writeTo(writer);
        }
        return outputPath;
    }

    public File writeTo(File file) throws IOException {
        final Path outputPath = writeTo(file.toPath(), StandardOpenOption.APPEND);
        return outputPath.toFile();
    }

}

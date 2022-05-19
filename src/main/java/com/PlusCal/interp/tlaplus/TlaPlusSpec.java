package com.PlusCal.interp.tlaplus;

import com.PlusCal.parser.PlusCalParser;

import java.io.File;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

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

    public void print() {
        try {
            translator.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTo(Appendable out) throws IOException {
        translator.writeTo(out);
    }


    public Path writeTo(Path path) throws IOException {
        writeTo(path, StandardCharsets.UTF_8);
        return path;
    }

    public Path writeTo(Path path, Charset charset) throws IOException {
        final String outputFileName = ""; // TODO
        Path outputPath = path.resolve(outputFileName);
        try (Writer writer = new OutputStreamWriter(Files.newOutputStream(outputPath), charset)) {
            writeTo(writer);
        }
        return outputPath;
    }

    public File writeTo(File file) throws IOException {
        final Path outputPath = writeTo(file.toPath());
        return outputPath.toFile();
    }

}

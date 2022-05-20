package com.PlusCal;

import com.PlusCal.interp.PlusCalLogger;
import com.PlusCal.interp.PlusCalParams;
import com.PlusCal.interp.PlusCalTranslator;
import com.PlusCal.interp.pretreatment.PlusCalPretreatmentAnalyser;
import com.PlusCal.interp.tlaplus.TlaPlusSpec;
import com.PlusCal.parser.PlusCalLexer;
import com.PlusCal.parser.PlusCalParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws IOException {
        String file;
        if (args.length > 0) {
            file = args[0];
        }
        else {
            file = "test.pluscal";
        }
        beginTranslation(file);
    }

    @SuppressWarnings("rawtypes")
    private static void beginTranslation(String file) throws IOException {
        CharStream stream = CharStreams.fromFileName(file);
        PlusCalLexer lexer = new PlusCalLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokenStream);
        PlusCalParser parser = new PlusCalParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(PlusCalLogger.getLogger());
        PlusCalPretreatmentAnalyser analyser = new PlusCalPretreatmentAnalyser(rewriter);
        parser.addParseListener(analyser);
        ParseTree tree = parser.algorithm();
        PlusCalLogger.logInfo("----------------------------END PRETREATMENT----------------------------");

        if (parser.getNumberOfSyntaxErrors() == 0 && !PlusCalParams.pretreatmentError) {
            lexer.setInputStream(CharStreams.fromString(rewriter.getText()));
            tokenStream.setTokenSource(lexer);
            parser.setTokenStream(tokenStream);
            parser.removeParseListeners();
            TlaPlusSpec spec = PlusCalTranslator.translate(parser.algorithm());
//            spec.writeTo(new File(file));
            spec.print();
            PlusCalLogger.logInfo("----------------------------END TRANSLATION----------------------------");
        }

    }
}

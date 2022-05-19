package com.PlusCal;

import com.PlusCal.interp.Logger;
import com.PlusCal.interp.PlusCalParams;
import com.PlusCal.interp.PlusCalTranslator;
import com.PlusCal.interp.pretreatment.PlusCalPretreatmentAnalyser;
import com.PlusCal.parser.PlusCalLexer;
import com.PlusCal.parser.PlusCalParser;
import com.PlusCal.parser.PlusCalParserVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {


    @SuppressWarnings("rawtypes")public static void main(String[] args) throws IOException {
        beginTranslation("test.pluscal");
    }

    @SuppressWarnings("rawtypes")
    static void beginTranslation(String file) throws IOException {
        CharStream stream = CharStreams.fromFileName(file);
        PlusCalLexer lexer = new PlusCalLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokenStream);
        PlusCalParser parser = new PlusCalParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(Logger.getLogger());
        PlusCalPretreatmentAnalyser analyser = new PlusCalPretreatmentAnalyser(rewriter);
        parser.addParseListener(analyser);
        ParseTree tree = parser.algorithm();
        Logger.logInfo("----------------------------END PRETREATMENT----------------------------");

        if (parser.getNumberOfSyntaxErrors() == 0 && !PlusCalParams.pretreatmentError) {
            lexer.setInputStream(CharStreams.fromString(rewriter.getText()));
            tokenStream.setTokenSource(lexer);
            parser.setTokenStream(tokenStream);
            parser.removeParseListeners();
            PlusCalTranslator.translate(parser.algorithm());
        }

    }
}

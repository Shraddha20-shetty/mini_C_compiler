import org.antlr.v4.runtime.*;

public class ErrorHandler extends BaseErrorListener {

    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg,
            RecognitionException e) {

        System.out.println("\n===== SYNTAX ERROR =====");

        System.out.println(
            "Syntax Error at Line " +
            line +
            ": " +
            msg
        );
    }
}
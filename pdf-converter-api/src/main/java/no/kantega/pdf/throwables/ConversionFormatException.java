package no.kantega.pdf.throwables;

public class ConversionFormatException extends ConverterException {

    public ConversionFormatException(String message) {
        super(message);
    }

    public ConversionFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}

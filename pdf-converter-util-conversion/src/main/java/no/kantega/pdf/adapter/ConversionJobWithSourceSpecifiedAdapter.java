package no.kantega.pdf.adapter;

import no.kantega.pdf.api.*;

import java.io.File;
import java.io.OutputStream;

public abstract class ConversionJobWithSourceSpecifiedAdapter implements IConversionJobWithSourceSpecified {

    private static final String PDF_FILE_EXTENSION = ".pdf";

    @Override
    public IConversionJobWithTargetUnspecified to(File target) {
        return to(target, NoopFileConsumer.getInstance());
    }

    @Override
    public IConversionJobWithTargetUnspecified to(File target, IFileConsumer callback) {
        return to(new FileConsumerToInputStreamConsumer(target, callback));
    }

    @Override
    public IConversionJobWithTargetUnspecified to(OutputStream target) {
        return to(target, true);
    }

    @Override
    public IConversionJobWithTargetUnspecified to(OutputStream target, boolean closeStream) {
        return to(new OutputStreamToInputStreamConsumer(target, closeStream));
    }

    @Override
    public IConversionJobWithTargetUnspecified to(IInputStreamConsumer callback) {
        return to(makeTemporaryFile(PDF_FILE_EXTENSION), new InputStreamConsumerToFileConsumer(callback));
    }

    protected abstract File makeTemporaryFile(String suffix);
}

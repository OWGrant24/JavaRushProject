package Collections4.Collections1;

public class Level31Task07_NullFileData implements Level31Task07_FileData {
    private Exception exception;

    public Level31Task07_NullFileData(Exception e) {
        this.exception = e;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public boolean isExecutable() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isWritable() {
        return false;
    }
}

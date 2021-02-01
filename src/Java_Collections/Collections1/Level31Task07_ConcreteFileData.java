package Java_Collections.Collections1;

public class Level31Task07_ConcreteFileData implements Level31Task07_FileData {
    private boolean hidden;
    private boolean executable;
    private boolean directory;
    private boolean writable;

    public Level31Task07_ConcreteFileData(boolean hidden, boolean executable, boolean directory, boolean writable) {
        this.hidden = hidden;
        this.executable = executable;
        this.directory = directory;
        this.writable = writable;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public boolean isExecutable() {
        return executable;
    }

    @Override
    public boolean isDirectory() {
        return directory;
    }

    @Override
    public boolean isWritable() {
        return writable;
    }
}

package Java_Collections.Collections1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Level31Task11_SearchFileVisitor extends SimpleFileVisitor<Path> {
    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize = Integer.MAX_VALUE;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (partOfName != null && partOfContent != null) {
            byte[] content = Files.readAllBytes(file);
            String stPart = new String(content);
            if (file.toString().contains(partOfName)
                    && stPart.contains(partOfContent)
                    && minSize <= attrs.size()
                    && maxSize >= attrs.size()) {
                foundFiles.add(file.toAbsolutePath());
            }
        }
        if (partOfName == null && partOfContent != null) {
            byte[] content = Files.readAllBytes(file);
            String stPart = new String(content);
            if (stPart.contains(partOfContent)
                    && minSize <= attrs.size()
                    && maxSize >= attrs.size()) {
                foundFiles.add(file.toAbsolutePath());
            }
        }
        if (partOfName != null && partOfContent == null) {
            byte[] content = Files.readAllBytes(file);
            String stPart = new String(content);
            if (file.toString().contains(partOfName)
                    && minSize <= attrs.size()
                    && maxSize >= attrs.size()) {
                foundFiles.add(file.toAbsolutePath());
            }
        }
        if (partOfName == null && partOfContent == null) {
            if ( minSize <= attrs.size() && maxSize >= attrs.size()) {
                foundFiles.add(file.toAbsolutePath());
            }
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partName) {
        this.partOfName = partName;
    }

    public void setPartOfContent(String partContent) {
        this.partOfContent = partContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}

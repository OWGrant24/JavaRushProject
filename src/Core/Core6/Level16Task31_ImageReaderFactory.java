package Core.Core6;

import Core.Core6.common.*;

public class Level16Task31_ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes){
            if(imageTypes != null) {
                if (imageTypes.equals(ImageTypes.JPG)) {
                    return new JpgReader();
                } else if (imageTypes.equals(ImageTypes.BMP)) {
                    return new BmpReader();
                } else if (imageTypes.equals(ImageTypes.PNG)) {
                    return new PngReader();
                }
            }
                throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
package Utils;

import jakarta.servlet.http.Part;
import org.eclipse.tags.shaded.org.apache.bcel.generic.INSTANCEOF;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class CreateImagePath {
    private static final CreateImagePath INSTANCE = new CreateImagePath();
    public String CreateImagePath(Part imagePart, String id, String uploadPath) throws IOException {
        String fileName = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
        String savedName = "dish_" + id + "_" + fileName;
        File file = new File(uploadPath, savedName);
        imagePart.write(file.getAbsolutePath());
        return "/img/" + savedName;
    }

    private CreateImagePath(){};

    public static CreateImagePath getInstance(){
        return INSTANCE;
    }

}

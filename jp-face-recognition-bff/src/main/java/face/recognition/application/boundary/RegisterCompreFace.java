package face.recognition.application.boundary;

import face.recognition.application.model.FaceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface RegisterCompreFace {

    FaceResponse registerFace(UUID subject, MultipartFile file) throws IOException;
}

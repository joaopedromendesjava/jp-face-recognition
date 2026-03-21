package face.recognition.application.service;

import face.recognition.application.model.FaceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface FaceService {
    FaceResponse registerFace(UUID subject, MultipartFile photo);
}

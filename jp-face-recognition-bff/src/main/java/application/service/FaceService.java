package application.service;

import application.model.FaceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface FaceService {
    FaceResponse registerFace(UUID subject, MultipartFile photo);
}

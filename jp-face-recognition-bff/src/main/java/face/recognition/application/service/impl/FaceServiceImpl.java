package face.recognition.application.service.impl;

import face.recognition.application.boundary.RegisterCompreFace;
import face.recognition.application.model.FaceResponse;
import face.recognition.application.service.FaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FaceServiceImpl implements FaceService {

    private final RegisterCompreFace registerCompreFace;

    @Override
    public FaceResponse registerFace(UUID subject, MultipartFile photo) {
        try {
            return registerCompreFace.registerFace(subject, photo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

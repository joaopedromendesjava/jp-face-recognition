package application.service.impl;

import application.model.FaceResponse;
import application.service.FaceService;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class FaceServiceImpl implements FaceService {

    @Override
    public FaceResponse registerFace(UUID subject, MultipartFile photo) {
        return null;
    }
}

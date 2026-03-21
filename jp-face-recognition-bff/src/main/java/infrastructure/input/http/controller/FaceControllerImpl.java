package infrastructure.input.http.controller;

import application.service.FaceService;
import infrastructure.input.http.mapper.FaceMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.FaceApi;
import org.openapitools.model.FaceResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class FaceControllerImpl implements FaceApi {

    private final FaceService faceService;
    private final FaceMapper faceMapper;

    @Override
    public ResponseEntity<FaceResponseDTO> registerFace(UUID subject, MultipartFile photo) {
        var face = faceService.registerFace(subject, photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(faceMapper.toFaceRegisterDto(face));
    }
}

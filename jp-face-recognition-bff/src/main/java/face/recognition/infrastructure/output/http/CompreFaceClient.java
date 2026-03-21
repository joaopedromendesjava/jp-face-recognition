package face.recognition.infrastructure.output.http;

import face.recognition.application.boundary.RegisterCompreFace;
import face.recognition.application.model.FaceResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static face.recognition.application.AppConstants.Api.PATH;
import static face.recognition.application.AppConstants.Api.X_API_KEY;

@Service
public class CompreFaceClient implements RegisterCompreFace {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${compre.face.url}")
    private String baseUrl;

    @Value("${x.api.key}")
    private String key;

    @Value("${threshold}")
    private String threshold;

    @Override
    public FaceResponse registerFace(UUID subject, MultipartFile file) throws IOException {

        final String url = baseUrl + String.format(PATH, subject, threshold);

        var httpHeaders = new HttpHeaders();
        httpHeaders.set(X_API_KEY, key);

        var body = new LinkedMultiValueMap<>();
        body.add("file", buildFile(file));

        var requestEntity = new HttpEntity<>(body, httpHeaders);

        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, FaceResponse.class).getBody();
    }

    private InputStreamResource buildFile(MultipartFile file) throws IOException {
        return new InputStreamResource(file.getInputStream()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }

            @Override
            public long contentLength() {
                return file.getSize();
            }
        };
    }
}

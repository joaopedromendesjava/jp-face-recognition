package face.recognition.application.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record FaceResponse(UUID subject, UUID imageId, OffsetDateTime createdAt) { }

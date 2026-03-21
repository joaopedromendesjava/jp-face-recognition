package face.recognition.infrastructure.input.http.mapper;

import face.recognition.application.model.FaceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.openapitools.model.FaceResponseDTO;

import java.time.OffsetDateTime;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface FaceMapper {

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "mapToDate")
    @Mapping(source = "imageId", target = "image_id")
    FaceResponseDTO toFaceRegisterDto(FaceResponse faceResponse);

    @Named("mapToDate")
    default Date maptoDate(OffsetDateTime offsetDateTime){
        if (offsetDateTime == null){
            return null;
        }
        return Date.from(offsetDateTime.toInstant());
    }
}

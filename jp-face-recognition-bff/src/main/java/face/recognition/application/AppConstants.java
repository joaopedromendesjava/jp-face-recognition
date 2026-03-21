package face.recognition.application;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AppConstants {

    @UtilityClass
    public static class Api {
        public static final String X_API_KEY = "x-api-key";
        public static final String PATH = "?subject=%s&det_prob_threshold=%s";
    }
}

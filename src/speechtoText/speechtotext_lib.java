package speechtoText;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;

public class speechtotext_lib {

	SpeechToText service;
    RecognizeOptions options = null;

		
		public speechtotext_lib(File audio) {
			// TODO Auto-generated method stub
		    service = new SpeechToText();
            service.setUsernameAndPassword("cfc7a773-d208-4623-91bf-8969e467b595", "fkFb8J65nldc");
            try {
				options = new RecognizeOptions.Builder()
						.model("ja-JP_BroadbandModel")
				    .audio(audio)
				    .contentType(RecognizeOptions.ContentType.AUDIO_MP3)
				    .build();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
	  }
		  public SpeechRecognitionResults getTranscript() {
              SpeechRecognitionResults transcript = service.recognize(options).execute();
              return transcript;
      }
  }

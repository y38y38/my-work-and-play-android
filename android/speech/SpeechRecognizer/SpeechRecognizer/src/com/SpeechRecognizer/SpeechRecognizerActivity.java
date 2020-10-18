package com.SpeechRecognizer;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;

public class SpeechRecognizerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        class MyRecognitionListener implements RecognitionListener {

			@Override
			public void onBeginningOfSpeech() {
				Log.d("Speech", "onBeginningOfSpeech");
			}

			@Override
			public void onBufferReceived(byte[] buffer) {
				Log.d("Speech", "onBufferReceived");
			}

			@Override
			public void onEndOfSpeech() {
				Log.d("Speech", "onEndOfSpeech");
			}

			@Override
			public void onError(int error) {
				Log.d("Speech", "onError");
			}

			@Override
			public void onEvent(int eventType, Bundle params) {
				Log.d("Speech", "onEvent");
			}

			@Override
			public void onPartialResults(Bundle partialResults) {
				Log.d("Speech", "onPartialResults");
			}

			@Override
			public void onReadyForSpeech(Bundle params) {
				Log.d("Speech", "onReadyForSpeech");
			}
			

			@Override
			public void onResults(Bundle results) {
				Log.d("Speech", "onResults");
				ArrayList<String> strlist = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
				for (int i = 0; i < strlist.size();i++ ) {
					Log.d("Speech", "result=" + strlist.get(i));
				}
			}

			@Override
			public void onRmsChanged(float rmsdB) {
				Log.d("Speech", "onRmsChanged");
			}
        	
        }
        SpeechRecognizer sr = SpeechRecognizer.createSpeechRecognizer(getApplicationContext());
        MyRecognitionListener listener = new MyRecognitionListener();
        sr.setRecognitionListener(listener);
        sr.startListening(RecognizerIntent.getVoiceDetailsIntent(getApplicationContext()));
     }
}
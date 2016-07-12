package translator.aeq.com.aeqtranslator;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    GoogleTranslator translator;
    EditText translateedittext;
    TextView translatabletext;
    Spinner mFromLang;
    Spinner mToLang;
    Languages languages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFromLang = (Spinner) findViewById(R.id.from_language);
        mToLang = (Spinner) findViewById(R.id.to_language);

        ArrayList<String> fromLangList = new ArrayList<String>();

        translator = new GoogleTranslator(this.getResources().getString(R.string.api_key));

        languages = new Languages();
        Map languageMap = languages.getLangMap();
        Set<String> keys = languageMap.keySet();
        fromLangList.addAll(keys);
        final ArrayAdapter<String> langAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fromLangList);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mFromLang.setAdapter(langAdapter);
        mFromLang.setSelection(getIndex(mFromLang, "English"));
        mToLang.setAdapter(langAdapter);

        mToLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setTranslate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here

            }

        });

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        translatabletext = (TextView) findViewById(R.id.translatabletext);
        translateedittext = (EditText) findViewById(R.id.translateedittext);
//        Button translatebutton = (Button) findViewById(R.id.translatebutton);
/*
* android EditText - finished typing event
* */
        translateedittext.setOnKeyListener(new OnKeyListener() {
                                               @Override
                                               public boolean onKey(View view, int i, KeyEvent keyEvent) {
                                                   setTranslate();
                                                   return false;
                                               }
                                           });


                /*translatebutton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        setTranslate();
                        // new EnglishToTagalog().execute();

                    }
                });*/
    }

    private void setTranslate(){
        String fromLanguage = mFromLang.getSelectedItem().toString().trim();
        String toLanguage = mToLang.getSelectedItem().toString().trim();
        String text = translateedittext.getText().toString();
        if (text != null && !text.isEmpty()) {
            GoogleTranslator translator = new GoogleTranslator(MainActivity.this.getResources().getString(R.string.api_key));
            String langFrom = languages.getValueByKey(fromLanguage);
            String langto = languages.getValueByKey(toLanguage);
            String translatedText = translator.translte(text, langFrom, langto);


            translatabletext.setText(translatedText);
        }else{
            translatabletext.setHint("TranslatedText");
        }
    }

    private int getIndex(Spinner spinner, String myString) {

        int index = 0;

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(myString)) {
                index = i;
            }
        }
        return index;
    }

    private class EnglishToTagalog extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progress = null;

        protected void onError(Exception ex) {

        }

        @Override
        protected Void doInBackground(Void... params) {

            try {


                Thread.sleep(1000);


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPreExecute() {
            //start the progress dialog
            progress = ProgressDialog.show(MainActivity.this, null, "Translating...");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setIndeterminate(true);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void result) {
            progress.dismiss();

            super.onPostExecute(result);
            translated();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }


    public void translated() {

        String translatetotagalog = translateedittext.getText().toString();//get the value of text


        String text = translator.translte(translatetotagalog, "en", "ta");
        translatabletext = (TextView) findViewById(R.id.translatabletext);
        translatabletext.setText(text);

    }

}

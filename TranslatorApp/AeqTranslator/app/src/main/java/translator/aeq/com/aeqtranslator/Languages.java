package translator.aeq.com.aeqtranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by aequalis on 6/7/16.
 */
public class Languages {


    private Map <String,String> langMap = new TreeMap<>();
    public Languages(){

        langMap.put("Afrikaans","af");
        langMap.put("Albanian","sq");
        langMap.put("Arabic","ar");
        langMap.put("Armenian","hy");
        langMap.put("Azerbaijani","az");
        langMap.put("Basque","eu");
        langMap.put("Belarusian","be");
        langMap.put("Bengali","bn");
        langMap.put("Bosnian","bs");
        langMap.put("Bulgarian","bg");
        langMap.put("Catalan","ca");
        langMap.put("Cebuano","ceb");
        langMap.put("Chichewa","ny");
        langMap.put("Chinese Simplified","zh-CN");
        langMap.put("Chinese Traditional","zh-TW");
        langMap.put("Croatian","hr");
        langMap.put("Czech","cs");
        langMap.put("Danish","da");
        langMap.put("Dutch","nl");
        langMap.put("English","en");
        langMap.put("Esperanto","eo");
        langMap.put("Estonian","et");
        langMap.put("Filipino","tl");
        langMap.put("Finnish","fi");
        langMap.put("French","fr");
        langMap.put("Galician","gl");
        langMap.put("Georgian","ka");
        langMap.put("German","de");
        langMap.put("Greek","el");
        langMap.put("Gujarati","gu");
        langMap.put("Haitian Creole","ht");
        langMap.put("Hausa","ha");
        langMap.put("Hebrew","iw");
        langMap.put("Hindi","hi");
        langMap.put("Hmong","hmn");
        langMap.put("Hungarian","hu");
        langMap.put("Icelandic","is");
        langMap.put("Igbo","ig");
        langMap.put("Indonesian","id");
        langMap.put("Irish","ga");
        langMap.put("Italian","it");
        langMap.put("Japanese","ja");
        langMap.put("Javanese","jw");
        langMap.put("Kannada","kn");
        langMap.put("Kazakh","kk");
        langMap.put("Khmer","km");
        langMap.put("Korean","ko");
        langMap.put("Lao","lo");
        langMap.put("Latin","la");
        langMap.put("Latvian","lv");
        langMap.put("Lithuanian","lt");
        langMap.put("Macedonian","mk");
        langMap.put("Malagasy","mg");
        langMap.put("Malay","ms");
        langMap.put("Malayalam","ml");
        langMap.put("Maltese","mt");
        langMap.put("Maori","mi");
        langMap.put("Marathi","mr");
        langMap.put("Mongolian","mn");
        langMap.put("Myanmar (Burmese)","my");
        langMap.put("Nepali","ne");
        langMap.put("Norwegian","no");
        langMap.put("Persian","fa");
        langMap.put("Polish","pl");
        langMap.put("Portuguese","pt");
        langMap.put("Punjabi","ma");
        langMap.put("Romanian","ro");
        langMap.put("Russian","ru");
        langMap.put("Serbian","sr");
        langMap.put("Sesotho","st");
        langMap.put("Sinhala","si");
        langMap.put("Slovak","sk");
        langMap.put("Slovenian","sl");
        langMap.put("Somali","so");
        langMap.put("Spanish","es");
        langMap.put("Sudanese","su");
        langMap.put("Swahili","sw");
        langMap.put("Swedish","sv");
        langMap.put("Tajik","tg");
        langMap.put("Tamil","ta");
        langMap.put("Telugu","te");
        langMap.put("Thai","th");
        langMap.put("Turkish","tr");
        langMap.put("Ukrainian","uk");
        langMap.put("Urdu","ur");
        langMap.put("Uzbek","uz");
        langMap.put("Vietnamese","vi");
        langMap.put("Welsh","cy");
        langMap.put("Yiddish","yi");
        langMap.put("Yoruba","yo");
        langMap.put("Zulu","zu");

    }
    public Map<String,String> getLangMap(){

        return langMap;
    }

    public String getValueByKey(String key){

        if(langMap.containsKey(key)){
            return langMap.get(key);
        }

        return null;
    }
}

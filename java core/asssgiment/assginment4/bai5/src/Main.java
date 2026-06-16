import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Get the regex to be checked
        String regex = "(Geeks)";

        Pattern pattern = Pattern.compile(regex);
        String stringToBeMatched = "GeeksForGeeks";
      Matcher matcher = pattern.matcher(stringToBeMatched);
        if(matcher.find())
        {
            System.out.println( "tìm thấy  tại vị trí "+matcher.start(1));
        }
        }
    }
